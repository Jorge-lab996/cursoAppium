package pages;

import Driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;
import java.util.List;

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

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> listaClientes;


    public void validaVistaregistro(){
        if(esperarObjeto(tituloRegistro,5)){
            addStep("Se muestra el titulo "+tituloRegistro.getText(),true, Status.PASSED,false);
        }else{
            addStep("No se encuentra el titulo Registro en la aplicacion",true, Status.FAILED,true);
        }
    }

    public void tapBtnPlus(){
        if(esperarObjeto(btnPlus,5)){
            addStep("Se realiza Tap a boton Mas + ",true, Status.PASSED,false);
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

    public void validarClienteRegistrado(String name){
        System.out.println("Validar que exista cliente en el registro");
        for(MobileElement cliente: listaClientes){
            if(cliente.getText().equals(name)){
                System.out.println("Se valida que el cliente: "+cliente.getText()+" se encuentra en registro");
                addStep("Se valida que existe el cliente: "+cliente.getText()+" en el registro",true,Status.PASSED,false);
                break;
            }
            //Esta condicion verifica que si se recorre todo el bucle, llega al final y no encuentra el valor buscado, se caera el flujo
            if(cliente.getText().equals(listaClientes.get(listaClientes.size()-1).getText())){
                addStep("Se recorre la lista de clientes, pero no se encuentra al cliente buscado: "+name,true,Status.FAILED,true);
            }
        }
    }

    public void tapBtnCrearProducto(){
        if(esperarObjeto(btnCrearProducto,5)){
            addStep("Se realiza Tap a boton Crear Producto",false, Status.PASSED,false);
            btnCrearProducto.click();
        }else{
            addStep("No se logra encontrar el boton Crear Producto en la aplicacion",true, Status.FAILED,true);
        }
    }

}
