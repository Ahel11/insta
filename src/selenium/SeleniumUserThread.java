package selenium;


import helpers.MailTextGenerator;
import model.MailAccount;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;

public class SeleniumUserThread extends Thread {

    public static String url = "https://www.mail.ru";
    private WebDriver driver;
    private MailAccount mailAccount;

    public SeleniumUserThread() {
        initialize();
    }

    private void initialize() {
        this.driver = generateDriver();
    }

    public void sendMails() {
        login();
        sleepT(4000);
        for(int i=0; i<4; i++) {
            sendMessages();
            sleepT(3000);
        }
    }

    public void run() {
        sendMails();
    }

    public void abort() {
        this.driver.close();
        this.stop();
    }

    private void sendMessages() {
        int nrOfFailedTimes = 0;
        while(true) {
            if(nrOfFailedTimes > 3) {
                break;
            }
            try {
                WebElement sendMessageButton = this.driver.findElement(By.className("b-toolbar__btn"));
                sendMessageButton.sendKeys(Keys.chord(Keys.ESCAPE));
                sendMessageButton.click();

                //Write the email addresses
                sleepT(3000);
                writeEmailAddresses();

                //Write the title for the mail
                sleepT(1500);
                writeTitle("Found you on your IG bio");

                //Write the textbody for the mail
                sleepT(1500);
                writeTextBody();

                //Send the mail
                sleepT(1500);
                clickOnSend();

                break;
            } catch (Exception e) {
                nrOfFailedTimes++;
                sleepT(9000);
            }
        }
    }

    private void clickOnSend() {
        this.driver.findElement(By.className("b-toolbar__btn")).click();
    }

    private void writeTextBody() {
        String body = MailTextGenerator.generateMailText();
        this.driver.findElements(By.tagName("iframe")).get(1).click();
        sleepT(100);
        this.driver.findElements(By.tagName("iframe")).get(1).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        sleepT(100);
        this.driver.findElements(By.tagName("iframe")).get(1).sendKeys("");
        sleepT(100);
        this.driver.findElements(By.tagName("iframe")).get(1).sendKeys(body);
        sleepT(500);
        this.driver.findElements(By.tagName("iframe")).get(1).sendKeys(Keys.chord(Keys.CONTROL, Keys.ALT, Keys.ENTER));

    }

    private void writeTitle(String title) {
        this.driver.findElements(By.className("b-input")).get(3).sendKeys(title);
    }

    private void writeEmailAddresses() {
        WebElement mailInputField = this.driver.findElements(By.className("compose__labels__input")).get(1);
        String mails[] = MailTextGenerator.getMails();
        mailInputField.sendKeys(MailTextGenerator.getMails());
        for(int i=0; i<mails.length; i++) {
            mailInputField.sendKeys(String.valueOf(mails[i] +"\t"));
            sleepT(22);
        }
    }

    private void login() {
        this.driver.get(url);
        WebElement loginMail = this.driver.findElement(By.id("mailbox__login"));
        WebElement loginPass = this.driver.findElement(By.id("mailbox__password"));
        WebElement loginButton = this.driver.findElement(By.id("mailbox__auth__button"));

        loginMail.sendKeys(mailAccount.getMailAddress());
        loginPass.sendKeys(mailAccount.getPassword());
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
        SeleniumUserThread handler = new SeleniumUserThread();

    }






    public MailAccount getMailAccount() {
        return mailAccount;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        SeleniumUserThread.url = url;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void setMailAccount(MailAccount mailAccount) {
        this.mailAccount = mailAccount;
    }

    private void sleepT(long ms) {
        try {

            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

}

