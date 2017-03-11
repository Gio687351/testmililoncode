package refactula.story.quest;

import refactula.story.markdown.Header;
import refactula.story.markdown.MDElements;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDWriter;
import refactula.story.achievement.GangOfOne;
import refactula.story.skill.ObjectOrientedProgramming;

import static refactula.story.markdown.Formatting.link;
import static refactula.story.markdown.MDElements.subheader;

public class DesignPatterns extends Quest {

    public DesignPatterns(ObjectOrientedProgramming objectOrientedProgramming, GangOfOne gangOfOne) {
        super("Design Patterns");

        gangOfOne.setDesignPatterns(this);

        String implPackage = "DesignPatterns/src/main/java/refactula/design/patterns";
        String creational = implPackage + "/creational";
        String behavioral = implPackage + "/behavioral";
        String structural = implPackage + "/structural";

        writeln(MDLine.of("Implement all design patterns."));

        writeln(subheader("Creational Patterns"));
        write(done(link("Singleton", creational + "/singleton"), objectOrientedProgramming));
        write(done(link("Factory", creational + "/factory"), objectOrientedProgramming));
        write(done(link("Factory Method", creational + "/factory_method"), objectOrientedProgramming));
        write(done(link("Abstract Factory", creational + "/abstract_factory"), objectOrientedProgramming));
        write(done(link("Builder", creational + "/builder"), objectOrientedProgramming));
        write(done(link("Prototype", creational + "/prototype"), objectOrientedProgramming));
        writeln(done(link("Object Pool", creational + "/object_pool"), objectOrientedProgramming));

        writeln(subheader("Behavioral Patterns"));
        write(done(link("Chain of Responsibility", behavioral + "/chain_of_responsibility"), objectOrientedProgramming));
        write(done(link("Command", behavioral + "/command"), objectOrientedProgramming));
        write(done(link("Interpreter", behavioral + "/interpreter"), objectOrientedProgramming));
        write(done(link("Iterator", behavioral + "/iterator"), objectOrientedProgramming));
        write(done(link("Mediator", behavioral + "/mediator"), objectOrientedProgramming));
        write(done(link("Memento", behavioral + "/memento"), objectOrientedProgramming));
        write(done(link("Observer", behavioral + "/observer"), objectOrientedProgramming));
        write(done(link("Strategy", behavioral + "/strategy"), objectOrientedProgramming));
        write(done(link("Template Method", behavioral + "/template_method"), objectOrientedProgramming));
        write(done(link("Visitor", behavioral + "/visitor"), objectOrientedProgramming));
        writeln(done(link("Null Object", behavioral + "/null_object"), objectOrientedProgramming));

        writeln(subheader("Structural Patterns"));
        write(done(link("Adapter", structural + "/adapter"), objectOrientedProgramming));
        write(done(link("Bridge", structural + "/bridge"), objectOrientedProgramming));
        write(done(link("Composite", structural + "/composite"), objectOrientedProgramming));
        write(done(link("Decorator", structural + "/decorator"), objectOrientedProgramming));
        write(done(link("Flyweight", structural + "/flyweight"), objectOrientedProgramming));
        writeln(done(link("Proxy", structural + "/proxy"), objectOrientedProgramming));

        writeln(subheader("Achievements"));
        writeln(done("Implement all patterns", gangOfOne));
    }

}
