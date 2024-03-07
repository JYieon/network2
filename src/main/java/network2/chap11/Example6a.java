package network2.chap11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Example6a {

    // 드라이버 설치 경로
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/JAVA/chromedriver-win64/chromedriver.exe";

    public static void naverLogin() {

        WebDriver driver = null;
        try {
            // WebDriver 경로 설정
            System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

            // WebDriver 옵션 설정
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-popup-blocking");

            String url = "https://nid.naver.com/nidlogin.login?mode=form&url=https://www.naver.com/";
            driver = new ChromeDriver(options);
            driver.get(url);
            Thread.sleep(2000); // 페이지 로딩 대기 시간

            // ID 입력
            WebElement element = driver.findElement(By.id("id"));
            element.click();
            element.sendKeys("clsm4569");
            Thread.sleep(100);

            // 비밀번호 입력
            element = driver.findElement(By.id("pw"));
            element.click();
            element.sendKeys("63v92w6d2us!");
            Thread.sleep(100);

            // 전송
            element = driver.findElement(By.className("btn_login"));
            element.click();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null)
			 {
				driver.close(); // 5. 브라우저 종료
			}
        }
    }

    public static void main(String[] args) {
        naverLogin();
    }

}

