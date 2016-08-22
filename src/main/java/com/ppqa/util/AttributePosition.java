package com.ppqa.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.jsoup.nodes.Node;


/**
 * 
 * @author Saurabh Kumar
 * @version 1.0 
 * 
 *
 */
public class AttributePosition {

	final private Node childNode;
	HashMap<String,Integer> hm=new HashMap<String,Integer>();  

	private int j;
	private List<AtrributePostionTO> listAttribute = new ArrayList<AtrributePostionTO>();

	/**
	 * @param childNode
	 */
	public AttributePosition(Node childNode) {
		this.childNode = childNode;
		this.j=0;
	}

	private void getAttributeAndPosition(Node childNode) {

		for (int i = 0; i < childNode.childNodeSize(); i++) {

			getAttributeAndPosition1(childNode.childNode(i));

		}

	}

	private void getAttributeAndPosition1(Node childNode) {

		if (childNode.childNodeSize() > 1) {
			List<Node> list = childNode.childNodes();
			for (Iterator<Node> iterator = list.iterator(); iterator.hasNext();) {
				Node node = (Node) iterator.next();
				getAttributeAndPosition1(node);

			}

		} else {

			if (childNode.childNodeSize() == 1) {
				hm.put(childNode.childNode(0).toString(), j);
				//listAttribute.add(new AtrributePostionTO(childNode.childNode(0).toString(), j));
				j++;
			}
		}

	}

	public HashMap<String,Integer> getAttributeAndPosition() {
        j=0;
		getAttributeAndPosition(childNode);

		return hm;
	}

}
