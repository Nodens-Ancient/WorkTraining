package com.company.framework;

import com.company.Product;
import com.company.ProductList;
import org.w3c.dom.*;
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

    public static Document GetDocumentFromXML(String filePath){
        Path path = Paths.get(filePath);
        InputSource is = new InputSource();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newNSInstance().newDocumentBuilder();
            String content = Files.readString(path);
            is.setCharacterStream(new StringReader(content));
            Document document = documentBuilder.parse(is);
            return document;
        } catch (IOException | SAXException | ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void PrintAllNodes(NodeList nodeList){
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

    public static ProductList GetInformation(Document document, ProductList productList){
        NodeList nodeList = document.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element =(Element) node;
                for (int j = 0; j < element.getElementsByTagName("Product").getLength(); j++){

                    String prodID = element.getElementsByTagName("productId").item(j).getTextContent();
                    String prodName = element.getElementsByTagName("productName").item(j).getTextContent();
                    String prodPrice = element.getElementsByTagName("price").item(j).getTextContent();
                    String prodStock = element.getElementsByTagName("stock").item(j).getTextContent();

                    productList.AddProduct(new Product(prodName, prodID, prodPrice, prodStock));
                }
            }
        }
        return productList;
    }

    public static void PrintList(NodeList nodeList){

    }
}
