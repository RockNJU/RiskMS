package edu.rms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="riskitem")
public class RiskItem {
	
	@Id
	private int riskItem_id;
	private String content;
	private int probability;
	private int effects;
	private String threshold;

	private int submitter;
	private String sub_name;
	private String tracker_id;
	private String tracker_name;
	
	public int getRiskItem_id() {
		return riskItem_id;
	}
	public void setRiskItem_id(int riskItem_id) {
		this.riskItem_id = riskItem_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getProbability() {
		return probability;
	}
	
	
	public void setProbability(int probability) {
		this.probability = probability;
	}
	public int getEffects() {
		return effects;
	}
	public void setEffects(int effects) {
		this.effects = effects;
	}

	public String getThreshold() {
		return threshold;
	}
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	public int getSubmitter() {
		return submitter;
	}
	public void setSubmitter(int submitter) {
		this.submitter = submitter;
	}
	public String getSub_name() {
		return sub_name;
	}
	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}
	public String getTracker_id() {
		return tracker_id;
	}
	public void setTracker_id(String tracker_id) {
		this.tracker_id = tracker_id;
	}
	public String getTracker_name() {
		return tracker_name;
	}
	public void setTracker_name(String tracker_name) {
		this.tracker_name = tracker_name;
	}
	
	
	
	
}
