/**
 * 
 */
package com.ppqa.util;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import com.ppqa.ValidationResult;

/**
 * @author Saurabh Kumar
 *
 */
public class HTMLReport {

	List<ValidationResult> validationResult;

	/**
	 * @param validationResult
	 */
	public HTMLReport(List<ValidationResult> validationResult) {
		this.validationResult = validationResult;
	}

	/**
	 * 
	 */
	public HTMLReport() {
	}

	public void generateHTMLReport() {

		System.out.println("<!DOCTYPE html>");
		System.out.println("<html>");
		System.out.println("<head>");
		System.out.println("<style>");
		System.out.println("table, th, td {");
		System.out.println("    border: 1px solid black;");
		System.out.println(" border-collapse: collapse;");
		System.out.println("}");
		System.out.println("th, td {");
		System.out.println("padding: 5px;");
		System.out.println("text-align: left;");
		System.out.println("}");
		System.out.println("</style>");
		System.out.println("</head>");
		System.out.println("<body>");

		System.out.println("<table style=\"width:100%\">");
		System.out.println("<caption>Report</caption>");
		System.out.println("<tr>");
		System.out.println("<th>");
		System.out.println("PUID");
		System.out.println("</th>");
		System.out.println("<th>");
		System.out.println("VV_Verification_Procedure_Name");
		System.out.println("</th>");

		System.out.println("<th>");
		System.out.println("VV_Verification_Procedure_Version");
		System.out.println("</th>");

		System.out.println("<th>");
		System.out.println("Comment");
		System.out.println("</th>");

		System.out.println("<tr>");

		for (Iterator<ValidationResult> iterator = validationResult.iterator(); iterator.hasNext();) {
			ValidationResult validationResult2 = (ValidationResult) iterator.next();

			System.out.println("<tr>");
			System.out.println("<td>");
			System.out.println(validationResult2.getPUID());
			System.out.println("</td>");
			System.out.println("<td>");
			if (validationResult2.getVV_Verification_Procedure_Name() != null) {
				for (int i = 0; i < validationResult2.getVV_Verification_Procedure_Name().length; i++) {

					System.out.println(validationResult2.getVV_Verification_Procedure_Name()[i]);
					System.out.println("<br/>");
				}
			} else {
				System.out.println("");
			}
			System.out.println("</td>");
			System.out.println("<td>");
			if (validationResult2.getVV_Verification_Procedure_Version() != null) {
				for (int i = 0; i < validationResult2.getVV_Verification_Procedure_Version().length; i++) {
					System.out.println(validationResult2.getVV_Verification_Procedure_Version()[i]);
					System.out.println("<br/>");
				}
			}

			else {
				System.out.println("");
			}

			System.out.println("</td>");
			System.out.println("<td>");
			if (validationResult2.getComment() != null) {
				for (int i = 0; i < validationResult2.getComment().length; i++) {

					System.out.println(validationResult2.getComment()[i]);
					System.out.println("<br/>");
				}
			}

			else {
				System.out.println("");
			}

			System.out.println("</td>");

			System.out.println("<tr>");

		}

		System.out.println("</table>");

		System.out.println("</body>");
		System.out.println("</html>");

	}

