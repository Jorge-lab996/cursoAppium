package testSuites;

import static Driver.DriverContext.setUp;
import static reports.Reports.addStep;

import Driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarCliente;


public class example2 {
    //AgregarCliente agregarCliente = new AgregarCliente();
    @BeforeMethod
    public void iniciarSesion(){
        setUp("emulator-5554","Android","/Users/jorgesoto/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }

   @AfterMethod
    public void cerrarSesion(){
       DriverContext.quitDriver();
    }

    @Test
    public void test1(){
        MobileElement botonNext= (MobileElement) DriverContext.getDriver().findElementById("com.rodrigo.registro:id/next");
        botonNext.click();
        botonNext.click();
        addStep("Validar vista carrusel", true, Status.FAILED,false);
    }


}
