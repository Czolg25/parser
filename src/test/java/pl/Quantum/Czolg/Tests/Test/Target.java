package pl.Quantum.Czolg.Tests.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Target {
    private final String name;
    private final String path;

    public Target(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public List<WebElement> getWebElements(WebDriver webDriver){
        String path;
        switch (name.split(":")[0]){
            case "linkText":
                path = this.path.replaceFirst("linkText=","");
                return webDriver.findElements(By.partialLinkText(path));
            case "css":
                path = this.path.replaceFirst("css=","");
                return webDriver.findElements(By.cssSelector(path));
            case "xpath":
                path = this.path.replaceFirst("xpath=","");
                return webDriver.findElements(By.xpath(path));
        }
        return null;
    }

    @Override
    public String toString() {
        return "Target{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
