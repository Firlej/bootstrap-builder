package pl.put.poznan.builder.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class BootstrapBuilder {

    String header;
    String footer;



    public BootstrapBuilder(String _header, String _footer){
        header = _header;
        footer = _footer;
    }

    public String render(){
        return header + " " + footer;
    }
}
