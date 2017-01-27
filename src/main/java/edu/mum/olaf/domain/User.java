package edu.mum.olaf.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USERS")
 public class User implements Serializable{

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id = null;

    @Version
    private int version = 0;
    @NotEmpty(message="{User.firstName.empty}")
    @Size(min=3,max=25,message="{User.firstName.empty}")
    @Column(name = "FIRSTNAME", nullable = false)
    private String firstName;
    
    @NotEmpty(message="{User.lastName.empty}")
    @Size(min=3,max=25,message="{User.lastName.empty}")
    @Column(name = "LASTNAME", nullable = false)
    private String lastName;
    @Email(message="{User.email}")
    @Column(name = "EMAIL", nullable = false)
    private String email;

    @Column(name = "RANK", nullable = true)
    private int ranking = 0;
    
    @Column(name = "IS_ADMIN", nullable = false)
    private boolean admin = false;


	@Valid
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private List<Address> addresses = new ArrayList<Address>();
     
	@Valid
	@OneToOne(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name="USERCREDENTIAL")
	UserCredentials userCredentials;
    
	@JsonIgnore
	@Valid
	@OneToMany(mappedBy = "user", fetch=FetchType.LAZY, cascade=CascadeType.ALL)	
	private List<Comment> comments = new ArrayList<Comment>();
	
	@JsonIgnore
	@Valid
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private List<Bid> bids = new ArrayList<Bid>();
	
	@JsonIgnore
	@Transient
	ShoppingCart shoppingCart=new ShoppingCart();
	
	
	public Long getId() {
		return id;
	}
	
	public List<Bid> getBids() {
		return bids;
	}

	public void setBids(List<Bid> bids) {
		this.bids = bids;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public UserCredentials getUserCredentials() {
		return userCredentials;
	}

	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public boolean isAdmin() {
		return admin;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}