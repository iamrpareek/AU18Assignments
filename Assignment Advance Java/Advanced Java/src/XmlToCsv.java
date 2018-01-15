import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
public class XmlToCsv {
	public static void main(String[] args) throws Exception 
	{
		File SS = new File("src/style.xsl");
        File xmlSrc = new File("src/data.xml");

        DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
        DocumentBuilder b = f.newDocumentBuilder();
        Document doc = b.parse(xmlSrc);

        StreamSource styleSrc = new StreamSource(SS);
        Transformer trans = TransformerFactory.newInstance().newTransformer(styleSrc);
        Source src = new DOMSource(doc);
        Result oTarget = new StreamResult(new File("CsvFile.csv"));
        trans.transform(src, oTarget);
        System.out.println("Converted");
	}

}
