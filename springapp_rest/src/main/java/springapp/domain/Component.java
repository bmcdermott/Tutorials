package springapp.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;

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
    private Product product;
    
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
	
	@ManyToOne
	@JoinColumn(name = "PRODUCT_ID")
	public Product getProduct(){
		return this.product;
	}
	
	public void setProduct(Product product){
		this.product = product;
	}
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Long Description: " + long_description + ";");
        //buffer.append("Product_id: " + product_id);
        buffer.append("Product ID from Product:" + getProduct().getId());
        return buffer.toString();
    }



}