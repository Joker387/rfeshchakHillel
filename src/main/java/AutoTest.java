import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoTest {
    By searchB = By.xpath("//button[@class='button']");
    By brand = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-brand']");
    By carModel = By.xpath("//input[@id='brandTooltipBrandAutocompleteInput-model']");
    By priceF = By.xpath("//input[@id='priceFrom']");
    By priceT = By.xpath("//input[@id='priceTo']");
    @Test
    public void openSite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://auto.ria.com/uk/");
        driver.findElement(brand).sendKeys("Ford");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-value='24']")).click();
        Thread.sleep(1000);
        driver.findElement(carModel).sendKeys("Kuga");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@data-value='2874']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='yearFrom']/option[14]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//select[@id='yearTo']/option[3]")).click();
        Thread.sleep(1000);
        driver.findElement(priceF).sendKeys("3500");
        Thread.sleep(1000);
        driver.findElement(priceT).sendKeys("9000");
        driver.findElement(searchB).click();
        Thread.sleep(2000);
        Assert.assertEquals("https://auto.ria.com/uk/search/?categories.main.id=1&price.currency=1&price.USD.gte=3500&price.USD.lte=9000&indexName=auto,order_auto,newauto_search&brand.id[0]=24&model.id[0]=2874&year[0].gte=2010&year[0].lte=2021&size=20", driver.getCurrentUrl());
    }
}
