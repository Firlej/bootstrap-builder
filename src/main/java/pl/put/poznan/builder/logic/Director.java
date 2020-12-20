package pl.put.poznan.builder.logic;

public class Director {

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
