package springapp.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import springapp.domain.Product;
import springapp.repository.JPAProductDao;

@Transactional
public class SimpleProductManager implements ProductManager {


	private static final long serialVersionUID = 1L;
	// private List<Product> products;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
    private JPAProductDao jpaProductDao;

    public List<Product> getProducts() {
        // return products;
        return jpaProductDao.findAll();
    }
    
    public Product getProductByID(int id) {
    	return (Product) jpaProductDao.findOne(id);
    }
    
    public Product addProduct(Product prod) {
    	// add a new product to the product list
    	return jpaProductDao.saveAndFlush(prod);
    
    }
    
    public Product updateProduct(Product prod) {
    	Product existingProd = jpaProductDao.findOne(prod.getId());
    	existingProd.setDescription(prod.getDescription());
    	existingProd.setLong_description(prod.getLong_description());
    	existingProd.setPrice(prod.getPrice());
    	return jpaProductDao.saveAndFlush(existingProd);
    }
    
    public void deleteProduct(Product prod) {
    	jpaProductDao.delete(prod);
    }

    public void increasePrice(int percentage) {
        List<Product> products = jpaProductDao.findAll();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                jpaProductDao.saveAndFlush(product);
            }
        }
    }

//    public void setProductDao(ProductDao productDao) {
//        this.productDao = productDao;
//    }

//    public void setProducts(List<Product> products) {
//        this.products = products;
//    }

}