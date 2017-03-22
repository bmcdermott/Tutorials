package springapp.web;


import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springapp.service.PriceIncrease;
//import springapp.service.PriceIncreaseValidator;
import springapp.service.ProductManager;

@Controller
@RequestMapping("/priceincrease.htm")
public class PriceIncreaseAnnotatedFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;
    @Autowired
    private Validator priceIncreaseValidator;

    @RequestMapping(method= RequestMethod.POST)
    public String onSubmit(@ModelAttribute("priceincrease")PriceIncrease pi, BindingResult result) throws ServletException {


        	priceIncreaseValidator.validate(pi, result);
        	
            if (result.hasErrors()) {
                return "priceincrease";
            }
            
            int increase = pi.getPercentage();
            logger.info("Increasing prices by " + increase + "%.");
            productManager.increasePrice(increase);

            return "redirect:hello.htm";
 
    }

    @RequestMapping(method=RequestMethod.GET)
    public String initializeForm(ModelMap model) {

        PriceIncrease pi= new PriceIncrease();
        model.addAttribute("priceincrease", pi);

        return "priceincrease";

      }


}