package aha_chanllenge;

import static java.lang.System.out;

import java.io.ByteArrayInputStream;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Za {


	private static String testXML() throws Exception {
		String xml = "<root><Ext><![CDATA[ClientId=18&ClientIdExt=1003&Ip=218.205.245.9&ProvCode=26&OrderType=3&LoginType=2&LoginFrom=66&partid=12]]></Ext></root>";
		String ext = getExtFromXML(xml);
		out.println(ext);
		ext = GetXMLValue(xml, "Ext");
		out.println(ext);
		return ext;
	}

	private static String getExtFromXML(String xml) throws Exception {
		SAXReader reader = new SAXReader();
		ByteArrayInputStream bis = new ByteArrayInputStream(xml.getBytes());
		Document document = reader.read(bis);
		Element rootElem = document.getRootElement();
		String ext = rootElem.elementText("Ext");
		return ext;
	}

	private static boolean isWebLogin() throws Exception {
		boolean webLogin = false;
		// String ext = testXML();
		String xml = "<root><Ext><![CDATA[ClientId=18&ClientIdExt=1003&Ip=218.205.245.9&ProvCode=26&OrderType=3&LoginType=2&LoginFrom=66&partid=12]]></Ext></root>";
		String ext = GetXMLValue(xml, "Ext");
		out.println(ext);
		ext = ext.replace("<![CDATA[", "");
		ext = ext.replace("]]>", "");
		String clientId = null;
		String clientIdExt = null;

		String[] exts = ext.split("&");

		for (int i = 0; i < exts.length; i++) {
			out.println("ext: " + exts[i]);
			String[] client = exts[i].split("=");
			// client[0] = client[0].replace("<![CDATA[", "");
			out.println("client: " + client[0]);
			if (client.length != 2) {
				continue;
			}

			if ("ClientId".equals(client[0])) {
				clientId = client[1];
				continue;
			}

			if ("ClientIdExt".equals(client[0])) {
				clientIdExt = client[1];
			}
		}

		if ("18".equals(clientId) && "1001,1002,1003".contains(clientIdExt)) {
			webLogin = true;
		}

		return webLogin;
	}

	public static String GetXMLValue(String srcXML, String element) {
		int begPos, endPos;
		String begElement = "<" + element + ">";
		String endElement = "</" + element + ">";

		begPos = srcXML.indexOf(begElement);
		endPos = srcXML.indexOf(endElement);
		if (begPos != -1 && endPos != -1) {
			begPos = begPos + begElement.length();
			return srcXML.substring(begPos, endPos);
		} else {
			return "";
		}
	}

}
