package Testing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public  class  Test_neon {
	
	Properties propiedades;
	public  WebDriver driver;
	
	
	
	
  @Test(priority=1)
  
	  public   void openbrowser() {
	  
	  propiedades = new Properties();
		 System.out.println(System.getProperty("user.dir"));
		try {
			propiedades.load(new FileReader("C:\\Users\\fhoyos\\git\\Neon_test\\Neon_testing\\Properties\\propiedades.properties"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	
	 driver.get(propiedades.getProperty("Host"));
	
	  
	  }
	  

  @ Test (priority=2 ) //Login
  public  void Credentials() throws InterruptedException {
	  
	 	
	  	
	 driver.findElement(By.id("j_idt8:j_idt14")).click();//Campo Usuario habilitar
	 	driver.findElement(By.id("j_idt8:j_idt14")).sendKeys(propiedades.getProperty("User"));//Envio de usuario properties
	 		driver.findElement(By.id("j_idt8:j_idt18")).click();//Campo Password habilitar
	 			driver.findElement(By.id("j_idt8:j_idt18")).sendKeys(propiedades.getProperty("Password")); //Envio de Password
	 				Thread.sleep(5000); //Revisar datos (visual)	
	 					driver.findElement(By.id("j_idt8:j_idt21")).click();//Clic en boton Entrar
	 				}
  

  
  
  
 
  @BeforeTest
  public  void beforeTest() {
	  

	driver = new ChromeDriver();
	
	  
	
	  
	  
  }	  
	  
 

  @AfterTest
  public  void afterTest() throws InterruptedException {
  
	  	
	  			Thread.sleep(5000);

	  		driver.close();
  
  }

}

