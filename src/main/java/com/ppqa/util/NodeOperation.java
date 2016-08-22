/**
 * 
 */
package com.ppqa.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Node;

/**
 * @author Saurabh Kumar
 *
 */
public class NodeOperation {

	/**
	 * 
	 */
	public NodeOperation() {
	
	}

	
	public List<Node> removeTextNode(List<Node> childNode) {

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
	public String getNodeText(Node node) {

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
