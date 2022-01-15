package seleniumgluecode;

import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;
import pom.ReservationPage;

public class TestBase {

    protected ChromeDriver driver = Hooks.getDriver();
    protected HomePage homePage = new HomePage(driver);
    protected ReservationPage reservationPage = new ReservationPage(driver);
}
