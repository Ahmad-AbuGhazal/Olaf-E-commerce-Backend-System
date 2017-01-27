package edu.mum.olaf.domain;

 

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
@SuppressWarnings("serial")
@Entity
@Table(name = "ITEM")
 public class Item implements Serializable {

    @Id @GeneratedValue
    @Column(name = "ITEM_ID")
    private Long id = null;

    @Version
    @Column(name = "OBJ_VERSION")
    private int version = 0;
    @NotEmpty(message="Item.name.empty")
    @Size(min=4,max=50,message="{Item.name.size}")
    @Column(name = "ITEM_NAME", length = 255, nullable = false, updatable = false)
    private String name;
 
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="SELLER_ID")
     private User seller;
    
    @Transient
    private User buyer;

    @Column(name = "DESCRIPTION", length = 4000, nullable = false)
    private String description;
    @Column(name="INITIAL_PRICE")
     private BigDecimal initialPrice;
    @Column(name="RESERVE_PRICE") 
     private BigDecimal reservePrice;
     
    
    @ManyToMany(fetch=FetchType.LAZY) 
    
     @JoinTable ( name="ITEM_CATEGORY", joinColumns={@JoinColumn(name="ITEM_ID")},  
    		    inverseJoinColumns={ @JoinColumn(name="CATEGORY_ID")} )  
     @JsonIgnore
     private Set<Category> categories = new HashSet<Category>();
    
    
    
    
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
    	// TODO Auto-generated method stub
    	return super.clone();
    }
    
    @OneToMany(mappedBy = "item", fetch=FetchType.LAZY,cascade=CascadeType.ALL)	
    @JsonIgnore
	private List<Comment> comments = new ArrayList<Comment>();
    
    
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ITEM_ID")
	@JsonIgnore
	private List<Bid> bids = new ArrayList<Bid>();
	
	@Transient
	private User approvedBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "APPROVAL_DATETIME", nullable = true)
    private Date approvalDatetime;
    @Transient
    private Collection<String> images = new ArrayList<String>();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = true, updatable = false)
    private Date created = new Date();
    
    
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE", nullable = true, updatable = false)
    private Date startDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_DATE", nullable = true, updatable = false)
    @org.hibernate.annotations.Index(name = "IDX_END_DATE")
    private Date endDate;
    
    public Item() {}

    public List<Comment> getComments() {
  		return comments;
  	}



  	public void setComments(List<Comment> comments) {
  		this.comments = comments;
  	}



  	public List<Bid> getBids() {
  		return bids;
  	}



  	public void setBids(List<Bid> bids) {
  		this.bids = bids;
  	}
    
  	public void setId(Long id) {
		this.id = id;
	}

	public void setVersion(int version) {
		this.version = version;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setSeller(User seller) {
		this.seller = seller;
	}



	public void setInitialPrice(BigDecimal initialPrice) {
		this.initialPrice = initialPrice;
	}



	public void setReservePrice(BigDecimal reservePrice) {
		this.reservePrice = reservePrice;
	}



	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}



	


	public void setCreated(Date created) {
		this.created = created;
	}



	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}



	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}




    public Long getId() { return id; }
    public int getVersion() { return version; }

    public String getName() { return name; }

    public User getSeller() { return seller; }

    public User getBuyer() { return buyer; }
    public void setBuyer(User buyer) { this.buyer = buyer; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getInitialPrice() { return initialPrice; }

    public BigDecimal getReservePrice() { return reservePrice; }

    public Date getStartDate() { return startDate; }

    public Date getEndDate() { return endDate; }

 
    public User getApprovedBy() { return approvedBy; }
    public void setApprovedBy(User approvedBy) { this.approvedBy = approvedBy; }

    public Date getApprovalDatetime() { return approvalDatetime; }
    public void setApprovalDatetime(Date approvalDatetime) { this.approvalDatetime = approvalDatetime; }

 
     public Set<Category> getCategories() { return categories; }

 
   
    public Date getCreated() { return created; }

  
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;

        final Item item = (Item) o;

        if (! (created.getTime() == item.created.getTime()) ) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (name != null ? name.hashCode() : 0);
        result = 29 * result + created.hashCode();
        return result;
    }

    public String toString() {
        return  "Item ('" + getId() + "'), " +
                "Name: '" + getName() + "' " +
                "Initial Price: '" + getInitialPrice()+ "'";
    }

    public int compareTo(Object o) {
        if (o instanceof Item) {
             return Long.valueOf(this.getCreated().getTime()).compareTo(
                    Long.valueOf( ((Item)o).getCreated().getTime())
                   );
        }
        return 0;
    }

   
  
}
