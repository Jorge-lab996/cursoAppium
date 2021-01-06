package testSuites;

import Driver.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarruselPage;
import testClases.AgregarCliente;

import static Driver.DriverContext.setUp;

public class RegistroDeUsuario {
    @BeforeMethod
    public void iniciarSesion(){
        setUp("emulator-5554","Android","/Users/jorgesoto/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }

    @AfterMethod
    public void cerrarSesion(){
        DriverContext.quitDriver();
    }


    @Test
    public void casoAgregarCliente(){
        AgregarCliente agregarCliente = new AgregarCliente();
        agregarCliente.flujo();
    }


}
