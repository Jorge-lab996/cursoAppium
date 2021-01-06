package pages;

import Driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;

public class AgregarProductoPage {
    private AppiumDriver driver;

    public AgregarProductoPage(){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//*[contains(@text,\"Crear Producto\")]")
    private MobileElement tituloCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement inputNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private MobileElement inputPrecioDeLista;

    @AndroidFindBy(id="com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    @AndroidFindBy(xpath = "//*[contains(@text,\"PRODUCTOS\")]")
    private MobileElement btnProductos;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> listaProductos;

    public void validaVistaCrearCliente(){
        if(esperarObjeto(tituloCrearProducto,5)){
            addStep("Se muestra el titulo "+tituloCrearProducto.getText(),true, Status.PASSED,false);
        }else{
            addStep("No se encuentra el titulo Crear producto en la aplicacion",true, Status.FAILED,true);
        }
    }

    public void ingresoDatosProducto(String name, String price){
        System.out.println("Ingreso de datos a formulario Crear Producto");
        inputNombreProducto.setValue(name);
        this.driver.hideKeyboard();
        inputPrecioDeLista.click();
        inputPrecioDeLista.setValue(price);
        this.driver.hideKeyboard();
        addStep("Se ingresan datos al formulario Crear Cliente",true,Status.PASSED,false);
    }

    public void tapBtnConfirmar(){
        btnConfirmar.click();
    }

    public void validaVistaProductos(){
        if(esperarObjeto(btnProductos,5)){
            addStep("Se muestra el titulo "+btnProductos.getText(),true, Status.PASSED,false);
            btnProductos.click();
        }else{
            addStep("No se encuentra el titulo Crear producto en la aplicacion",true, Status.FAILED,true);
        }
    }

    public void validarProductoAgregado(String name) {
        System.out.println("Validar que exista el producto en la vista");
        for (MobileElement producto : listaProductos) {
            if (producto.getText().equals(name)) {
                System.out.println("Se valida que el producto: " + producto.getText() + " se encuentra en registro");
                addStep("Se valida que el producto: " + producto.getText() + " se encuentra en registro", true, Status.PASSED, false);
                break;
            }
            //Esta condicion verifica que si se recorre todo el bucle, llega al final y no encuentra el valor buscado, se caera el flujo
            if (producto.getText().equals(listaProductos.get(listaProductos.size() - 1).getText())) {
                addStep("Se recorre la lista de los productos, pero no se encuentra el producto buscado: " + name, true, Status.FAILED, true);
            }
        }
    }

}
