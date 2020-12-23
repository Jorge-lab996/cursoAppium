package testSuites;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ejecicioTestNG {
    @BeforeSuite
    public void metodo1(){

    }
    @AfterSuite
    public void metodo2(){

    }
    @Test(priority = 1 , description = "Prueba 1")
    public void metodo3(){
        System.out.println("Test 1 ");

    }
    @Test(priority = 2, description = "Prueba 2")
    public void metodo4(){
        System.out.println("Test 2");
    }
    @AfterMethod
    public void metodo5(){

    }

}
