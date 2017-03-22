package springapp.service;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import springapp.domain.Component;
import springapp.domain.Product;

public class AddComponentValidator implements Validator {


    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public boolean supports(Class<?> clazz) {
        return Component.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Component comp = (Component) obj;
        
        logger.info("COMPONENT INFO" + comp.toString());
        
        if (comp.getDescription().length() == 0) {
            errors.rejectValue("description", "required", null, "Value required.");
        }
        if (comp.getLong_description().length() == 0) {
            errors.rejectValue("long_description", "required", null, "Value required.");
        }     
        if (comp.getLong_description().length() < 10) {
            errors.rejectValue("long_description", "error.too-short", null, "Too Short");
        }        

    }


}