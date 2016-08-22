/**
 * 
 */
package com.ppqa;

import java.util.Arrays;

/**
 * @author Saurabh Kumar
 *
 */
public class ValidationResult {

	private String PUID;
	private String[] VV_Verification_Procedure_Name;
	private Integer[] VV_Verification_Procedure_Version;
	private String[] Comment;

	/**
	 * 
	 */
	public ValidationResult() {
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ValidationResult [PUID=" + PUID + ", VV_Verification_Procedure_Name="
				+ Arrays.toString(VV_Verification_Procedure_Name) + ", VV_Verification_Procedure_Version="
				+ Arrays.toString(VV_Verification_Procedure_Version) + ", Comment=" + Arrays.toString(Comment) + "]";
	}




	/**
	 * @param pUID
	 * @param vV_Verification_Procedure_Name
	 * @param vV_Verification_Procedure_Version
	 * @param comment
	 */
	public ValidationResult(String pUID, String[] vV_Verification_Procedure_Name,
			Integer[] vV_Verification_Procedure_Version, String[] comment) {
		PUID = pUID;
		VV_Verification_Procedure_Name = vV_Verification_Procedure_Name;
		VV_Verification_Procedure_Version = vV_Verification_Procedure_Version;
		Comment = comment;
	}




	/**
	 * @return the pUID
	 */
	public String getPUID() {
		return PUID;
	}

	/**
	 * @param pUID the pUID to set
	 */
	public void setPUID(String pUID) {
		PUID = pUID;
	}

	/**
	 * @return the vV_Verification_Procedure_Name
	 */
	public String[] getVV_Verification_Procedure_Name() {
		return VV_Verification_Procedure_Name;
	}

	/**
	 * @param vV_Verification_Procedure_Name the vV_Verification_Procedure_Name to set
	 */
	public void setVV_Verification_Procedure_Name(String[] vV_Verification_Procedure_Name) {
		VV_Verification_Procedure_Name = vV_Verification_Procedure_Name;
	}

	/**
	 * @return the vV_Verification_Procedure_Version
	 */
	public Integer[] getVV_Verification_Procedure_Version() {
		return VV_Verification_Procedure_Version;
	}

	/**
	 * @param vV_Verification_Procedure_Version the vV_Verification_Procedure_Version to set
	 */
	public void setVV_Verification_Procedure_Version(Integer[] vV_Verification_Procedure_Version) {
		VV_Verification_Procedure_Version = vV_Verification_Procedure_Version;
	}

	/**
	 * @return the comment
	 */
	public String[] getComment() {
		return Comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(String[] comment) {
		Comment = comment;
	}



}
