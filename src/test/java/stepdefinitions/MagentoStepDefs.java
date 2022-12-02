package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import pages.LumaHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.io.IOException;
/*
TEST CASE
 Open site https://magento.softwaretestingboard.com/
1.	Add to cart 4 - Gwyn Endurance Tee Medium Green
2.	Address should United Kingdom
3.	Check cart total is $92.00 (discount applied)
4.	Update the Quantity of  Gwyn Endurance Tee Medium Green to 3
5.	Add to cart 1 - Gwyn Endurance Tee Small Yellow
6.	Add to cart 1 Quest Lumaflex™ Band
7.	Check cart total is $116.00
 */
public class MagentoStepDefs {
    LumaHomePage lumaHomePage = new LumaHomePage();
    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

    // Open site https://magento.softwaretestingboard.com/
    @Given("Navigate to the home page")
    public void navigate_to_the_home_page() {
    Driver.getDriver().get(ConfigReader.getProperty("homepage_url"));

}
// To be able to see the address and the total sum I need to sign in as an existing customer
    @Then("user enters existing email as {string} and  password {string}")
    public void user_enters_existing_email_as_and_password(String email, String password) {
        lumaHomePage.SignIn.click();
        Driver.waitAndSendText(lumaHomePage.email,email);
        Driver.waitAndSendText(lumaHomePage.password,password);
        Driver.waitAndClick(lumaHomePage.Login);
        Assert.assertTrue(lumaHomePage.homePage.isDisplayed());
    }
    // Customer should go to the women department page to choose the product
    @When("customer goes to women section select tees and click")
    public void customer_goes_to_women_section_select_tees_and_click() {
        Driver.waitAndClick(lumaHomePage.clickWomen);
        Driver.getDriver().findElement(By.xpath("//li[@class=\"item\"][3]"));
        lumaHomePage.clickTees.click();
    }
    // 1.	Add to cart 4 - Gwyn Endurance Tee Medium Green
    // Task 1 => Step A) choose size and color
    @Then("select Gwyn Tee and click medium size and green color")
    public void select_gwyn_tee_and_click_medium_size_and_green_color() throws IOException {
        Driver.getDriver().findElement(By.xpath("//li[@class='item product product-item'][2]"));
        Driver.waitAndClick(lumaHomePage.medium);
        Driver.waitAndClick(lumaHomePage.green);
        ReusableMethods.getScreenshot("medium");
    }
    // Task 1 => Step B) Add to the basket
    @Then("hover over and click Add to cart")
    public void hover_over_and_click_Add_to_cart(){
        Driver.waitAndClick(lumaHomePage.addCart);
        Driver.wait(1);
        }

    // Task 1 => Step C) Click the basket
    @Then("click the number next to cart symbol")
    public void click_the_number_next_to_cart_symbol() {
       Driver.waitAndClick(lumaHomePage.cartSymbol);
       Driver.wait(2);
       }
    // Task 1 => Step D) Change the Quantity
   @Then("click on qty box and change the number and click update")
    public void click_on_qty_input_box_and_change_the_number_and_click_update() {
        jsExecutor.executeScript("arguments[0].value = 0;", lumaHomePage.inputBox);
       lumaHomePage.inputBox.sendKeys("4");
       lumaHomePage.updateButton.click();
       Driver.wait(1);
     }
    // 2.	Address should United Kingdom
    @When("customer click proceed button and verifies address")
    public void customer_click_proceed_button_and_verifies_address() throws IOException {
        Driver.waitAndClick(lumaHomePage.proceedCheckout);
        Assert.assertTrue(lumaHomePage.verifyAddress.isDisplayed());
        Driver.wait(2);
        ReusableMethods.getScreenshot("verifyAddress");
    }
    // 3.	Check cart total is $92.00 (discount applied)
    //  Task 3 => Step A) go back to previous page
    @When("customer return previous page and click on view edit")
    public void customer_return_previous_page_and_click_on_view_edit() {
        Driver.getDriver().navigate()
                .to("https://magento.softwaretestingboard.com/women/tops-women/tees-women.html");
        Driver.waitAndClick(lumaHomePage.cartSymbol);
        Driver.waitAndClick(lumaHomePage.viewAndEdit);
        Driver.wait(2);

    }
    // Task 3 => Step B) Verify the Discount
    @Then("verify discount applied")
    public void verify_discount_appliedk() throws IOException {
        Assert.assertTrue(lumaHomePage.verifyDiscount.isDisplayed());
        Driver.wait(2);
        ReusableMethods.getScreenshot("verifyDiscount");
    }

    //4.	Update the Quantity of  Gwyn Endurance Tee Medium Green to 3
    @Then("change the quantity and click Update")
    public void change_the_quantity_and_click_update() throws IOException {
        jsExecutor.executeScript("arguments[0].value = 0;", lumaHomePage.quantityBox);
        lumaHomePage.quantityBox.sendKeys("3");
       Driver.waitAndClick(lumaHomePage.updateShopping);
       Driver.wait(2);
          ReusableMethods.getScreenshot("updateShopping");
    }
    //5.	Add to cart 1 - Gwyn Endurance Tee Small Yellow
    // Task 5 => Step A) Go to women department page
    @Then("customer return women department page")
    public void customer_return_women_department_page() {
       Driver.getDriver().navigate()
                .to("https://magento.softwaretestingboard.com/women/tops-women/tees-women.html");
    }

    //  Task 5 =>Step B)
    @Then("choose the item and add to the basket")
    public void choose_the_item_and_add_to_the_basket() throws IOException {
        Driver.getDriver().findElement(By.xpath("//li[@class='item product product-item'][2]"));
        lumaHomePage.smallSize.click();
        lumaHomePage.yellowColor.click();
        Driver.waitAndClick(lumaHomePage.addCart);
        Driver.wait(1);
        ReusableMethods.getScreenshot("addCart");
       }

     // 6.	Add to cart 1 Quest Lumaflex™ Band
    @Then("goes to the fitness page and select the item")
    public void goes_to_the_fitness_page_and_select_the_item() {
        Driver.getDriver().findElement(By.xpath("//*[@id=\"ui-id-6\"]/span[2]"));
        actions.moveToElement(lumaHomePage.gearButton).perform();
        Driver.waitAndClick(lumaHomePage.fitnessEquip);
        Driver.getDriver().findElement(By.xpath("(//a[@class=\"product-item-link\"])[6]"));
        actions.moveToElement(lumaHomePage.priceflexBand).perform();
        Driver.waitAndClick((lumaHomePage.lastAddCart));
    }
    // 7.	Check cart total is $116.00
    @Then("checks the cart and verifies total amount")
    public void checks_the_cart_and_verifies_total_amount() throws IOException {
        Driver.getDriver().findElement(By.xpath("//span[@class='counter-number']"));
        Driver.waitAndClick(lumaHomePage.cartSymbol);
        Driver.wait(1);
         Assert.assertTrue(lumaHomePage.finalFigure.isDisplayed());
        ReusableMethods.getScreenshot("updateButton");
    }
}
// All the steps passed