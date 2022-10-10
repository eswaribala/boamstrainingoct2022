package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name="Individual")
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = false)
public class Individual extends Customer {

	@Column(name="Gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
}
