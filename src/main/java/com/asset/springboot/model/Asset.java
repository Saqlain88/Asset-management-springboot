package com.asset.springboot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
public class Asset {

	// Asset will have a name,
	// purchase date, condition notes, a category,
	// assignment status - Available, Assigned, Recovered.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	@Column(name = "purchase_date")
	private Date purchaseDate;

	@Column(name = "condition_note")
	private String conditionNote;

	@Column(name = "category_id")
	private long categoryId;
	
	private int assignmentStatus;
	
	private long assignedTo;
	
	public long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public int getAssignmentStatus() {
		return assignmentStatus;
	}

	public void setAssignmentStatus(int assignmentStatus) {
		this.assignmentStatus = assignmentStatus;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getConditionNote() {
		return conditionNote;
	}

	public void setConditionNote(String conditionNote) {
		this.conditionNote = conditionNote;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public Asset(String name, Date purchaseDate, String conditionNote, long categoryId, int assignmentStatus) {
		super();
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.conditionNote = conditionNote;
		this.categoryId = categoryId;
		this.assignmentStatus=assignmentStatus;
	}
	
	public Asset(String name, Date purchaseDate, String conditionNote, long categoryId, int assignmentStatus,long assignedTo) {
		super();
		this.name = name;
		this.purchaseDate = purchaseDate;
		this.conditionNote = conditionNote;
		this.categoryId = categoryId;
		this.assignmentStatus=assignmentStatus;
		this.assignedTo = assignedTo;
	}

	public Asset() {

	}

	@Override
	public String toString() {
		return "Asset [id=" + id + ", name=" + name + ", purchaseDate=" + purchaseDate + ", conditionNote="
				+ conditionNote + ", categoryId=" + categoryId+", assignmentStatus="+ assignmentStatus + "]";
	}

}
