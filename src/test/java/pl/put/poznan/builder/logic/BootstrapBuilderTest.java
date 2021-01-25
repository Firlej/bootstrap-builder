package pl.put.poznan.builder.logic;
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

    }
}