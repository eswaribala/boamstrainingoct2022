package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Customer_Id")
	private long customerId;
	@Embedded
	private FullName name;
	@Column(name="Email",nullable = false,length = 150)
	private String email;
	@Column(name="Password",nullable = false,length = 10)
	private String password;
	@Column(name="Contact_Number")
	private long contactNumber;
}
