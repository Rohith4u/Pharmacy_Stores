package com.cg.healthassist.pharmacy.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cg.healthassist.pharmacy.dto.Pharmacy;
import com.cg.healthassist.pharmacy.service.PharmacyServicesImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
@RunWith(SpringRunner.class)
@WebMvcTest(value = PharmacyController.class)
class PharmacyControllerTest {

	 @Autowired
	    private MockMvc mockMvc;
	 @Autowired
		private ObjectMapper objectMapper;

	    @MockBean
	    private PharmacyServices Pharmacyservices;
	    
	@Test
	void testViewAllMedicines() throws Exception {
		String URI = "/api/v2/viewAll";
		
		Pharmacy pharmacy = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		Pharmacy pharmacy1 = new Pharmacy(2,"Paracetmol", 100, 100, "29-09-2020");
		
	    	 List<Pharmacy> MedicineList=new ArrayList<>();
	    	 MedicineList.add(pharmacy);
	    	 MedicineList.add(pharmacy1);
	    	 
	    	String jsonInput = this.converttoJson(MedicineList);

	         Mockito.when(Pharmacyservices.viewAllMedicines()).thenReturn(MedicineList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);	}

	private String converttoJson(Object pharmacy) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(pharmacy);
	}
	
	@Test
	void testSaveMadicine() {
		//fail("Not yet implemented");
	}

	@Test
	void testViewMedicineById() {
		//fail("Not yet implemented");
	}

	@Test
	void testUpdateMedicineById() {
	//	fail("Not yet implemented");
	}

	@Test
	void testDeleteMedicine() {
		//fail("Not yet implemented");
	}

}


*//**
	 * The PharmacyController class provides testing for Application
	 * 
	 * @author Rohith
	 * @version 2.0
	 * 
	 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = PharmacyController.class)
class PharmacyControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PharmacyServicesImpl Pharmacyservice;

	/**
	 * This method returns list of all Medicines
	 * 
	 * @return list of all Medicines
	 * 
	 */
	@Test
	void testViewAllMedicines() throws Exception {
		String URI = "/api/v2/viewAll";

		Pharmacy Pharmacy = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		Pharmacy Pharmacy1 = new Pharmacy(2,"Paracetmol", 100, 100, "29-09-2020");

		List<Pharmacy> MedicineList = new ArrayList<>();
		MedicineList.add(Pharmacy);
		MedicineList.add(Pharmacy1);

		String jsonInput = this.converttoJson(MedicineList);

		Mockito.when(Pharmacyservice.viewAllMedicines()).thenReturn(MedicineList);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	private String converttoJson(Object cart) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(cart);
	}

	/**
	 * Adding new Medicines into the pharmacy
	 * 
	 * @param AddNewMedicine
	 * 
	 */
	@Test
	void testAddMedicine() throws Exception {
		String URI = "/api/v2/save";
		Pharmacy Pharmacy = new Pharmacy(1,"Zintac", 100, 100, "29-09-2020");
		String jsonInput = this.converttoJson(Pharmacy);

		Mockito.when(Pharmacyservice.saveMedicine(Mockito.any(Pharmacy.class))).thenReturn(Pharmacy);
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	/**
	 * Remove medicine by its Id from pharmacy
	 * 
	 * @param GetMedicineById
	 * 
	 */
	@SuppressWarnings("unused")
	@Test
	void testRemoveMedicine() throws Exception {
		String URI = "/api/v2/delete/{Medicineid}";
		Pharmacy Pharmacy = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		Pharmacy.setMedicineId(10);
		Mockito.when(Pharmacyservice.viewMedicine(Mockito.any())).thenReturn(Pharmacy);
        Mockito.when(Pharmacyservice.deleteMedicine(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	}

	/**
	 * Searching medicine by its Id from pharmacy
	 * 
	 * @param GetMedicineById
	 * 
	 */
	@Test
	void testViewMedicineById() throws Exception {

		String URI = "/api/v2/view/{Medicineid}";
		Pharmacy Pharmacy = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		String jsonInput = this.converttoJson(Pharmacy);
		Mockito.when(Pharmacyservice.viewMedicine(Mockito.any())).thenReturn(Pharmacy);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	/**
	 * Updating medicines from pharmacy
	 * 
	 * @param UpdateMedicine
	 * 
	 */
	@Test
	void testUpdateMedicine() throws Exception {
		String URI = "/api/v2/edit/{Medicineid}";
		Pharmacy Pharmacy = new Pharmacy(1,"Dola", 100, 100, "29-09-2020");
		Mockito.when(Pharmacyservice.updateMedicine(Mockito.anyInt(), Mockito.any(Pharmacy.class)))
				.thenReturn(Pharmacy);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		@SuppressWarnings("unused")
		String jsonOutput = mockHttpServletResponse.getContentAsString();
	}
}
