package com.technotalkative.saxparsing;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 
 * @author Paresh N. Mayani
 * email: pareshmayani@gmail.com
 *
 */
public class MyXMLHandler extends DefaultHandler
{
	public static ItemList itemList;
	public boolean current = false;
	public String currentValue = null;
	
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub

		current = true;
		
		if (localName.equals("PARTS"))
		{
			/** Start */ 
			itemList = new ItemList();
			
		} 
	}
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		current = false;
		
		if(localName.equals("ITEM"))
		{
			itemList.setItem(currentValue);
		}
		else if(localName.equals("MANUFACTURER"))
		{
			itemList.setManufacturer(currentValue);
		}
		else if(localName.equals("MODEL"))
		{
			itemList.setModel(currentValue);
		}
		else if(localName.equals("COST"))
		{
			itemList.setCost(currentValue);
		}
	}
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
		if(current)
		{
			currentValue = new String(ch, start, length);
			current=false;
		}
	}
}
