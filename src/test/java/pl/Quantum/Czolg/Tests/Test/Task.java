package pl.Quantum.Czolg.Tests.Test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.Quantum.Czolg.Funtions.Waiters;

import java.util.ArrayList;
import java.util.List;

public class Task {
    private static final Waiters WAITERS = new Waiters();
    private final String comment;
    public final String id;
    private final String command;
    private final String target;
    private final List<Target> targets = new ArrayList<>();

    public Task(JSONObject jsonObject){
        comment = jsonObject.getString("comment");
        id = jsonObject.getString("id");
        command = jsonObject.getString("command");
        target = jsonObject.getString("target");

        for (Object object : jsonObject.getJSONArray("targets")){
            JSONArray jsonArray = ((JSONArray) object);
            targets.add(new Target(jsonArray.getString(1),jsonArray.getString(0)));
        }
    }

    public void run(WebDriver webDriver){
        List<List<WebElement>> listListWebElement = getListListWebElement(webDriver);

        if(listListWebElement.size() == 0) return;

        WebElement webElement = getSingleWebElement(listListWebElement);
        if(webElement == null) return;
        action(webDriver,webElement);
    }

    private List<List<WebElement>> getListListWebElement(WebDriver webDriver){
        List<List<WebElement>> listListWebElement = new ArrayList<>();

        switch (command){
            case "click":
                for (Target target1 : targets) {
                    List<WebElement> webElementList = target1.getWebElements(webDriver);
                    if(webElementList != null) listListWebElement.add(webElementList);
                }
                break;
        }

        return listListWebElement;
    }

    private void action(WebDriver webDriver,WebElement webElement){
        switch (command){
            case "click":
                webElement = WAITERS.waitForClickablility(webDriver, webElement);
                webElement.click();
                break;
        }
    }

    private WebElement getSingleWebElement(List<List<WebElement>> listListWebElement){
        List<WebElement> webElementListEnd = new ArrayList<>(listListWebElement.get(0));
        List<WebElement> webElementListTemp = new ArrayList<>(listListWebElement.get(0));
        for (List<WebElement> webElementList : listListWebElement) {
            for (WebElement webElement : webElementListTemp) {
                if(!webElementList.contains(webElement))
                    webElementListEnd.remove(webElement);
            }
        }
        return webElementListEnd.get(0);
    }

    @Override
    public String toString() {
        return "Task{" +
                "comment='" + comment + '\'' +
                ", id='" + id + '\'' +
                ", command='" + command + '\'' +
                ", target='" + target + '\'' +
                ", targets=" + targets +
                '}';
    }
}
