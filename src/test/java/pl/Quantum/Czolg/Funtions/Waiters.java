package pl.Quantum.Czolg.Funtions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waiters {
    private static final int timeout = 1000;


    public WebElement waitForClickablility(WebDriver webDriver,WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds((timeout)));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForVisible(WebDriver webDriver,By element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds((10000)));
        return  wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }
}
