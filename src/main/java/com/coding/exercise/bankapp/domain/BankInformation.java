package com.coding.exercise.bankapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BankInformation {

	private String branchName;
	
	private Integer branchCode;
	
	private AddressDetails branchAddress;
	
	private Integer routingNumber;
}
