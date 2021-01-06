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

public class CarruselPage {

    private AppiumDriver driver;

    public CarruselPage (){
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    /*** Objetos
     *
      */
    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private MobileElement tituloVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement btnFlechaNext;

    //PopUp Android

    @AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
    private MobileElement btnPermitir;

    @AndroidFindBy(id = "com.rodrigo.registro:id/done")
    private MobileElement btnDone;
    
    public void validarVistaDesplegable(){
        if(iconoVista1.isDisplayed()){
            addStep("Validar Vista 1 de Carrusel Desplegado",true, Status.PASSED,false);
        }else{
            addStep("Validar Vista 1 de Carrusel Desplegado",true, Status.FAILED,true);
        }
    }

    public void btnDone(){
        btnPermitir.click();
        btnDone.click();
    }

    public void validartextoVistaCarrusel1(){
        if(esperarObjeto(descripcionVista, 5)) {
            String textoDescripcoinVista1 = descripcionVista.getText();
            if (textoDescripcoinVista1.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios.")) {
                addStep("Se valida que el texto es el mismo que se espera", true, Status.PASSED, false);
            } else {
                addStep("Se valida que el texto No es el mismo que se espera", true, Status.FAILED, true);
            }
        }else{
            addStep("No se encuentra el elemento descripcion vista", true, Status.FAILED, true);
        }
    }

    public void recorrerCarrusel(){
        for (int i=0;i<3;i++){
            btnFlechaNext.click();
        }
    }

}
