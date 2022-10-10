package com.boa.customerapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;
@SuperBuilder
@Entity
@Table(name="Corporate")
@Data
@EqualsAndHashCode(callSuper = false)
public class Corporate extends Customer{
    @Enumerated(EnumType.STRING)
    @Column(name="Company_Type",nullable = false)
	private CompanyType companyType;

}
