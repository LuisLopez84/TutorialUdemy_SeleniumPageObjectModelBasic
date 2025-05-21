package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewUser {

    @FindBy(xpath = "//input[@name='username']")
    WebElement textUsername;

    @FindBy(xpath = "//input[@name='password']")
    WebElement textPasword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    WebElement linkAdmin;

    @FindBy(xpath = "//i[@class='oxd-icon bi-plus oxd-button-icon']")
    WebElement btnAddUser;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
    WebElement clicListUserRole;

    @FindBy(xpath = "//div[@role='listbox']")
    WebElement seleccionarAdmin;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
    WebElement clicListStatus;

    @FindBy(xpath = "//div[@role='listbox']")
    WebElement seleccionarStatus;

    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement empInput;

    @FindBy(css = "div[role='listbox'] div[role='option']")
    WebElement firstOption;

    @FindBy(xpath = "//label[text()='Username']/following::input[1]")
    WebElement ingresarUsername;

    @FindBy(xpath = "//label[text()='Status']/following::div[1]")
    WebElement statusDropdown;

    @FindBy(xpath = "//label[text()='Password']/following::input[1]")
    WebElement ingresarPassword;

    @FindBy(xpath = "//label[text()='Confirm Password']/following::input[1]")
    WebElement confirmarPassword;

    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement buttonSubmit;

    public void ingresoUsername(String userLogin){
        textUsername.sendKeys(userLogin);
    }

    public void ingresoPassword(String passwordLogin){
        textPasword.sendKeys(passwordLogin);
    }

    public void botonLogin(){
        btnLogin.click();
    }

    public void linkAdmin() throws InterruptedException {
        linkAdmin.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void botonAdicionarUsuario(){
        btnAddUser.click();
    }

    public void desplegableUserRole() throws InterruptedException {
        clicListUserRole.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void seleccionarUserRole() throws InterruptedException {
        seleccionarAdmin.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public  void desplegableStatus() throws InterruptedException {
        clicListStatus.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void seleccionStatusEnable1() throws InterruptedException {
        seleccionarStatus.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void ingresoTextoEmploye(String ingresoTextoBusqueda) throws InterruptedException {
        empInput.sendKeys(ingresoTextoBusqueda);
        Thread.sleep(Long.parseLong("3000"));
    }
    public void seleccionPrimeraOpcionEmploye() throws InterruptedException {
        firstOption.click();
        Thread.sleep(Long.parseLong("5000"));
    }

    public void ingresoNuevoUsuario(String textoNuevoUsuario) throws InterruptedException {
        ingresarUsername.sendKeys(textoNuevoUsuario);
        Thread.sleep(500);
    }

    public void seleccionStatusEnable2() throws InterruptedException {
        statusDropdown.click();
        Thread.sleep(500);
    }

    public void ingresoPasswordNew(String ingresoPass) throws InterruptedException {
        ingresarPassword.sendKeys(ingresoPass);
        Thread.sleep(500);
    }

    public void confirmarNewPassword(String confirmPass) throws InterruptedException {
        confirmarPassword.sendKeys(confirmPass);
        Thread.sleep(500);
    }

    public void clicButtonSubmit() throws InterruptedException {
        buttonSubmit.click();
        Thread.sleep(5000);
    }

    public void dataPageNewUser(String userLogin, String passwordLogin, String ingresoTextoBusqueda, String textoNuevoUsuario, String ingresoPass, String confirmPass) throws InterruptedException {
        ingresoUsername(userLogin);
        ingresoPassword(passwordLogin);
        botonLogin();
        linkAdmin();
        botonAdicionarUsuario();
        desplegableUserRole();
        seleccionarUserRole();
        desplegableStatus();
        seleccionStatusEnable1();
        ingresoTextoEmploye(ingresoTextoBusqueda);
        seleccionPrimeraOpcionEmploye();
        ingresoNuevoUsuario(textoNuevoUsuario);
        seleccionStatusEnable2();
        ingresoPasswordNew(ingresoPass);
        confirmarNewPassword(confirmPass);
        clicButtonSubmit();
    }

    public AddNewUser(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
