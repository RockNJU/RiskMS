package edu.rms.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="raList")
public class RaList {
	
	@Id
	private int ra_id;
	private String ra_name;
	private Timestamp createTime;
	public int getRa_id() {
		return ra_id;
	}
	public void setRa_id(int ra_id) {
		this.ra_id = ra_id;
	}
	public String getRa_name() {
		return ra_name;
	}
	public void setRa_name(String ra_name) {
		this.ra_name = ra_name;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	
}
