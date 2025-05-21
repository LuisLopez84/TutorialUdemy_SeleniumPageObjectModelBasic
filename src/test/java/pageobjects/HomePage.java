package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    @FindBy(xpath = "//input[@name='username']")
    private WebElement textUsername;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement textPasword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id='app']/div[1]/div[1]/header/div[1]/div[1]/span/h6")
    WebElement asercionLogin;


    public void ingresarUsuario(String loginUsuario){
        textUsername.sendKeys(loginUsuario);
    }

    public void ingresarPassword(String loginPassword){
        textPasword.sendKeys(loginPassword);
    }

    public void ingresaraOrangeHRM() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(Long.parseLong("5000"));
    }

    public boolean resAsercionLogin(String mensajeRespuesta){
        System.out.println(mensajeRespuesta); // Mensaje esperado
        System.out.println(asercionLogin.getText()); // Mensaje del elemento (xpath). Llamamos al elemento del dashboard con el contenido (texto) que tenga éste xpath.
        return mensajeRespuesta.equals(asercionLogin.getText());
    }

    public void dataPageLogin(String loginUsuario, String loginPassword, String mensajeRespuesta) throws InterruptedException {
        ingresarUsuario(loginUsuario);
        ingresarPassword(loginPassword);
        ingresaraOrangeHRM();
        resAsercionLogin(mensajeRespuesta);
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
}