package pl.put.poznan.builder.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.builder.logic.BootstrapBuilder;


@RestController
@RequestMapping("/builder")
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(
            @RequestParam(value = "header", defaultValue = "static") String header,
            @RequestParam(value = "footer", defaultValue = "false") String footer
    ) {
//        logger.debug(header);

//        System.out.println(header);
//        System.out.println(footer);

        BootstrapBuilder director = new BootstrapBuilder.Builder()
                .setPreHeader()
                .setHeader(header)
                .setPostHeader()
                .setFooter(footer)
                .setPostFooter()
                .build();

        return director.toString();
    }

//    @RequestMapping(method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
//    public String post(@RequestBody Request request) {
//
//        System.out.println(request);
//        System.out.println(request.header);
//        System.out.println(request.footer);
//
//        BootstrapBuilder director = new BootstrapBuilder.Builder()
//                .setPreHeader()
//                .setHeader(request.header)
//                .setPostHeader()
//                .setFooter(request.footer)
//                .setPostFooter()
//                .build();
//
//        return director.toString();
//    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(
            @RequestParam(value = "header", defaultValue = "static") String header,
            @RequestParam(value = "footer", defaultValue = "false") String footer
    ) {

//        System.out.println(header);
//        System.out.println(footer);

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