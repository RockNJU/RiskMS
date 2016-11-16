package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="riskStateTrack")
public class RiskStateTrack {
	
	@Id
	private int riskStateTrack_id;
	private int riskItemId;
	private int state;
	private String content;
	private Date createTime;
	private int previousStateId;
	
	
	
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
	
	public int getRiskStateTrack_id() {
		return riskStateTrack_id;
	}
	public void setRiskStateTrack_id(int riskStateTrack_id) {
		this.riskStateTrack_id = riskStateTrack_id;
	}
	public int getRiskItemId() {
		return riskItemId;
	}
	public void setRiskItemId(int riskItemId) {
		this.riskItemId = riskItemId;
	}
	public int getPreviousStateId() {
		return previousStateId;
	}
	public void setPreviousStateId(int previousStateId) {
		this.previousStateId = previousStateId;
	}
	
	
	
}
