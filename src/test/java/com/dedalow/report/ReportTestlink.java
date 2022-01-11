package com.dedalow.report;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Map.Entry;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import br.eti.kinoshita.testlinkjavaapi.model.Platform;

import com.dedalow.utils.Utils;
import com.dedalow.report.Report;

public class ReportTestlink {
	public static ConectorTestlink conectorTestLink;
	private static Logger logger = Utils.logger();
	private static Map<String, TestSuite> listedTestSuites = new HashMap<String, TestSuite>();
	private static String testSuitesKey;
	private static TestSuite testSuitesValues;
	private static TestCase testCase;

	public void reportResultTestLink(JsonReport json, Boolean screenShot,
		String suiteName, String caseName) throws NullPointerException, MalformedURLException {
		conectorTestLink = new ConectorTestlink(json.url, json.devKey);
		
		int testCaseId = 0;
		
		ExecutionStatus status = null;
		String tracks[];
		int executionId;
		String platformName = null;

		Map<String, TestSuite> testsuites = json.testSuites;
		getLastIndex(testsuites, suiteName);
		String testPlanName = testSuitesValues.testSuiteTL;

		int testPlanId = conectorTestLink.getTestPlanId(testPlanName, json.projectName);
		int buildId = conectorTestLink.getBuildIdByName(json.buildName, testPlanId);
		
		testCaseValues(testSuitesValues.testCases);
		testCaseId = conectorTestLink.getTestCaseId(testCase.externalId);
		if (testCase.result.get(0).contains("KO")) {
			status = ExecutionStatus.FAILED;
		} else if (testCase.result.get(0).contains("OK")) {
			status = ExecutionStatus.PASSED;
		} else {
			status = ExecutionStatus.BLOCKED;
		}
		
		tracks = new String[testCase.notes.size()];
		for (int i = 0; i < testCase.notes.size(); i++) {
			tracks[i] = testCase.notes.get(i);
		}

		try {
			Platform[] testplanplatforms = conectorTestLink.getTestPlanPlatforms(testPlanId);
			for (int i = 0; i < testplanplatforms.length; i++) {
				String platformNameConfigured = testplanplatforms[i].getName();
				if (platformNameConfigured.equals(json.platform)) {
					platformName = json.platform;
				}
			} 				
		} catch (Exception e) {
			Report.reportErrors("Testlink Report: " + e.getMessage());
		}					

		String preparedTracks = (Arrays.toString(tracks));

		try {
			conectorTestLink.reportResult(testCaseId, testPlanId, buildId, status, preparedTracks, platformName);
			executionId = conectorTestLink.getlastExecution(testPlanId, testCaseId, buildId);
			if (screenShot) {
				for (int i = 0; i < testCase.screenShootsPaths.size();i++) {
					try {
						if (testCase.screenShootsPaths.get(i).contains("BQ_")
								|| testCase.screenShootsPaths.get(i).contains("KO_")) {
							conectorTestLink.addAttachmentsForTestCase(testCase.screenShootsPaths.get(i),
									executionId, testCase.name, testCase.name,
									testCase.name, "image/png");
						}
					} catch (Exception e) {
						Report.reportErrors(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			Report.reportErrors("Testlink Report: " + e.getMessage());
		}
	}
	
	private static void getLastIndex(Map<String, TestSuite> testsuites, String suiteName) {
        int count = 1;
        for (Entry<String, TestSuite> it :
        	testsuites.entrySet()) {
            
            if (count == testsuites.size()) {
                listedTestSuites.put(it.getKey(), it.getValue());
                testSuitesKey = it.getKey();
                testSuitesValues = it.getValue();
                return;
            }
            count++;
        }
	}
	
	private static void testCaseValues(Map<String, TestCase> testCases) {
        int count = 1;
        for (Entry<String, TestCase> it :
        	testCases.entrySet()) {
            if (count == testCases.size()) {
                testCase = it.getValue();
                return;
            }
            count++;
        }
	}

}