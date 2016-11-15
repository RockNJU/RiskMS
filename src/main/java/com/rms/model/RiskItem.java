package com.rms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="riskItem")
public class RiskItem {
	
	@Id
	private Long riskItem_id;
	private String content;
	private int probability;
	private int effects;
	private String triggers;
	private int submitter;
	private String tracker;
	
	public Long getRiskItem_id() {
		return riskItem_id;
	}
	public void setRiskItem_id(Long riskItem_id) {
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
	public String getTriggers() {
		return triggers;
	}
	public void setTriggers(String triggers) {
		this.triggers = triggers;
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
