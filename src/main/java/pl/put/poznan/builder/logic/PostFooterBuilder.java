package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PostFooterBuilder implements MiniBuilderComponent {

    private String component;

    public PostFooterBuilder() {
        this.component = "";
    }

    @Override
    public void setComponent() {
        Path path = Paths.get("./src/main/resources/our_template/5.post_footer.txt");

        try {
            component = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public String getComponent() {
        return component;
    }
}
