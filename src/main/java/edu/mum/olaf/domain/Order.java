package edu.mum.olaf.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

public class Order {
	  @Id
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "id", updatable = false, nullable = false)
	   private Long id = null;
	   @Version
	   @Column(name = "version")
	   private int version = 0;

	   @Column
	   private String orderNumber;

//	   @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	   private Set<OrderItem> items = new HashSet<OrderItem>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	
}
