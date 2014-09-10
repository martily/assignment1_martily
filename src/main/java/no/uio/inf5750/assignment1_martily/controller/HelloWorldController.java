package no.uio.inf5750.assignment1_martily.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HelloWorldController {

	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String test(ModelMap model) {
		model.addAttribute("message", "This is a test");
        //Spring uses InternalResourceViewResolver and return back index.jsp
        return "index";
	}
	
    @RequestMapping(value="/hello/{name}", method = RequestMethod.GET)
	public String helloWorld(@PathVariable String name, ModelMap model) {
		model.addAttribute("visitor", name);
		return "hello";
	}	
}
