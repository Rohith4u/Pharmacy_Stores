package com.cg.healthassist.pharmacy.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.pharmacy.dao.PharmacyRepository;
import com.cg.healthassist.pharmacy.dto.Pharmacy;
import com.cg.healthassist.pharmacy.exception.MedicineNotFoundException;

/** The PharmacyServicesImplTest class provides testing for PharmacyServicesImpl
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PharmacyServicesImplTest {
	
@MockBean
    private PharmacyRepository pharmacyrepository;

@Autowired
    private PharmacyServices pharmacyservice;

	/** This method returns list of all Medicines 
	 * 
	 * @return list of all Medicines
	 * 
	 * */
	@Test
	void testViewAllMedicines() {
		
		Pharmacy medicalstore = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		Pharmacy medicalstore1 = new Pharmacy(2,"vicks", 200, 100, "29-09-2020");
		Pharmacy medicalstore2 = new Pharmacy(3,"Paracetmol", 100, 300, "29-09-2020");

	    List<Pharmacy> medicalstores = new ArrayList<>();
	    medicalstores.add(medicalstore);
	    medicalstores.add(medicalstore1);
	    medicalstores.add(medicalstore2);

		System.out.println(pharmacyrepository.findById(100));
	    Assert.assertTrue(pharmacyrepository.findById(100).isEmpty());
		}

	/** This method takes MedicineId and deletes the Medicine
	 * 
	 * @param MedicineId - Integer value to remove Medicine based on Id
	 * @throws MedicineNotFoundException 
	 * 
	 * */
	@Test
	void testDeleteMedicine() throws MedicineNotFoundException {
		
		  Pharmacy medicalstore = new Pharmacy(100,"Dola", 100, 100, "29-09-2020");
		  medicalstore.setMedicineId(10);
		  
		  pharmacyrepository.deleteById(medicalstore.getMedicineId());
	        System.out.println(pharmacyrepository.findById(100));
	        Assert.assertTrue(pharmacyrepository.findById(100).isEmpty());
	}

	/** This method updates the Medical details by searching with id
	 * 
	 * @param medicineId - Integer value to update medicine based on Id
	 * @throws MedicineNotFoundException 
	 * 
	 * */
	@Test
	void testUpdateMedicine() throws MedicineNotFoundException {
		
		  Pharmacy medicalstore = new Pharmacy(30,"Dola", 100, 100, "29-09-2020");
		  medicalstore.setMedicineId(20);
		  
		  Pharmacy updatedmedicalstore = medicalstore;
		  updatedmedicalstore.setMedicineId(30);
		  updatedmedicalstore.setMedicineCost(200);
		  updatedmedicalstore.setMedicineName("dolo");
		  updatedmedicalstore.setMedicineDose(100);
		  updatedmedicalstore.setExpireDate("21/2/2009");
		  
		  pharmacyrepository.save(updatedmedicalstore);
	      System.out.println(pharmacyrepository.findById(30));
	      Assert.assertTrue(pharmacyrepository.findById(30).isEmpty());
		  
		  assertThat(medicalstore.getMedicineName()).isEqualTo(updatedmedicalstore.
		  getMedicineName());
		  verify(pharmacyrepository).save(updatedmedicalstore);
		 }
	
	/** This method takes Medicine details and adds Medicines to Pharmacy
	 * 
	 * @param medicalstore - medicalstore entity details
	 * 
	 * */
	@Test
	void testSaveMedicine() {
		
		Pharmacy medicalstore = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		Mockito.when(pharmacyrepository.save(medicalstore)).thenReturn(medicalstore);
        assertThat(pharmacyservice.saveMedicine(medicalstore)).isEqualTo(medicalstore);
		}
	
	/** This method returns Medicines by searching with specific MedicineId
	 * 
	 * @param MedicineId - long value to view Medicine based on Id
	 * @return Medicine details if found or else throws exception
	 * @throws MedicineNotFoundException 
	 * 
	 * */
	@Test
	void testViewMedicine() throws Exception {
		  
	  Pharmacy medicalstore = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
	  pharmacyrepository.save(medicalstore);
      System.out.println(pharmacyrepository.findById(100));
      Assert.assertTrue(pharmacyrepository.findById(100).isEmpty());
      
	}

}
