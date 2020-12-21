package pl.put.poznan.builder.logic;

/**
 * Class with one static method for building website using Builder class
 */
public class Director {

    /**
     * Building website using Builder class
     * @param header String ("static" - static header, "fixed" - fixed header, anything else - no header)
     * @param footer String ("true" - adds header, anything else - changes nothing)
     * @return BootstrapBuilder
     */
    public static BootstrapBuilder construct(String header, String footer) {
        return new Builder()
                .setPreHeader()
                .setHeader(header)
                .setPostHeader()
                .setFooter(footer)
                .setPostFooter()
                .build();
    }
}
