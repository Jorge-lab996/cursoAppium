package utils;

import Driver.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static boolean esperarObjeto(MobileElement elemento, int segundos){
        try {
            System.out.println("Buscamos elemento:" + elemento + ", esperamos " + segundos + " segundos, hasta que se muestre");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontro el elemento (" + elemento + "), se retorna true");
            return true;
        }catch(Exception e){
            System.out.println("No se encontro el elemente ("+elemento+"), se retorna false");
            return false;
        }
    }
    public static void swipeAbajo(){
        int ancho = (int) (DriverContext.getDriver().manage().window().getSize().width * 0.08D);
        int puntoInicio = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.09D);
        int puntoTermino  = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction(DriverContext.getDriver());
        touchAction.press(PointOption.point(ancho, puntoInicio)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500l))).moveTo(PointOption.point(ancho,puntoTermino)).release().perform();
        System.out.println("[Utils] Swipe hacia abajo");
    }
}
