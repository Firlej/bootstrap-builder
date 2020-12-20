package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BootstrapBuilder {

    private String preHeader;
    private String header;
    private String postHeader;
    private String footer;
    private String postFooter;

    public BootstrapBuilder(String preHeader, String header, String postHeader, String footer, String postFooter) {
        this.preHeader = preHeader;
        this.header = header;
        this.postHeader = postHeader;
        this.footer = footer;
        this.postFooter = postFooter;
    }

    @Override
    public String toString() {
        String page = "";
        if (preHeader != null) {
            page += preHeader;
        }
        if (header != null) {
            page += header;
        }
        if (postHeader != null) {
            page += postHeader;
        }
        if (footer != null) {
            page += footer;
        }
        if (postFooter != null) {
            page += postFooter;
        }

        return page;
    }

    public String getPreHeader() {
        return preHeader;
    }

    public String getHeader() {
        return header;
    }

    public String getPostHeader() {
        return postHeader;
    }

    public String getFooter() {
        return footer;
    }

    public String getPostFooter() {
        return postFooter;
    }

    public static class Builder {
        private String preHeader;
        private String header;
        private String postHeader;
        private String footer;
        private String postFooter;

        public Builder setPreHeader() {
            Path path = Paths.get("./src/main/resources/1.pre_header.txt");
            try {
                preHeader = Files.readString(path, StandardCharsets.US_ASCII);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return this;
        }

        public Builder setHeader(String type) {
            Path path;
            switch (type) {
                case ("static"):
                    path = Paths.get("./src/main/resources/2.header_static.txt");
                    break;
                case ("fixed"):
                    path = Paths.get("./src/main/resources/2.header_fixed.txt");
                    break;
                default:
                    return this;
            }

            try {
                header = Files.readString(path, StandardCharsets.US_ASCII);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return this;
        }

        public Builder setPostHeader() {
            Path path = Paths.get("./src/main/resources/3.between_header_and_footer.txt");
            try {
                postHeader = Files.readString(path, StandardCharsets.US_ASCII);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            return this;
        }

        public Builder setFooter(String foot) {
            // TODO: 20/12/2020 footer.txt content needs to be created
            Path path = Paths.get("./src/main/resources/4.footer.txt");
            if (foot.equals("true")) {
                try {
                    footer = Files.readString(path, StandardCharsets.US_ASCII);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            return this;
        }

        public Builder setPostFooter() {
            Path path = Paths.get("./src/main/resources/5.post_footer.txt");
            try {
                postFooter = Files.readString(path, StandardCharsets.US_ASCII);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return this;
        }

        public BootstrapBuilder build() {
            return new BootstrapBuilder(preHeader, header, postHeader, footer, postFooter);
        }
    }
}
