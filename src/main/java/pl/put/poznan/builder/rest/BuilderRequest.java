package pl.put.poznan.builder.rest;

public class BuilderRequest {
    private String header;
    private String footer;
    private String generatedText;

    public BuilderRequest() {
    }

    public BuilderRequest(String header, String footer) {
        this.header = header;
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    @Override
    public String toString() {
        return "BuilderRequest{" +
                "headerFixed='" + header + '\'' +
                ", footerTrue='" + footer + '\'' +
                '}';
    }
}
