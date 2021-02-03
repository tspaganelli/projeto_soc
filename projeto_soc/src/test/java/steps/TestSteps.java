package steps;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.FapPage;
import pages.FormularioPage;
import pages.HomePageBlog;
import pages.ResultadoBuscaPage;

public class TestSteps {
	
	private static WebDriver driver;
	private HomePageBlog homePageBlog = new HomePageBlog(driver);
	
	ResultadoBuscaPage resultadoBusca;
	FapPage fapPage;
	FormularioPage formPage;
	
	//Abrir webdriver
	@Before(order = '0')
	public static void inicializar() {
		System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\ChromeDriver\\88\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//Direcionar navegador para a pagina inicial
	@Before(order = '1')
	public void carregarPaginaInicial() {
		driver.get("https://ww2.soc.com.br/blog/");
		homePageBlog = new HomePageBlog(driver);
	}
	
	//Chamar carregamento da pagina inicial e validar que estamos na pagina correta
	@Dado("que estou na home page")
	public void que_estou_na_home_page() {
	   homePageBlog.carregarPaginaInicial();
	   assertThat(homePageBlog.obterTituloPagina(), is("Conteúdos SOC - Medicina e Segurança do Trabalho"));
	}
	
	@Dado("clicar botao cookie")
	public void clickar_botao_cookie() {
		homePageBlog.clicarBotaoCookies();
	}
	
	@Dado("clicar em recursos")
	public void clicar_em_recursos() {
		homePageBlog.clicarBotaoRecursos();
	}
	
	@Dado("clicar em FAP")
	public void clicar_em_FAP() {
		fapPage = homePageBlog.clicarBotaoFAP();
	}
	
	@Quando("preencher nome empresa {string}")
	public void preencher_nome_empresa(String nomeEmpresa) {
		fapPage.nomeEmpresa (nomeEmpresa);
	}

	@Quando("preencher numero FAP {string}")
	public void preencher_numero_fap(String nFap) {
		fapPage.nFap (nFap);
	}

	@Quando("preencher valor projecao {string}")
	public void preencher_valor_projecao(String vProjecao) {
		fapPage.nProjecao (vProjecao);
	}

	@Quando("selecionar valor RAT")
	public void selecionar_valor_rat() {
		fapPage = fapPage.clicarBotaoRat();		
		fapPage = fapPage.selecionarValorRat();
	}

	@Quando("clickar botao estipular")
	public void clickar_botao_estipular() {
		formPage = fapPage.clicarEstimarFap();
	}

	@Quando("preencher campo busca {string}")
	public void preencher_campo_busca(String textoBusca) {
	   homePageBlog.preencherBusca(textoBusca);
	}
	
	@Quando("clickar botao busca")
	public void clicar_botao_busca() {
		resultadoBusca = homePageBlog.clicarBotaoBusca(); 
	}

	//Validar que a busca foi feita com sucesso
	@Entao("validar resultado busca {string}")
	public void validar_resultado_busca(String textoBusca) { 
		assertThat(resultadoBusca.obterResultadoBusca(), is(textoBusca));
	}
	
	//Validação de que o Formulario foi bem preenchido
	@Entao("validar que formulario foi gerado")
	public void validar_que_formulario_foi_gerado() {
		assertThat(formPage.obterResultadoForm(), is("ESTIMATIVA FAP DA EMPRESA"));
	}
	
	//Rotina para captura de tela
	@After(order = '1')
	public void capturarTela(Scenario scenario) {
		var camera = (TakesScreenshot) driver;
		File capturarTela = camera.getScreenshotAs(OutputType.FILE);
		
		String scenarioId = scenario.getId().substring(scenario.getId().lastIndexOf(".feature:") + 9 );
		
		String nomeArquivo = "resources/screenshots/ " + scenario.getName() + "_" + scenarioId + "_" + scenario.getStatus() + ".jpeg";
		
		
		try {
			Files.move(capturarTela, new File(nomeArquivo));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Fechar webdriver
	@After(order = '0')
	public static void finalizar() {
		driver.quit();
	}


}
