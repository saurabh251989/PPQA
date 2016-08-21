package com.ppqa;
/**
 * 
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author Saurabh Kumar
 * @version 1.0
 *
 */
public class ClearCaseNameAndVersion {

	/**
	 * 
	 */
	public ClearCaseNameAndVersion() {
	}

	public HashMap<String, Integer> getVV_VerificationNameAndVersion() {
		HashMap<String, Integer> nameVersion = new HashMap<String, Integer>();

		try (FileReader in = new FileReader("Input/Input.txt"); BufferedReader reader = new BufferedReader(in)) {
			String line = null;
			while ((line = reader.readLine()) != null) {

				String[] words = line.split("@@");

				String name = words[0].substring(words[0].lastIndexOf("\\testscripts\\") + 13);
				Integer version = Integer.parseInt(words[1].replace("\\main\\development\\", ""));

				nameVersion.put(name, version);
			   
			    }
			} catch (IOException x) {
			    System.err.println(x);
			}
		return nameVersion;

	}

}
