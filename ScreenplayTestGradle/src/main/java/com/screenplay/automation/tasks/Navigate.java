package com.screenplay.automation.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

import javax.swing.text.html.Option;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {

    private final Option option;

    public Navigate(Option option) {
        this.option = option;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
   // actor.attemptsTo(Open.url(option.url));
    }

    public static Performable to(Option opcion) {
        return instrumented(Navigate.class, opcion);
    }
}
