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
	private String tracker;
	
	
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
	public String getTracker() {
		return tracker;
	}
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
	
	
	
}
