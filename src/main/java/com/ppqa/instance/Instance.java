/**
 * 
 */
package com.ppqa.instance;

import java.util.HashMap;

import com.ppqa.ClearCaseNameAndVersion;
import com.ppqa.util.AttributePosition;

/**
 * @author Saurabh Kumar
 *
 */
public class Instance {
public static final HashMap<String, Integer> clearCaseNameAndVersion;
public static AttributePosition attributePosition=null;
static
{
	
	clearCaseNameAndVersion=new ClearCaseNameAndVersion().getVV_VerificationNameAndVersion();
}
}
