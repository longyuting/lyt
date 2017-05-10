package xmx.lyt;

import java.io.IOException;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BdTest {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", 
				"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
		
		WebDriver bro = new ChromeDriver();
		bro.manage().window().maximize();
		
		//打开百度云盘页面
		bro.get("https://pan.baidu.com/");
		
		WebDriverWait wait = new WebDriverWait(bro, 10);
		
		//点击账号密码登录链接，打开账号密码输入窗		
		WebElement upLogin = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro) {
				// TODO Auto-generated method stub
				return bro.findElement(By.cssSelector("div.account-title a"));
			}	
		});
		upLogin.click();
		
		//输入账号密码
		String uName = "";
		String pWord = "";
		WebElement inUname = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				return bro.findElement(By.id("TANGRAM__PSP_4__userName"));
			}
		});
		inUname.sendKeys(uName);
		WebElement inPword = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				return bro.findElement(By.name("password"));
			}
		});
		inPword.sendKeys(pWord);
		//取消自动登录
		bro.findElement(By.name("memberPass")).click();
		//登录
		bro.findElement(By.id("TANGRAM__PSP_4__submit")).click();
		
		/*//点击新建文件夹
		WebElement newFolder = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				return bro.findElement(By.cssSelector("em.icon.icon-newfolder"));
			}
		});
		newFolder.click();
		
		////div[@class='new-dir-item']/input
		//重命名文件夹，确认
		final String dirnStr = "上传测试";
		WebElement inDirn = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				return bro.findElement(By.xpath("//div[@class='new-dir-item']/input[@class='box']"));
			}
		});
		Thread.sleep(1000);	
		inDirn.sendKeys(dirnStr);
		bro.findElement(By.cssSelector("em.icon.checksmall-icon")).click();
		//进入新加的文件夹	
		Thread.sleep(2000);	
		WebElement newDirn = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				return bro.findElement(By.cssSelector("a[class='filename'][title = '"+dirnStr+"']"));
			}
		});
		newDirn.click();*/
		
		//进入指定文件夹	
		Thread.sleep(2000);	
		WebElement dirNa = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				return bro.findElement(By.cssSelector("a[class='filename'][title = '来自百度手机浏览器']"));
				}
		});
		dirNa.click();
		
		Thread.sleep(2000);	
		//点击上传按钮
		bro.findElement(By.id("h5Input0")).click();
		
		Thread.sleep(1000);		
		Runtime.getRuntime().exec("D:\\upload.exe");
		
		Thread.sleep(3000);	
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//em[text()='上传完成']")));
//		String str = bro.findElement(By.xpath("//em[text()='上传完成']")).getAttribute("class");
//		System.out.println(str);
		bro.navigate().refresh();
		Thread.sleep(2000);
		
		//选中文件下载		
		WebElement fileCheck = bro.findElement(By.xpath("//a[text()='01.jpg']/../../../span[@class='checkbox']"));
		/*((JavascriptExecutor) bro).executeScript(
				"arguments[0].style.border = '5px solid yellow'", fileCheck);*/
		
		fileCheck.click();
		WebElement downButton = bro.findElement(By.cssSelector("em[class='icon icon-download'][title='下载']"));
		
		Actions action = new Actions(bro);
		action.moveToElement(downButton);
		action.click();
		action.perform();
		
		Thread.sleep(2000);
		WebElement userInfo = bro.findElement(By.cssSelector(".user-arrow.icon.icon-dropdown-arrow"));
		action.moveToElement(userInfo).perform();
		WebElement logOut = bro.findElement(By.cssSelector("a[node-type='login-out']"));
		logOut.click();
		Thread.sleep(2000);
		
		WebElement quitConf = wait.until(new ExpectedCondition<WebElement>(){
			public WebElement apply(WebDriver bro){
				//return bro.findElement(By.xpath("//div[9]/div[3]/div[1]/a[1]/b"));
				return bro.findElement(By.xpath("//div[3]/div[1]/a[1]/b[text()='确定']"));
			}
		});		
		quitConf.click();
			
		
	}

}
