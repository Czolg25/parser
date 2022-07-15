package pl.Quantum.Czolg.Main;


import org.junit.After;
import org.junit.Before;
import pl.Quantum.Czolg.Tests.Test.Test;
import pl.Quantum.Czolg.Tests.TestMeneger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Main {
    private static final char SEPARATOR = File.separatorChar;
    private static final String path = "src"+SEPARATOR+"main"+SEPARATOR+"resources"+SEPARATOR;
    private static final TestMeneger TEST_MENEGER = new TestMeneger();
    private WebDriver webDriver;
    private String url;
    private Test currentTest;

    public static String getPath() {
        return path;
    }

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver",path+"geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", path+"chromedriver.exe");

        webDriver = new ChromeDriver();
        setupTest();
    }

    @org.junit.Test
    public void testAll(){
        webDriver.get(url);

        currentTest.run(webDriver);
    }

    @After
    public void close(){
        webDriver.close();
    }
    private void setupTest(){
        currentTest = TEST_MENEGER.getCurrentTest();
        url = currentTest.getUrl();
    }
}
