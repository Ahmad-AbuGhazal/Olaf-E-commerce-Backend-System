package edu.mum.olaf.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	long id;
    
    @Min(0)
    @Max(5)
    @Column(name="REVIEW")
    int review;
    
    @NotEmpty
    @NotNull
    @Column(name="DESCRIBTION")
    String describtion;
    
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED", nullable = false, updatable = false)
    private Date created = new Date();
    
    @NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    @JsonIgnore
    private User user;
    
    public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@NotNull
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ITEM_ID")
    @JsonIgnore
    private Item item;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getReview() {
		return review;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public String getDescribtion() {
		return describtion;
	}

	public void setDescribtion(String describtion) {
		this.describtion = describtion;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}
    
}
