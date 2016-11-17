package edu.rms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="raItems")
public class RaItems {
	
	@Id
	private int ra_id;
	private int riskItem_id;
	public int getRa_id() {
		return ra_id;
	}
	public void setRa_id(int ra_id) {
		this.ra_id = ra_id;
	}
	public int getRiskItem_id() {
		return riskItem_id;
	}
	public void setRiskItem_id(int riskItem_id) {
		this.riskItem_id = riskItem_id;
	}
	
	
}
