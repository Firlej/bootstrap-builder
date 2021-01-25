package pl.put.poznan.builder.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.builder.logic.*;


@Controller
public class BootstrapBuilderController {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapBuilderController.class);

    @GetMapping("/builder")
    public String builderFrom(Model model) {
        model.addAttribute("request", new BuilderRequest("fixed","true", "", ""));
        return "ui";
    }

    @PostMapping("/builder")
    public String builderSubmit(@ModelAttribute BuilderRequest builderRequest, Model model) {

        logger.info("header: " + builderRequest.getHeader());
        logger.info("footer: " + builderRequest.getFooter());
        logger.info("author: " + builderRequest.getAuthor());
        logger.info("keywords: " + builderRequest.getKeywords());

        MiniBuilderComponent header;
        if (builderRequest.getHeader().equals("fixed")) {
            header = new FixHeaderBuilder();
        }
        else if (builderRequest.getHeader().equals("static")) {
            header = new StaticHeaderBuilder();
        }
        else {
            header = new NoHeaderBuilder();
        }

        MiniBuilderComponent footer;
        if (builderRequest.getFooter().equals("true")) {
            footer = new FooterBuilder();
        }
        else {
            footer = new NoFooterBuilder();
        }

        MiniBuilderComponent metaTags = new MetaBuilder(builderRequest.getAuthor(), builderRequest.getKeywords());

        Builder builder = new Builder(header, footer, metaTags);
        Director.construct(builder);
        String template = builder.build().toString();

        model.addAttribute("template", template);
        return "return";
    }
}