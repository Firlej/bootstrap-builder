package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;


@RestController
@RequestMapping("/builder")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(
            @RequestParam(value="header", defaultValue="static") String header,
            @RequestParam(value="footer", defaultValue="true") String footer
    ) {

        // log the parameters
//        logger.debug(text);
        logger.debug(header);
//        logger.debug(Arrays.toString(header));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer builder = new TextTransformer(header, footer);
        return builder.render();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@PathVariable String text, @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer("a", "b");
        return transformer.render();
    }



}


