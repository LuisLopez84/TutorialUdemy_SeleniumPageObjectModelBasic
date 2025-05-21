package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConsultUser {

    @FindBy(xpath = "//input[@name='username']")
    WebElement textUsername;

    @FindBy(xpath = "//input[@name='password']")
    WebElement textPasword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")
    WebElement linkAdmin;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement textConsultaUsername;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")
    WebElement listaRole;

    @FindBy(xpath = "//div[@role='listbox']")
    WebElement seleccionarAdmin;

    @FindBy(css = "input[placeholder='Type for hints...']")
    WebElement empInput;

    @FindBy(css = "div[role='listbox'] div[role='option']")
    WebElement firstOption;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")
    WebElement listaStatus;

    @FindBy(xpath = "//div[@role='listbox']")
    WebElement seleccionarAdminStatus;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement botonSubmit;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
    WebElement asercionConsula;

    public void loginUsername(String usernameLogin){
        textUsername.sendKeys(usernameLogin);
    }

    public void loginPassword(String passwordLogin){
        textPasword.sendKeys(passwordLogin);
    }

    public void botonLogin(){
        btnLogin.click();
    }

    public void linkIzquierdoAdmin() throws InterruptedException {
        linkAdmin.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void consultaUsername(String usernameConsult) throws InterruptedException {
        textConsultaUsername.sendKeys(usernameConsult);
        Thread.sleep(Long.parseLong("1000"));
    }

    public void listaDesplegableUserRole() throws InterruptedException {
        listaRole.click();
        Thread.sleep(Long.parseLong("1000"));
    }

    public void seleccionarUserRoleList() throws InterruptedException {
        seleccionarAdmin.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void ingresarTextoBusqueda(String textoBusqueda) throws InterruptedException {
        empInput.sendKeys(textoBusqueda);
        Thread.sleep(Long.parseLong("3000"));
    }

    public void seleccionarPrimeraOpcion() throws InterruptedException {
        firstOption.click();
        Thread.sleep(Long.parseLong("5000"));
    }

    public void listaStatusDesplegable() throws InterruptedException {
        listaStatus.click();
        Thread.sleep(1000);
    }

    public void seleccionStatusAdmin() throws InterruptedException {
        seleccionarAdminStatus.click();
        Thread.sleep(Long.parseLong("500"));
    }

    public void botonConsulta() throws InterruptedException {
        botonSubmit.click();
        Thread.sleep(Long.parseLong("3000"));
    }

    public boolean resAsercionConsulta(String mensajeRespuesta){
        System.out.println(mensajeRespuesta); // Mensaje esperado
        System.out.println(asercionConsula.getText()); // Mensaje del elemento (xpath). Llamamos al elemento del dashboard con el contenido (texto) que tenga éste xpath.
        return mensajeRespuesta.equals(asercionConsula.getText());
    }

    public void dataPageConsultaUsuario(String usernameLogin, String passwordLogin, String usernameConsult, String textoBusqueda, String mensajeRespuesta) throws InterruptedException {
        loginUsername(usernameLogin);
        loginPassword(passwordLogin);
        botonLogin();
        linkIzquierdoAdmin();
        consultaUsername(usernameConsult);
        listaDesplegableUserRole();
        seleccionarUserRoleList();
        ingresarTextoBusqueda(textoBusqueda);
        seleccionarPrimeraOpcion();
        listaStatusDesplegable();
        seleccionStatusAdmin();
        botonConsulta();
        resAsercionConsulta(mensajeRespuesta);
    }

    public ConsultUser(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

}
