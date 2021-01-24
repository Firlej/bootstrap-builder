package pl.put.poznan.builder.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuilderRequestTest {
    private BuilderRequest request;
    private String header;
    private String footer;

    @BeforeEach
    public void setUp(){
        this.request = new BuilderRequest();
    }

    @Test
    public void testSetHeader(){
        String obj = "HEADER";
        request.setHeader(obj);
        assertEquals(obj, request.getHeader());
        assertNotEquals("some text",request.getHeader());
    }

    @Test
    public void testSetFooter(){
        String obj = "FOOTER";
        request.setFooter(obj);
        assertEquals(obj, request.getFooter());
        assertNotEquals("some text",request.getFooter());
    }

    @Test
    public void testGetHeader(){
        assertNull(request.getHeader());
        String obj1 = "HEADER";
        request.setHeader(obj1);
        assertNotNull(request.getHeader());
    }

    @Test
    public void testGetFooter(){
        assertNull(request.getFooter());
        String obj1 = "FOOTER";
        request.setFooter(obj1);
        assertNotNull(request.getFooter());
    }

    @Test
    public void testToString(){
        String obj1 = "HEADER";
        request.setHeader(obj1);
        request.getHeader();
        String obj2 = "FOOTER";
        request.setFooter(obj2);
        request.getFooter();
        String object1 = "BuilderRequest{" +
                "headerFixed='" + request.getHeader() + '\'' +
                ", footerTrue='" + request.getFooter() + '\'' +
                '}';
        assertEquals(object1, request.toString());
    }



}