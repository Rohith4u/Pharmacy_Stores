package com.cg.healthassist.pharmacy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.healthassist.pharmacy.dto.Pharmacy;

/** The PharmacyRepository layer provides jpa repository for CURD Methods
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@Repository
public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer>  {

}
