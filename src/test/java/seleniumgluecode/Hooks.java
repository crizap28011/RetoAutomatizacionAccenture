package seleniumgluecode;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    private static ChromeDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp(){
        numberOfCase++;
        System.out.println("Se esta ejecutando el escenario " + numberOfCase);
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.despegar.com.co/");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        System.out.println("El escenario # " + numberOfCase + " se ejecuto correctamente.");
        driver.quit();
    }

    public static ChromeDriver getDriver(){
        return driver;
    }
}
