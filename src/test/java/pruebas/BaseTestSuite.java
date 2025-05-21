package pruebas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobjects.AddNewUser;
import pageobjects.ConsultUser;
import pageobjects.HomePage;

import java.util.concurrent.TimeUnit;

public class BaseTestSuite {

    protected WebDriver chromeDriver;

    HomePage homePage;
    AddNewUser addNewUser;
    ConsultUser consultUser;

    private void inicializarpaginas(WebDriver driver){

        homePage = new HomePage(driver);
        addNewUser = new AddNewUser(driver);
        consultUser = new ConsultUser(driver);
    }

    @BeforeEach
    public void abrirNavegador() {

        // Reconocer el webdriver
        System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");

        // Creamos las opciones sobre el driver
        ChromeOptions options = new ChromeOptions();

        // Creamos una nueva instancia de chromeDriver
        chromeDriver = new ChromeDriver(options);

        // Definimos el tiempo de espera implícito para los elementos de la página
        chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        inicializarpaginas(chromeDriver);

        // Abrir el navegador de Google Chrome
        chromeDriver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Maximizar la ventana del navegador
        chromeDriver.manage().window().maximize();


    }
    @AfterEach
    public void cerrarNavegador () {
        // Cerra el navegador
        chromeDriver.quit();
    }
}
