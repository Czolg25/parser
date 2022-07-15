package pl.Quantum.Czolg.Tests.Test;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class SingleTest {
    private final String name;
    private final String id;
    private final List<Task> tasks = new ArrayList<>();
    public SingleTest(JSONObject jsonObject){
        this.name = jsonObject.getString("name");
        this.id = jsonObject.getString("id");

        for (Object object : jsonObject.getJSONArray("commands"))
            tasks.add(new Task((JSONObject) object));
    }

    public void run(WebDriver webDriver){
        System.out.println("Start test "+name);
        for (Task task : tasks)
            task.run(webDriver);
    }

    @Override
    public String toString() {
        return "SingleTest{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
