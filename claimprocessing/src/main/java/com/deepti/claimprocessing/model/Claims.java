package com.deepti.claimprocessing.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import net.bytebuddy.implementation.bind.annotation.Default;

 @Entity
public class Claims {
   @Id
   @GeneratedValue
	private int claimId;
    private double laborCost;
    private String partId;
    private double amountClaimed;
    private int dealerId;
    
public Claims() {
	
}
	

	public Claims(int claimId, double laborCost, String partId, double amountClaimed, int dealerId) {
		super();
		this.claimId = claimId;
		this.laborCost = laborCost;
		this.partId = partId;
		this.amountClaimed = amountClaimed;
		this.dealerId = dealerId;
	}


	public int getClaimId() {
		return claimId;
	}
	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}
	public double getLaborCost() {
		return laborCost;
	}
	public void setLaborCost(double laborCost) {
		this.laborCost = laborCost;
	}
	public String getPartId() {
		return partId;
	}
	public void setPartId(String partId) {
		this.partId = partId;
	}
	public double getAmountClaimed() {
		return amountClaimed;
	}
	public void setAmountClaimed(double amountClaimed) {
		this.amountClaimed = amountClaimed;
	}
	public int getDealerId() {
		return dealerId;
	}
	public void setDealerId(int dealerId) {
		this.dealerId = dealerId;
	}
    
    
    
	
}
