package pl.put.poznan.builder.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.BootstrapBuilder;

@RestController
@RequestMapping("/builder")
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(
            @RequestParam(value="header", defaultValue="static\n\n") String header,
            @RequestParam(value="footer", defaultValue="\n\nfalse") String footer
    ) {
//      log the parameters
        logger.debug(header);

        BootstrapBuilder director = new BootstrapBuilder.Builder()
                .setPreHeader()
                .setHeader(header)
                .setPostHeader()
                .setFooter(footer)
                .setPostFooter()
                .build();

        return director.toString();
    }

    // TODO: 20/12/2020 post not working correctly 
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(
            @RequestParam(value="header", defaultValue="static\n\n") String header,
            @RequestParam(value="footer", defaultValue="\n\nfalse") String footer
//            @RequestBody BootstrapBuilder info
    ) {
//      log the parameters
        logger.debug(header);

        System.out.println(header);
        System.out.println(footer);

        BootstrapBuilder director = new BootstrapBuilder.Builder()
                .setPreHeader()
                .setHeader(header)
                .setPostHeader()
                .setFooter(footer)
                .setPostFooter()
                .build();

        return director.toString();
    }
}