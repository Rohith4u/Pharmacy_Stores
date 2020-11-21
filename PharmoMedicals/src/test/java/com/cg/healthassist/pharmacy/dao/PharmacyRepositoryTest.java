package com.cg.healthassist.pharmacy.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.healthassist.pharmacy.dto.Pharmacy;

/** The MedicalStoreDaoTest class provides testing for MedicalStoreDao
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class PharmacyRepositoryTest {
	
	@Autowired
    private PharmacyRepository pharmrepository;

    @Autowired
    private TestEntityManager testEntityManager;
    
    /** Adding new Medicines into the pharmacy
     * 
     * @param AddNewMedicine
     * 
     */
    @Test
    public void testNewMedicine() throws Exception{
    	Pharmacy pharm = getMedicine();
    	Pharmacy saveInDb = testEntityManager.persist(pharm);
    	Pharmacy getFromInDb = pharmrepository.findById(saveInDb.getMedicineId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
	private Pharmacy getMedicine() {
		Pharmacy pharm=new Pharmacy();
		pharm.setMedicineName("Paracetmol");
		pharm.setMedicineDose(100);
		pharm.setMedicineCost(200);
	    pharm.setExpireDate("22/09/2020");
		return pharm;
	}
	
	/** Searching medicine by its Id from pharmacy
     * 
     * @param GetMedicineById
     * 
     */
	@Test
    public void testGetMedicineById() throws Exception{
		Pharmacy pharm=new Pharmacy();
		pharm.setMedicineName("Paracetmol");
		pharm.setMedicineDose(100);
		pharm.setMedicineCost(200);
	    pharm.setExpireDate("22/09/2020");
       Pharmacy saveInDb = testEntityManager.persist(pharm);
       Pharmacy getInDb = pharmrepository.findById(pharm.getMedicineId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	
	/** This method returns list of all Medicines
	 * 
	 * @return list of all Medicines
	 * 
	 * */
	 @Test
	    public void testGetAllMedicines() throws Exception{
		 Pharmacy pharm=new Pharmacy();
			pharm.setMedicineName("Paracetmol");
			pharm.setMedicineDose(100);
			pharm.setMedicineCost(200);
		    pharm.setExpireDate("22/09/2020");
	        
		    Pharmacy pharm1=new Pharmacy();
			pharm1.setMedicineName("Dolo");
			pharm1.setMedicineDose(100);
			pharm1.setMedicineCost(200);
		    pharm1.setExpireDate("22/09/2020");
		    
	        testEntityManager.persist(pharm); 
	        testEntityManager.persist(pharm1);
	        List<Pharmacy> PharmList = (List<Pharmacy>) pharmrepository.findAll();

	        Assert.assertEquals(2, PharmList.size());
	    }
	 
	 /** Deleting medicine by its Id from pharmacy
	     * 
	     * @param GetDeleteMedicineById
	     * 
	     */
		
	 @Test
	    public void testDeleteMedicine() throws Exception{
		 Pharmacy pharm=new Pharmacy();
			pharm.setMedicineName("Paracetmol");
			pharm.setMedicineDose(100);
			pharm.setMedicineCost(200);
		    pharm.setExpireDate("22/09/2020");
	        
		    Pharmacy pharm1=new Pharmacy();
			pharm1.setMedicineName("Dolo");
			pharm1.setMedicineDose(100);
			pharm1.setMedicineCost(200);
		    pharm1.setExpireDate("22/09/2020");
	        

			Pharmacy pharm2 = testEntityManager.persist(pharm);
	        testEntityManager.persist(pharm1);
	        testEntityManager.remove(pharm2);

	        List<Pharmacy> pharmo = (List<Pharmacy>) pharmrepository.findAll();
	        Assert.assertEquals(pharmo.size(), 1);
	        
	    }
	 
	 /** Updating medicines from pharmacy
		 * 
		 * @param UpdateMedicine
		 * 
		 */
	 @Test
	    public void testUpdateMedicine(){

		 Pharmacy pharm=new Pharmacy();
			pharm.setMedicineName("Paracetmol");
			pharm.setMedicineDose(100);
			pharm.setMedicineCost(200);
		    pharm.setExpireDate("22/09/2020");
	        
	        testEntityManager.persist(pharm);

	        Pharmacy getFromDb = pharmrepository.findById(pharm.getMedicineId()).get();
	        getFromDb.setMedicineCost(500); 
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getMedicineCost()).isEqualTo(500);
	    }
}
