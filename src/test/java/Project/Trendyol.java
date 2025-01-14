package Project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Trendyol {

    //Tendyol alınan son ürüne yorum yapma

    static WebDriver driver;

    @BeforeAll
    static void beforeAll() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    void Test01() throws InterruptedException {

        driver.get("https://www.trendyol.com/");

        //çerezler penceresi görünürse reddete tıklayacak
        if (driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).isDisplayed()) {

            driver.findElement(By.xpath("//button[@id='onetrust-reject-all-handler']")).click();

        }



        //sağ üst köşede giriş yap butonuna tıklayacak
        driver.findElement(By.xpath("(//p[@class='link-text'])[1]")).click();


        //mail yazma kısmına mail yazacak
        driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("MAİL");


        //Şifre kısmına şifre yazacak
        driver.findElement(By.xpath("//input[@id='login-password-input']")).sendKeys("ŞİFRE");

        //Giriş yapa tıklayacak
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //giriş yapıldığını doğruluyoruz
        Assertions.assertTrue(driver.findElement(By.xpath("(//p[@class='link-text'])[1]")).isDisplayed());

        Thread.sleep(5000);

        //Hesabım butonuna tıklar
        driver.findElement(By.xpath("(//p[@class='link-text'])[1]")).click();

        //Değerlendirmelerim butonuna tıklar
        driver.findElement(By.xpath("(//a[@class='layout-item-container'])[1]")).click();

        //ilk ürünün ürünü değerlendir butonuna tıklar
        driver.findElement(By.xpath("(//button[@class='card-rate-button'])[1]")).click();


        Thread.sleep(5000);

        //(//div[@class='star-w'])[5]

        //5. yıldıza tıklar
        driver.findElement(By.cssSelector(".ratings-wrapper .ratings .star-w:nth-child(5)")).click();


        //yorum kısmına yorum yazar
        driver.findElement(By.xpath("//textarea[@maxlength='2000']")).sendKeys("gayet şık ve sağlam bir çanta memnun kaldım");

        //aydınlatma metni checkboxına tıklar
        driver.findElement(By.xpath("//div[@class='sc']")).click();

        //yorum yap butonuna tıklar
        driver.findElement(By.xpath("(//div[@class='button'])[2]")).click();

    }
}
