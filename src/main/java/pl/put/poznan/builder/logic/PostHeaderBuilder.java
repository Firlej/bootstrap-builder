package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PostHeaderBuilder implements MiniBuilderComponent {

    private String component;

    public PostHeaderBuilder() {
        this.component = "";
    }

    @Override
    public void setComponent() {
        Path path = Paths.get("./src/main/resources/our_template/3.between_header_and_footer.txt");

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
