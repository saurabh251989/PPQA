/**
 * 
 */
package com.ppqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Node;

import com.ppqa.instance.Instance;
import com.ppqa.util.AttributePosition;
import com.ppqa.util.NodeOperation;

/**
 * @author Saurabh Kumar
 *
 * @version 1.0
 */
public class MTSNode {

	List<Node> nodeList;
	NodeOperation nodeOperation = new NodeOperation();

	/**
	 * 
	 * 
	 */
	public MTSNode() {

	}

	List<Node> getMTSNode(List<Node> nodeList) {

		List<Node> mtsListNode = new ArrayList<Node>();
		List<Node> tempNode = new ArrayList<Node>();
		
		
		for (Iterator<Node> iterator = nodeList.iterator(); iterator.hasNext();) {
			Node node = iterator.next();

			tempNode = removeTextNode(node.childNodes());
			if (tempNode.get(Instance.attributePosition.getAttributeAndPosition().get("PUID")).toString().contains("[MTS_") &&
					nodeOperation.getNodeText(tempNode.get(Instance.attributePosition.getAttributeAndPosition().get("Req_Mother")))!=null	
					) {
				mtsListNode.add(node);

			}

		}

		return mtsListNode;

	}

	List<Node> removeTextNode(List<Node> childNode) {

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
