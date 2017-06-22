package springapp.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springapp.service.PriceIncrease;
import springapp.service.ProductManager;

@RestController
public class restPriceIncrease {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
    @Autowired
    private Validator priceIncreaseValidator;
    
    @Autowired
    private ProductManager productManager;
	
	@RequestMapping("raiseprices")
	public void priceIncrease(@RequestParam(value="percent") int percent){
		
		PriceIncrease pi = new PriceIncrease();
		pi.setPercentage(percent);
		BeanPropertyBindingResult errors = new BeanPropertyBindingResult(pi, "PriceIncrease");
		
		priceIncreaseValidator.validate(pi, errors);
		
        if (!(errors.hasErrors())) {
            int increase = pi.getPercentage();
            logger.info("Increasing prices by " + increase + "%.");
            productManager.increasePrice(increase);
        }

		
		//return new String("you increased prices by " + percent);
	}

}
