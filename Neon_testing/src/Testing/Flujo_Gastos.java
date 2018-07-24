package Testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

	public class Flujo_Gastos {
	public static WebDriver driver;
	

	Properties propiedades;
	JavascriptExecutor js;
    int opcion; //Guardaremos la opcion del usuario para guardar o ejecutar opcion 
    boolean salir = false;
	@Test(priority = 1)
	public void openbrowser() {
		driver.manage().window().maximize();
		propiedades = new Properties();
		System.out.println(System.getProperty("user.dir"));
		try {
			propiedades.load(new FileReader(
					"C:\\Users\\fhoyos\\git\\Neon_test\\Neon_testing\\Properties\\propiedades.properties"));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.get(propiedades.getProperty("Host"));
		js = (JavascriptExecutor) driver;
	}

	@Test(priority = 2)
	public void credentials() throws InterruptedException {
		driver.findElement(By.id("j_idt8:j_idt14")).click();// Campo Usuario habilitar
		driver.findElement(By.id("j_idt8:j_idt14")).sendKeys(propiedades.getProperty("User"));// Envio de usuario en
																								// Properties
		driver.findElement(By.id("j_idt8:j_idt18")).click();// Campo Password habilitar
		driver.findElement(By.id("j_idt8:j_idt18")).sendKeys(propiedades.getProperty("Password"));// Envio de Password
		Thread.sleep(1000); // Revisar datos (visual)
		driver.findElement(By.id("j_idt8:j_idt21")).click();// Clic en boton Entrar

	}

	@Test(priority = 3)
	public void SeleccionarGastos() throws InterruptedException {

		Thread.sleep(2000);
		Actions act = new Actions(driver);//
		js.executeScript("document.getElementsByClassName(\"ripplelink\")[2].click()");
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void Llenar_solicitud() throws InterruptedException {

		driver.findElement(By.id("solicitudGastos:descripcion")).click();
		driver.findElement(By.id("solicitudGastos:descripcion")).sendKeys(propiedades.getProperty("Des_Gastos"));
		js.executeScript("document.getElementById(\"solicitudGastos:" + propiedades.getProperty("Moneda_Seleccionar") + "\").click()");
        js.executeScript("document.getElementById(\"solicitudGastos:"+propiedades.getProperty("Grupo_Seleccionar")+ "\").click()");
        driver.findElement(By.name("solicitudGastos:j_idt61")).click();
        driver.findElement(By.name("solicitudGastos:j_idt61")).sendKeys(propiedades.getProperty("Justificacion"));
        driver.findElement(By.name("solicitudGastos:dias")).click();
        driver.findElement(By.name("solicitudGastos:dias")).sendKeys(propiedades.getProperty("Dias"));
        js.executeScript("document.getElementById(\"solicitudGastos:"+propiedades.getProperty("Tipo_Gastos")+"\").click()");
        driver.findElement(By.id("solicitudGastos:j_idt72")).click();
       
        
	}

	@Test (priority =5)
	public void EjecutarGasto() throws InterruptedException {
		
		Scanner sn = new Scanner(System.in);
	       boolean salir = false;

	       
	       while(!salir){
	            
	           System.out.println("1. Guardar Solicitud\n");
	           System.out.println("2. Enviar Solicitud\n");
	           System.out.println("3. Terminar Proceso\n");
	         
	            
	           System.out.println("\nEscribe una de las opciones\n");
	           opcion = sn.nextInt();
	            
	           switch(opcion){
	               case 1:
	                   js.executeScript("document.getElementById(\"solicitudGastos:btnSolicitud\").click()");
	                   break;
	               case 2:
	                   js.executeScript("document.getElementById(\"solicitudGastos:btnEjecutar\").click()");
	                   break;
	               case 3:
	            	   salir =true;
	            	   
	                default:
	                   System.out.println("Solo acepta valor 1 al 3");
	           }
	            
	       }
	        
	    }
		
	@BeforeTest
	public void beforeTest() {
		driver = new ChromeDriver();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {

		Thread.sleep(5000);

		if (salir =true) {
			Thread.sleep(6000);
			driver.close();
		}
		else {
			System.out.println("Elige salirpara terminar el proceso");
		}

	}

}
