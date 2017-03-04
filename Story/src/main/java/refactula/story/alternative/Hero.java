package refactula.story.alternative;

public class Hero {
    private final String name;
    private final MDAdvancedImage avatar;

    public Hero(String name) {
        this.name = name;
        this.avatar = new MDAdvancedImage("http://github.com/" + name + ".png", "200px");
    }

    public String getName() {
        return name;
    }

    public MDAdvancedImage getAvatar() {
        return avatar;
    }
}
