
package com.ppqa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Node;

import com.ppqa.util.AtrributePostionTO;
import com.ppqa.util.AttributePosition;

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

			List<Node> nodeList = node.childNodes();

			List<Node> nodeListMTS = removeTextNode(nodeList);
			MTSNode mt = new MTSNode();
			List<Node> nodeMts = mt.getMTSNode(nodeListMTS);
			AttributePosition attributePosition = new AttributePosition(nodeListMTS.get(0));

			HashMap<String, Integer> att = attributePosition.getAttributeAndPosition();

			for (Iterator<Node> iterator2 = nodeMts.iterator(); iterator2.hasNext();) {
				Node node2 = iterator2.next();
				List<Node> listNode = removeTextNode(node2.childNodes());

				String pUID = getNodeText(listNode.get(att.get("PUID")));
				
				String[] vV_Verification_Procedure_Name= null;
				if(getNodeText(
						listNode.get(att.get("VV_Verification_Procedure_Name")))!=null)
				 {
					vV_Verification_Procedure_Name = getNodeText(
				 
						listNode.get(att.get("VV_Verification_Procedure_Name"))).split(";");
				 }
				String[] temp =null;
				if(getNodeText(listNode.get(att.get("VV_Verification_Procedure_Version")))!=null)
				{
				
					temp= getNodeText(listNode.get(att.get("VV_Verification_Procedure_Version"))).split(";");
				
				}
				Integer[] vV_Verification_Procedure_Version=null;
				int i = 0;
				if(temp!=null)
				{
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

		}
	}

	static List<Node> removeTextNode(List<Node> childNode) {

		List<Node> nodeList = new ArrayList<Node>();

		for (Iterator<Node> iterator2 = childNode.iterator(); iterator2.hasNext();) {
			Node node1 = iterator2.next();
			if (node1.childNodeSize() == 0 && node1.nodeName().equals("#text")) {
				continue;
			}
			nodeList.add(node1);

		}
		return nodeList;

	}

	static String getNodeText(Node node) {

		for (int i = 0; i < node.childNodeSize();) {
			node = node.childNode(0);
		}
		if (node.attributes().hasKey("text")) {
			return node.toString();
		} else {
			return null;
		}

	}

}
