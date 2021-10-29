package co.com.sofka.runners.testwithoutcucumber;

import co.com.sofka.page.practiceform.PracticeForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTest {

    private WebDriver driver;

    @BeforeEach //Esto es para hacer los ajustes antes de iniciar la prueba
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/windows/chrome/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.demoqa.com/automation-practice-form");
    }

    @Test //Lo que se hace durante el test es llenar los campos obligatorios(en este caso en concreto)
    public void practiceFormMandatoryFields(){
        PracticeForm practiceForm = new PracticeForm(driver);
        practiceForm.typeName("Teodoro");
        practiceForm.typeLastName("Calle");
        practiceForm.clickGenderMale();
        practiceForm.typeUserNumberMobile("1234567890");
        practiceForm.doSubmit();

        /**=========Validaciones===========*/
        Assertions.assertEquals(practiceForm.isRegistrationDone(),forSubmittedForm());
    }

    @AfterEach //TearDown traduce dar de baja o terminar, lo usamos para cerrar el driver despues del test
    public void tearDown(){

        driver.quit();
    }

    private List<String> forSubmittedForm(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add("Teodoro Calle");
        submitedFormResult.add("Male");
        submitedFormResult.add("1234567890");
        return submitedFormResult;
    }

}
