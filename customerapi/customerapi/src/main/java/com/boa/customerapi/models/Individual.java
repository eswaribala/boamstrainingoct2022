package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Individual")
@SuperBuilder
public class Individual extends Customer {

	@Column(name="Gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
