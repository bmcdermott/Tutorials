package springapp.domain;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/test-context.xml")
//@ContextConfiguration("file:src/test/resources/test-context.xml")

public class ProductComponentInteractionTest {
	
	private Product p;
	private Component c1;
	private Component c2;
	private String pDescription = "New Product";
	private String pLongDescription = "New Product....";
	private Double pPrice = 100.00;
	private String c1Description = "New Component 1";
	private String c2Description = "New Component 2";
	private String c1LongDescription = "New Component 1....";
	private String c2LongDescription = "New Component 2....";
	private Set<Component> components;
	
//	@PersistenceContext
//	private EntityManager entityManager;

	@Before
	public void setUp() throws Exception {
		p = new Product();
		c1 = new Component();
		c2 = new Component();
		components = new HashSet<Component>();
		
		p.setDescription(pDescription);
		p.setLong_description(pLongDescription);
		p.setPrice(pPrice);
		c1.setDescription(c1Description);
		c1.setLong_description(c1LongDescription);
		c2.setDescription(c2Description);
		c2.setLong_description(c2LongDescription);
		components.add(c1);
		components.add(c2);
	}

	@Test
	public void addThenReadComponentsAsASet() {
		p.setComponents(components);
		Set<Component> compset = p.getComponents();
		assertEquals(compset.contains(c1),true);
		assertEquals(compset.contains(c2),true);
		assertEquals(compset.size(),2);
		assertEquals(compset.containsAll(components),true);
	}

	@Test
	public void addThenReadComponentsIndividually() {
		p.addComponent(c1);
		p.addComponent(c2);
		Set<Component> compset = p.getComponents();
		assertEquals(compset.contains(c1),true);
		assertEquals(compset.contains(c2),true);
		assertEquals(compset.size(),2);
		assertEquals(compset.containsAll(components),true);
	}
}
