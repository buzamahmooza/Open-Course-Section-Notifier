import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {
	final static String ENCRYPTED_GOOGLE_URL = "https://encrypted.googe.com";
	final static String COURSE_OFFERINGS_URL = "http://registrar.kfupm.edu.sa/CourseOffering";
	static WebDriver driver;

	public static void main(String[] args) {
		String DRIVER_PATH = Paths.get("").toAbsolutePath() + File.separator + "chromedriver.exe"; // the excecution path
		// the chrome driver must be inside the same directory of the execution path

		System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
		System.out.println(System.getProperty("webdriver.chrome.driver"));
		openCourseOfferings();
	}

	private static void openCourseOfferings() {
		driver = new ChromeDriver();
		String location = COURSE_OFFERINGS_URL;
		driver.get(location);

		WebElement departmentSelect = driver.findElement(By.cssSelector("#CntntPlcHldr_ddlDept"));
		departmentSelect.click();
		System.out.println("departmentselect:" + departmentSelect);
		List<WebElement> departments = driver.findElements(By.cssSelector("#CntntPlcHldr_ddlDept > option"));
		departments.remove(0); // removing the SELECT DEPARTMENT element
		System.out.println("Departments:");

		for (WebElement webElement : departments) {
			printElement(webElement);
		}
		departments.get(1).click();

		// driver.

		// driver.quit();
	}

	public static void printElement(WebElement el) {
		System.out.println("Element:TagName: " + el.getTagName() + "\tText: " + el.getText() + "\t" + el.toString());
	}
}
