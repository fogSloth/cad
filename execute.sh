#!/bin/sh

cd /app/projectFolderExe && zip -r ./3221qaExe.zip . -x "execute.sh"

echo 'Wait dapr...';
_RETURN=0
while [ $_RETURN != "204" ]; do
    _RETURN=$(curl -X GET -s -o /dev/null -w "%{http_code}" http://localhost:3500/v1.0/healthz)
    echo $_RETURN
    echo "Waiting to dapr server.... HTTP return CODE: $_RETURN"
    sleep 5
done

echo "{ \"operation\": \"create\", \"data\": \"$( base64 3221qaExe.zip )\", \"metadata\": { \"blobName\": \"${BUILD_ID}.zip\" } }" > data.json

response=$(curl -d @data.json  http://localhost:3500/v1.0/bindings/testing-artifacts)

url=$(echo $response | jq -r 'if .blobURL then .blobURL elif .location then .location else "none" end')

echo $url

echo "{
    \"jobId\": \"${JOB_ID}\",
    \"generation-id\": \"${JOB_ID}\",
    \"id\": \"${BUILD_ID}\",
    \"triggerBy\": \"${TRIGGER_BY}\",
    \"code\": \"build/job/end\",
    \"msg\": \"Artifact uploaded\",
    \"date\": \"$(date -Is)\",
    \"downloadUrl\": \"${url}\"
}" > msg.json

_RETURN=$(curl -sL -w "%{http_code}" -H "Content-Type: application/json" -X POST ${URL_NOTIFICATIONS} -d @msg.json)
echo "End send notification  HTTP return CODE: $_RETURN"

echo "{
    \"jobId\": \"${JOB_ID}\",
    \"generation-id\": \"${JOB_ID}\",
    \"id\": \"${BUILD_ID}\",
    \"triggerBy\": \"${TRIGGER_BY}\",
    \"code\": \"execute/test/end\",
    \"msg\": \"No tests to execute\",
    \"date\": \"$(date -Is)\"
}" > msg.json

_RETURN=$(curl -sL -w "%{http_code}" -H "Content-Type: application/json" -X POST ${URL_NOTIFICATIONS} -d @msg.json)
echo "End send notification  HTTP return CODE: $_RETURN"

_RETURN=$(curl -sL -w "%{http_code}" -X POST http://localhost:3500/v1.0/shutdown)

echo "shutdown_dapr $_RETURN"