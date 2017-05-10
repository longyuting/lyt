package xmx.lyt;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class tbTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		
		WebDriver wd = new ChromeDriver();		
		wd.manage().window().maximize();
		
		//打开淘宝首页,记录当前窗口句柄
		wd.get("https://www.taobao.com/");	
		String defaultWind = wd.getWindowHandle();
		
		//点击请登录按钮
		WebDriverWait wait = new WebDriverWait(wd,10);
		WebElement toLogin = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("div.site-nav-sign a.h"));
			}
		});		
		toLogin.click();
		
		//点击密码登录
		WebElement staticLogin = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("#J_Quick2Static"));
			}
		});	
		staticLogin.click();

		//输入账号密码登录
		String uname = "";
		String pword = "";
		WebElement userName = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("#TPL_username_1"));
			}
		});	
		userName.sendKeys(uname);
		WebElement passWord = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("input#TPL_password_1"));
			}
		});	
		passWord.sendKeys(pword);
		WebElement loginB = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("#J_SubmitStatic"));
			}
		});	
		loginB.click();
		
	/*	//搜索宝贝
		WebElement inSea = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("input#q"));
			}
		});	
		inSea.sendKeys("上海移动10");
		WebElement cliSea = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("button.btn-search.tb-bg"));
			}
		});	
		cliSea.click();
		
		Thread.sleep(2000);
		//选择宝贝
		List<WebElement> goods = wd.findElements(By.cssSelector("a.J_ClickStat"));
		goods.get(1).click();
		
		//切换至宝贝购买页面
		Set<String> currentWinds = wd.getWindowHandles(); //获取当前所有窗口句柄
		for(String wind:currentWinds){
			if(!wind.endsWith(defaultWind)){
				wd = wd.switchTo().window(wind);
				wd.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				break;
			}
		}
		
		//点击去购买
		WebElement toBuy = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("a#J_LinkBuy"));
			}
		});	
		toBuy.click();
		
		//确认订单信息提交
		String phone = "13524103170";
		WebElement inPhone = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("input#pAccount"));
			}
		});	
		inPhone.sendKeys(phone);
		WebElement rePhone = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("input#rpAccount"));
			}
		});	
		rePhone.sendKeys(phone);
		wd.findElement(By.cssSelector("button#J_PerformSubmit")).click();*/
		
		//点击已买的宝贝立即付款
		Thread.sleep(3000);
		WebElement myTaobao = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("li#J_SiteNavMytaobao div.site-nav-menu-hd a"));
			}
		});	
		myTaobao.click();
		
		WebElement boughtGoods = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("a#bought"));
			}
		});	
		boughtGoods.click();

		Thread.sleep(3000);
		WebElement immePay = wd.findElement(By.cssSelector("a#pay"));
		immePay.click();
		
		//切换至支付页面
		Set<String> currentWinds = wd.getWindowHandles(); //获取当前所有窗口句柄
		for(String wind:currentWinds){
			if(!wind.endsWith(defaultWind)){
				wd = wd.switchTo().window(wind);
				wd.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				break;
			}
		}
		
		//输入支付密码确认付款
		Actions action = new Actions(wd);
		String[] pws = {"1","2","3","4","5","6"};
		Thread.sleep(6000);
		List<WebElement> pwords = wd.findElements(By.cssSelector("div.sixDigitPassword i"));				
		
		for(int i = 0;i < 6;i ++){
			action.moveToElement(pwords.get(i));
			action.click();
			action.sendKeys(pws[i]);
			action.build().perform();
		}
				
		WebElement paySub = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver d){
				return d.findElement(By.cssSelector("input#J_authSubmit"));
			}
		});	
		paySub.click();
		
	}
}
