import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UiForMavenTest {

    @Test
    public void testAmazon() {

        System.setProperty("webdriver.chrome.driver","C:\\Users\\bielskyi\\Documents\\MavenTraining\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");

        WebElement searchField = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        WebElement goButton = driver.findElement(By.xpath("//input[@value='Go']"));

        searchField.sendKeys("puzzle");
        goButton.click();

        assert (driver.getTitle().contains("puzzle"));
        driver.quit();
    }

    @Test
    public void testApple() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://pn.com.ua");
        WebElement cellPhone = driver.findElement(By.xpath("//*[@id='column-center']/section/div[2]/ul/li[1]/a"));
        cellPhone.click();
        WebElement appleFilter = driver.findElement(By.xpath("//*[@id='producers-filter-block']//span[4]//a[1]"));
        appleFilter.click();

        WebElement searchResultTitle = driver.findElement(By.xpath("//body/div/div/div/div/div/div/div[@id='column-center']/section/div[3]"));

        assert (driver.getTitle().contains("Мобильные телефоны, смартфоны"));
        assert (searchResultTitle.getText().contains("Apple iPhone 11 128Gb"));
        driver.quit();
    }
}
