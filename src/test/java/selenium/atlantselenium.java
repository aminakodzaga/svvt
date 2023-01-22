package selenium;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;



class atlantselenium {

	private static WebDriver webDriver;
	private static String baseUrl;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/PC/Desktop/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		webDriver = new ChromeDriver(options);
		baseUrl = "https://www.atlantbh.com/";
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		webDriver.quit();
	}

	
     //1
	@Test
	void testTitles()throws InterruptedException {
		webDriver.get(baseUrl);
		String title= webDriver.getTitle();
		assertEquals("Atlantbh Sarajevo - We Make Things Look Easy", title);
		
		webDriver.navigate().to(baseUrl+"/services");
		assertEquals("Services - Atlantbh Sarajevo", webDriver.getTitle());
		
		webDriver.navigate().to(baseUrl+"/jobs");
		assertEquals("Jobs - Atlantbh Sarajevo", webDriver.getTitle());
		
		webDriver.navigate().to(baseUrl+"/scholarships");
		assertEquals("Scholarships - Atlantbh Sarajevo", webDriver.getTitle());
		
		webDriver.navigate().to(baseUrl+"/blog");
		assertEquals("Blog - Atlantbh Sarajevo", webDriver.getTitle());
		
		webDriver.navigate().to(baseUrl+"/contact");
		assertEquals("Contact - Atlantbh Sarajevo", webDriver.getTitle());
		
		webDriver.get(baseUrl);
		webDriver.findElement(By.className("search-icon")).click();
		WebElement search = webDriver.findElement(By.id("is-search-input-0"));
		search.sendKeys("Dynamic Programming");
		webDriver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/nav/ul[1]/li[7]/form/button/span[2]")).click();
		
	}

	
	
	
	//2
	@Test
	void testTabs() throws InterruptedException {
		webDriver.get(baseUrl);

		String handle1 = webDriver.getWindowHandle();
		System.out.println(handle1);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[8]/a[1]")).click();
		for (String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
	
		Thread.sleep(5000);
		
		webDriver.close();
		
		webDriver.switchTo().window(handle1);
		
		Thread.sleep(2000);
	
	
	webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[8]/a[2]")).click();
	for (String handle2: webDriver.getWindowHandles()) {
		if (!handle2.equals(handle1)) {
			webDriver.switchTo().window(handle2);
			break;
		}
	}
	WebElement namee=webDriver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[1]/input"));
	namee.sendKeys("nametesting");
	WebElement passwordd= webDriver.findElement(By.xpath("/html/body/div/main/div[2]/div[1]/form/div[2]/input"));
	passwordd.sendKeys("testpassword");
	
	
	Thread.sleep(5000);
	
	  webDriver.close();
	
	   webDriver.switchTo().window(handle1);
	
	Thread.sleep(2000);
	
	  webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[8]/a[3]")).click();
	for (String handle3: webDriver.getWindowHandles()) {
		if (!handle3.equals(handle1)) {
			webDriver.switchTo().window(handle3);
			break;
		}
	}
	Thread.sleep(5000);
	
	webDriver.close();
	
	webDriver.switchTo().window(handle1);
	
Thread.sleep(2000);

	}



	
	  //3
	  @Test
	  void testContactForm()throws InterruptedException {
		webDriver.get(baseUrl);
		WebElement contact= webDriver.findElement(By.xpath("//*[@id=\"menu-item-14574\"]/a"));
		contact.click();
		Thread.sleep(2000);
		
		WebElement message= webDriver.findElement(By.name("ask-us"));
		message.sendKeys("test");
		
		WebElement email= webDriver.findElement(By.name("form-input-mail"));
		email.sendKeys("test@gmail.com");
		
		WebElement name = webDriver.findElement(By.name("form-input-text"));
		name.sendKeys("Tessttt");
		Thread.sleep(3000);
			
	}



	
	//4
	@Test
	void testServicesFeatures()throws InterruptedException  {
		webDriver.get(baseUrl);
		webDriver.findElement(By.cssSelector("#menu-item-1451 > a")).click();
		Thread.sleep(3000);
		
		String employee=webDriver.findElement(By.className("hero-header")).getText();
		assertTrue(employee.contains("Esena Gušić"));
		
		WebElement position = webDriver.findElement(By.className("small-hero-paragraph"));
		assertEquals("Product Manager @Atlantbh", position.getText());
		
		WebElement a= webDriver.findElement(By.className("hero-link"));
		assertEquals("MEET ESENA AND OTHER ATLANTERS>", a.getText());
		
		webDriver.findElement(By.className("hero-link")).click();
		webDriver.navigate().back();
	
		Thread.sleep(3000);
		
	}

	
	//5
	@Test
	void testEmail()throws InterruptedException  {
		webDriver.get(baseUrl);
		
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-18684\"]/a")).click();
		webDriver.findElement(By.cssSelector("#menu-item-18685 > a")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[6]/div[2]/div/div/div[2]/div/div[2]/div/a[2]")).click();
		Thread.sleep(2000);
		
		WebElement elementi= webDriver.findElement(By.xpath("//*[@id=\"page-header-bg\"]/div[2]/div/div/div/h1"));
		assertEquals("Atlantbh call for Scholarships 2022/2023", elementi.getText());
		
		
		WebElement elementa= webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div[2]/div/div/div/div/span[2]"));
		assertEquals("October 3, 2022", elementa.getText());
		
		String elementb= webDriver.findElement(By.xpath("//*[@id=\"single-below-header\"]/span[1]/span/a")).getText();
		assertTrue(elementb.contains("Alma Muratovic") );
		
		webDriver.navigate().back();
		
		WebElement email= webDriver.findElement(By.xpath("//*[@id=\"mlb2-5847491\"]/div/div/div[1]/form/div[1]/div/div/input"));
		email.sendKeys("test@gmail.com");
		Thread.sleep(2000);
	
	   }
	
      


	//6
	@Test
	void testrelativeLocators()throws InterruptedException  {
		webDriver.get(baseUrl);
		WebElement icon1= webDriver.findElement(By.xpath("//*[@id=\"menu-item-1081\"]/a"));
		webDriver.findElement(
				RelativeLocator.with(By.xpath("//*[@id=\"menu-item-1451\"]/a"))
				.toRightOf(icon1)).click();
		
		WebElement icon2 = webDriver.findElement(By.xpath("//*[@id=\"menu-item-1451\"]/a"));
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/a"))
				.toRightOf(icon2)).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/ul/li[1]/a")).click();
		webDriver.navigate().back();
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[1]"))
				.toLeftOf(icon2)).click();
		
		WebElement icon3 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/a"));
		
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[4]/a"))
				.toRightOf(icon3)).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[4]/ul/li/a")).click();
		webDriver.navigate().back();
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[2]/a"))
				.toLeftOf(icon3)).click();
		
        WebElement icon4 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[4]/a"));
		
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[5]/a"))
				.toRightOf(icon4)).click();
		webDriver.navigate().back();
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/a"))
				.toLeftOf(icon4)).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/ul/li[1]/a")).click();
		
		WebElement icon5 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[5]/a"));
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[6]/a"))
				.toRightOf(icon5)).click();
		webDriver.navigate().back();
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[4]/a"))
				.toLeftOf(icon5)).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[4]/ul/li/a")).click();
		
		WebElement icon6 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[6]/a"));
		webDriver.findElement(
				RelativeLocator.with(By.className("search-icon"))
				.toRightOf(icon6)).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/nav/ul[1]/li[7]/div")).click();
		webDriver.findElement(
				RelativeLocator.with(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[5]/a"))
				.toLeftOf(icon6)).click();
	
		WebElement icon7 = webDriver.findElement(By.className("search-icon"));
	
		webDriver.findElement(
				RelativeLocator.with(By.cssSelector("#social-in-menu > a:nth-child(1) > i"))
				.toRightOf(icon7)).click();  
		
		String handle1 = webDriver.getWindowHandle();
		System.out.println(handle1);
		for (String handle: webDriver.getWindowHandles()) {
			if (!handle.equals(handle1)) {
				webDriver.switchTo().window(handle);
				break;
			}
		}
		Thread.sleep(5000);
		
		webDriver.close();
		
		webDriver.switchTo().window(handle1);
		
		Thread.sleep(2000); 
		webDriver.findElement(
				RelativeLocator.with(By.xpath("//*[@id=\"menu-item-14574\"]/a"))
				.toLeftOf(icon7)).click();
	
   }
	
	

	
	
	//7
	@Test
	void testForm() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[4]/a")).click();
		webDriver.findElement(By.linkText("Scholarships")).click();
		
		webDriver.findElement(By.className("entire-meta-link")).click();
		Thread.sleep(3000);
		
		WebElement comment= webDriver.findElement(By.id("comment"));
		comment.sendKeys("testhello");
		WebElement name= webDriver.findElement(By.id("author"));
		name.sendKeys("aminatest");
		WebElement email= webDriver.findElement(By.id("email"));
		email.sendKeys("test@gmail.com");
		WebElement website= webDriver.findElement(By.id("url"));
		website.sendKeys("https://www.atlantbh.com/five-years-of-atlantbh-scholarships/");
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div[2]/div/div/div/form/p[1]")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div[2]/div/div/div/form/p[2]")).click();
		Thread.sleep(5000);
		
	}

	
     //8
	     @Test
	      void applicationForm() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[5]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[2]/a")).click();
		Thread.sleep(5000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[2]/div[2]/div/div/div[2]/a/span")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/button")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div/div/div/main/div[2]/ul/li[1]/div/a")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.cssSelector("#app > div > div > div > div > nav > a:nth-child(3)")).click();
		Thread.sleep(3000);
		WebElement name=webDriver.findElement(By.id("firstname"));
		name.sendKeys("test");
		WebElement lastname=webDriver.findElement(By.id("lastname"));
		lastname.sendKeys("testitest");
		WebElement email=webDriver.findElement(By.id("email"));
		email.sendKeys("test@gmail.com");
		WebElement phone= webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[1]/div[2]/div[4]/label/div/div/div/div/input"));
		phone.sendKeys("061555555");
		Thread.sleep(3000);
		
		WebElement address=webDriver.findElement(By.id("address"));
		address.sendKeys("testiranje");
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/div/button")).click();
		WebElement school=webDriver.findElement(By.id("school"));
		school.sendKeys("school");
		WebElement study=webDriver.findElement(By.id("field_of_study"));
		study.sendKeys("it");
		WebElement degree=webDriver.findElement(By.id("degree"));
		degree.sendKeys("bachlor");
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/ul/li/div/div[4]/label/div/div/div/div/input")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/ul/li/div/div[4]/label/div[2]/div/button"));
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/ul/li/div/div[4]/label/div[2]/div/div/div[2]/div[1]/div[1]")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/ul/li/div/div[5]/label/div/div/div/div/input")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/ul/li/div/div[5]/label/div[2]/div/div/div[2]/div[1]/div[1]")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[1]/ul/li/div/div[6]/button[1]")).click();
		Thread.sleep(10000);
		
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[2]/div/button")).click();
		WebElement title=webDriver.findElement(By.id("title"));
		title.sendKeys("engineer");
		WebElement company=webDriver.findElement(By.id("company"));
		company.sendKeys("International Burch University");
		WebElement industry=webDriver.findElement(By.id("industry"));
		industry.sendKeys("IT");
		WebElement summary=webDriver.findElement(By.id("summary"));
		summary.sendKeys("testing");
		Thread.sleep(10000);
		
		
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[2]/ul/li/div/div[5]/label/div/div/div/div/input")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[2]/ul/li/div/div[5]/label/div[2]/div/div/div[2]/div[1]/div[1]")).click();
		
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[2]/ul/li/div/label/span")).click();
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[2]/ul/li/div/div[7]/button[1]")).click();
		Thread.sleep(10000);
				
		WebElement summary1= webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[2]/div[2]/div[3]/label/div/div/textarea"));
		summary1.sendKeys("testingtesting");
		WebElement details= webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[3]/div[2]/div[1]/label/div/div/textarea"));
		details.sendKeys("coverletter");
		webDriver.findElement(By.xpath("/html/body/div/div/div/div/main/form/section[3]/div[2]/div[2]/div/fieldset/div[1]/label/div/div/span[2]")).click();
		Thread.sleep(10000);
			
		
	         }	
			
	   //9
	   @Test
	     void testQAmp() throws InterruptedException {
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("//*[@id=\"menu-item-17838\"]/a")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/ul/li[3]/a")).click();
		
		String ime = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[4]/div[2]/div[2]/div/div[2]/div[2]/div/h2")).getText();
		assertTrue(ime.contains("Senita Isović"));
		Thread.sleep(3000);
		
		String ime1 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[5]/div[2]/div[1]/div/div[2]/div[2]/div/h2")).getText();
		assertTrue(ime1.contains("Maja Mujanović"));
		
		WebElement ime3 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[6]/div[2]/div[2]/div/div[2]/div[2]/div/h2"));
		assertEquals("Damir Čović", ime3.getText());
		
		String source= webDriver.getPageSource();
		assertTrue(source.contains("wp-content"));
	
		WebElement aa= webDriver.findElement(By.xpath("//*[@id=\"mlb2-5847491\"]/div/div/div[1]/form/div[1]/div/div/input"));
		aa.sendKeys("test@gmail.com");
		Thread.sleep(2000);
		
		
	          }
		
 
	
	
	//10
	@Test
	void testSearchIcon() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[7]/a")).click();
	
		Thread.sleep(3000);		
		webDriver.findElement(By.xpath("//*[@id=\"top\"]/div/div/div[2]/nav/ul[1]/li[7]/form/button/span[2]")).click();
		
		WebElement text= webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div/div/span"));
		assertEquals("260 results found", text.getText());
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/div[2]/a")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/div[1]")).click();
		webDriver.get(baseUrl);
		Thread.sleep(3000);
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[7]/a")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[7]/div")).click();
		Thread.sleep(3000);

		
	}
	

	
	       //11
	     @Test
	      void testJobsLinks() throws InterruptedException {
		webDriver.get(baseUrl);
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/a")).click();
		WebElement jobs = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[3]/ul/li[1]/a"));
		js.executeScript("arguments[0].click()", jobs);
		js.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(1000);
		
		WebElement text1 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/ul/li[1]/h3/a"));
		js.executeScript("arguments[0].click();", text1);
		Thread.sleep(2000);
		webDriver.navigate().back();
		WebElement text2 = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/div/div[2]/div/div/div/ul/li[2]/h3/a"));
		js.executeScript("arguments[0].click();", text2);
		Thread.sleep(2000);
		webDriver.navigate().back();
        
      
	        }
	
   

	//12
	@Test
	void testNumbers() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[2]/a")).click();
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/a")).click();
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[5]/div[2]/div[4]/div/div[2]/a/span")).click();
		Thread.sleep(2000);
		webDriver.navigate().back();
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/a")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/a[1]")).click();
		Thread.sleep(3000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/a[3]")).click();
		Thread.sleep(4000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/a[4]")).click();
		Thread.sleep(3000);
		
	}

	
	     //13
	        @Test
	     void testPhotoAndForm() throws InterruptedException {
		webDriver.get(baseUrl);
        webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[2]/a")).click();
		
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[3]/div[2]/div[2]/div/div[2]/div/div/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div[2]/div[2]/div[1]/div/div[2]/div/div[2]")).click();
	    Thread.sleep(3000);
	    webDriver.findElement(By.xpath("/html/body/div[5]/div")).click();
	    Thread.sleep(2000);
	    webDriver.navigate().back();
	    Thread.sleep(3000);
		
		WebElement text= webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[1]/div/div/div[7]/div[2]/div/div/div[2]/div/form/div[2]/div[1]/span/textarea"));
		text.sendKeys("test1");
		
		WebElement email= webDriver.findElement(By.name("form-input-mail"));
		email.sendKeys("test@gmail.com");
		
		WebElement name = webDriver.findElement(By.name("form-input-text"));
		name.sendKeys("Tesstiranje");
		Thread.sleep(3000);
		
		
	         }
         
	
	//14
	
	@Test
	void testQA() throws InterruptedException {
		webDriver.get(baseUrl);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[2]/header/div/div/div[2]/nav/ul[1]/li[5]/a")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/ul/li[4]/a/span")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div/div[4]/div[1]/div/div/article[1]/div/div/div/a")).click();
		Thread.sleep(2000);
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div[1]/div/article/div/div/div/div[2]/div[2]/div/div/div[5]/div[2]/div/div/div[2]/div/div/div/article[1]/div/div/div[2]/span[1]/a")).click();
		webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div/div/article/div/div/div[2]/div/a/i")).click();
		Thread.sleep(2000);
		webDriver.navigate().back();
		Thread.sleep(3000);
		
	
	      }
        
	
	//15
	@Test
	void testMapView() throws InterruptedException {
		webDriver.get(baseUrl);
		
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		
		WebElement contactLink = webDriver.findElement(By.linkText("Contact"));
		js.executeScript("arguments[0].click()", contactLink);
		
		js.executeScript("window.scrollBy(0, 600);");
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0, -600);");
		Thread.sleep(1000);

		WebElement map = webDriver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div/div/div[3]/div[2]"));
		js.executeScript("arguments[0].scrollIntoView(true);", map);
		
		Thread.sleep(3000);
	}
	
}

	
	
	
