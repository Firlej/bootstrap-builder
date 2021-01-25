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

    private final MiniBuilderComponent preHeader;
    private final MiniBuilderComponent meta;
    private final MiniBuilderComponent header;
    private final MiniBuilderComponent postHeader;
    private final MiniBuilderComponent footer;
    private final MiniBuilderComponent postFooter;

    /**
     * Empty constructor
     */
    public Builder(MiniBuilderComponent header, MiniBuilderComponent footer, MiniBuilderComponent meta) {
        this.header = header;
        this.footer = footer;
        this.meta = meta;
        this.preHeader = new PreHeaderBuilder();
        this.postHeader = new PostHeaderBuilder();
        this.postFooter = new PostFooterBuilder();
    }

    /**
     * Sets all HTML code before header, it is all the same in every case
     * @return Builder
     */
    public Builder setPreHeader() {
        preHeader.setComponent();
        return this;
    }

    /**
     * Sets chosen header - static or fixed. When something else is passed as a parameter, returns Builder without changes
     * @return Builder
     */
    public Builder setHeader() {
        header.setComponent();
        return this;
    }

    /**
     * Sets chosen meta
     * @return Builder
     */
    public Builder setMeta() {
        meta.setComponent();
        return this;
    }

    /**
     * Sets HTML code between header and footer, it is all the same in every case
     * @return Builder
     */
    public Builder setPostHeader() {
        postHeader.setComponent();
        return this;
    }

    /**
     * Sets footer
     * @return Builder
     */
    public Builder setFooter() {
        footer.setComponent();
        return this;
    }

    /**
     * Sets rest HTML code after footer, it is all the same in every case
     * @return
     */
    public Builder setPostFooter() {
        postFooter.setComponent();
        return this;
    }

    /**
     * Returns complete object that is ready to be created
     * @return BootstrapBuilder
     */
    public BootstrapBuilder build() {
        return new BootstrapBuilder(
                preHeader.getComponent(),
                meta.getComponent(),
                header.getComponent(),
                postHeader.getComponent(),
                footer.getComponent(),
                postFooter.getComponent()
        );
    }
}
