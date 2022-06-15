import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;



public class Main {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "/Users/laraalissa/Downloads/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx\n");

        driver.findElement(By.xpath("/html/body/form/div[3]/input[1]")).sendKeys("Tester");
        driver.findElement(By.xpath(" /html/body/form/div[3]/input[2]")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/form/div[3]/input[3]")).click();


        driver.findElement(By.xpath("//a[@href='Process.aspx']")).click();
        int price = 100;

        double discount = 0.08;
        int quantity = (int) (1 + Math.random() * 100);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[2]/input")).sendKeys(Keys.chord(Keys.BACK_SPACE+
                "" + quantity));

        if (quantity > 0 && quantity <= 10) {
            System.out.println(price * quantity);
        }
        if (quantity > 10 && quantity <= 100) {
            System.out.println(price * quantity - discount);

            Thread.sleep(1000);


        }

        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[1]/li[5]/input[2]")).click();

        String firstName = "Dona";
        String lastName = "Smith";

        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[2]/li[1]/input")).sendKeys(firstName + " " + lastName);
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[2]/li[2]/input")).sendKeys("4444 Main St");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[2]/li[3]/input")).sendKeys("Springfield");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[2]/li[4]/input")).sendKeys("VA");
        driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td[2]/div[2]/table/tbody/tr/td/ol[2]/li[5]/input")).sendKeys("22341");
        Thread.sleep(1000);


        Thread.sleep(2000);


        int cardType =1+(int)(Math.random()*3) ;
        String cardNum = "";
        if (cardType == 1) {
        WebElement visa = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        visa.click();
        long visaNumber = 4000000000000000L + (long) (Math.random() * 1000000000000000L);
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(Keys.chord("" + visaNumber));

       // driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_" + cardType)).click();

        //driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNum);

 } else if (cardType == 2) {
            WebElement masterCard = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
            masterCard.click();
            long mastercardNumber = 5000000000000000L + (long) (Math.random() * 1000000000000000L);
            driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(Keys.chord(""+mastercardNumber));

    } else if (cardType == 3) {
        WebElement americanExpress = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
        americanExpress.click();
        long americanExpressNumber = 300000000000000L + (long) (Math.random() * 100000000000000L);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).sendKeys(Keys.chord(""+americanExpressNumber));
    }

        Thread.sleep(1000);

        int mm=1+(int)(Math.random()*12);
        if ( mm>=1 && mm<=9) {
            System.out.println("0" + mm);
        }else{
            System.out.println(mm);

        int yy=22+(int)(Math.random()*31);
        driver.findElement(By. name( "ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(mm+"/"+yy);
            Thread.sleep(1000);

        //driver.findElement(By. xpath ("//a[@class='btn_light']")).click();
        driver.findElement(By. className ("btn_light")).click();

        String pageSource=driver.getPageSource();
        System.out.println(pageSource);
        String expectedText="New order has been successfully added";
        Assert.assertTrue(pageSource.contains(expectedText));


        driver.close();
}}}

