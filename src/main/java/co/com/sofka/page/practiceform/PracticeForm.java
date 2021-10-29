package co.com.sofka.page.practiceform;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class PracticeForm {

    /**Atributos*/
    private WebDriver driver; //Para usar los locators y los metodos en la web

    /**Localizadores------------------------------------------------------------*/
    /**=========================================================================*/
    private final By name = By.id("firstName");
    private final By lastName = By.id("lastName");
    private final By genderMale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[1]/label");
    private final By genderFemale = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label");
    private final By genderOther = By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[3]/label");
    private final By userNumberMobile = By.id("userNumber");
    private final By btnSubmit = By.id("submit");

    /**Localizadores--para--validar--los--datos--del--registro-------------------*/
    /**=========================================================================*/
    private final By assertionStudentName = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[1]/td[2]");
    private final By assertionGender = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[3]/td[2]");
    private final By assertionMobile = By.xpath("/html/body/div[4]/div/div/div[2]/div/table/tbody/tr[4]/td[2]");

    //=====================================Metodos===============================//
    //==========================//
    /**=========Construtor===========*/
    public PracticeForm(WebDriver driver) {
        this.driver = driver;
    }

    /**==========================================================================**/
    //==Metodo para escribir o pasar paramatros
    public void typeName(String name){
        driver.findElement(this.name).clear();
        driver.findElement(this.name).sendKeys(name);
    }

    public void typeLastName(String lastName){
        driver.findElement(this.lastName).clear();
        driver.findElement(this.lastName).sendKeys(lastName);
    }

    public void typeUserNumberMobile(String numberMobile){
        driver.findElement(this.userNumberMobile).clear();
        driver.findElement(this.userNumberMobile).sendKeys(numberMobile);
    }

    //=========Metodos para seleccionar el genero mediante un click
    public void clickGenderMale(){
        driver.findElement(this.genderMale).click();
    }

    public void clickGenderFemale(){
        driver.findElement(this.genderFemale).click();
    }

    public void clickGenderOther(){
        driver.findElement(this.genderOther).click();
    }

    //===Click sobre el boton submit o hacer submit
    public void doSubmit(){
        driver.findElement(this.btnSubmit).submit();
    }

    //===Metodo para saber si ya se hizo el regitro
    public List<String> isRegistrationDone(){
        List<String> submitedFormResult = new ArrayList<String>();
        submitedFormResult.add(driver.findElement(assertionStudentName).getText().trim());
        submitedFormResult.add(driver.findElement(assertionGender).getText().trim());
        submitedFormResult.add(driver.findElement(assertionMobile).getText().trim());
        return submitedFormResult;
    }

}
