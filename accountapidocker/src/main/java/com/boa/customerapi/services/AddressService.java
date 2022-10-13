package com.boa.customerapi.services;

import java.util.List;

import com.boa.customerapi.models.Address;


public interface AddressService {
	Address addAddress(Address Address);
	Address updateAddress(Address address);
	List<Address> viewAllAddresses();
	List<Address> viewAddressById(long customerId);
	boolean deleteAddressById(long customerId);
}
