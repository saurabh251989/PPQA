package com.ppqa;
/**
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.ppqa.instance.Instance;

/**
 * @author Saurabh Kumar
 * @version 1.0
 */
public class ValidateNameAndVersion {

	/**
	 * 
	 */
	public ValidateNameAndVersion() {
	}

	List<ValidationResult> validate(List<VersionPPQA> MTSMappedVersion) {

		List<ValidationResult> validationResultList = new ArrayList<ValidationResult>();

		for (Iterator<VersionPPQA> iterator = MTSMappedVersion.iterator(); iterator.hasNext();) {
			VersionPPQA validationMTS = (VersionPPQA) iterator.next();
			ValidationResult validationResult = new ValidationResult();

			validationResult.setPUID(validationMTS.getPUID());
			validationResult.setVV_Verification_Procedure_Name(validationMTS.getVV_Verification_Procedure_Name());
						validationResult.setVV_Verification_Procedure_Version(validationMTS.getVV_Verification_Procedure_Version());



			if(validationMTS.getVV_Verification_Procedure_Name() !=null && validationMTS.getVV_Verification_Procedure_Version()!=null)
			{
				
			if(validationMTS.getVV_Verification_Procedure_Name().length>validationMTS.getVV_Verification_Procedure_Version().length)	
			{
				
				
			}
			else if(validationMTS.getVV_Verification_Procedure_Name().length<validationMTS.getVV_Verification_Procedure_Version().length)
			{
				
			}
			else
			{
				
				String comment[]=new String[validationMTS.getVV_Verification_Procedure_Name().length]; 

				for (int i = 0; i <validationMTS.getVV_Verification_Procedure_Name().length; i++) {
					
					String str=validationMTS.getVV_Verification_Procedure_Name()[i];
					int clearCaseVersion=Instance.clearCaseNameAndVersion.get(str.substring(str.lastIndexOf("\\")+1));
				    
					int mtsVersion=validationMTS.getVV_Verification_Procedure_Version()[i];
					if(mtsVersion!=clearCaseVersion)
					{
						comment[i]=validationMTS.getVV_Verification_Procedure_Name()[i] 
								+" Mapped "
								+ mtsVersion +" "
								+clearCaseVersion+" ";
					}
					else
					{
						comment[i]="None";

					}
					
					validationResult.setComment(comment);
	
				}
				
			}
				
			Instance.clearCaseNameAndVersion.get(validationMTS.getVV_Verification_Procedure_Name());
			}
			else if(validationMTS.getVV_Verification_Procedure_Name()==null && validationMTS.getVV_Verification_Procedure_Version()==null)
			{
				validationResult.setComment(new String[]{"VV_Verification_Procedure_Name and VV_Verification_Procedure_Version is empty"});	

			}
			else if (validationMTS.getVV_Verification_Procedure_Name()==null)
			{
				

				validationResult.setComment(new String[]{"VV_Verification_Procedure_Name is empty"});	
				
			}
			else if(validationMTS.getVV_Verification_Procedure_Version()==null){			
				validationResult.setComment(new String[]{"VV_Verification_Procedure_Version is empty"});	
			}
			

			validationResultList.add(validationResult);

		}
		return validationResultList;
	}

}
