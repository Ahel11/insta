package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.util.List;

public class SeleniumHandler {

    public static String url = "https://www.mail.ru";
    private WebDriver driver;

    public SeleniumHandler() {
        initialize();
    }

    private void initialize() {
        this.driver = generateDriver();
    }

    public void sendMails() {
        login();
        sleep(4000);

        sendMessages();
    }

    private void sendMessages() {
        int nrOfFailedTimes = 0;
        while(true) {
            if(nrOfFailedTimes > 3) {
                break;
            }
            try {
                WebElement sendMessageButton = this.driver.findElement(By.className("b-toolbar__btn"));
                sendMessageButton.click();
                sleep(3000);
                writeEmailAddresses();
                break;
            } catch (Exception e) {
                nrOfFailedTimes++;
                sleep(9000);
            }
        }
    }

    private void writeEmailAddresses() {
        WebElement mailInputField = this.driver.findElements(By.className("compose__labels__input")).get(1);
        for(int i=0; i<29; i++) {
            mailInputField.sendKeys(String.valueOf(System.currentTimeMillis() + "@gmail.com\t"));
            sleep(150);
        }
    }

    private void login() {
        this.driver.get(url);
        WebElement loginMail = this.driver.findElement(By.id("mailbox__login"));
        WebElement loginPass = this.driver.findElement(By.id("mailbox__password"));
        WebElement loginButton = this.driver.findElement(By.id("mailbox__auth__button"));

        loginMail.sendKeys("timofeigromik1978@mail.ru");
        loginPass.sendKeys("sQ0PxtHO37A");
        loginButton.click();
    }

    private WebDriver generateDriver() {
        File pathToBinary = new File("C:\\Users\\ahmad\\Desktop\\generalFiles\\librarys\\Selenium\\2.53\\firefox\\firefox46\\firefox.exe");
        FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
        FirefoxProfile firefoxProfile = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(ffBinary,firefoxProfile);

        return driver;
    }

    public static void main(String args[]) {
        SeleniumHandler handler = new SeleniumHandler();

    }


    private void sleep(long ms) {
        try {

            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

}

