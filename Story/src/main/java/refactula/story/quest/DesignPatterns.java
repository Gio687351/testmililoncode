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
        String implPackage = "DesignPatterns/src/main/java/refactula/design/patterns";
        
        singleton = done(link("Singleton", implPackage + "/creational/singleton"), objectOrientedProgramming);
        factory = done(link("Factory", implPackage + "/creational/factory"), objectOrientedProgramming);
        factoryMethod = done(link("Factory Method", implPackage + "/creational/factory_method"), objectOrientedProgramming);
        abstractFactory = done(link("Abstract Factory", implPackage + "/creational/abstract_factory"), objectOrientedProgramming);
        builder = done(link("Builder", implPackage + "/creational/builder"), objectOrientedProgramming);
        prototype = done(link("Prototype", implPackage + "/creational/prototype"), objectOrientedProgramming);
        objectPool = done(link("Object Pool", implPackage + "/creational/object_pool"), objectOrientedProgramming);
        
        chainOfResponsibility = done(link("Chain of Responsibility", implPackage + "/behavioral/chain_of_responsibility"), objectOrientedProgramming);
        command = done(link("Command", implPackage + "/behavioral/command"), objectOrientedProgramming);
        interpreter = done(link("Interpreter", implPackage + "/behavioral/interpreter"), objectOrientedProgramming);
        iterator = task("Iterator", objectOrientedProgramming);
        mediator = task("Mediator", objectOrientedProgramming);
        memento = task("Memento", objectOrientedProgramming);
        observer = task("Observer", objectOrientedProgramming);
        strategy = task("Strategy", objectOrientedProgramming);
        templateMethod = task("Template Method", objectOrientedProgramming);
        visitor = task("Visitor", objectOrientedProgramming);
        nullObject = task("Null Object", objectOrientedProgramming);

        adapter = done(link("Adapter", implPackage + "/structural/adapter"), objectOrientedProgramming);
        bridge = done(link("Bridge", implPackage + "/structural/bridge"), objectOrientedProgramming);
        composite = done(link("Composite", implPackage + "/structural/composite"), objectOrientedProgramming);
        decorator = done(link("Decorator", implPackage + "/structural/decorator"), objectOrientedProgramming);
        flyweight = done(link("Flyweight", implPackage + "/structural/flyweight"), objectOrientedProgramming);
        proxy = done(link("Proxy", implPackage + "/structural/proxy"), objectOrientedProgramming);

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
