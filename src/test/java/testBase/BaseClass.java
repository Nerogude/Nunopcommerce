package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public WebDriver driver;
	public ChromeOptions ops;
	public EdgeOptions opts;
	public Logger log;
	public ResourceBundle rb;
	
	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {
		
		log = LogManager.getLogger(this.getClass());
		rb = ResourceBundle.getBundle("config");
		
		if(br.equals("chrome")) {
			ops = new ChromeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(ops);
		}
		else {
			opts = new EdgeOptions();
			opts.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver(opts);
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));
		driver.manage().window().maximize();
	}
	
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public String generateRandomString() {
		return RandomStringUtils.randomAlphabetic(5); 
	}
	
	public String captureScreen(String tname) throws IOException {
		
		//SimpleDateFormat df = new SimpleDateFormat("yyyymmDDhhmmss");
		//Date dt = new Date();
		String timestamp = new SimpleDateFormat("yyyymmDDhhmmss").format(new Date());
		
		TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir")+"\\screenshots\\"+tname + "_"+ timestamp+".png";
		FileUtils.copyFile(src, new File(destination));
		return destination;
		
	}

}
