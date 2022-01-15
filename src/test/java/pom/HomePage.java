package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage{

    private String titleHomePage = "Agencia de viajes y turismo líder en América Latina | Despegar";
    private String origenLocator =  "//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[1]/div/div[1]/div[1]/div/input";
    private String destinoLocator =  "//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[1]/div/div[2]/div/div/input";
    private String fechaIdaLocator = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[1]/div[1]/div[2]/div/div[1]/div/div/div/div/input";
    private String btnBuscarLocator = "//*[@id=\"searchbox-sbox-box-flights\"]/div/div[2]/div[3]/button";
    private String elementListOrigen = "/html/body/div[4]/div/div/ul/li";
    private String elementListDestino = "/html/body/div[4]/div/div[1]/ul/li[1]";
    private String firstResultLocator = "//*[@id=\"eva-select\"]";
    private String selectFiltro = "//*[@id=\"eva-select\"]";
    private String bestButton = "//*[@id=\"clusters\"]/span[1]/div/span/cluster/div/div/div[2]/fare/span/span/div[2]/buy-button";
    private String nextButton = "//*[@id=\"upselling-popup-position\"]/upselling-popup/div/div[3]/div/div/button";
    private String textPageLocator = "//*[@id=\"checkout-content\"]/div[1]/payment-component/payment-method-selector/div/span";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean homePageIsDisplayed() throws Exception {
        return this.getTitle().equals(titleHomePage);
    }

    public void fillOrigenInput() throws Exception {
        this.clickAndSendKeys(origenLocator, "mMDE");
        this.waitAndClick(elementListOrigen);
    }

    public void fillDestinoInput() throws Exception {
        this.click(destinoLocator);
        TimeUnit.SECONDS.sleep(1);
        this.sendKeys(destinoLocator,"BBog");
        this.waitAndClick(elementListDestino);
    }

    public void fillDates() throws Exception {
        this.click(fechaIdaLocator);

        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);

        int diaIda = c.get(Calendar.DATE) + 1;
        int diaVuelta = c.get(Calendar.DATE) + 2;

        String elementDiaIda = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[" + diaIda + "]";
        String elementDiaVuelta = "//*[@id=\"component-modals\"]/div[1]/div[1]/div[2]/div[1]/div[3]/div[" + diaVuelta + "]";

        this.waitAndClick(elementDiaIda);
        TimeUnit.SECONDS.sleep(1);
        this.waitAndClick(elementDiaVuelta);
        this.click(btnBuscarLocator);
    }

    public void fillForm() throws Exception {
        this.fillOrigenInput();
        this.fillDestinoInput();
        this.fillDates();
    }

    public void waitElementInReservationPage() throws Exception {
        this.waitElement(firstResultLocator);
    }

    public void clickOnSelect() throws Exception {
        TimeUnit.SECONDS.sleep(1);
        this.SelectElementByValue(selectFiltro);
        TimeUnit.SECONDS.sleep(5);
    }

    public void clickOnBestButton() throws Exception {
        this.click(bestButton);
    }

    public void selectOptionsBaggage() throws Exception {
        this.waitAndClick(nextButton);
        TimeUnit.SECONDS.sleep(10);
    }

    public void awaitElementInReservationPage() throws Exception {
        this.waitAndClick(textPageLocator);
    }
}
