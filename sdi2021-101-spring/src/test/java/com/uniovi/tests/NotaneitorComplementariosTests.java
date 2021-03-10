package com.uniovi.tests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;

public class NotaneitorComplementariosTests {

	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\Home\\Desktop\\Nueva carpeta\\geckodriver024win64.exe";
	
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";
	
	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	} 

	
	//Antes de cada prueba se navega al URL home de la aplicación
	@Before
	public void setUp(){
		driver.navigate().to(URL);
	}
	
	//Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown(){
		driver.manage().deleteAllCookies();
	}
	
	//Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}
	
	//Al finalizar la última prueba
	@AfterClass
	static public void end() {
		//Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}
	
	@Test
	public void PR16() {
		PO_PrivateView.signup(driver, "77777678A", "Josefo", "Perez", "77777","77777", "Notas del usuario");	

	}
	
	@Test
	public void PR17() {
		PO_PrivateView.signup(driver, "77777678A", "Jo", "Perez", "77777","77777", "Notas del usuario");	
		PO_RegisterView.checkKey(driver,"Error.signup.name.length",PO_Properties.getSPANISH());
	}
	
	@Test
	public void PR18() {
		PO_PrivateView.login(driver, "99999990A", "Notas del usuario");
		driver.navigate().to(URL + "/user/add");
		PO_View.checkElement(driver, "text", "Access is denied");
	}
}
