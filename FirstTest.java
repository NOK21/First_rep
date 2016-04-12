import junit.framework.TestCase;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by SamsungR538 on 11.04.2016.
 */
public class FirstTest extends TestCase{
    private static WebDriver driver = new FirefoxDriver();
    private By input = By.id ("searchInput");
    private By image = By.xpath("//img[@alt='Logo Tesla Motors.svg']");
    private By discription = By.xpath("//div[@id='mw-content-text']/table/tbody/tr[2]/td/p");

    @Before
    public void setUp() throws Exception {
        driver.get ("https://ru.wikipedia.org");}

    @Test
    public void testSearchTesla() throws Exception {
        WebElement wikiSearch = driver.findElement(input);
        wikiSearch.sendKeys("Tesla Motors");
        wikiSearch.submit();
        assertTrue(driver.getTitle().contains("Tesla"));
        WebElement proof = driver.findElement(image);
        assertTrue(proof.isDisplayed());
    }

    @Test
    public void testSearchSelenium() throws Exception {
        WebElement wikiSearch = driver.findElement(input);
        wikiSearch.sendKeys("Selenium");
        wikiSearch.submit();
        WebElement discript = driver.findElement(discription);
        assertEquals("Wrong page","тестирование программного обеспечения",discript.getText());
    }

    @After
    public void tearDown () throws Exception {
        driver.quit();
    }







}
