package com.cg.healthassist.pharmacy.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.healthassist.pharmacy.dao.PharmacyRepository;
import com.cg.healthassist.pharmacy.dto.Pharmacy;
import com.cg.healthassist.pharmacy.exception.MedicineNotFoundException;

/** The MedicalStoreServiceImpTest class provides methods for MedicalStoreService
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@Transactional
@Service
public class PharmacyServicesImpl implements PharmacyServices {

	@Autowired 
	private PharmacyRepository pharmrepository;

	/** This method returns list of all Medicines 
	 * 
	 * @return list of all Medicines
	 * 
	 * */
	    @Override
		public List<Pharmacy> viewAllMedicines() {
			return pharmrepository.findAll();
		}
		
	    /** This method returns Medicines by searching with specific MedicineId
		 * 
		 * @param MedicineId - integer value to view Medicine based on Id
		 * @return Medicine details if found or else throws exception
		 * 
		 * */
		@Override
		public Pharmacy viewMedicine(Integer medicineId) throws MedicineNotFoundException {
			Pharmacy pharmacy = pharmrepository.findById(medicineId).
					orElseThrow(() -> new MedicineNotFoundException("Medicine not found for this id :: " + medicineId));
			return pharmacy;
		}
		
		/** This method takes MedicineId and deletes the Medicine
		 * 
		 * @param MedicineId - Integer value to remove Medicine based on Id
		 * 
		 * */
		@Override
		public boolean deleteMedicine(Integer medicineId) throws MedicineNotFoundException {
			Pharmacy pharmacy = pharmrepository.findById(medicineId)
					.orElseThrow(() -> new MedicineNotFoundException("Medicine not found for this id :: " + medicineId));

			pharmrepository.delete(pharmacy);
		 if(null == pharmacy){
	            return true;
	        }
	        return false;
		}
		
		/** This method updates the Medical details by searching with id
		 * 
		 * @param medicineId - Integer value to update medicine based on Id
		 * 
		 * */
		@Override
		public Pharmacy updateMedicine(Integer medicineId, Pharmacy pharmacy) throws MedicineNotFoundException {
			Pharmacy pharmo = pharmrepository.findById(medicineId)
					.orElseThrow(() -> new MedicineNotFoundException("Medicine not found for this id :: " + medicineId));
			pharmo.setMedicineName(pharmacy.getMedicineName());
			pharmo.setMedicineCost(pharmacy.getMedicineCost());
			pharmo.setMedicineDose(pharmacy.getMedicineDose());
			pharmo.setExpireDate(pharmacy.getExpireDate());
			final Pharmacy updatemedicine = pharmrepository.save(pharmo);
			return updatemedicine; 
		}
		
		/** This method takes Medicine details and adds Medicines to Pharmacy
		 * 
		 * @param Pharmacy - Pharmacy entity details
		 * 
		 * */
		@Override
		public Pharmacy saveMedicine(Pharmacy pharmacy) {
			return  pharmrepository.save(pharmacy);
		}
}
