package ujianmingguan3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ujianmingguan3 {
    public static void main(String[] args) {
        String path = "C:\\MyTools\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String URL = "https://shop.demoqa.com/";
        driver.get(URL);
        System.out.println("Open Browser");

        WebElement clickDismis = driver.findElement(By.xpath("/html/body/p/a"));
        clickDismis.click();
        delay(6);

        WebElement myAccount = driver.findElement(By.xpath("//a[normalize-space()='My Account']"));
        myAccount.click();
        delay(6);

        //Login
        scrollByPixels(driver, 0, 400);
        WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));

        username.sendKeys("dickyfarhan");
        password.sendKeys("Diky123123#");
        delay(3);
        btnLogin.click();
        delay(4);
        System.out.println("Success Login");

        //Find Product
        WebElement txtDashboardName = driver.findElement(By.xpath("//a[normalize-space()='Dashboard']"));
        String getTxtDashboardName = txtDashboardName.getText();
        assertEquals(getTxtDashboardName,"Dashboard");
        WebElement dashboard = driver.findElement(By.xpath("//span[contains(text(),'ToolsQA Demo Site')]"));
        dashboard.click();

        delay(4);
        WebElement elemntScrollTo = driver.findElement(By.xpath("//div[@class='noo_simple_banner left']//img[@class='attachment-full size-full']"));
        scrollIntoView(driver, elemntScrollTo);

        //ChooseProduct
        WebElement txtProductName = driver.findElement(By.xpath("//a[normalize-space()='red satin round neck backless maxi dress']"));
        String getTxtProductName = txtProductName.getText();
        WebElement chooseProduct = driver.findElement(By.xpath("//a[normalize-space()='red satin round neck backless maxi dress']"));
        System.out.println("Choose RED SATIN ROUND NECK BACKLESS MAXI DRESS");
        assertEquals(getTxtProductName, "RED SATIN ROUND NECK BACKLESS MAXI DRESS");
        chooseProduct.click();


        //Color and Size
        scrollByPixels(driver,0,450);
        WebElement txtColorProduct = driver.findElement(By.xpath("//label[@for='pa_color']"));
        String getTxtColorProduct = txtColorProduct.getText();
        WebElement selectColor = driver.findElement(By.xpath("//select[@id='pa_color']"));
        Select selectColorRed = new Select(selectColor);
        delay(2);
        selectColorRed.selectByValue("red");
        delay(3);
        System.out.println("Color : Red");
        assertEquals(getTxtColorProduct, "COLOR");

        //Size
        WebElement txtSizeProduct = driver.findElement(By.xpath("//label[@for='pa_size']"));
        String getTxtSizeProduct = txtSizeProduct.getText();
        WebElement selectSize = driver.findElement(By.xpath("//select[@id='pa_size']"));
        Select selectSizeSmall = new Select(selectSize);
        delay(2);
        selectSizeSmall.selectByValue("small");
        delay(3);
        System.out.println("Size : Small");
        assertEquals(getTxtSizeProduct, "SIZE");

        //Plus Item

        WebElement plusItem = driver.findElement(By.xpath("//i[@class='icon_plus']"));
        System.out.println("+ Item Clicked");
        plusItem.click();
        delay(4);

        //Add To Cart
        WebElement txtAddToCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        String getTxtAddToCart = txtAddToCart.getText();
        WebElement addToChart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        System.out.println("Add To Cart");
        assertEquals(getTxtAddToCart, "ADD TO CART");
        addToChart.click();



        //Open cart;
        delay(4);
        WebElement txtOpenCart =driver.findElement(By.xpath("//a[@class='button wc-forward']"));
        String getTxtOpenChart = txtOpenCart.getText();
        WebElement openCart = driver.findElement(By.xpath("//a[@class='button wc-forward']"));
        System.out.println("View Cart");
        assertEquals(getTxtOpenChart,"View cart");
        openCart.click();
        delay(4);

        //ProcessCheckOut
        scrollByPixels(driver,0,400);
        WebElement txtCheckOut = driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
        String getTxtCheckOut = txtCheckOut.getText();
        WebElement ProcessCheckOut = driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']"));
        delay(4);
        System.out.println("Checkout");
        assertEquals(getTxtCheckOut,"PROCEED TO CHECKOUT");
        ProcessCheckOut.click();
        delay(4);


        driver.quit();
        System.out.println("Browser Closed");
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void assertEquals (String actualText, String expectedText) {
        if (actualText.equals(expectedText)) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
    public static void scrollIntoView(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth' });", element);
        System.out.println("Scroll To Target with Element");
    }

    public static void scrollByPixels(WebDriver driver, int x, int y) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy({ top: " + y + ", behavior: 'smooth' });");
        System.out.println("Scrolling smooth To Target with Pixels");
    }
}
