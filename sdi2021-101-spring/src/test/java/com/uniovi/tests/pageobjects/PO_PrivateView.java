package com.uniovi.tests.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.uniovi.tests.util.SeleniumUtils;

public class PO_PrivateView extends PO_NavView{
	
	static public void fillFormAddMark(WebDriver driver, int userOrder, String descriptionp,
	String scorep)
	{
		 //Esperamos 5 segundo a que carge el DOM porque en algunos equipos falla
		 SeleniumUtils.esperarSegundos(driver, 5);
		 //Seleccionamos el alumnos userOrder
		 new Select (driver.findElement(By.id("user"))).selectByIndex(userOrder);
		 //Rellenemos el campo de descripción
		 WebElement description = driver.findElement(By.name("description"));
		 description.clear();
		 description.sendKeys(descriptionp);
		 WebElement score = driver.findElement(By.name("score"));
		 score.click();
		 score.clear();
		 score.sendKeys(scorep);
		 By boton = By.className("btn");
		 driver.findElement(boton).click();
	}
	
	static public void login(WebDriver driver, String dnip, String message) {
		//Vamos al formulario de logueo.
		clickOption(driver, "login", "class", "btn btn-primary");
		//Rellenamos el formulario
		PO_LoginView.fillForm(driver, dnip , "123456" );
		//COmprobamos que entramos en la pagina privada del Profesor
		checkElement(driver, "text", message);
	}
	
	static public void signup(WebDriver driver, String dnip, String namep, String surnamep, String passwordp, String passwordRp, String message) {
		clickOption(driver, "signup", "class", "btn btn-primary");
		//Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, dnip, namep, surnamep, passwordp,passwordRp);
				
	}
	
	static public void logout(WebDriver driver, String message) {
		clickOption(driver, "logout", "text", message);
	}
	
	static public List<WebElement> goToPage(WebDriver driver, String page) {
		//Pinchamos en la opción de menu de Notas: //li[contains(@id, 'marks-menu')]/a
		List<WebElement> elementos = PO_View.checkElement(driver, "free","//li[contains(@id, 'marks-menu')]/a");
		elementos.get(0).click();
		//Pinchamos en la opción de lista de notas.
		elementos = PO_View.checkElement(driver, "free", page);
		elementos.get(0).click();
		return elementos;
	}
}
