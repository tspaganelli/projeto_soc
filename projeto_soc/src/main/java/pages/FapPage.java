package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FapPage {
	
	private WebDriver driver;

	//Localizadores da pagina do formulario FAP
	private By formNomeEmpresa = By.id("nomeEmpresa");
	
	private By formFap = By.id("fap");
	
	private By formBotaoRat = By.className("button");
	
	private By formValorRat = By.xpath("//*[@id=\"frmcalculadora\"]/div[2]/div[3]/span/div/div[3]/div/ul/li[2]");
	
	private By formProjecao = By.id("projecao");
	
	private By formEstimarFap = By.id("estimar");
		
	public FapPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void nomeEmpresa(String texto) {
		driver.findElement(formNomeEmpresa).sendKeys(texto);
	}
	
	public void nFap(String texto) {
		driver.findElement(formFap).sendKeys(texto);
	}
		
	public void nProjecao(String texto) {
		driver.findElement(formProjecao).sendKeys(texto);
	}
	
	public FapPage clicarBotaoRat()  {
		driver.findElement(formBotaoRat).click();
		return new FapPage(driver);
	}
					
	public FapPage selecionarValorRat() {
		driver.findElement(formValorRat).click();
		return new FapPage(driver);
	}
	
	public FormularioPage clicarEstimarFap()  {
		driver.findElement(formEstimarFap).click();
		return new FormularioPage(driver);
	}
	
}
