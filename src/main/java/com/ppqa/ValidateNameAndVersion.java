package com.ppqa;
/**
 * 
 */

import java.util.ArrayList;
import java.util.List;

import com.ppqa.instance.Instance;

/**
 * @author Saurabh Kumar
 *
 */
public class ValidateNameAndVersion {

	/**
	 * 
	 */
	public ValidateNameAndVersion() {
	}

	List<ValidationResult> validate(List<VersionPPQA> MTSMappedVersion)
	{
		
		List<ValidationResult> validationResult =new ArrayList<ValidationResult>();

		
		
		Instance.clearCaseNameAndVersion.get(MTSMappedVersion.get(0).getVV_Verification_Procedure_Name());
		
		return validationResult;
	}
	
	
}
