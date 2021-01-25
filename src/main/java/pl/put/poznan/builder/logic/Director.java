package pl.put.poznan.builder.logic;

/**
 * Class with one static method for building website using Builder class
 */
public class Director {

    /**
     * Building website using Builder class
     * @param builder On this builder director execute all steps
     * @return BootstrapBuilder
     */
    public static void construct(Builder builder) {
        builder
        .setPreHeader()
        .setMeta()
        .setHeader()
        .setPostHeader()
        .setFooter()
        .setPostFooter();
    }
}
