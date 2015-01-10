package demo.controller;

import demo.domain.User;
import demo.domain.UserDao;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello() {
        System.out.println("Hello World !");
        return "home";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<User> getUsers() {
        return userDao.findAll();
    }

    public static final String HANDLEBARS_TEMPLATE_LOCATION = "demo/tpl/";
    public static final String HANDLEBARS_TEMPLATE_EXTENSION = ".tpl.html";

    @RequestMapping(value = "/tpl/{simpleTemplateName}")
    public void loadHandlebarsTemplate(@PathVariable String simpleTemplateName, HttpServletResponse response) {
        if (StringUtils.isEmpty(simpleTemplateName))
            throw new TemplateNotFoundException("Handlebars template name null or empty isn't allowed");
        final InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(HANDLEBARS_TEMPLATE_LOCATION + simpleTemplateName + HANDLEBARS_TEMPLATE_EXTENSION);
        if (resourceAsStream==null)
            throw new TemplateNotFoundException("Handlebars template " + simpleTemplateName + " is not found");
        try {
            IOUtils.copy(resourceAsStream, response.getOutputStream());
        } catch (IOException e) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR,"Loading handlebars template went with something wrong");
            } catch (IOException e1) {
                throw new RuntimeException(e);
            }
        }
    }
}
