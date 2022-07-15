package pl.Quantum.Czolg.Tests.Test;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import pl.Quantum.Czolg.Readers.FileReader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Test {
    private final String url;
    private final String name;
    private final List<SingleTest> singleTests = new ArrayList<>();

    public Test(File file){
        FileReader fileReader = new FileReader();
        JSONObject jsonObject = fileReader.fileToJSON(file);

        this.url = jsonObject.getString("url");
        this.name = jsonObject.getString("name");

        for (Object object : jsonObject.getJSONArray("tests"))
            singleTests.add(new SingleTest((JSONObject) object));
    }

    public void run(WebDriver webDriver){
        System.out.println("Start test "+name+" from file");
        for (SingleTest singleTest : singleTests)
            singleTest.run(webDriver);
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "Test{" +
                "url='" + url + '\'' +
                ", singleTests=" + singleTests +
                '}';
    }
}
