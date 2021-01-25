package pl.put.poznan.builder.logic;
<<<<<<< HEAD
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;


class BootstrapBuilderTest {

  private static BootstrapBuilder bb;

  @Test
   public void test1() {
       bb = mock(BootstrapBuilder.class);
       when(bb.getFooter()).thenReturn("footer");
       String gf = bb.getFooter();
       verify(bb).getFooter();

  }

  @Test
  public void test2() {
      bb = mock(BootstrapBuilder.class);
      when(bb.getHeader()).thenReturn("header");
      String gh = bb.getHeader();
      verify(bb).getHeader();


  }

  @Test
  public void test3() {
      bb = mock(BootstrapBuilder.class);
      when(bb.getPostFooter()).thenReturn("postfooter");
      String gh = bb.getPostFooter();
      verify(bb).getPostFooter();

  }
  @Test
  public void test4() {
        bb = mock(BootstrapBuilder.class);
        when(bb.getPostHeader()).thenReturn("postheader");
        String gh = bb.getPostHeader();
        verify(bb).getPostHeader();

    }

    @Test
    public void test5() {
        bb = mock(BootstrapBuilder.class);
        when(bb.getPreHeader()).thenReturn("postheader");
        String gh = bb.getPreHeader();
        verify(bb).getPreHeader();

=======

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class BootstrapBuilderTest {

    @Test
    void testToStringEmpty() {
        BootstrapBuilder bsBuilder = new BootstrapBuilder("", "", "", "", "", "");

        assertEquals("", bsBuilder.toString());
    }

    @Test
    void testToString() {
        String toTest = "preHeader meta header postHeader footer postFooter";
        List<String> words = List.of(toTest.split(" "));
        String expected = String.join("", words);

        BootstrapBuilder bsBuilder = new BootstrapBuilder(words.get(0), words.get(1), words.get(2), words.get(3), words.get(4), words.get(5));

        assertEquals(expected, bsBuilder.toString());
>>>>>>> 6765aec17b76c99c549305ffb0ddd005f746180c
    }
}