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

import static org.testng.Assert.assertTrue;


//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertTrue;

public class Pensionamiento_AutomatedTest2 {

	private WebDriver driver;
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
	
	

	//CLIENTE
	By nombrecliente =By.xpath("//ion-input[@formcontrolname='names'] ");
	By apellidocliente=By.xpath("//ion-input  [@formcontrolname='lastNames'] ");
	By fechanaccliente=By.xpath("//ion-datetime  [@formcontrolname='birthday'] ");
	By RegistroclienteBtn=By.xpath("//ion-button[ @class='submit-btn md button button-solid button-disabled ion-activatable ion-focusable hydrated' ]");
	By logincliente =By.xpath("//a [@routerlink='/login']");
	
	
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","src/drive/chromedrive/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8100/");
	}

	@AfterTest
	public void tearDown() throws Exception {
	//	driver.quit();
	}

	@Test
	public void PreregisterCliente() throws InterruptedException {
		//1. click en Registrarse
		driver.findElement(registerLinkLocator).click();
		Thread.sleep(2000);
		
		if(driver.findElement(registerPageLocator).isDisplayed()){
			//2.Completar campos para registrar
            driver.findElement(mailLocator).sendKeys("us_cli2@gmail.com");
            driver.findElement(passwordLocator).sendKeys("cliente-123");
            driver.findElement(confirmpassLocator).sendKeys("cliente-123");
            driver.findElement(BtnCliente).click();
            driver.findElement(sgteBtnLocator).click();
        
		}else{
			System.out.println("Pre-register page was not found");
		}
		
	}
	
	
	@Test
	public void RegisterCliente(){
		
		if(driver.findElement(fechanaccliente).isDisplayed()){
			driver.findElement(nombrecliente).sendKeys("Ana");
			driver.findElement(apellidocliente).sendKeys("Ramirez");
			driver.findElement(fechanaccliente).sendKeys("12/09/1997");
			driver.findElement(RegistroclienteBtn).click();
			System.out.println("Usuario registrado exitosamente");
		}else{System.out.println("Usuario no registrado");}
	}
	
	@Test
	public void logincliente() throws InterruptedException{
		if(driver.findElement(LoginTitle).isDisplayed()){
            driver.findElement(mailLocator).sendKeys("us_cli2@gmail.com");
            driver.findElement(passwordLocator).sendKeys("cliente-123");
			driver.findElement(Btnlogin).click();
			Thread.sleep(2000);
			assertTrue(driver.findElement(LoginTitle).isDisplayed());
		}else{
			System.out.println("Usuario no encontrado");
		}
		
	}
}
