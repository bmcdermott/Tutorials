package springapp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="component")
@Table(name="components")
//@NamedQueries({
//	@NamedQuery(name="Component.findByDesc",query=
//			"select distinct c from Component c where c.description = :desc")
//})

public class Component implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5508997879604851558L;
	private int id;
    private String description;
    private String long_description;
//    private int product_id;
    private Set<Product> products = new HashSet<Product>();;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }


    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    
    public void setDescription(String description) {
        this.description = description;
    }
    
//    @Column(name = "PRODUCT_ID")
//    public int getProduct_id() {
//        return product_id;
//    }
//    
//    public void setProduct_id(int product_id) {
//        this.product_id = product_id;
//    }
    
    @Column(name = "LONG_DESCRIPTION")
	public String getLong_description() {
		return long_description;
	}
    
	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}
	
//	@ManyToOne
//	@JoinColumn(name = "PRODUCT_ID")
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "components")
	public Set<Product> getProducts(){
		return this.products;
	}
	
	public void addProduct(Product product){
		getProducts().add(product);
	}
	
	public void setProducts(Set<Product> products){
		this.products = products;
	}
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Long Description: " + long_description + ";");
        //buffer.append("Product_id: " + product_id);
        //buffer.append("Product ID from Product:" + getProducts().getId());
        return buffer.toString();
    }



}