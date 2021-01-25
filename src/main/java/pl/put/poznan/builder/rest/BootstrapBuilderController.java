package pl.put.poznan.builder.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.Director;


@Controller
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @GetMapping("/builder")
    public String builderFrom(Model model) {
        model.addAttribute("request", new BuilderRequest("fixed","true", "null", "null"));
        return "ui";
    }

    @PostMapping("/builder")
    public String builderSubmit(@ModelAttribute BuilderRequest builderRequest, Model model) {

        logger.info("header: " + builderRequest.getHeader());
        logger.info("footer: " + builderRequest.getFooter());
        logger.info("author: " + builderRequest.getAuthor());
        logger.info("keywords: " + builderRequest.getKeywords());

        String template = Director.construct(builderRequest.getHeader(), builderRequest.getFooter(), builderRequest.getAuthor(), builderRequest.getKeywords()).toString();
        model.addAttribute("template", template);
        return "return";
    }
}