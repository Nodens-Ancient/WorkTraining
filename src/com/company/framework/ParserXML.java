package com.company.framework;

import com.company.Product;
import com.company.ProductList;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
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
            return documentBuilder.parse(is);
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

    public static void GetInformation(Document document, ProductList productList){
        NodeList nodeList = document.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE){
                Element element =(Element) node;
                for (int j = 0; j < element.getElementsByTagName("Product").getLength(); j++){
                    String prodID =element.getElementsByTagName("productId").item(j).getTextContent();
                    float prodPrice = Float.parseFloat(element.getElementsByTagName("price").item(j).getTextContent());
                    int prodStock = Integer.parseInt(element.getElementsByTagName("stock").item(j).getTextContent());
                    String prodName = element.getElementsByTagName("productName").item(j).getTextContent();
                    productList.AddProduct(new Product(prodName, prodID, prodPrice, prodStock));
                }
            }
        }
    }

    public static Document SetXMLFileFromListOfProducts(ProductList productList){
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newNSInstance().newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("ProductList");
            document.appendChild(rootElement);
            for (Product p:
                    productList.products) {
                 rootElement.appendChild(CreateProductNode(document, p));
            }
            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Node CreateProductNode(Document document, Product product){
        Element element = document.createElement("Product");
        element.appendChild(CreateProductChildNode(document, "ID", product.getProductID()));
        element.appendChild(CreateProductChildNode(document, "Name", product.getProductName()));
        element.appendChild(CreateProductChildNode(document, "Price", product.getProductPrice().toString()));
        element.appendChild(CreateProductChildNode(document, "Stock", product.getProductInStock().toString()));
        return element;
    }
    public static Node CreateProductChildNode(Document document, String nodeName, String value){
        Element node = document.createElement(nodeName);
        node.appendChild(document.createTextNode(value));
        return node;
    }

    public static void PrintDocumentToXMLFile(Document document, String path){
        DOMSource source = new DOMSource(document);
        try {
            FileWriter writer = new FileWriter(path);
            StreamResult result = new StreamResult(writer);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.transform(source, result);
        } catch (IOException | TransformerException e) {
            e.printStackTrace();
        }
    }
}
