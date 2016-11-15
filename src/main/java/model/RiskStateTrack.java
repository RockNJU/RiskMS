package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="riskStateTrack")
public class RiskStateTrack {
	
	@Id
	private Long riskStateTrack_id;
	private Long specificRiskId;
	private int state;
	private String content;
	private Date createTime;
	public Long getRiskStateTrack_id() {
		return riskStateTrack_id;
	}
	public void setRiskStateTrack_id(Long riskStateTrack_id) {
		this.riskStateTrack_id = riskStateTrack_id;
	}
	public Long getSpecificRiskId() {
		return specificRiskId;
	}
	public void setSpecificRiskId(Long specificRiskId) {
		this.specificRiskId = specificRiskId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
}
