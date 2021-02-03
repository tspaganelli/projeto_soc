package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultadoBuscaPage {
	
	private WebDriver driver;
	
	//Localizadores da pagina de resultado da busca
	private By resultadoBusca = By.xpath("//h2[@class=\"pagetitle search\"]/span");
	
	public ResultadoBuscaPage(WebDriver driver) {
		this.driver = driver;
	}

	public String obterResultadoBusca() {
		return driver.findElement(resultadoBusca).getText();	
	}
}
