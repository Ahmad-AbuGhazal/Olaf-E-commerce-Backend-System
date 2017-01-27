package edu.mum.olaf.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.*;

 @Entity
@Table(name = "CATEGORY")
    public class Category implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "CATEGORY_ID")
    private Long id = null;

    @Version
    @Column(name = "OBJ_VERSION")
    private int version = 0;
    @NotEmpty(message="{Category.name.empty}")
    @Size(min=3,max=50,message="{Category.name.size}")
    @Column(name = "CATEGORY_NAME", length = 255, nullable = false)
    private String name;
    
    @ManyToMany(mappedBy="categories",fetch=FetchType.LAZY)
    @JsonIgnore
    private List<Item> items = new ArrayList<Item>();
    
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    private Date created = new Date();
    
    public void setId(Long id) {
		this.id = id;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}
    
  public Category() {}

   public Category(String name) {
        this.name = name;
    }

 public Long getId() { return id; }
    public int getVersion() { return version; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

 
    public List<Item> getItems() { return items; }
    public void addItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Null item!");
        items.add(item);
        item.getCategories().add(this);
    }
    public void removeItem(Item item) {
        if (item == null) throw new IllegalArgumentException("Null item!");
        items.remove(item);
        item.getCategories().remove(this);
    }

public Date getCreated() { return created; }

  public int compareTo(Object o) {
        if (o instanceof Category) {
            return this.getName().compareTo( ((Category)o).getName() );
        }
        return 0;
    }

    public String toString() {
        return  "(" + getId() + ") Name: '" + getName();
    }

}
