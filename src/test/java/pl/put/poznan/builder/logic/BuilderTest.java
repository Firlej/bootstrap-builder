package pl.put.poznan.builder.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderTest {

    @Test
    public void testSetPreHeader() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/1.pre_header.txt");
        Builder builder = new Builder(new StaticHeaderBuilder(), new FooterBuilder(), new MetaBuilder("", ""));
        String preHeader = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setPreHeader().build();

        assertEquals(preHeader, bsBuilder.getPreHeader());
    }

    @Test
    public void testSetHeaderFixed() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/2.header_fixed.txt");
        Builder builder = new Builder(new FixHeaderBuilder(), new FooterBuilder(), new MetaBuilder("", ""));
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setHeader().build();

        assertEquals(expected, bsBuilder.getHeader());
    }

    @Test
    public void testSetHeaderStatic() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/2.header_static.txt");
        Builder builder = new Builder(new StaticHeaderBuilder(), new FooterBuilder(), new MetaBuilder("", ""));
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setHeader().build();

        assertEquals(expected, bsBuilder.getHeader());
    }

    @Test
    public void testPostHeader() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/3.between_header_and_footer.txt");
        Builder builder = new Builder(new StaticHeaderBuilder(), new FooterBuilder(), new MetaBuilder("", ""));
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setPostHeader().build();

        assertEquals(expected, bsBuilder.getPostHeader());
    }

    @Test
    public void testFooterTrue() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/4.footer.txt");
        Builder builder = new Builder(new StaticHeaderBuilder(), new FooterBuilder(), new MetaBuilder("", ""));
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setFooter().build();

        assertEquals(expected, bsBuilder.getFooter());
    }

    @Test
    public void testFooterFalse() throws IOException {
        Builder builder = new Builder(new StaticHeaderBuilder(), new NoFooterBuilder(), new MetaBuilder("", ""));
        BootstrapBuilder bsBuilder = builder.setHeader().build();
        assertEquals("", bsBuilder.getFooter());
    }

    @Test
    public void testPostFooter() throws IOException{
        Path path = Paths.get("./src/main/resources/our_template/5.post_footer.txt");
        Builder builder = new Builder(new StaticHeaderBuilder(), new FooterBuilder(), new MetaBuilder("", ""));
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setPostFooter().build();

        assertEquals(expected, bsBuilder.getPostFooter());
    }
}