package reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

import Driver.DriverContext;
import io.qameta.allure.Allure;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Reports {
    private static SoftAssert softAssert = new SoftAssert();

    public static void addStep(String description, Boolean screenshot, Status status, Boolean fatal){
        String uuid = UUID.randomUUID().toString();
        StepResult result = new StepResult().setName(description).setStatus(status);
        Allure.getLifecycle().startStep(uuid,result);
        if(screenshot){
            reportScreenshot();
        }

        Allure.getLifecycle().stopStep(uuid);
        softAssert.assertTrue(true, description);

        if(status.equals(Status.FAILED)){
            softAssert.fail(description);
        }

        if(fatal){
            Assert.fail(description);
        }

        System.out.println("[Report] "+description);
    }

    private static void reportScreenshot(){
        File srcFile;
        srcFile = ((TakesScreenshot) DriverContext.getDriver()).getScreenshotAs(OutputType.FILE);
        File foto = new File(srcFile.getPath());
        InputStream image;
        try {
            image = new FileInputStream(foto);
            Allure.addAttachment("Imagen Adjunto", image);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void finalAssert(){
        softAssert.assertAll();
    }

}
