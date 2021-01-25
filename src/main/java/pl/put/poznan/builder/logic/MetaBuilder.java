package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MetaBuilder implements MiniBuilderComponent {

    private String component;
    private String author;
    private String keywords;

    public MetaBuilder(String author, String keywords) {
        this.component = "";
        this.author = author;
        this.keywords = keywords;
    }

    @Override
    public void setComponent() {
        component = "" +
                "<meta name=\"author\" content=\"" +
                author +
                "\">\n" +
                "<meta name=\"keywords\" content=\"" +
                keywords +
                "\">\n";
    }

    @Override
    public String getComponent() {
        return component;
    }
}
