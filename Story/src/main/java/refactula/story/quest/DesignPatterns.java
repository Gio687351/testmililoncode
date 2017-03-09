package refactula.story.quest;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.achievement.GangOfOne;
import refactula.story.skill.ObjectOrientedProgramming;

import static refactula.story.markdown.Formatting.link;

public class DesignPatterns extends Quest {
    private final Header header = new Header(3, "Design Patterns");

    private final Task singleton;
    private final Task factory;
    private final Task factoryMethod;
    private final Task abstractFactory;
    private final Task builder;
    private final Task prototype;
    private final Task objectPool;

    private final Task chainOfResponsibility;
    private final Task command;
    private final Task interpreter;
    private final Task iterator;
    private final Task mediator;
    private final Task memento;
    private final Task observer;
    private final Task strategy;
    private final Task templateMethod;
    private final Task visitor;
    private final Task nullObject;

    private final Task adapter;
    private final Task bridge;
    private final Task composite;
    private final Task decorator;
    private final Task flyweight;
    private final Task proxy;

    private final Task implementAll;

    public DesignPatterns(ObjectOrientedProgramming objectOrientedProgramming, GangOfOne gangOfOne) {
        gangOfOne.setDesignPatterns(this);

        String implPackage = "DesignPatterns/src/main/java/refactula/design/patterns";

        String creational = implPackage + "/creational";
        singleton = done(link("Singleton", creational + "/singleton"), objectOrientedProgramming);
        factory = done(link("Factory", creational + "/factory"), objectOrientedProgramming);
        factoryMethod = done(link("Factory Method", creational + "/factory_method"), objectOrientedProgramming);
        abstractFactory = done(link("Abstract Factory", creational + "/abstract_factory"), objectOrientedProgramming);
        builder = done(link("Builder", creational + "/builder"), objectOrientedProgramming);
        prototype = done(link("Prototype", creational + "/prototype"), objectOrientedProgramming);
        objectPool = done(link("Object Pool", creational + "/object_pool"), objectOrientedProgramming);

        String behavioral = implPackage + "/behavioral";
        chainOfResponsibility = done(link("Chain of Responsibility", behavioral + "/chain_of_responsibility"), objectOrientedProgramming);
        command = done(link("Command", behavioral + "/command"), objectOrientedProgramming);
        interpreter = done(link("Interpreter", behavioral + "/interpreter"), objectOrientedProgramming);
        iterator = done(link("Iterator", behavioral + "/iterator"), objectOrientedProgramming);
        mediator = done(link("Mediator", behavioral + "/mediator"), objectOrientedProgramming);
        memento = done(link("Memento", behavioral + "/memento"), objectOrientedProgramming);
        observer = done(link("Observer", behavioral + "/observer"), objectOrientedProgramming);
        strategy = task("Strategy", objectOrientedProgramming);
        templateMethod = task("Template Method", objectOrientedProgramming);
        visitor = done(link("Visitor", behavioral + "/visitor"), objectOrientedProgramming);
        nullObject = done(link("Null Object", behavioral + "/null_object"), objectOrientedProgramming);

        String structural = implPackage + "/structural";
        adapter = done(link("Adapter", structural + "/adapter"), objectOrientedProgramming);
        bridge = done(link("Bridge", structural + "/bridge"), objectOrientedProgramming);
        composite = done(link("Composite", structural + "/composite"), objectOrientedProgramming);
        decorator = done(link("Decorator", structural + "/decorator"), objectOrientedProgramming);
        flyweight = done(link("Flyweight", structural + "/flyweight"), objectOrientedProgramming);
        proxy = done(link("Proxy", structural + "/proxy"), objectOrientedProgramming);

        implementAll = task("Implement all patterns", gangOfOne);
    }

    @Override
    public void writeTo(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(MDLine.of("Implement all design patterns."));

        writer.writeln(new Header(5, "Creational Patterns"));
        writer.write(singleton);
        writer.write(factory);
        writer.write(factoryMethod);
        writer.write(abstractFactory);
        writer.write(builder);
        writer.write(prototype);
        writer.writeln(objectPool);

        writer.writeln(new Header(5, "Behavioral Patterns"));
        writer.write(chainOfResponsibility);
        writer.write(command);
        writer.write(interpreter);
        writer.write(iterator);
        writer.write(mediator);
        writer.write(memento);
        writer.write(observer);
        writer.write(strategy);
        writer.write(templateMethod);
        writer.write(visitor);
        writer.writeln(nullObject);

        writer.writeln(new Header(5, "Structural Patterns"));
        writer.write(adapter);
        writer.write(bridge);
        writer.write(composite);
        writer.write(decorator);
        writer.write(flyweight);
        writer.writeln(proxy);

        writer.writeln(new Header(5, "Achievements"));
        writer.writeln(implementAll);
    }

    @Override
    public Header getHeader() {
        return header;
    }
}
