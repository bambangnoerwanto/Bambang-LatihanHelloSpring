/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.HelloService;

/**
 *
 * @author Bengbenk
 */
public class HelloController extends SimpleFormController {
    
    public HelloController() {
        setCommandClass(Name.class);
    setCommandName("name");
    setSuccessView("helloView");
    setFormView("nameView");
    }
    
   
   
    @Override
protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {

        Name name = (Name) command;
        ModelAndView mv = new ModelAndView(getSuccessView());
        mv.addObject("helloMessage", helloService.sayHello(name.getValue(), name.getUmur()));
        
        
        return mv;
}
    private HelloService helloService;
    public void setHelloService(HelloService helloService) {
    this.helloService = helloService;
}
     }
  
