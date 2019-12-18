package com.mycompany.test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTestNGTest {

    By registerLinkLocator = By.xpath("//a[@routerlink='/pre-register']");
    By registerPageLocator= By.xpath("//ion-title/font/font [@style]");
    By mailLocator = By.xpath("//input [@name='ion-input-2']");
    By passwordLocator = By.xpath("//input [@name='ion-input-6']");
    By confirmpassLocator=By.xpath("//input [@name='ion-input-7']");
    By sgteBtnLocator=By.xpath("//ion-button [@class='submit-btn md button button-solid button-disabled ion-activatable ion-focusable hydrated']");
    By BtnRestaurante=By.xpath("//ion-radio [@ng-reflect-name='register-restaurant' ]");
    By BtnCliente=By.xpath("//ion-radio [@ng-reflect-name='register-client' ]");

    By LoginTitle=By.xpath("//ion-title [@class='md title-md title-default hydrated']");
    By HomeTitle=By.xpath("//ion-toolbar [@class='in-toolbar md toolbar-title-default hydrated toolbar-searchbar']");
    By DashboardTitle=By.xpath("//ion-content [@class='md hydrated' ]");

    //RESTAURANTE
    By nombre_rest=By.xpath("//ion-input[@formcontrolname='name']");
    By desc_rest=By.xpath("//ion-input[@formcontrolname='description']");
    By dir_rest=By.xpath("//ion-input[@formcontrolname='address']");
    By rubro_rest=By.xpath("//ion-input[@formcontrolname='business']");
    By Registro_rest=By.xpath("//ion-button [@class='submit-btn md button button-solid button-disabled ion-activatable ion-focusable hydrated']");
    By login_rest=By.xpath("//a [@routerlink='/login']");
    By id=By.xpath("//p [@ class='go-to-login']");

    //LOGIN
    By email= By.xpath("//ion-input[@formcontrolname='email']");
    By pass= By.xpath("//ion-input[@formcontrolname='password']");
    By Btnlogin= By.xpath("//ion-button [@class='submit-btn md button button-solid ion-activatable ion-focusable hydrated']");




    public String baseUrl = "http://localhost:8100/login";
    public WebDriver driver;
    
    public SeleniumTestNGTest() {
    }


    @BeforeTest
    public void setBaseURL() throws Exception {
        
       // System.setProperty("webdriver.chrome.driver","/Users/gustavo/Downloads/chromedriver"); esto era lo del ing
        System.setProperty("webdriver.chrome.driver","src/drive/chromedrive/chromedriver.exe");
        driver = new ChromeDriver();
        
        driver.get(baseUrl);
    }
    
    @Test
    public void verifyHomePage(){
        String pageTitle = driver.getTitle();
        System.out.println("Page Title reconocida, prueba exitosa:: "+pageTitle);
        Assert.assertEquals(pageTitle, "Ionic App");
    }
    
    @Test
    public void LoginParametrosok(){
        
        WebElement searchInput = driver.findElement(By.name("ion-input-0"));
        searchInput.sendKeys("registroresgmailcom");

        WebElement searchInput2 = driver.findElement(By.name("ion-input-1"));
        searchInput2.sendKeys("12345678");

        WebElement searchButton = driver.findElement(By.name("sub"));
        
        searchButton.submit();
        
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Encontrar el elemento el ion buttom
        searchInput = driver.findElement(By.id("hola"));



//Store the alert text in a variable


//Press the OK button

        searchInput2 = driver.findElement(By.id("hola"));



        // sacar el valor del ion buttom identificado
        String value = searchInput.getText();
        System.out.println(value);
        //String value = "Paso de pagina";
        System.out.println(" Prueba exitosa Boton del cambio de pagina identificado retornando un valor:: "+value);
        
        Assert.assertEquals(value, "VER DETALLES");


        Assert.assertNotNull(value);
//        public static void assertNull(Object var0) {
//            assertNull(var0, (String)null);
//        }
//
//        public static void assertNull(Object var0, String var1) {
//            if (var0 != null) {
//                failNotSame(var0, (Object)null, var1);
//            }
//
//        }

        if(driver.findElement(By.id("hola")).isDisplayed()){System.out.println("Sirve");}else{
            System.out.println("No sirve");}



    }

    @Test
    public void LoginParametrosok2(){



        WebElement searchInput = driver.findElement(By.name("ion-input-0"));
        searchInput.clear();
        searchInput.sendKeys("registrores@gmailcom");


        WebElement searchInput2 = driver.findElement(By.name("ion-input-1"));
        searchInput2.sendKeys("12345678");

        WebElement searchButton = driver.findElement(By.name("sub"));

        searchButton.submit();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Encontrar el elemento el ion buttom
        searchInput = driver.findElement(By.id("hola"));



//Store the alert text in a variable


//Press the OK button

        searchInput2 = driver.findElement(By.id("hola"));



        // sacar el valor del ion buttom identificado
        String value = searchInput.getText();
        System.out.println(value);
        //String value = "Paso de pagina";
        System.out.println(" Prueba exitosa Boton del cambio de pagina identificado retornando un valor:: "+value);

        Assert.assertEquals(value, "VER DETALLES");


        Assert.assertNotNull(value);
//        public static void assertNull(Object var0) {
//            assertNull(var0, (String)null);
//        }
//
//        public static void assertNull(Object var0, String var1) {
//            if (var0 != null) {
//                failNotSame(var0, (Object)null, var1);
//            }
//
//        }

        if(driver.findElement(By.id("hola")).isDisplayed()){System.out.println("Sirve");}else{
            System.out.println("No sirve");}



    }


    @Test
        public void VerDetalles(){


       // String value = driver.getPageSource();
       // System.out.println(value);

        WebElement verdetalleBtn = driver.findElement(By.id("hola"));

        verdetalleBtn.click();
             //  driver.findElement(By.name("hola")).click();
        //verdetalleBtn.submit();

        String value = verdetalleBtn.getText();
        System.out.println(value);
        //String value = "Paso de pagina";
        System.out.println(" Prueba exitosa Boton del cambio de pagina identificado retornando un valor:: "+value);

        Assert.assertEquals(value, "VER DETALLES");




//        WebElement detButton = driver.findElement(By.className("button-inner"));
//        detButton.submit();

       // System.out.println(detButton);


//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SeleniumTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//
//
//        String value = "Paso de pagina";
//        System.out.println("sub:: "+value);
//
//        Assert.assertEquals(value, "Paso de pagina");

//        try {
//            TimeUnit.SECONDS.sleep(5);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SeleniumTestNGTest.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }



//    @Test
//    public void PreregisterRestaurant() throws InterruptedException {
//        //1. click en Registrarse
//        driver.findElement(registerLinkLocator).click();
//        Thread.sleep(2000);
//
//        if(driver.findElement(registerPageLocator).isDisplayed()){
//            //2.Completar campos para registrar
//            driver.findElement(mailLocator).sendKeys("admin_res2@gmail.com");
//            driver.findElement(passwordLocator).sendKeys("admin-123");
//            driver.findElement(confirmpassLocator).sendKeys("admin-123");
//            driver.findElement(BtnRestaurante).click();
//            driver.findElement(sgteBtnLocator).click();
//
//        }else{
//            System.out.println("Pre-register page was not found");
//        }}



//    @AfterTest
//    public void endSession() throws Exception {
//        driver.quit();
//    }



}


