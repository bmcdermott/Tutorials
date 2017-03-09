package springapp.service;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import springapp.domain.Product;

public class AddProductValidator implements Validator {


    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Product prod = (Product) obj;
        if (prod.getDescription().length() == 0) {
            errors.rejectValue("description", "required", null, "Value required.");
        }
        if (prod.getLong_description().length() == 0) {
            errors.rejectValue("long_description", "required", null, "Value required.");
        }     
        if (prod.getLong_description().length() < 10) {
            errors.rejectValue("long_description", "error.too-short", null, "Too Short");
        }        
        if (prod.getPrice() == 0) {
            errors.rejectValue("price", "error.not-zero", null, "Value required.");
        }
        if (prod.getPrice() > 10000) {
            errors.rejectValue("price", "error.too-expensive", null, "Too expensive.");
        }


    }


}