package pages;

import Driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;
import static utils.Utils.swipeAbajo;

public class BorrarClientePage {
    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> listaClientes;

    @AndroidFindBy(id = "com.rodrigo.registro:id/vc_anadirVenta")
    private MobileElement tituloNuevaVentana;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private MobileElement btnBorrarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/textView1")
    private MobileElement tituloEliminarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement inputBorrarCliente;

    @AndroidFindBy(id = "android:id/button1")
    private MobileElement btnOKborrarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/textView6")
    private MobileElement msjNoHayClientes;

    private AppiumDriver driver;
    public BorrarClientePage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public void seleccionarCliente(String nombre){
        System.out.println("Validar que exista cliente en el registro");
        for(MobileElement cliente: listaClientes){
            if(cliente.getText().equals(nombre)){
                System.out.println("Se valida que el cliente: "+cliente.getText()+" se encuentra en registro");
                addStep("Se valida que existe el cliente: "+cliente.getText()+" en el registro",true,Status.PASSED,false);
                cliente.click();
                break;
            }
            //Esta condicion verifica que si se recorre todo el bucle, llega al final y no encuentra el valor buscado, se caera el flujo
            if(cliente.getText().equals(listaClientes.get(listaClientes.size()-1).getText())){
                addStep("Se recorre la lista de clientes, pero no se encuentra al cliente buscado: "+nombre,true,Status.FAILED,true);
            }
        }
    }

    public void validaVistaDetalleCliente(){
        if(esperarObjeto(tituloNuevaVentana,5)){
            addStep("Se muestra el titulo "+tituloNuevaVentana.getText(),true, Status.PASSED,false);
        }else{
            addStep("No se encuentra el titulo Añadir nueva ventana cliente, en la vista Detalles cliente",true, Status.FAILED,true);
        }
    }

    public void tapBorrarCliente(){
        swipeAbajo();
        btnBorrarCliente.click();
    }

    public void validaPopUpConfirmacion(){
        System.out.println("Pop Up de confirmacion de borrar cliente");
        if(esperarObjeto(tituloEliminarCliente,5)){
            addStep("Se muestra el titulo "+tituloEliminarCliente.getText(),true, Status.PASSED,false);
        }else{
            addStep("No se encuentra el titulo 'Para eliminar el cliente escriba BORRAR'",true, Status.FAILED,true);
        }
    }

    public void ingreasarBorrar(){
        inputBorrarCliente.setValue("BORRAR");
        this.driver.hideKeyboard();
        btnOKborrarCliente.click();
    }


    public void verificarClienteNoExiste(String nombre) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println("Validar que exista cliente en el registro");
         for (MobileElement cliente : listaClientes) {
             String prueba = cliente.getText();
            if (!cliente.getText().equals(nombre)) {
                System.out.println("Se encuentra cliente: " + cliente.getText() + ", no se logra eliminar");
                addStep("Se encuentra cliente: " + cliente.getText() + ", no se logra eliminar", true, Status.FAILED, true);
                cliente.click();
                break;
            }

            if (cliente.getText().equals(listaClientes.get(listaClientes.size() - 1).getText())) {
                addStep("Se recorre la lista de clientes y no se encuentra al cliente buscado: " + nombre, true, Status.PASSED, false);
            }
        }
    }


}

