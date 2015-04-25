import BaseApi.Base;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by HP on 4/12/2015.
 */
    @Test
public class Home extends Base {
    public void homepage() throws InterruptedException{
        clickByxpath(".//*[@id='nav-header']/nav/div/div[4]/ul/li[1]/div/ul/li[3]/a");
        String url = driver.getCurrentUrl();
        System.out.println(url);
        sleepFor(4);
        driver.navigate().back();
        sleepFor(4);
    }
}
