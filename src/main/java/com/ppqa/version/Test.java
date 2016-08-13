package com.ppqa.version;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class Test {

	public static void main(String[] args) {

		File input = new File("C:/Users/Saurabh Kumar/Downloads/aim_adiru (2)/aim_adiru.HTM");
		Document doc = null;
		try {
			doc = Jsoup.parse(input, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Sudip");
		System.out.println("Sp");

		System.out.println("Hello");
		System.out.println("*****************");
		List<Node> childList = doc.body().childNodes();
		for (Iterator<Node> iterator = childList.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			// System.out.println(node.nodeName());
		}
		List<Node> childListNodde3 = childList.get(3).childNodes();
		for (Iterator iterator = childListNodde3.iterator(); iterator.hasNext();) {
			Node node = (Node) iterator.next();
			// System.out.println(node.nodeName());
			// System.out.println("Hello");
			List<Node> childNode = node.childNodes();
			List<Node> childNode1=new ArrayList<Node>();
			 System.out.println(childNode.get(0));
			
			for (Iterator<Node> iterator2 = childNode.iterator(); iterator2.hasNext();) {
				Node node1 = (Node) iterator2.next();
				if(node1.childNodeSize()==0 && node1.nodeName().equals("#text") )
					{
					//childNode.remove(node1);
					continue;
					}
				childNode1.add(node1);
      			// System.out.println( node1.nodeName());
			
			}
			
			
			for (Iterator<Node> iterator2 = childNode1.iterator(); iterator2.hasNext();) {
				Node node2 = (Node) iterator2.next();
				/// System.out.println( node2.nodeName()+"\t"+node2.childNodeSize());
			}
			
			List<Node> xyz = childNode.get(0).childNodes();
for (Iterator iterator2 = xyz.iterator(); iterator2.hasNext();) {
	Node node2 = (Node) iterator2.next();
	 System.out.println( node2.nodeName()+"\t"+node2.childNodeSize());

}
		}

		Elements element = doc.body().getElementsByTag("tbody");
		// System.out.println(element);

	}

}
