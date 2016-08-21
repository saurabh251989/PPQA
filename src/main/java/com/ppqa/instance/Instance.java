/**
 * 
 */
package com.ppqa.instance;

import java.util.HashMap;

import com.ppqa.ClearCaseNameAndVersion;

/**
 * @author Saurabh Kumar
 *
 */
public class Instance {
public static final HashMap<String, Integer> clearCaseNameAndVersion;
static
{
	
	clearCaseNameAndVersion=new ClearCaseNameAndVersion().getVV_VerificationNameAndVersion();
}
}
