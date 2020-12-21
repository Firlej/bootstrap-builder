package pl.put.poznan.builder.logic;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * It builds complete template of HTML webpage, based on Bootstrap framework, from parts.
 */
public class Builder {

    private String preHeader;
    private String header;
    private String postHeader;
    private String footer;
    private String postFooter;

    /**
     * Empty constructor
     */
    public Builder() {}

    /**
     * Sets all HTML code before header, it is all the same in every case
     * @return Builder
     */
    public Builder setPreHeader() {
        Path path = Paths.get("./src/main/resources/1.pre_header.txt");
        try {
            preHeader = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this;
    }

    /**
     * Sets chosen header - static or fixed. When something else is passed as a parameter, returns Builder without changes
     * @param type String ("static" - static header, "fixed" - fixed header, anything else - no header)
     * @return Builder
     */
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

    /**
     * Sets HTML code between header and footer, it is all the same in every case
     * @return Builder
     */
    public Builder setPostHeader() {
        Path path = Paths.get("./src/main/resources/3.between_header_and_footer.txt");
        try {
            postHeader = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return this;
    }

    /**
     * Sets footer if "true" is passed as parameter
     * @param foot String ("true" - adds header, anything else - changes nothing)
     * @return Builder
     */
    public Builder setFooter(String foot) {
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

    /**
     * Sets rest HTML code after footer, it is all the same in every case
     * @return
     */
    public Builder setPostFooter() {
        Path path = Paths.get("./src/main/resources/5.post_footer.txt");
        try {
            postFooter = Files.readString(path, StandardCharsets.US_ASCII);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return this;
    }

    /**
     * Returns complete object that is ready to be created
     * @return BootstrapBuilder
     */
    public BootstrapBuilder build() {
        return new BootstrapBuilder(preHeader, header, postHeader, footer, postFooter);
    }
}
