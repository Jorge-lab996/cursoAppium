package testSuites;

import Driver.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ExampleDriver {
    @BeforeMethod
    public void inicioSesion() {
//        AppiumDriver driver;
//        URL server = null;
//        try {
//            server = new URL("http://127.0.0.1:4723/wd/hub");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        DesiredCapabilities cap = new DesiredCapabilities();
//        cap.setCapability("deviceName", "emulator-5554");
//        cap.setCapability("platformName", "Android");
//        cap.setCapability("app", "/Users/jorgesoto/Downloads/registroDeUsuarios.apk");
//        cap.setCapability("udid", "emulator-5554");
//
//        driver = new AndroidDriver(server, cap);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DriverContext.setUp("emulator-5554","Android","/Users/jorgesoto/Downloads/registroDeUsuarios.apk","emulator-5554",true);
    }
        @Test
        public void test1(){
            System.out.println("prueba");
        }

    }

