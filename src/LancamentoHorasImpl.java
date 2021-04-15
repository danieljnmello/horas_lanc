package src;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.hitssembratel.bpo.util.RoboUtil;

@Service
public class LancamentoHorasImpl extends BaseServiceImpl implements LancamentoHorasService {


	@Value("${prop.horas.user}")
	String usuario;

	@Value("${prop.horas.user}")
	String senha;

	@Override
	public void runProcesso() {
		
		this.lancarHora();
		
	}
	
	public void lancarHora() {
		
		DesiredCapabilities capabilities = DesiredCapabilities.htmlUnit();
		LoggingPreferences logs = new LoggingPreferences();
		logs.enable(LogType.BROWSER, java.util.logging.Level.OFF);
		logs.enable(LogType.CLIENT, java.util.logging.Level.OFF);
		logs.enable(LogType.DRIVER, java.util.logging.Level.OFF);
		logs.enable(LogType.PERFORMANCE, java.util.logging.Level.OFF);
		logs.enable(LogType.PROFILER, java.util.logging.Level.OFF);
		logs.enable(LogType.SERVER, java.util.logging.Level.OFF);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, logs);
		capabilities.setJavascriptEnabled(true);
		
		WebDriver driver = null;
		driver = new HtmlUnitDriver(capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Calendar dataIniLog = this.getSysDate();
		
		try {

			driver.get("https://mytimes.embratel.com.br:20443/MyTimes/Login2.xhtml");
			
			RoboUtil.inserirValorCampoTextoPorIDCampo(driver, "frmCadastro:email", usuario);
			
			RoboUtil.inserirValorCampoTextoPorIDCampo(driver, "frmCadastro:senha", senha);
			
			RoboUtil.clicarBotaoPorNome(driver, "frmCadastro:botaoLogin", true);
			
			System.out.println(driver.toString());
			
		} catch (Exception e) {
				e.printStackTrace();
			} 
	}

	}
