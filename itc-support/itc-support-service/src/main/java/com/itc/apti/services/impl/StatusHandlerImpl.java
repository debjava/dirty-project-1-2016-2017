package com.itc.apti.services.impl;

import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.itc.apti.entity.IStatus;
import com.itc.apti.entity.Status;
import com.itc.apti.services.XmlHandler;

/**
 * The Class StatusHandlerImpl is used to parse the XML contents using SAX
 * parser.
 * 
 * @author Debadatta Mishra
 */
@Component("statusHandler")
public class StatusHandlerImpl extends XmlHandler<IStatus> {

	/** The status. */
	private Status status = null;

	/** The parsed data. */
	private String parsedData = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startDocument()
	 */
	@Override
	public void startDocument() throws SAXException {
		status = new Status();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName, org.xml.sax.Attributes attributes)
			throws org.xml.sax.SAXException {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws org.xml.sax.SAXException {

		if (qName.equalsIgnoreCase("host.name")) {
			status.setHostName(parsedData);
		} else if (qName.equalsIgnoreCase("host.ip")) {
			status.setHostIp(parsedData);
		} else if (qName.equalsIgnoreCase("host.canonical.name")) {
			status.setHostCanonicalName(parsedData);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length) throws org.xml.sax.SAXException {
		parsedData = new String(ch, start, length);
		parsedData = (parsedData == null) ? "" : parsedData;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.itc.apti.services.XmlHandler#get()
	 */
	public IStatus get() {
		return status;
	}

}
