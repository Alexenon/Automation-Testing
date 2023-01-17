import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class WebWait{

    private WebDriver driver;
    private int timeout;
    private int interval;
    private String message;

    public WebWait() {

    }

    private FluentWait<WebDriver> getWait() {
        return null;
    }

    public void until() {}



    private void test(WebDriver driver) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(WebDriver::manage);
    }

    public void until(Function isTrue) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        wait.until(isTrue);
    }

}
