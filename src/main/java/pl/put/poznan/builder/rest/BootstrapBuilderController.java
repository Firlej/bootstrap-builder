package pl.put.poznan.builder.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.*;
/*
BootstrapBuilderController class
 */

@RestController
@RequestMapping("/builder")
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(
            @RequestParam(value = "header", defaultValue = "static") String header,
            @RequestParam(value = "footer", defaultValue = "false") String footer
    ) {
        logger.info("GET header: " + header);
        logger.info("GET footer: " + footer);

        return Director.construct(header, footer).toString();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    public String post(@RequestBody Request request) {

        logger.info("POST header: " + request.header);
        logger.info("POST footer: " + request.footer);

        return Director.construct(request.header, request.footer).toString();
    }
}