package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="specificRisk")
public class SpecificRisk {
		
	@Id
	private Long specificRisk_id;
	private Long riskItemId;
	private String location;
	private Date createTime;
	public Long getSpecificRisk_id() {
		return specificRisk_id;
	}
	public void setSpecificRisk_id(Long specificRisk_id) {
		this.specificRisk_id = specificRisk_id;
	}
	public Long getRiskItemId() {
		return riskItemId;
	}
	public void setRiskItemId(Long riskItemId) {
		this.riskItemId = riskItemId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
