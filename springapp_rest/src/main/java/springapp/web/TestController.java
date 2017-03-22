package springapp.web;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


@Controller
public class TestController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @RequestMapping(value="test", method= RequestMethod.GET)
	public ModelAndView methodGet()
			{
    	
    	logger.info("Found it's way to the GET method");
 
		ModelAndView model = new ModelAndView();

		model.setViewName("security_test");
 
		return model;
 
	}
    
    @RequestMapping(value="testDefault", method= RequestMethod.GET)
	public ModelAndView testDefault()
			{
    	
    	logger.info("Found it's way to the testDefault method");
 
		ModelAndView model = new ModelAndView();

		model.setViewName("testDefault");
 
		return model;
 
	}

    @RequestMapping(value="/admin/security_landing", method=RequestMethod.POST)
 	public ModelAndView sendToLandingPOST()
 			{
     	
     	logger.info("Found it's way to the POST method");
  
 		ModelAndView model = new ModelAndView();

 		model.setViewName("/admin/security_landing");
  
 		return model;
  
 	}
    
    @RequestMapping(value="/admin/security_landing", method= RequestMethod.GET)
  	public ModelAndView sendToLandingGET()
  			{
      	
      	logger.info("Found it's way to the GET method");
   
  		ModelAndView model = new ModelAndView();

  		model.setViewName("/admin/security_landing");
   
  		return model;
   
  	}
}