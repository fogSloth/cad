@cucumberact @RegressionCAD
Feature: RegressionCAD
    Background: Background_RegressionCAD
    Given Acceder a la aplicación SupertestUI
    
    
    @SimpleActionsScen
    Scenario: SimpleActionsScen
    Given Ir a la página del formulario
    And Comprobar que estamos en la página
    When Escribir en el formulario
    Then Comprobar todos los tipos de assert
    When Ir a la página de botones
    And Comprobar el click izquierdo por ID
    And Comprobar el click izquierdo por Xpath
    And Comprobar el doble click
    And Ir a la página de drag and drop
    And Arrastrar una imagen
    Then Comprobar que se ha hecho correctamente
    
    