package refactula.story.alternative.chapter;

import refactula.story.alternative.Header;
import refactula.story.alternative.Hero;
import refactula.story.alternative.Level;
import refactula.story.alternative.MDLine;
import refactula.story.alternative.MDImage;
import refactula.story.alternative.MDWriter;

import static refactula.story.alternative.Formatting.bold;

public class CharacterChapter {
    private final Header header = new Header(2, "Character");
    private final Hero hero;
    private final Level level;
    private final String progressBar;

    public CharacterChapter(Hero hero, Level level, String progressBar) {
        this.hero = hero;
        this.level = level;
        this.progressBar = progressBar;
    }

    public void print(MDWriter writer) {
        writer.writeln(header);
        writer.writeln(hero.getAvatar());
        writer.write(MDLine.joined("Name: " + bold(hero.getName())));
        writer.write(MDLine.joined("Level: " + bold(level.getLevel())));
        String progressPercents = String.format("%.2f%%", level.getProgress());
        writer.writeln(MDLine.joined("Progress: " + progressPercents
                + " (" + level.getCompleted() + "/" + level.getLines() + ")"));
        writer.writeln(new MDImage(progressBar, "Progress: " + progressPercents));
    }
}
