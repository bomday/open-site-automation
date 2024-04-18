package opensite;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class OpenSiteTest {
	
	// Comanda navegador Web
	private WebDriver driver;
	
	@BeforeEach
	public void setUp() throws Exception {
		// Estabelece Chrome como navegador de teste
		driver = new ChromeDriver();
	}                              

	@AfterEach
	public void tearDown() throws Exception {
		// Fecha navegador após finalziar teste
		driver.quit();
	}

	@Test
	public void openSite() throws InterruptedException {
		// Abre link abaixo
		driver.get("https://marcelodebittencourt.com/demopages/demosimplesearch/");
		// Confere se Título da página está correto
		assertTrue("Título da página está incorreto!", driver.getTitle().contentEquals("Demo Simple Search using JavaScript"));
		Thread.sleep(3000);
	}
	
	@Test
	public void interactElement() throws InterruptedException {
		// Abre link abaixo
		driver.get("https://marcelodebittencourt.com/demopages/demosimplesearch/");
		// Insere informações, buscando elemento por id
		WebElement textBox = driver.findElement(By.id("textbox"));
		textBox.sendKeys("selenium");
		// Envia informações, buscando elemento por id
		WebElement button1 = driver.findElement(By.id("button1"));
		button1.click();
		// Confere se informações estão corretas, buscando elemento por id
		WebElement result = driver.findElement(By.id("result"));
		assertTrue("Conteúdo incorreto!", result.getText().contentEquals("selenium"));
		Thread.sleep(3000);
	}
}
