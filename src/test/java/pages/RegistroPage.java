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

public class RegistroPage {

    private AppiumDriver driver;

    public RegistroPage (){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloRegistro;

    @AndroidFindBy(id="com.rodrigo.registro:id/fab_expand_menu_button")
    private  MobileElement btnPlus;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;


    public void validaVistaregistro(){
        if(esperarObjeto(tituloRegistro,5)){
            addStep("Se muestra el titulo "+tituloRegistro.getText(),true, Status.PASSED,false);
        }else{
            addStep("No se encuentra el titulo Registro en la aplicacion",true, Status.FAILED,true);
        }
    }

    public void tapBtnPlus(){
        if(esperarObjeto(btnPlus,5)){
            addStep("Se realiza Tap a boton Mas + ",false, Status.PASSED,false);
            btnPlus.click();
        }else{
            addStep("No se logra encontrar el boton + en la aplcacion",true, Status.FAILED,true);
        }
    }

    public void tapBtnCrearCliente(){
        if(esperarObjeto(btnCrearCliente,5)){
            addStep("Se realiza Tap a boton Crear Cliente",false, Status.PASSED,false);
            btnCrearCliente.click();
        }else{
            addStep("No se logra encontrar el boton Crear Cliente en la aplcacion",true, Status.FAILED,true);
        }
    }

}
