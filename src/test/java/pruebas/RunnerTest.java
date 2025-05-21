package pruebas;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RunnerTest extends BaseTestSuite {


    @Test
    public void login() throws InterruptedException {

        homePage.dataPageLogin("Admin", "admin123", "Dashboard");
        Assertions.assertTrue(homePage.resAsercionLogin("Dashboard"));
    }

    @Test
    public void addUser() throws InterruptedException {

        addNewUser.dataPageNewUser("Admin", "admin123", "J", "LLOPEZ6", "1234567l", "1234567l");
    }

    @Test
    public void consultaNewUser() throws InterruptedException {

        consultUser.dataPageConsultaUsuario("Admin", "admin123", "LLOPEZ6", "J", "LLOPEZ6");
        Assertions.assertTrue(consultUser.resAsercionConsulta("LLOPEZ6"));
    }
}