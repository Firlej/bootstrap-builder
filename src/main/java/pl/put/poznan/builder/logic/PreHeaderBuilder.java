package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PreHeaderBuilder implements MiniBuilderComponent {

    private String component;

    public PreHeaderBuilder() {
        this.component = "";
    }

    @Override
    public void setComponent() {
        Path path = Paths.get("./src/main/resources/our_template/1.pre_header.txt");

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
