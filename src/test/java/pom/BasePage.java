package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle() throws Exception {
        try {
            return this.driver.getTitle();
        }
        catch (Exception e){
            throw new Exception("No se pudo obtener el titulo del driver");
        }
    }

    public void click(String element) throws Exception {
        try{
            WebElement webElement = driver.findElement(By.xpath(element));
            webElement.click();
        }
        catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento: " + element);
        }
    }

    public void sendKeys(String element, String keyword) throws Exception {
        try{
            WebElement webElement = driver.findElement(By.xpath(element));
            webElement.sendKeys(keyword);
        }
        catch (Exception e){
            throw new Exception("No se pudo encontrar el elemento: " + element);
        }
    }

    public void clickAndSendKeys(String element, String keyword) throws Exception {
        try{
            WebElement webElement = driver.findElement(By.xpath(element));
            webElement.click();
            webElement.sendKeys(keyword);
        }
        catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento: " + element);
        }
    }

    public void waitAndClick(String element) throws Exception {
        try{
            WebElement webElement = new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
            webElement.click();
        }
        catch (Exception e){
            throw new Exception("No se pudo clickear sobre el elemento: " + element);
        }
    }

    public WebElement waitElement(String element) throws Exception {
        try{
            return new WebDriverWait(driver, 10)
                    .until(ExpectedConditions.elementToBeClickable(By.xpath(element)));
        }
        catch (Exception e){
            throw new Exception("No se pudo encontrar el elemento: " + element);
        }
    }

    public void SelectElementByValue(String element) throws Exception {
        try{
            Select objSelect = new Select(driver.findElement(By.xpath(element)));
            objSelect.selectByValue("fare_minus_discount_ascending");
        }
        catch (Exception e){
            throw new Exception("Excepcion " + e);
        }
    }
}
