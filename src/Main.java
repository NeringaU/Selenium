import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {
        System.out.println("-- LE_TEST--");
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Neringa\\IdeaProjects\\chromedriver.exe");

        //atidaryti puslapi
        WebDriver browser=new ChromeDriver();
        browser.get("https://www.bing.com/");

        //suformuluoti uzklausa
        String fieldQuery="Baranauskas";

        waitForElementByName(browser,1,"q");

        //surasti laukeli kuri panaudosime
        WebElement searchField=browser.findElement(By.id("sb_form_q"));

        //i laukeli idedame uzklausa kintama fieldQuery
        searchField.sendKeys(fieldQuery);

        waitForElementById(browser,1,"sb_form_go");

        //paspausti paieskos mygtuka
        WebElement paieskosMygtukas=browser.findElement(By.id("sb_form_go"));
        paieskosMygtukas.click();

        waitForElementByXpath(browser,1,"//*[@id=\"b_results\"]/li[2]/h2/a");

        WebElement ieitiIvidu=browser.findElement(By.xpath("//*[@id=\"b_results\"]/li[2]/h2/a"));
        ieitiIvidu.click();

        //waitForElementByXpath(browser,1,"//*[@id=\"b_tween\"]/span");

        //atsakymo paemimas
//        WebElement rezultataiSk=browser.findElement(By.xpath("//*[@id=\"b_tween\"]/span"));
//        int skaiciusRezultatu=Integer.parseInt(rezultataiSk.getText()
//                .replace(" Results","")
//                .replace(",",""));
//
//        if (skaiciusRezultatu < 50000)
//        System.out.println("Nepopuliarus Baranauskas");
//        else if (skaiciusRezultatu>50000)
//            System.out.println("Baranauskas geriausias valdytojas !");
//        else
//            System.out.println("Nepatiktas rezultatas, FAIL");

    }

    static private void waitForElementById (WebDriver browser, int timeOutInSec, String id){
        WebDriverWait waitas=new WebDriverWait(browser,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    static private void waitForElementByClassName (WebDriver browser, int timeOutInSec, String className){
        WebDriverWait waitas=new WebDriverWait(browser,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.className(className)));
    }

    static private void waitForElementByName (WebDriver browser, int timeOutInSec, String Name){
        WebDriverWait waitas=new WebDriverWait(browser,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.name(Name)));
    }

    static private void waitForElementByXpath (WebDriver browser, int timeOutInSec, String Xpath){
        WebDriverWait waitas=new WebDriverWait(browser,timeOutInSec);
        waitas.until(ExpectedConditions.elementToBeClickable(By.xpath(Xpath)));
    }
}
