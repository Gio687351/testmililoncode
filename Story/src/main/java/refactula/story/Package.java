package refactula.story;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import refactula.story.markdown.Formatting;

import java.util.Arrays;
import java.util.List;

public class Package {
    private final List<String> pathFolders;

    public static Package create(String... pathFolders) {
        return new Package(ImmutableList.copyOf(pathFolders));
    }

    public Package(List<String> pathFolders) {
        this.pathFolders = pathFolders;
    }

    public Package child(String... childFolders) {
        Builder<String> builder = ImmutableList.builder();
        builder.addAll(pathFolders);
        builder.addAll(Arrays.asList(childFolders));
        return new Package(builder.build());
    }

    public String link(String text) {
        return Formatting.link(text, Joiner.on("/").join(pathFolders));
    }

    public String link(String text, String firstChild, String... otherChildren) {
        return Formatting.link(text, Joiner.on("/")
                .join(ImmutableList.builder()
                        .addAll(pathFolders)
                        .add(firstChild)
                        .addAll(Arrays.asList(otherChildren))
                        .build()));
    }
}
