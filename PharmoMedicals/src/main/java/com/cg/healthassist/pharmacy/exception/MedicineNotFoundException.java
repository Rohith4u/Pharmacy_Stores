package com.cg.healthassist.pharmacy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** The MedicineNotFoundException layer provides customized Exceptions
 * 
 * @author Rohith
 * @version 2.0
 * 
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MedicineNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public MedicineNotFoundException(String message){
    	super(message);
    }
}

