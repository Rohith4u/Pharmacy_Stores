package com.cg.healthassist.pharmacy.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="Pharma")
public class Pharmacy  {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="medicine_id")
    private int medicineId;

    @Column(name = "medicine_name" ,nullable = false)
    @NotBlank
    @Size(min = 3, message = "Please provide a valid MedicineName with min 3 chars")
    private String medicineName;
	
    @Column(name = "medicine_dose" ,nullable = false)
	@DecimalMin(value = "2", message = "Dosage must be positive ➕")
    @Digits(message="Enter Valiid Dosage", fraction = 0, integer = 6)
    private int medicineDose;
	
    @Column(name = "medicine_cost" ,nullable = false)
	@DecimalMin(value = "2", message = "Cost must be positive ➕")
    @Digits(message="Enter Valiid cost", fraction = 0, integer = 6)
    private int medicineCost;
	
    @Column(name = "expire_date",nullable = false)
	@NotBlank
	@Size(min = 4, message = "Please provide a valid expiredate")
    private String expireDate;
	
	
	

public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public int getMedicineDose() {
		return medicineDose;
	}
	public void setMedicineDose(int medicineDose) {
		this.medicineDose = medicineDose;
	}
	public int getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(int medicineCost) {
		this.medicineCost = medicineCost;
	}
	public String getExpireDate() {
		return expireDate;
	}
	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}
	
public Pharmacy(int medicineId,String medicineName, int medicineDose, int medicineCost, String expireDate) {
		super();
		this.medicineId= medicineId;
		this.medicineName = medicineName;
		this.medicineDose = medicineDose;
		this.medicineCost = medicineCost;
		this.expireDate = expireDate;
	}
public Pharmacy() {
	super();
}

}
