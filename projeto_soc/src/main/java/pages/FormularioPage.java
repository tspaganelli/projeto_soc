package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioPage {
	
	private WebDriver driver;
	
	//Localizadores da pagina do formulario preenchido
	private By formComSucesso = By.xpath("//*[@id=\"page\"]/section/div/header/h1");
	
	public FormularioPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obterResultadoForm() {
		return driver.findElement(formComSucesso).getText();	
	}
}
