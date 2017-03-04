package refactula.story.alternative;

import refactula.story.alternative.markdown.MDAdvancedImage;

public class Hero {
    private final String name;
    private final MDAdvancedImage avatar;

    public Hero(String name, String alternativeName) {
        this.name = name;
        this.avatar = new MDAdvancedImage("https://github.com/" + name + ".png", alternativeName, "200px");
    }

    public String getName() {
        return name;
    }

    public MDAdvancedImage getAvatar() {
        return avatar;
    }
}
