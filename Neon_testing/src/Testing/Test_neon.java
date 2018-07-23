package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class  Test_neon {
	

	public static WebDriver driver;
	
	
	
	
  @Test(priority=1)
  
	  public  static void openbrowser() {
	
	 driver.get("http://localhost:8080/neonsh/");
	
	  
	  }
	  

  @ Test (priority=2 ) //Login
  public static void Logeo() throws InterruptedException {
	  
	 	
	  	
	 driver.findElement(By.id("j_idt8:j_idt14")).click();//Campo Usuario habilitar
	 	driver.findElement(By.id("j_idt8:j_idt14")).sendKeys("EmpleadoA");//Envio de usuario
	 		driver.findElement(By.id("j_idt8:j_idt18")).click();//Campo Password habilitar
	 			driver.findElement(By.id("j_idt8:j_idt18")).sendKeys("neonsm");//Envio de Password
	 				Thread.sleep(5000); //Revisar datos (visual)	
	 					driver.findElement(By.id("j_idt8:j_idt21")).click();//Clic en boton Entrar
	 				}
  

  
  
  
 
  @BeforeTest
  public static void beforeTest() {
	  

	driver = new ChromeDriver();
	
	  
	
	  
	  
  }	  
	  
 

  @AfterTest
  public  static void afterTest() throws InterruptedException {
  
	  	
	  			Thread.sleep(5000);

	  		driver.close();
  
  }

}

