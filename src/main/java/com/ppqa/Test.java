
package com.ppqa;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
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

		List<Node> childListNodde3 = childList.get(3).childNodes();
		for (Iterator<Node> iterator = childListNodde3.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();

			List<Node> nodeList = node.childNodes();

			List<Node> nodeList1 = removeTextNode(nodeList);

			//System.out.println(nodeList1.get(4));
			nodeList1 = removeTextNode(nodeList1.get(4).childNodes());
			//System.out.println(nodeList1.get(0));
			for (Iterator<Node> iterator2 = nodeList1.iterator(); iterator2.hasNext();) {
				Node node2 = (Node) iterator2.next();
				System.out.println("**************");

				System.out.println(node2);
			}

			List<Node> nodeList2 = nodeList1.get(2).childNodes();
			for (Iterator<Node> iterator2 = nodeList2.iterator(); iterator2.hasNext();) {
				Node node2 = (Node) iterator2.next();
				//System.out.println(node2.toString());
				// System.out.println("Hello");
				// System.out.println(node2);
			}

			AttributePosition attributePosition = new AttributePosition(nodeList1.get(0));

			for (Iterator<AtrributePostionTO> iterator1 = attributePosition.getAttributeAndPosition()
					.iterator(); iterator1.hasNext();) {
				AtrributePostionTO node1 = (AtrributePostionTO) iterator1.next();
				//System.out.println(node1.getAttribute());
				//System.out.println(node1.getPosition());
			}

		}
	}

	static List<Node> removeTextNode(List<Node> childNode) {

		List<Node> nodeList = new ArrayList<Node>();

		for (Iterator<Node> iterator2 = childNode.iterator(); iterator2.hasNext();) {
			Node node1 = (Node) iterator2.next();
			if (node1.childNodeSize() == 0 && node1.nodeName().equals("#text")) {
				continue;
			}
			nodeList.add(node1);

		}
		return nodeList;

	}

}
