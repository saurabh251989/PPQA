package com.ppqa.util;

import java.util.ArrayList;
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

	/**
	 * @param childNode
	 */
	public AttributePosition(Node childNode) {
		this.childNode = childNode;
	}

	private int j = 0;
	private List<AtrributePostionTO> listAttribute = new ArrayList<AtrributePostionTO>();

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

				listAttribute.add(new AtrributePostionTO(childNode.childNode(0).toString(), j));
				j++;
			}
		}

	}

	public List<AtrributePostionTO> getAttributeAndPosition() {

		getAttributeAndPosition(childNode);

		return listAttribute;
	}

}
