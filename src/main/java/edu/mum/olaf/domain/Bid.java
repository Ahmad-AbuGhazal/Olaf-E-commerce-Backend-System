package edu.mum.olaf.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BID")
public class Bid {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
     long id;
Date bidDate;

}
