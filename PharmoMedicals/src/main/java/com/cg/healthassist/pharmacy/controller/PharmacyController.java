package com.cg.healthassist.pharmacy.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.healthassist.pharmacy.dto.Pharmacy;
import com.cg.healthassist.pharmacy.exception.MedicineNotFoundException;
import com.cg.healthassist.pharmacy.service.PharmacyServicesImpl;


/** The PharmacyController layer provides connections to url's for CURD Methods
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@RestController
@Validated
@RequestMapping("/api/v2") 
public class PharmacyController {
	
	@Autowired 
	private PharmacyServicesImpl pharmacyServicesImpl;
	

	/** GET method for viewing all Medicines
	*
	* @return list of all Medicines
	*/
	@GetMapping("/viewAll")
	public List<Pharmacy> viewAllMedicines() {
		return pharmacyServicesImpl.viewAllMedicines();
	}
	
	/** POST method to add Medicines
	*
	* @param Medicines
	* @return Medicines object
	*/
	@PostMapping("/save") 
	public Pharmacy saveMadicine( @Valid @RequestBody Pharmacy pharmacy) {
		return pharmacyServicesImpl.saveMedicine(pharmacy);
	} 
	
	/** GET method to view Medicine by Id
	*
	* @param MedicineId
	* @return Medicine object
	 * @throws MedicineNotFoundException 
	*/
	@GetMapping("/view/{id}")
	public ResponseEntity<Pharmacy> viewMedicineById(@PathVariable(value = "id") @Min(1) Integer medicineId) throws MedicineNotFoundException {
		Pharmacy pharm = pharmacyServicesImpl.viewMedicine(medicineId);
		return  ResponseEntity.ok(pharm);
	}
	
	/** PUT method to update appointment
    *
    * @param MedicineId
    * @param Medicine
    * @return Medicine object
    * @throws MedicineNotFoundException 
    */
	@PutMapping("/edit/{id}")
	public ResponseEntity<Pharmacy> updateMedicineById(@PathVariable(value = "id") @Min(1) Integer medicineId,
			@Valid @RequestBody Pharmacy pharmacy) throws MedicineNotFoundException {
		Pharmacy pharm = pharmacyServicesImpl.updateMedicine(medicineId,pharmacy);
		return  ResponseEntity.ok(pharm);
	}

	/** DELETE method to remove Medicine
	*
	* @param MedicineId
	 * @throws MedicineNotFoundException 
	*/
	@DeleteMapping("/delete/{id}")	
	public ResponseEntity<Boolean> deleteMedicine(@PathVariable(value = "id") @Min(1) Integer medicineId,
			@Valid @RequestBody Pharmacy pharmacy) throws MedicineNotFoundException	{
		Boolean pharm = pharmacyServicesImpl.deleteMedicine(medicineId);
		return  ResponseEntity.ok(pharm);
	}
}
