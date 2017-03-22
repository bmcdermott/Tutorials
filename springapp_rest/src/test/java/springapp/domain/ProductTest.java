package springapp.domain;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.TestCase;

public class ProductTest extends TestCase {

	private Product product;
	
//	@PersistenceContext
//	private EntityManager entityManager;

	protected void setUp() throws Exception {
		product = new Product();
	}

	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(product.getDescription());
		product.setDescription(testDescription);
		assertEquals(testDescription, product.getDescription());
	}

	public void testSetAndGetLongDescription() {
		String testLongDescription = "aDescription";
		assertNull(product.getLong_description());
		product.setLong_description(testLongDescription);
		assertEquals(testLongDescription, product.getLong_description());
	}

	public void testSetAndGetPrice() {
		double testPrice = 100.00;
		assertEquals(0, 0, 0);
		product.setPrice(testPrice);
		assertEquals(testPrice, product.getPrice(), 0);
	}

}