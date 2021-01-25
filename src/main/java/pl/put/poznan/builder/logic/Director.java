package pl.put.poznan.builder.logic;

/**
 * Class with one static method for building website using Builder class
 */
public class Director {

    /**
     * Building website using Builder class
     * @param header String ("static" - static header, "fixed" - fixed header, anything else - no header)
     * @param footer String ("true" - adds header, anything else - changes nothing)
     * @param author String author
     * @param keywords String keywords
     * @return BootstrapBuilder
     */
    public static BootstrapBuilder construct(String header, String footer, String author, String keywords) {
        return new Builder()
                .setPreHeader()
                .setMeta(author, keywords)
                .setHeader(header)
                .setPostHeader()
                .setFooter(footer)
                .setPostFooter()
                .build();
    }
}
