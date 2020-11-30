package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    String header;
    String footer;



    public TextTransformer(String _header, String _footer){
        header = _header;
        footer = _footer;
    }

    public String render(){
        return header + " " + footer;
    }
}
