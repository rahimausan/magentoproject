package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LumaHomePage {
    // create CONSTRUCTOR (step1)
    public LumaHomePage() {
        // PageFactory is used for initializing the page object
    PageFactory.initElements(Driver.getDriver(),this);
    }
    // we will use @FindBy annotation to locate the elements(step3)
    @FindBy(xpath="/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    public WebElement  SignIn;
    @FindBy(xpath = "//*[@id=\"email\"]")
    public WebElement email;
    @FindBy(xpath = "//*[@id=\"pass\"]")
    public WebElement password;
    @FindBy(xpath = "//*[@id=\"login-form\"]/fieldset/div[4]/div[1]")
    public WebElement Login;
    @FindBy(xpath = "//span[@class='logged-in']")
    public WebElement homePage;
    @FindBy(xpath ="//*[@id='ui-id-4']/span[2]")
    public WebElement clickWomen;
    @FindBy(xpath="//li[@class=\"item\"][3]/a")
    public WebElement clickTees;
//    @FindBy(xpath ="//li[@class='item product product-item'][2]")
//    public WebElement enduranceTee;
    @FindBy(xpath ="(//*[@id=\"option-label-size-143-item-168\"])[2]")
    public WebElement medium;
    @FindBy(xpath ="(//*[@id=\"option-label-color-93-item-53\"])[1]")
    public WebElement green;
    @FindBy(xpath ="(//span[contains(text(),'Add to Cart')])[2]")
    public WebElement addCart;
    @FindBy(xpath ="//div[@class='message-success success message']")
    public WebElement verifyMessage;
    @FindBy(xpath ="//span[@class='counter-number']")
    public WebElement cartSymbol;
    @FindBy(xpath ="//input[@class=\"item-qty cart-item-qty\"]")
    public WebElement inputBox;
    @FindBy(xpath ="//*[@class=\"update-cart-item\"]")
    public WebElement updateButton;
    @FindBy(xpath ="(//div[@class='actions'])[1]")
    public WebElement proceedCheckout;
    @FindBy(xpath ="//a[@class='action viewcart']")
    public WebElement viewAndEdit;
    @FindBy(xpath ="//div[@class='shipping-address-items']")
    public WebElement verifyAddress;
    @FindBy(xpath ="(//td[@class=\"amount\"])[4]")
    public WebElement verifyDiscount;
    @FindBy(xpath = "(//*[@id=\"option-label-size-143-item-167\"])[2]")
    public WebElement smallSize;
    @FindBy(xpath = "(//*[@id=\"option-label-color-93-item-60\"])[2]")
    public WebElement yellowColor;
    @FindBy(xpath ="//input[@class=\"input-text qty\"]")
    public WebElement quantityBox; //and delete 4 and put 3
    @FindBy(xpath ="//button[@title='Update Shopping Cart']")
    public WebElement updateShopping;
//    @FindBy(xpath = "(//span[@class=\"count\"])[1]")
//    public WebElement updateItems; //Verify 3 Items in Cart
    @FindBy(xpath = "//*[@id=\"ui-id-6\"]/span[2]")
    public WebElement gearButton;
    @FindBy(xpath = "//*[@id=\"ui-id-26\"]/span")
    public WebElement fitnessEquip;
    @FindBy(xpath = "(//a[@class=\"product-item-link\"])[6]")
    public WebElement lumaflexBand;
    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[6]/div/div/div[3]/div/div[1]/form/button/span")  // (//input[@name="form_key"])[1] //(//div[@class="actions-primary"])[6]
    public WebElement lastAddCart;
    @FindBy(xpath = "//*[@id=\"product-price-20\"]/span")
    public WebElement priceflexBand;
    @FindBy(xpath = "(//span[@class=\"price-wrapper\"])[1]")
    public WebElement finalFigure;

}
