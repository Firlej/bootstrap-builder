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
    private Builder builder;

    @BeforeEach
    public void SetUp(){
        this.builder = new Builder();
    }

    @Test
    public void testSetPreHeader() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/1.pre_header.txt");
        String preHeader = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setPreHeader().build();

        assertEquals(preHeader, bsBuilder.getPreHeader());
    }

    @Test
    public void testSetHeaderFixed() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/2.header_fixed.txt");
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setHeader("fixed").build();

        assertEquals(expected, bsBuilder.getHeader());
    }

    @Test
    public void testSetHeaderStatic() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/2.header_static.txt");
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setHeader("static").build();

        assertEquals(expected, bsBuilder.getHeader());
    }

    @Test
    public void testPostHeader() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/3.between_header_and_footer.txt");
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setPostHeader().build();

        assertEquals(expected, bsBuilder.getPostHeader());
    }

    @Test
    public void testFooterTrue() throws IOException {
        Path path = Paths.get("./src/main/resources/our_template/4.footer.txt");
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setFooter("true").build();

        assertEquals(expected, bsBuilder.getFooter());
    }

    @Test
    public void testFooterFalse() throws IOException {
        BootstrapBuilder bsBuilder = builder.setHeader("false").build();
        assertEquals(null, bsBuilder.getFooter());
    }

    @Test
    public void testPostFooter() throws IOException{
        Path path = Paths.get("./src/main/resources/our_template/5.post_footer.txt");
        String expected = Files.readString(path, StandardCharsets.US_ASCII);

        BootstrapBuilder bsBuilder = builder.setPostFooter().build();

        assertEquals(expected, bsBuilder.getPostFooter());
    }
}