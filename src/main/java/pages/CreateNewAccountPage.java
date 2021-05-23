package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccountPage {
    private WebDriver driver;
    private By maleGenderField = By.name("uniform-id_gender1");
    private By femaleGenderField = By.name("uniform-id_gender2");
    private By customerFirstNameField = By.id("customer_firstname");
    private By customerLastNameField = By.id("customer_lastname");
    private By emailField = By.id("email");
    private By passwordField = By.id("passwd");
    private By daysDropDownField = By.id("days");
    private By monthsDropDownField = By.id("months");
    private By yearsDropDownField = By.id("years");
    private By newsletterField = By.id("newsletter");
    private By offersField= By.id("uniform-optin");
    private By firstNameField = By.id("firstname");
    private By lastNameField = By.id("lastname");
    private By companyField = By.id("company");
    private By address1Field = By.id("address1");
    private By address2Field = By.id("address2");
    private By cityField = By.id("city");
    private By stateField = By.id("id_state");
    private By postalCodeField = By.id("postcode");
    private By countryField = By.id("id_country");
    private By otherInfoField = By.id("other");
    private By homePhoneField = By.id("phone");
    private By mobilePhoneField = By.id("phone_mobile");
    private By addressAliasField = By.id("alias");
    private By submitAccountButton = By.id("submitAccount");

    public CreateNewAccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void setGender(String gender){
        if(gender.equals("M")){driver.findElement(maleGenderField).click();}
        if(gender.equals("F")){driver.findElement(femaleGenderField).click();}
    }
    public void setCustomerFirstName(String firstName){driver.findElement(customerFirstNameField).sendKeys(firstName);}
    public void setCustomerLastName(String lastName){driver.findElement(customerLastNameField).sendKeys(lastName);}
    public void setEmail(String email){ driver.findElement(emailField).sendKeys(email); }
    public void setPassword(String password){driver.findElement(passwordField).sendKeys(password);}
    public void setDateOfBirth(String day,String month,String year){
        selectFromDropDown(daysDropDownField,day);
        selectFromDropDown(monthsDropDownField,month);
        selectFromDropDown(yearsDropDownField,year);
    }
    public void setNewsletterOption(){driver.findElement(newsletterField).click();}
    public void setOffersOption(){driver.findElement(offersField).click();}
    public void setFirstNameForAddress(String firstName){driver.findElement(firstNameField).sendKeys(firstName);}
    public void setLastNameForAddress(String lastName){driver.findElement(lastNameField).sendKeys(lastName);}
    public void setCompany(String companyName){driver.findElement(companyField).sendKeys(companyName);}
    public void setCity(String city){driver.findElement(cityField).sendKeys(city);}
    public void setAddress1(String address){driver.findElement(address1Field).sendKeys(address);}
    public void setAddress2(String address){driver.findElement(address2Field).sendKeys(address);}
    public void setAddressAlias(String alias){driver.findElement(addressAliasField).sendKeys(alias);}
    public void setState(String state){selectFromDropDown(stateField,state);}
    public void setPostalCode(String postalCode){driver.findElement(postalCodeField).sendKeys(postalCode);}
    public void setCountry(String country){selectFromDropDown(countryField,country);}
    public void setOtherInfo(String info){driver.findElement(otherInfoField).sendKeys(info);}
    public void setHomePhone(String phone){driver.findElement(homePhoneField).sendKeys(phone);}
    public void setMobilePhone(String phone){driver.findElement(mobilePhoneField).sendKeys(phone);}

    public VerifyEmailSentPage registerAccount(){
        driver.findElement(submitAccountButton).click();
        return new VerifyEmailSentPage(driver);
    }

    private Select findDropdownElement(By dropdown){
        return new Select(driver.findElement(dropdown));
    }
    private void selectFromDropDown(By dropdown,String option){
        findDropdownElement(dropdown).selectByVisibleText(option);
    }
}
