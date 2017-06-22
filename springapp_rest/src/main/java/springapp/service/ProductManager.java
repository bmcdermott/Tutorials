package springapp.service;

import java.io.Serializable;
import java.util.List;

import springapp.domain.Component;
import springapp.domain.Product;

public interface ProductManager extends Serializable{

    public void increasePrice(int percentage);
    
    public List<Product> getProducts();
    
    public Product addProduct(Product prod);
    
    public Product updateProduct(Product prod);
    
    public void deleteProduct(Product prod);
    
    public void deleteComponent(Component comp);
    
    public Product getProductByID(int id);
    
    public Component getComponentByID(int id);
    
//    public void setProductDao(ProductDao productDao);
    
}
