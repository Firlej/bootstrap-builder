package pl.put.poznan.builder.rest;

public class BuilderRequest {
    private String header;
    private String author;
    private String keywords;
    private String footer;
    private String generatedText;

    public BuilderRequest() {
    }

    public BuilderRequest(String header, String footer, String author, String keywords) {
        this.header = header;
        this.author = author;
        this.keywords = keywords;
        this.footer = footer;
    }

    public String getHeader() {
        return header;
    }

    public String getAuthor() {
        return author;
    }

    public String getKeywords() {
        return keywords;
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
