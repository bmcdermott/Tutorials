package springapp.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.TransactionConfiguration;

import springapp.domain.Component;
import springapp.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-context.xml")
@Transactional
public class ComponentTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProductManager productManager;
	
//	@PersistenceContext
//	private EntityManager entityManager;

	

	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	private static int PRODUCT_COUNT = 2;


	//@BeforeTransaction
    private void init() {
		
		deleteFromTables("Components");
		deleteFromTables("Products");
		
		Product product1 = new Product();
		product1.setDescription("Fancy Table");
		product1.setLong_description("A Really Fancy Table");
		product1.setPrice(750.00);
		Component component =  new Component();
		component.setDescription("Wood");
		component.setLong_description("Lots of Wood");
		product1.addComponent(component);
		component =  new Component();
		component.setDescription("Glue");
		component.setLong_description("Lots of Glue");
		product1.addComponent(component);
		productManager.addProduct(product1);
		//products.add(product);

		product1 = new Product();
		product1.setDescription("Fancy Chair");
		product1.setLong_description("A Really Fancy Chair");
		product1.setPrice(560.00);
		component =  new Component();
		component.setDescription("Wood");
		component.setLong_description("Lots of Chair Wood");
		product1.addComponent(component);
		component =  new Component();
		component.setDescription("Glue");
		component.setLong_description("Lots of Chair Glue");
		product1.addComponent(component);
		productManager.addProduct(product1);
		
		component =  new Component();
		component.setDescription("An additional component");
		component.setLong_description("Did it work??????");
		product1.addComponent(component);
		productManager.addProduct(product1);

    }
	


	@Test
	public void testAddingComponents() {
		
		init() ;
		
		
		List<Product> products = productManager.getProducts();
		assertNotNull("Product is NULL", products);
		assertEquals(PRODUCT_COUNT, productManager.getProducts().size());
		
		for (Product prod : products) {
		    logger.info("PRODUCT: " + prod.getDescription());
		    for(Component comp : prod.getComponents()){
		    	logger.info("------- COMPONENT: " + comp.getLong_description());
		    }
		}



	}

	

}