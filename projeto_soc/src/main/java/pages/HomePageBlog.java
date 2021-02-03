package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageBlog {
	
	private WebDriver driver;
	
	//Localizadores da pagina inicial do blog
	private By botaoCookies = By.cssSelector("a[class='botao2 browser']");
	
	private By campoBusca = By.className("form-control");
	
	private By botaoBusca = By.className("lupa-form");
	
	private By botaoRecursos = By.xpath("//*[@id=\"navegacao-superior\"]/ul/li[3]");
	
	private By botaoFAP = By.cssSelector("a[href='/fap");
	
	public HomePageBlog clicarBotaoCookies()  {
		driver.findElement(botaoCookies).click();
		return new HomePageBlog(driver);
	}
	
	public void preencherBusca(String texto) {
		driver.findElement(campoBusca).sendKeys(texto);
	}
	
	public ResultadoBuscaPage clicarBotaoBusca()  {
		driver.findElement(botaoBusca).click();
		return new ResultadoBuscaPage(driver);
	}
	
	public HomePageBlog clicarBotaoRecursos()  {
		driver.findElement(botaoRecursos).click();
		return new HomePageBlog(driver);
	}
	
	public FapPage clicarBotaoFAP()  {
		driver.findElement(botaoFAP).click();
		return new FapPage(driver);
	}
	
	public HomePageBlog(WebDriver driver) {
		this.driver =  driver;
	}

	public void carregarPaginaInicial() {
		driver.get("https://ww2.soc.com.br/blog/");
	}

	public String obterTituloPagina() {
		return driver.getTitle();
	}

}
