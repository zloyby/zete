package by.zloy.twister;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Logger;

/**
 * The Class XmlParser.
 */
public class XmlParser {

    /**
     * The logger.
     */
    private static Logger logger = LogWrapper.getLogger();

    /**
     * Parse.
     *
     * @param description the description
     * @return the string
     */
    public static String parse(String description) {
        Document doc = parseXmlFile(TwisterPropertiesFinder.currentFileUri, false);
        NodeList list = doc.getElementsByTagName(description);
        Element element = (Element) list.item(0);
        return element.getAttribute("name");
    }

    /**
     * Parses the xml file.
     *
     * @param file       the inputStream
     * @param validating the validating
     * @return the document
     */
    private static Document parseXmlFile(URI file, boolean validating) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(validating);
            return factory.newDocumentBuilder().parse(file.toString());
        } catch (SAXException e) {
            logger.severe(e.getLocalizedMessage());
        } catch (ParserConfigurationException e) {
            logger.severe(e.getLocalizedMessage());
        } catch (IOException e) {
            logger.severe(e.getLocalizedMessage());
        }
        return null;
    }
}
