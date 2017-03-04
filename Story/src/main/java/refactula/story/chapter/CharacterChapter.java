package refactula.story.chapter;

import refactula.story.markdown.Header;
import refactula.story.Hero;
import refactula.story.Level;
import refactula.story.markdown.MDLine;
import refactula.story.markdown.MDImage;
import refactula.story.markdown.MDWriter;

import static refactula.story.markdown.Formatting.bold;

public class CharacterChapter extends Chapter {
    private final Header header = new Header(2, "Character");
    private final Hero hero;
    private final Level level;
    private final String progressBar;

    public CharacterChapter(Hero hero, Level level, String progressBar) {
        this.hero = hero;
        this.level = level;
        this.progressBar = progressBar;
    }

    @Override
    public void writeTo(MDWriter writer) {
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