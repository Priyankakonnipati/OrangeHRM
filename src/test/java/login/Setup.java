package login;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeTest;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class Setup {
		public static WebDriver driver;
		public static FileReader fr;
		public static Properties prop = new Properties();
		public static Properties l_loc = new Properties();
		public static Properties pd_loc = new Properties();
		public static Properties cd_loc = new Properties();
		public static Properties ec_loc = new Properties();
		public static Properties d_loc = new Properties();
		public static Properties i_loc = new Properties();
		public static FileReader login;
		public static FileReader personal_details;
		public static FileReader contact_details;
		public static FileReader emergency_contact;
		public static FileReader dependents;
		public static FileReader immigration;

		@BeforeTest
		public void setup() {
			if (driver == null) {
				try {
				fr = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/config.properties");
				login = new FileReader(System.getProperty("user.dir") + "/src/test/resources/configfiles/login.properties");
				
				try {
					l_loc.load(login);
					pd_loc.load(personal_details);
					cd_loc.load(contact_details);
					ec_loc.load(emergency_contact);
					d_loc.load(dependents);
					i_loc.load(immigration);
					prop.load(fr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("testurl"));
			} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("testurl"));
			} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				driver.manage().window().maximize();
				driver.get(prop.getProperty("testurl"));
			}
		}
		}

	@AfterTest

		public void tearDown() {
			driver.close();
			
	
}
	}
