package pages;

import Driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;

public class CrearCliente {
    private AppiumDriver driver;

    public CrearCliente (){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Cliente\")]")
    private MobileElement tituloCrearCliente;

    //Campos a completar crear cliente
    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement inputNombreCliente;
    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement inputID;
    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement inputTelefono;
    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement inputDireccion;
    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement inputNotas;
    @AndroidFindBy(id = "com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;

    public void validaVistaregistro(){
        if(esperarObjeto(tituloCrearCliente,5)){
            addStep("Se muestra el titulo "+tituloCrearCliente.getText(),true, Status.PASSED,false);
        }else{
            addStep("No se encuentra el titulo Crear Cliente",true, Status.FAILED,true);
        }
    }

    public void ingresoDatosCrearCliente(String nombre, String id, String telefono, String direccion, String notas){
        System.out.println("Ingreso de datos a formulario INgresar Cliente");
        inputNombreCliente.setValue(nombre);
        this.driver.hideKeyboard();
        inputID.click();
        inputID.setValue(id);
        this.driver.hideKeyboard();
        inputTelefono.click();
        inputTelefono.setValue(telefono);
        this.driver.hideKeyboard();
        inputDireccion.click();
        inputDireccion.setValue(direccion);
        this.driver.hideKeyboard();
        inputNotas.click();
        inputNotas.setValue(notas);
        this.driver.hideKeyboard();
        addStep("Se completa el ingreso de datos para crear cliente",true, Status.PASSED,false);
    }

    public void tapBtnGuardar(){
            btnGuardar.click();
    }
}
