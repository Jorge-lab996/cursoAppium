package testSuites;

import Driver.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarCliente;
import testClases.AgregarProducto;
import testClases.BorrarCliente;

import static Driver.DriverContext.setUp;

public class AllTest {
    //AgregarCliente agregarCliente = new AgregarCliente();
    @BeforeMethod
    public void iniciarSesion(){
        setUp("emulator-5554","Android","/Users/jorgesoto/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }

    @AfterMethod
    public void cerrarSesion(){
        DriverContext.quitDriver();
    }


    @Test(priority = 1, description = "Test Case Ultima sesion, agregar cliente")
    public void casoAgregarCliente() {
        AgregarCliente agregarCliente = new AgregarCliente();
        agregarCliente.flujoAgregarCliente();
    }

    @Test(priority = 2, description = "Test Case 1, Agregar Producto")
    public void casoAgregarProducto(){
        AgregarProducto agregarProducto = new AgregarProducto();
        agregarProducto.flujoCrearProducto();
    }

    @Test(priority = 3, description = "Test Case 3, Borrar Cliente")
    public void casoBorrarCliente(){
        BorrarCliente borrarCliente = new BorrarCliente();
        borrarCliente.flujoBorrarCliente();
    }

}
