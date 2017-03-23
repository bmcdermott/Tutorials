package springapp.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="product")
@Table(name="products")
//@NamedQueries({
//	@NamedQuery(name="Product.findByDesc",query=
//			"select distinct p from Product p where p.description = :desc")
//})

public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2190132372041233334L;
	private int id;
    private String description;
    private String long_description;
    private Double price = 0.00;
    private Set<Component> components = new HashSet<Component>();
    
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
    
    @Column(name = "PRICE")
    public Double getPrice() {
        return price;
    }
    
    public void setPrice(Double price) {
        this.price = price;
    }
    
    @Column(name = "LONG_DESCRIPTION")
	public String getLong_description() {
		return long_description;
	}
    
	public void setLong_description(String long_description) {
		this.long_description = long_description;
	}
	
	//@OneToMany(mappedBy = "product", cascade=CascadeType.ALL,orphanRemoval=true, fetch=FetchType.EAGER)
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "products_components", catalog = "public", joinColumns = {
			@JoinColumn(name = "product_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "component_id",
					nullable = false, updatable = false) })
	public Set<Component> getComponents() {
		return this.components;
	}
	
	public void setComponents(Set<Component> components){
		this.components = components;
	}
	
	public void addComponent(Component component){
		component.addProduct(this);
		getComponents().add(component);
	}
	
	public void removeComponent(Component component){
		getComponents().remove(component);
	}
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Description: " + description + ";");
        buffer.append("Long Description: " + long_description + ";");
        buffer.append("Price: " + price);
        return buffer.toString();
    }



}