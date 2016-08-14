package com.ppqa.version;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Node;

public class Test {

	public static void main(String[] args) {

		File input = new File("C:/Users/Saurabh Kumar/Downloads/aim_adiru (2)/aim_adiru.HTM");
	
		System.out.println("Hello");
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

			List<Node> childNode = node.childNodes();

			System.out.println(childNode.get(10).childNode(0).childNode(0).childNode(0));

			System.out.println(childNode.get(10).childNode(12).childNode(0));
			System.out.println(childNode.get(10).childNode(14).childNode(0));

		}

	}

	static List<Node> removeTextNode(List<Node> childNode) {

		List<Node> nodeList = new ArrayList<Node>();

		for (Iterator<Node> iterator2 = childNode.iterator(); iterator2.hasNext();) {
			Node node1 = (Node) iterator2.next();
			if (node1.childNodeSize() == 0 && node1.nodeName().equals("#text")) {
				// childNode.remove(node1);
				continue;
			}
			nodeList.add(node1);

		}
		return nodeList;

	}

}