	/**
	 * @param string
	 */
	public void generateHTMLReport(String fileName) {
		try {
			File statText = new File("Output/" + "Result" + fileName);
			FileOutputStream is = new FileOutputStream(statText, false);
			OutputStreamWriter osw = new OutputStreamWriter(is);
			Writer report = new BufferedWriter(osw);
            String cr="green";
			xyz:
			for (Iterator<ValidationResult> iterator = validationResult.iterator(); iterator.hasNext();) {
				ValidationResult validationResult2 = (ValidationResult) iterator.next();
		         for (int i = 0; i < validationResult2.getComment().length; i++) {
					 
		        	 if(!validationResult2.getComment()[i].equals("None"))
		        	 {
		        		
		        		 cr="red";
		        	      break xyz;	 
		        	 }
		        	 }
				}	
			
			
			
			report.write("<!DOCTYPE html>");
			report.write("\n");

			report.write("<html>");
			report.write("\n");
			report.write("<head>");
			report.write("\n");
			report.write("<style>");
			report.write("\n");
			report.write("table, th, td {");
			report.write("\n");
			report.write("    border: 1px solid black;");
			report.write("\n");
			report.write(" border-collapse: collapse;");
			report.write("\n");
			report.write("}");
			report.write("\n");
			report.write("th, td {");
			report.write("\n");
			report.write("padding: 5px;");
			report.write("\n");
			report.write("text-align: left;");
			report.write("\n");
			report.write("}");
			report.write("\n");
			report.write("</style>");
			report.write("\n");
			report.write("</head>");
			report.write("\n");
			report.write("<body>");
			report.write("\n");

			report.write("<table style=\"width:100%\">");
			report.write("\n");
			report.write("<caption ><font color="+cr+">"+fileName.substring(0,fileName.indexOf("."))+"_REPORT"+"</caption>");
			report.write("\n");
			report.write("<tr>");
			report.write("\n");
			report.write("<th>");
			report.write("\n");
			report.write("PUID");
			report.write("\n");
			report.write("</th>");
			report.write("\n");
			report.write("<th>");
			report.write("\n");
			report.write("VV_Verification_Procedure_Name");
			report.write("\n");
			report.write("</th>");
			report.write("\n");

			report.write("<th>");
			report.write("\n");
			report.write("VV_Verification_Procedure_Version");
			report.write("\n");
			report.write("</th>");
			report.write("\n");
			report.write("<th>");
			report.write("\n");
			report.write("Comment");
			report.write("\n");
			report.write("</th>");
			report.write("\n");

			report.write("<tr>");
			report.write("\n");

			for (Iterator<ValidationResult> iterator = validationResult.iterator(); iterator.hasNext();) {
				ValidationResult validationResult2 = (ValidationResult) iterator.next();

				report.write("<tr>");
				report.write("\n");
				report.write("<td>");
				report.write("\n");
				report.write(validationResult2.getPUID());
				report.write("</td>");
				report.write("\n");
				report.write("<td>");
				report.write("\n");
				if (validationResult2.getVV_Verification_Procedure_Name() != null) {
					for (int i = 0; i < validationResult2.getVV_Verification_Procedure_Name().length; i++) {

						report.write(validationResult2.getVV_Verification_Procedure_Name()[i]);
						report.write("\n");
						report.write("<br/>");
						report.write("\n");
					}
				} else {
					report.write("");
					report.write("\n");
				}
				report.write("</td>");
				report.write("\n");
				report.write("<td>");
				report.write("\n");
				if (validationResult2.getVV_Verification_Procedure_Version() != null) {
					for (int i = 0; i < validationResult2.getVV_Verification_Procedure_Version().length; i++) {
						report.write(validationResult2.getVV_Verification_Procedure_Version()[i].toString());
						report.write("<br/>");
						report.write("\n");
					}
				}

				else {
					report.write("");
					report.write("\n");
				}

				report.write("</td>");
				report.write("\n");
				report.write("<td>");
				report.write("\n");
				if (validationResult2.getComment() != null) {
					for (int i = 0; i < validationResult2.getComment().length; i++) {

						report.write(validationResult2.getComment()[i]);

						report.write("\n");
						report.write("<br/>");
						report.write("\n");
					}
				}

				else {
					report.write("");
					report.write("\n");
				}

				report.write("</td>");
				report.write("\n");

				report.write("<tr>");
				report.write("\n");

			}

			report.write("</table>");
			report.write("\n");
			report.write("</body>");
			report.write("\n");
			report.write("</html>");
			report.write("\n");
			report.close();
		} catch (IOException e) {
			System.err.println("Problem writing to the file statsTest.txt");
		}

	}

}
