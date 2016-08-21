
package com.ppqa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Node;

import com.ppqa.util.AttributePosition;
import com.ppqa.util.NodeOperation;

/**
 * 
 * @author Saurabh Kumar
 * @version 1.0
 *
 */
public class Test {

	public static void main(String[] args) {

		File input = new File("Input/AIM_ADIRU.htm");
		Document doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<Node> childList = doc.body().childNodes();
		List<VersionPPQA> listVersionPPQA = new ArrayList<VersionPPQA>();
		List<Node> childListNodde3 = childList.get(3).childNodes();
		for (Iterator<Node> iterator = childListNodde3.iterator(); iterator.hasNext();) {
			Node node = iterator.next();

			NodeOperation nodeOperation = new NodeOperation();
			MTSNode mt = new MTSNode();
			List<Node> nodeList = node.childNodes();

			List<Node> nodeListMTS = nodeOperation.removeTextNode(nodeList);

			List<Node> nodeMts = mt.getMTSNode(nodeListMTS);

			AttributePosition attributePosition = new AttributePosition(nodeListMTS.get(0));

			HashMap<String, Integer> att = attributePosition.getAttributeAndPosition();

			for (Iterator<Node> iterator2 = nodeMts.iterator(); iterator2.hasNext();) {
				Node node2 = iterator2.next();
				List<Node> listNode = nodeOperation.removeTextNode(node2.childNodes());

				String pUID = nodeOperation.getNodeText(listNode.get(att.get("PUID")));

				String[] vV_Verification_Procedure_Name = null;
				if (nodeOperation.getNodeText(listNode.get(att.get("VV_Verification_Procedure_Name"))) != null) {
					vV_Verification_Procedure_Name = nodeOperation.getNodeText(

					listNode.get(att.get("VV_Verification_Procedure_Name"))).split(";");
				}
				String[] temp = null;
				if (nodeOperation.getNodeText(listNode.get(att.get("VV_Verification_Procedure_Version"))) != null) {

					temp = nodeOperation.getNodeText(listNode.get(att.get("VV_Verification_Procedure_Version")))
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
				listVersionPPQA
						.add(new VersionPPQA(pUID, vV_Verification_Procedure_Name, vV_Verification_Procedure_Version));

			}

			for (Iterator<VersionPPQA> iterator2 = listVersionPPQA.iterator(); iterator2.hasNext();) {
				VersionPPQA versionPPQA = (VersionPPQA) iterator2.next();
				System.out.println(versionPPQA.toString());
			}

			
			ValidateNameAndVersion ValidateNameAndVersion=new ValidateNameAndVersion();
			ValidateNameAndVersion.validate(listVersionPPQA);
			
		}
	}

}
