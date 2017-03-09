package springapp.domain;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/test-context.xml")

public class ComponentTest {
	
//	@PersistenceContext
//	private EntityManager entityManager;

	private Component comp;
	
	@Before
	public void setUp() throws Exception {
		comp = new Component();		
	}

	@Test
	public void testSetAndGetLongDescription() {
		String testLongDescription = "longDescription";
		assertNull(comp.getLong_description());
		comp.setLong_description(testLongDescription);
		assertEquals(testLongDescription, comp.getLong_description());
	}

	@Test
	public void testSetAndGetDescription() {
		String testDescription = "aDescription";
		assertNull(comp.getDescription());
		comp.setDescription(testDescription);
		assertEquals(testDescription, comp.getDescription());
	}
}
