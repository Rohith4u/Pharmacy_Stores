package com.cg.healthassist.pharmacy.service;

import java.util.List;

import com.cg.healthassist.pharmacy.dto.Pharmacy;
import com.cg.healthassist.pharmacy.exception.MedicineNotFoundException;

public interface PharmacyServices {
	
	/** This method returns list of all medicines 
	 * 
	 * @return list of all Medicine
	 * 
	 * */
	 public List<Pharmacy> viewAllMedicines();
	 
	 /** This method returns Medicines by searching with specific Medicine Id
		 * 
		 * @param MedicineId - Integer value to view medicine based on Id
		 * @return Medicine details if found or else throws exception
		 * 
		 * */
	 public Pharmacy viewMedicine(Integer medicineId) throws MedicineNotFoundException;
	 
	 /** This method takes Medicine Id and deletes the Medicine
		 * 
		 * @param MedicineId - Integer value to remove Medicine based on Id
		 * 
		 * */
	 public boolean deleteMedicine(Integer medicineId) throws MedicineNotFoundException;
	 
	 /** This method updates the Medicine details by searching with id
		 * 
		 * @param MedicineId - Integer value to update Medicine based on Id
		 * 
		 * */
	 public Pharmacy updateMedicine(Integer medicineId,Pharmacy pharmacy) throws MedicineNotFoundException;
	 
	 /** This method takes Medicine details and add new medicines
		 * 
		 * @param Medicial Store - appointment entity details
		 * 
		 * */
	 public Pharmacy saveMedicine(Pharmacy pharmacy);
}
