import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class KongaWebOrderingTest {

    //import selenium web driver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");

        //1. Open chrome broswer
        driver = new ChromeDriver();

        //2. Input Konga URL (https://www.konga.com/)
        driver.get("https://www.konga.com/");
        Thread.sleep(15000);

        //3. Maximise the browser
        driver.manage().window().maximize();

        //4. Click on login / sign up button to open sign up page
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(15000);
        }

        @Test (priority = 0)
         public void logIn() throws InterruptedException {
            //5.Locate Email Address / Phone Number field to input Email address
            driver.findElement(By.id("username")).sendKeys("aitee@mailinator.com");

            //6. Locate Password field and input password
            driver.findElement(By.id("password")).sendKeys("Generate123@");
            Thread.sleep(5000);

            //7.Click on Login button
            driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
            Thread.sleep(5000);
            }

         @Test (priority = 1)
          public void computersCategories() throws InterruptedException {
             //8. Click on Computers and Accesories
             driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
             Thread.sleep(15000);

             //9. Click on laptops
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
             Thread.sleep(6000);

             //10. Click on Apple Macbook
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
             Thread.sleep(16000);

             //11.Click Add to Cart for selected Macbook
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[2]/div/div/div[2]/form/div[3]/button")).click();
             Thread.sleep(10000);
             }

         @Test (priority = 2)
          public void toCart() throws InterruptedException {
             //12. click on cart
             driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
             Thread.sleep(5000);

             //13.click on checkout
             driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
             Thread.sleep(5000);
             }

         @Test (priority = 3)
          public void chooseAddress() throws InterruptedException {
             //14. Click on Change
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
             Thread.sleep(5000);

             //15. Click on Add delivery address
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
             Thread.sleep(5000);

             //16. Click on Select Address
             driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
             Thread.sleep(5000);

             //17.Click on Use this address
             driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
             Thread.sleep(3000);
             }

          @Test (priority = 4)
          public void payOption() throws InterruptedException{
             //18. click on pay now
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
             Thread.sleep(5000);

             //19. Click on continue to payment
             driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
             Thread.sleep(5000);

             //20. Click on card
              driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
              Thread.sleep(5000);

              //22. locate iframe element
              WebElement iFrame = driver.findElement(By.tagName("iframe"));

              //23. switch focus to iframe
              driver.switchTo().frame("kpg-frame-component");

              //24.click on card button iframe
              WebElement cardbutton = driver.findElement(By.className("Card"));

              //25. click on card button
              cardbutton.click();
              Thread.sleep(5000);

              //26.click on card number field
              WebElement cardnumber = driver.findElement(By.id("card-number"));

              //27. input invalid card number in card number field
              cardnumber.sendKeys("1022304410223044");

              //28. click on date field
              WebElement datebutton = driver.findElement(By.className("expiry"));

              //29. input date in date field
              datebutton.sendKeys("01/25");

              //30. click on cvv field
              WebElement cvvbutton = driver.findElement(By.id("cvv"));

              //31. input cvv number in cvv field
              cvvbutton.sendKeys("419");

              //32.print out  error message
              WebElement errormessage = driver.findElement(By.id("card-number_unhappy"));
              System.out.println(errormessage.getText());
              Thread.sleep(5000);

              //33. close iframe
              WebElement closeiframe = driver.findElement(By.className("data-card__close"));
              closeiframe.click();
              Thread.sleep(3000);

              //34. switch out of iframe
              driver.switchTo().defaultContent();
              Thread.sleep(5000);
              }
          @AfterTest
          public void  closeBrowser() {
             //25. Close browser
              driver.quit();
              }

    }

