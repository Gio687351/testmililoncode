package refactula.story.quest;

import refactula.story.Package;
import refactula.story.achievement.GangOfOne;
import refactula.story.markdown.MDLine;
import refactula.story.skill.ObjectOrientedProgramming;

import static refactula.story.markdown.MDElements.subheader;

public class DesignPatterns extends Quest {

    public DesignPatterns(ObjectOrientedProgramming objectOrientedProgramming, GangOfOne gangOfOne) {
        super("Design Patterns");
        gangOfOne.setDesignPatterns(this);

        Package implPackage = Package.create("DesignPatterns", "src", "main", "java", "refactula", "design", "patterns");
        writeln(MDLine.of("Implement all design patterns."));

        Package creational = implPackage.child("creational");
        writeln(subheader("Creational Patterns"));
        write(done(creational.link("Singleton", "singleton"), objectOrientedProgramming));
        write(done(creational.link("Factory", "factory"), objectOrientedProgramming));
        write(done(creational.link("Factory Method", "factory_method"), objectOrientedProgramming));
        write(done(creational.link("Abstract Factory", "abstract_factory"), objectOrientedProgramming));
        write(done(creational.link("Builder", "builder"), objectOrientedProgramming));
        write(done(creational.link("Prototype", "prototype"), objectOrientedProgramming));
        writeln(done(creational.link("Object Pool", "object_pool"), objectOrientedProgramming));

        Package behavioral = implPackage.child("behavioral");
        writeln(subheader("Behavioral Patterns"));
        write(done(behavioral.link("Chain of Responsibility", "chain_of_responsibility"), objectOrientedProgramming));
        write(done(behavioral.link("Command", "command"), objectOrientedProgramming));
        write(done(behavioral.link("Interpreter", "interpreter"), objectOrientedProgramming));
        write(done(behavioral.link("Iterator", "iterator"), objectOrientedProgramming));
        write(done(behavioral.link("Mediator", "mediator"), objectOrientedProgramming));
        write(done(behavioral.link("Memento", "memento"), objectOrientedProgramming));
        write(done(behavioral.link("Observer", "observer"), objectOrientedProgramming));
        write(done(behavioral.link("Strategy", "strategy"), objectOrientedProgramming));
        write(done(behavioral.link("Template Method", "template_method"), objectOrientedProgramming));
        write(done(behavioral.link("Visitor", "visitor"), objectOrientedProgramming));
        writeln(done(behavioral.link("Null Object", "null_object"), objectOrientedProgramming));

        Package structural = implPackage.child("structural");
        writeln(subheader("Structural Patterns"));
        write(done(structural.link("Adapter", "adapter"), objectOrientedProgramming));
        write(done(structural.link("Bridge", "bridge"), objectOrientedProgramming));
        write(done(structural.link("Composite", "composite"), objectOrientedProgramming));
        write(done(structural.link("Decorator", "decorator"), objectOrientedProgramming));
        write(done(structural.link("Flyweight", "flyweight"), objectOrientedProgramming));
        writeln(done(structural.link("Proxy", "proxy"), objectOrientedProgramming));

        writeln(subheader("Achievements"));
        writeln(done("Implement all patterns", gangOfOne));
    }

}
