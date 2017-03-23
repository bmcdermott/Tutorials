package springapp.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.transaction.TransactionConfiguration;
import springapp.domain.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/test/resources/test-context.xml")
@Transactional
public class SimpleProductManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private ProductManager productManager;
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	@Autowired
//	private ProductDao productDao;

	private static int PRODUCT_COUNT = 2;

	private static Double CHAIR_PRICE = new Double(20.50);
	private static String CHAIR_DESCRIPTION = "Chair";

	private static String TABLE_DESCRIPTION = "Table";
	private static Double TABLE_PRICE = new Double(150.10);

	private static int POSITIVE_PRICE_INCREASE = 10;


	@BeforeTransaction
    public void beforeTransaction() {

    }
	

//	@Test
//	public void testGetProductsWithNoProducts() {
//		//productManager = new SimpleProductManager();
//		//productManager.setProductDao(new InMemoryProductDao(null));
//		assertNull(productManager.getProducts());
//	}

	@Test
	public void testGetProducts() {
		deleteFromTables("products_components");
		deleteFromTables("Components");
		deleteFromTables("Products");
		
		Product product1 = new Product();
		product1.setDescription("Chair");
		product1.setLong_description("Chair");
		product1.setPrice(CHAIR_PRICE);
		productManager.addProduct(product1);
		//products.add(product);

		product1 = new Product();
		product1.setDescription("Table");
		product1.setLong_description("Table");
		product1.setPrice(TABLE_PRICE);
		productManager.addProduct(product1);
		
		List<Product> products = productManager.getProducts();
		assertNotNull("Product is NULL", products);
		assertEquals(PRODUCT_COUNT, productManager.getProducts().size());

		Product product = products.get(0);
		assertEquals(CHAIR_DESCRIPTION, product.getDescription());
		assertEquals(CHAIR_PRICE, product.getPrice());

		product = products.get(1);
		assertEquals(TABLE_DESCRIPTION, product.getDescription());
		assertEquals(TABLE_PRICE, product.getPrice());
	}

	@Test
	public void testIncreasePriceWithNullListOfProducts() {
		try {
//			productManager = new SimpleProductManager();
//			productManager.setProductDao(new InMemoryProductDao(null));
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (NullPointerException ex) {
			fail("Products list is null.");
		}
	}

	@Test
	public void testIncreasePriceWithEmptyListOfProducts() {
		try {
			deleteFromTables("products_components");
			deleteFromTables("Components");
			deleteFromTables("Products");
			
			productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		} catch (Exception ex) {
			fail("Products list is empty.");
		}
	}
//
	@Test
	public void testIncreasePriceWithPositivePercentage() {
		deleteFromTables("products_components");
		deleteFromTables("Components");
		deleteFromTables("Products");
		
		Product product1 = new Product();
		product1.setDescription("Chair");
		product1.setLong_description("Chair");
		product1.setPrice(CHAIR_PRICE);
		productManager.addProduct(product1);
		//products.add(product);

		product1 = new Product();
		product1.setDescription("Table");
		product1.setLong_description("Table");
		product1.setPrice(TABLE_PRICE);
		productManager.addProduct(product1);
		
		productManager.increasePrice(POSITIVE_PRICE_INCREASE);
		double expectedChairPriceWithIncrease = 22.55;
		double expectedTablePriceWithIncrease = 165.11;

		List<Product> products = productManager.getProducts();
		Product product = products.get(0);
		assertEquals("Price is incorrect", expectedChairPriceWithIncrease,  product.getPrice(),.001);

		product = products.get(1);
		assertEquals("Price is incorrect", expectedTablePriceWithIncrease, product.getPrice(),.001);
	}

}