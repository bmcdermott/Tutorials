package springapp.web;

import javax.servlet.ServletException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springapp.domain.Component;
import springapp.domain.Product;
import springapp.service.AddComponentValidator;
import springapp.service.AddProductValidator;
import springapp.service.ProductManager;

@Controller
@RequestMapping("/admin")
public class ProductAnnotatedFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    @Autowired
    private ProductManager productManager;
    @Autowired
    AddProductValidator addProductValidator;
    @Autowired
    AddComponentValidator addComponentValidator;

    @RequestMapping(value="/addproduct", method=RequestMethod.GET)
    public String initAddProductForm(ModelMap model) {

        Product prod = new Product();
        model.addAttribute("product", prod);
        logger.info("Processing the page GET, added the new (unpopulated) product object to the model");

        return "/admin/addproduct";

    }
    
    @RequestMapping(value="/addproduct", method= RequestMethod.POST)
    public String addProduct(@ModelAttribute("product")Product prod, 
    		BindingResult result, 
    		final RedirectAttributes redirectAttributes) throws ServletException {

    	addProductValidator.validate(prod, result);
    	
        if (result.hasErrors()) {
            return "/admin/addproduct";
        }

        logger.info("Adding Product " + prod.getDescription() + ".");
        logger.info("Adding Product " + prod.getId() + ".");
        productManager.addProduct(prod);
        logger.info("Processing the page POST, added the product to the database");
        
        String msg = "Product: " + prod.getDescription();
        msg += ", added successfully";

        //Flash attributes are available via the model after the redirect:
        redirectAttributes.addFlashAttribute("product", prod);
        redirectAttributes.addFlashAttribute("message",msg);
        
        return "redirect:/admin/success.htm"; 
    }
    
    @RequestMapping(value="/editproduct", method=RequestMethod.GET)
    public String initEditProductForm(@RequestParam("PRODUCT_ID")String PRODUCT_ID, ModelMap model) {

    	logger.info("In the Edit Product GET Method with PRODUCT_ID:" + PRODUCT_ID);
        Product prod = productManager.getProductByID(Integer.parseInt(PRODUCT_ID));
        model.addAttribute("product", prod);
        logger.info("Processing the page GET, retrieved the product and added it to the model");

        return "/admin/editproduct";

    }
    
    @RequestMapping(value="/editproduct", method= RequestMethod.POST)
    public String updateProduct(@ModelAttribute("product")Product prod, 
    		BindingResult result, 
    		final RedirectAttributes redirectAttributes) throws ServletException {

    	addProductValidator.validate(prod, result);
    	
        if (result.hasErrors()) {
            return "/admin/addproduct";
        }

        logger.info("Adding Product " + prod.getDescription() + ".");
        logger.info("Adding Product " + prod.getId() + ".");
        productManager.updateProduct(prod);
        logger.info("Processing the page POST, updated the product in the database");
        
        String msg = "Product: " + prod.getDescription();
        msg += ", updated successfully";

        //Flash attributes are available via the model after the redirect:
        redirectAttributes.addFlashAttribute("product", prod);
        redirectAttributes.addFlashAttribute("message",msg);
        
        return "redirect:/admin/success.htm"; 
    }
    
    @RequestMapping(value="/deleteproductconfirm", method=RequestMethod.GET)
    public String initDeleteProductForm(@RequestParam("PRODUCT_ID")String PRODUCT_ID,
			ModelMap model) {

        Product prod = new Product();
        model.addAttribute("product", prod);
        model.addAttribute("PRODUCT_ID", PRODUCT_ID);
        logger.info("Processing the page GET, for the delete product method");

        return "/admin/deleteproductconfirm";

      }
    
    @RequestMapping(value="/deleteproductconfirm", method=RequestMethod.POST)
    public String deleteProduct(@ModelAttribute("product")Product prod, 
    		BindingResult result, 
    		@ModelAttribute("PRODUCT_ID")String PRODUCT_ID,
    		final RedirectAttributes redirectAttributes) throws ServletException {


        
        Product p = productManager.getProductByID(Integer.parseInt(PRODUCT_ID));
        logger.info("Deleting Product " + p.getDescription() + ".");
        productManager.deleteProduct(p);
        logger.info("Processing the page POST, DELETED the product from the database");
        
        String msg = "Product: " + p.getDescription();
        msg += ", deleted successfully";

        //Flash attributes are available via the model after the redirect:
        redirectAttributes.addFlashAttribute("product", p);
        redirectAttributes.addFlashAttribute("message",msg);
        
        //TODO - Generic result page
        return "redirect:/admin/success.htm"; 
    }
    
    @RequestMapping(value="/addcomponent", method=RequestMethod.GET)
    public String initAddComponentForm(@RequestParam("PRODUCT_ID")String PRODUCT_ID,
    									ModelMap model) {

    	//Uses the request parm PRODUCT_ID to generate a component with the 
    	//appropriate Product object assigned, passes along the component in the model
        Component comp = new Component();
        model.addAttribute("component", comp);
        model.addAttribute("PRODUCT_ID", PRODUCT_ID);

        return "/admin/addcomponent";

      }
    
    @RequestMapping(value="/addcomponent", method= RequestMethod.POST)
    public String addComponent(
    		@ModelAttribute("component")Component comp, 
    		BindingResult result, 
    		@ModelAttribute("PRODUCT_ID")String PRODUCT_ID,
    		final RedirectAttributes redirectAttributes) throws ServletException {

    	logger.info("Processing the page POST, Beginning");
        Product p = productManager.getProductByID(Integer.parseInt(PRODUCT_ID));
        p.addComponent(comp);
        comp.addProduct(p);    	
        addComponentValidator.validate(comp, result);
    	
        if (result.hasErrors()) {
            return "/admin/addcomponent";
        }
        
        productManager.addProduct(p);
        
        logger.info("COMPONENT INFO" + comp.toString());
        
        String msg = "Component: " + comp.getDescription();
        msg += ", successfully added to Product: " + p.getDescription();
        
        
        //Flash attributes are available via the model after the redirect:
        redirectAttributes.addFlashAttribute("product", p);
        redirectAttributes.addFlashAttribute("component", comp);
        redirectAttributes.addFlashAttribute("message",msg);
        
    	logger.info("Processing the page POST, Ending");
        
        return "redirect:/admin/success.htm"; 
    }
    
    @RequestMapping(value="/success", method=RequestMethod.GET)
    public String showProduct(){
        return "/admin/success";
    }

}