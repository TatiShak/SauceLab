import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SauceLab {

        private static final String URL = " https://www.saucedemo.com/";

        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

            driver.get(URL);

            String title = driver.getTitle();
            System.out.println("Step 2 is done");
            if (title.equals("Swag Labs")) {
                System.out.println("Step 3 is done");
            } else {
                System.out.println("Step 3 is failed");
            }

            WebElement loginLogo = driver.findElement(By.className("login_logo"));
            WebElement loginBotPicture = driver.findElement(By.className("bot_column"));
            if (loginLogo.isDisplayed()&&loginBotPicture.isDisplayed()) {
                System.out.println("Step 4 is done");
            } else {
                System.out.println("Step 4 is failed");
            }

            WebElement userName = driver.findElement(By.id("user-name"));
            userName.sendKeys("standard_user");
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("secret_sauce");
            WebElement loginBtn = driver.findElement(By.id("login-button"));
            loginBtn.click();
            System.out.println("Step 5 is done");

            if(driver.getTitle().equals("Swag Labs")){

                System.out.println( "Step 6 is done");
            }else{
                System.out.println("Step 6 is failed");
            }


            WebElement titleProducts = driver.findElement(By.className("title"));
            if (titleProducts.getText().equals("PRODUCTS")) {

                System.out.println( "Step 7 is done");
            } else {
                System.out.println("Step 7 is failed");
            }

            driver.findElement(By.id("react-burger-menu-btn")).click();
            System.out.println( "Step 8 is done");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-item-list")));
            List<WebElement> menuItems = driver.findElements(By.xpath("//a[@class='bm-item menu-item']"));
            String[] menuOptions = {"all items", "about", "logout", "reset app state"};

            for (int i = 0; i < menuItems.size(); i++) {
                boolean menuItemCorrect = menuItems.get(i).getText().trim().toLowerCase().equals(menuOptions[i]);
                if (!menuItemCorrect) {
                    System.out.println("Incorrect menu item: " + menuOptions[i]);
                }
            }
            System.out.println( "Step 9 is done");
            driver.findElement(By.id("about_sidebar_link")).click();
            System.out.println( "Step 10 is done");

            if(driver.getTitle().equals("Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs")){
                System.out.println("Step 11 is done");
            }else{
                System.out.println("Step 11 is failed");
            }

            driver.navigate().back();
            System.out.println("Step 12 is done");

            WebElement closeMenu = driver.findElement(By.id("react-burger-cross-btn"));
            if(closeMenu.isDisplayed()) {
                closeMenu.click();
                System.out.println("Step 13 is done");
            } else {
                System.out.println("Step 13 - is failed because menu was already closed");
            }
            List<WebElement> inventoryElements = driver.findElements(By.className("inventory_item_name"));

            if(inventoryElements.size()==6){
                System.out.println("Step 14 is done");
            }else{
                System.out.println("Step 14 is failed");
            }

            driver.findElement(By.className("product_sort_container")).click();
            driver.findElement(By.xpath("//option[@value='lohi']")).click();
            System.out.println("Step 15 is done");

            List<WebElement> inventoryPrices = driver.findElements(By.className("inventory_item_price"));
            boolean firstPrice = inventoryPrices.get(0).getText().trim().equals("$7.99");
            boolean lastPrice = inventoryPrices.get(inventoryPrices.size()-1).getText().trim().equals("$49.99");
            if(firstPrice && lastPrice){
                System.out.println("Step 16 is done");
            }else{
                System.out.println("Step 16 is failed");
            }

            driver.findElement(By.linkText("Sauce Labs Onesie")).click();
            System.out.println("Step 17 is done");

            WebElement onesieTitle = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));

            WebElement onesieDescription = driver.findElement(By.xpath("//div[@class='inventory_details_desc large_size']"));

            WebElement onesiePrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']"));


            boolean addToCartBtn = driver.findElement(By.id("add-to-cart-sauce-labs-onesie")).isDisplayed();

            if(onesieTitle.getText().equals("Sauce Labs Onesie") && onesieDescription.getText().equals("Rib snap infant onesie for the junior automation engineer in development." +
                    " Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.")
                    && onesiePrice.isDisplayed() && addToCartBtn){
                System.out.println("Step 18 is done");

            }else{
                System.out.println("Step 18 is failed");
            }

            if(driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText().equals("$7.99")){
                System.out.println("Step 19 is done");
            }else{
                System.out.println("Step 19 is failed");
            }

            WebElement clickBtn =  driver.findElement(By.xpath("//div/button[contains(text(),'Add to cart')]"));
            if (clickBtn.isDisplayed()) {
                clickBtn.click();
                System.out.println("Step 20 is done");
            }
            if(driver.findElement(By.id("remove-sauce-labs-onesie")).getText().equals("REMOVE")){
                System.out.println("Step 21 is done");
            }else{
                System.out.println("Step 21 is failed");
            }

            driver.findElement(By.className("shopping_cart_link")).click();
            if(driver.findElement(By.className("title")).isDisplayed()){
                System.out.println("Step 22 is done");
            }else{
                System.out.println("Step 22 is failed");
            }
            if(driver.findElement(By.xpath("//div[@class='cart_quantity']")).getText().equals("1")){
                System.out.println("Step 23 is done");
            }else{
                System.out.println("Step 23 is failed");
            }

            if(driver.findElement(By.id("checkout")).isEnabled()){
                System.out.println("Step 24 is done");
            }else{
                System.out.println("Step 24 is failed");
            }

            driver.findElement(By.id("checkout")).click();
            System.out.println("Step 25 is done");

            Faker faker = new Faker();
            String lastName = faker.name().lastName();
            String firstName = faker.name().firstName();
            String zipCode = faker.address().zipCode().substring(0, 5);

            driver.findElement(By.id("first-name")).sendKeys(firstName);
            driver.findElement(By.id("last-name")).sendKeys(lastName);
            driver.findElement(By.id("postal-code")).sendKeys(zipCode);
            System.out.println("Step 26 is done");



            WebElement continueBtn = driver.findElement(By.id("continue"));
            if(continueBtn.isEnabled()){
                continueBtn.click();
                System.out.println("Step 27 is done");
            }else{
                System.out.println("Step 27 is failed");
            }
            if(driver.findElement(By.className("title")).isDisplayed()){
                System.out.println("Step 28 is done");
            }else{
                System.out.println("Step 28 is failed");
            }

            WebElement paymentInfo = driver.findElement(By.xpath("//div[contains(text(),'SauceCard #31337')]"));
            if(paymentInfo.isDisplayed()){
                System.out.println("Step 29 is done. Confirmation number is: "+ paymentInfo.getText().substring(11));
            }else{
                System.out.println("Step 29 is failed");
            }

            WebElement deliveryInfo = driver.findElement(By.xpath("//div[contains(text(),'FREE PONY EXPRESS DELIVERY!')]"));

            if(deliveryInfo.getText().equals("FREE PONY EXPRESS DELIVERY!")){
                System.out.println("Step 30 is done");
            }
            else{
                System.out.println("Step 30 is failed");
            }

            Double subtotal =  Double.parseDouble(driver.findElement(By.className("summary_subtotal_label")).getText().replaceAll("[^0-9,.]", ""));
            //System.out.println(subtotal);
            Double tax = Double.parseDouble(driver.findElement(By.className("summary_tax_label")).getText().replaceAll("[^0-9,.]", ""));
            Double total = Double.parseDouble(driver.findElement(By.className("summary_total_label")).getText().replaceAll("[^0-9,.]",  ""));
            if (subtotal+tax==total){
                System.out.println("Step 31 is done");
            }else{
                System.out.println("Step 31 is failed");
            }
            if(driver.findElement(By.id("finish")).isEnabled()){
                driver.findElement(By.id("finish")).click();
                System.out.println("Step 32 is done");
            }else{
                System.out.println("Step 32 is failed");
            }
            Boolean thanksMsg = driver.findElement(By.className("complete-header")).getText().equalsIgnoreCase("THANK YOU FOR YOUR ORDER");
            Boolean  orderMsg = driver.findElement(By.className("complete-text")).getText().equalsIgnoreCase("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
            Boolean img = driver.findElement(By.className("pony_express")).isDisplayed();
            if (thanksMsg && orderMsg && img){
                System.out.println("Step 33 is done");
            }else {
                System.out.println("Step 33 is failed");
            }
            if(driver.findElement(By.id("back-to-products")).isEnabled()){
                driver.findElement(By.id("back-to-products")).click();
                System.out.println("Step 34 is done");
            }else {
                System.out.println("Step 34 is failed");
            }

            driver.findElement(By.id("react-burger-menu-btn")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("bm-item-list")));
            driver.findElement(By.id("logout_sidebar_link")).click();
            System.out.println("Step 35 is done");
            Thread.sleep(3000 );
            driver.quit();
            System.out.println("Step 36 is done");

        }
    }
