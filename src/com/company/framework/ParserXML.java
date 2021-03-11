package com.company.framework;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ParserXML {
    public static void Parse(String filePath){
        Path path = Paths.get(filePath);
        InputSource is = new InputSource();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newNSInstance().newDocumentBuilder();
            String content = Files.readString(path);
            is.setCharacterStream(new StringReader(content));
            Document document = documentBuilder.parse(is);
            PrintAllNodes(document.getChildNodes());
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private static void PrintAllNodes(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.TEXT_NODE) {
                String textInformation = node.getNodeValue().replace("\n", "").trim();
                if(!textInformation.isEmpty())
                    System.out.printf("text: %s\n", node.getNodeValue());
            }
            else {
                System.out.printf("element: %s, attributes:\n", node.getNodeName());
                NamedNodeMap attributes = node.getAttributes();
                for (int k = 0; k < attributes.getLength(); k++)
                    System.out.printf("attribute: %s, value: %s\n",attributes.item(k).getNodeName(), attributes.item(k).getNodeValue());
            }
            if (node.hasChildNodes())
                PrintAllNodes(node.getChildNodes());
        }
    }
}
