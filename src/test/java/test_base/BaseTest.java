package test_base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.FileReader;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    public Properties p;

    @BeforeTest
    public void setUp(){

        try {
            FileReader file = new FileReader(".//src//test//java//resources//config.properties");
            p = new Properties();
            p.load(file);
        }catch (Exception e){
            e.printStackTrace();
        }

        driver = new ChromeDriver();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
