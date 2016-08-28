
package com.ppqa;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import com.ppqa.instance.Instance;
import com.ppqa.log.Log4jConfigurator;
import com.ppqa.util.AttributePosition;
import com.ppqa.util.HTMLReport;
import com.ppqa.util.NodeOperation;

/**
 * 
 * @author Saurabh Kumar
 * @version 1.0
 *
 */

public class Test {

	static final Logger logger = Logger.getLogger(Test.class);
	private static final String LOG_FILE_PATH = "resources/log4j-config.xml";
	public static void main(String[] args) throws IOException {
		File file = new File("src/main/"+LOG_FILE_PATH);
		String absolutePath = file.getAbsolutePath();
		// Configure logger service
		Log4jConfigurator.getInstance().initilize(absolutePath);

		// Get logger instance
		Logger LOGGER = Logger.getLogger(Test.class);
		
		Files.walk(Paths.get("Input/")).forEach(filePath -> {

			if (Files.isRegularFile(filePath) && (filePath.getFileName().toString().endsWith(".html")
					|| filePath.getFileName().toString().endsWith(".htm")
					|| filePath.getFileName().toString().endsWith(".HTM")
					|| filePath.getFileName().toString().endsWith(".HTML"))) {
				Document doc = null;
				try {
					doc = Jsoup.parse(filePath.toFile(), "UTF-8");
					LOGGER.info(filePath.toFile());
				} catch (IOException e) {
					LOGGER.error(e);

				}

				List<Node> childList = doc.body().childNodes();
				List<VersionPPQA> listVersionPPQA = new ArrayList<VersionPPQA>();
				
				
				List<Node> childListNodde3 = childList.get(3).childNodes();
				LOGGER.info(childListNodde3);
				
				
				for (Iterator<Node> iterator = childListNodde3.iterator(); iterator.hasNext();) {
					Node node = iterator.next();

					NodeOperation nodeOperation = new NodeOperation();

					List<Node> nodeList = node.childNodes();

                    LOGGER.info(nodeList);
					List<Node> nodeListMTS = nodeOperation.removeTextNode(nodeList);
                    LOGGER.info(nodeList);
					
					Instance.attributePosition = new AttributePosition(nodeListMTS.get(0));

					HashMap<String, Integer> att = Instance.attributePosition.getAttributeAndPosition();
					LOGGER.info(att);
					
					
					Set<String> lAttributeList = new HashSet<String>();

					lAttributeList.add("PUID");
					lAttributeList.add("Req_Mother");
					lAttributeList.add(
							"Module Test Specification of Field Loadable SW - Level A Software (from S3.2.1 onwards)");
					lAttributeList.add("Val_Remark");
					lAttributeList.add("Req_Comment");
					lAttributeList.add("VV_Verification_Justification");
					lAttributeList.add("VV_Verification_Procedure_Name");
					lAttributeList.add("VV_Verification_Procedure_Version");
					lAttributeList.add("Req_PR_Change_History");
					lAttributeList.add("Tested_Code_Label");
					lAttributeList.add("VV_Verification_Result");
					lAttributeList.add("Val_Means");
					lAttributeList.add("Val_Reference");
					lAttributeList.add("Tested_Baseline");
					lAttributeList.add("Req_Status");
					lAttributeList.add("VV_Verification_Procedure_Dev_Status");

					Set<String> lAttribute = att.keySet();
					LOGGER.info(lAttribute);
					List<String> comment = new ArrayList<String>();

					for (Iterator<String> it = lAttributeList.iterator(); it.hasNext();) {
						String attribute = it.next();
						if (lAttribute.contains(attribute)) {

						} else {
							
							LOGGER.info(attribute +" is not found");
							comment.add("Attribute " + attribute + " is not present in HTML ");
						}

					}

					boolean flag = false;

					if (!(lAttribute.contains("PUID") && lAttribute.contains("VV_Verification_Procedure_Name")
							&& lAttribute.contains("VV_Verification_Procedure_Version"))) {
						flag = true;
						LOGGER.info("Tested attribute not found");
						
					} else {
						flag = false;
					}

					if (flag == false) {
						MTSNode mt = new MTSNode();
						List<Node> nodeMts = mt.getMTSNode(nodeListMTS);

						for (Iterator<Node> iterator2 = nodeMts.iterator(); iterator2.hasNext();) {
							Node node2 = iterator2.next();
							List<Node> listNode = nodeOperation.removeTextNode(node2.childNodes());

							String pUID = nodeOperation.getNodeText(listNode.get(att.get("PUID")));

							String[] vV_Verification_Procedure_Name = null;
							if (nodeOperation
									.getNodeText(listNode.get(att.get("VV_Verification_Procedure_Name"))) != null) {
								vV_Verification_Procedure_Name = nodeOperation.getNodeText(

								listNode.get(att.get("VV_Verification_Procedure_Name"))).split(";");
							}
							String[] temp = null;
							if (nodeOperation
									.getNodeText(listNode.get(att.get("VV_Verification_Procedure_Version"))) != null) {

								temp = nodeOperation
										.getNodeText(listNode.get(att.get("VV_Verification_Procedure_Version")))
										.split(";");

							}
							Integer[] vV_Verification_Procedure_Version = null;
							int i = 0;
							if (temp != null) {
								vV_Verification_Procedure_Version = new Integer[temp.length];
								for (String str : temp) {
									vV_Verification_Procedure_Version[i] = Integer.parseInt(str);
									i++;
								}
							}
							listVersionPPQA.add(new VersionPPQA(pUID, vV_Verification_Procedure_Name,
									vV_Verification_Procedure_Version));

						}

						ValidateNameAndVersion ValidateNameAndVersion = new ValidateNameAndVersion();
						List<ValidationResult> vl = ValidateNameAndVersion.validate(listVersionPPQA);
						LOGGER.info(vl);
						
						LOGGER.info(comment);
						
						LOGGER.info("Tested attribute not found");
						
						
						HTMLReport ht = new HTMLReport(vl, comment);
						ht.generateHTMLReport(filePath.getFileName().toString());
					} else {
						

						LOGGER.info(comment);
						
						HTMLReport ht = new HTMLReport(comment);
						ht.generateHTMLReport(filePath.getFileName().toString(), flag);

					}
				}
			}
		});

	}

}
