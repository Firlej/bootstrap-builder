package pl.put.poznan.builder.logic;

/**
    It holds parts of a website and is able to return fully constructed one
 */
public class BootstrapBuilder {

    private String preHeader;
    private String header;
    private String postHeader;
    private String footer;
    private String postFooter;

    /**
    Class constructor
     */
    public BootstrapBuilder(String preHeader, String header, String postHeader, String footer, String postFooter) {
        this.preHeader = preHeader;
        this.header = header;
        this.postHeader = postHeader;
        this.footer = footer;
        this.postFooter = postFooter;
    }

    /**
     * Binds parts to one complete website from available attributes
     * @return String
     */
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
}
