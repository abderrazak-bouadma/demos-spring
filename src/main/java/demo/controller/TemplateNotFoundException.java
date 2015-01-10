package demo.controller;

/**
 * Created with IntelliJ IDEA.
 * User: abderrazak
 * Date: 04/01/15
 * Time: 00:18
 */
public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException(String message) {
        super(message);
    }
}
