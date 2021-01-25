package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FixHeaderBuilder implements MiniBuilderComponent {

    private String component;

    public FixHeaderBuilder() {
        this.component = "";
    }

    @Override
    public void setComponent() {
        Path path = Paths.get("./src/main/resources/our_template/2.header_fixed.txt");

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
