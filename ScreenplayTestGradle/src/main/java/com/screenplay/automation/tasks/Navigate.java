package com.screenplay.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.text.html.Option;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {

    private WebDriver hisBrowser;
    private Actor actor = new Actor("User");


    @Override
    public <T extends Actor> void performAs(T actor) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\rherrera\\IdeaProjects\\GitHub\\ScreenplayTestGradle\\src\\test\\resources\\webDriver\\chromedriver.exe");
        hisBrowser = new ChromeDriver();
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    public static Performable to() {
        return instrumented(Navigate.class);
    }
}
