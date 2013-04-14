package com.technotalkative.saxparsing;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.technotalkative.saxparsing.adapter.myAdapter;
/**
 * 
 * @author Paresh N. Mayani
 * email: pareshmayani@gmail.com
 *
 */
public class SAXParsingActivity extends Activity {
    /** Called when the activity is first created. */
	
	ItemList itemList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String XML = prepareXML();
        
       try
       {
    	   SAXParserFactory spf = SAXParserFactory.newInstance();
   		   SAXParser sp = spf.newSAXParser();
   		   XMLReader xr = sp.getXMLReader();

   		   /** Create handler to handle XML Tags ( extends DefaultHandler ) */
   		   MyXMLHandler myXMLHandler = new MyXMLHandler();
   		   xr.setContentHandler(myXMLHandler);

   		   ByteArrayInputStream is = new ByteArrayInputStream(XML.getBytes());
   		   xr.parse(new InputSource(is));
   	  }
      catch(Exception e)
      {
    	  
      }
      	
      itemList = MyXMLHandler.itemList;
      
      ArrayList<String> listItem= itemList.getItem();
      ArrayList<String> listManu = itemList.getManufacturer();
      ArrayList<String> listModel = itemList.getModel();
      ArrayList<String> listCost = itemList.getCost();
      
      ListView lview = (ListView) findViewById(R.id.listview1);
      myAdapter adapter = new myAdapter(this, listItem, listManu, listModel, listCost);
      lview.setAdapter(adapter);
    }
    
    private String prepareXML()
    {
    	String strXML = "<PARTS>"
    		+"<TITLE>Computer Parts</TITLE>"
    		+"<PART>"
    		+"     <ITEM>Motherboard</ITEM>"
    		+"     <MANUFACTURER>ASUS</MANUFACTURER>"
    		+"      <MODEL>P3B-F</MODEL>"
    		+"     <COST> 123.00</COST>"
    		+"  </PART>"
    		+"  <PART>"
    		+"     <ITEM>Video Card</ITEM>"
    		+"      <MANUFACTURER>ATI</MANUFACTURER>"
    		+"     <MODEL>All-in-Wonder Pro</MODEL>"
    		+"      <COST> 160.00</COST>"
    		+"   </PART>"
    		+"   <PART>"
    		+"     <ITEM>Sound Card</ITEM>"
    		+"     <MANUFACTURER>Creative Labs</MANUFACTURER>"
    		+"      <MODEL>Sound Blaster Live</MODEL>"
    		+"     <COST> 80.00</COST>"
    		+"  </PART>"
    		+"  <PART>"
    		+"     <ITEM> inch Monitor</ITEM>"
    		+"     <MANUFACTURER>LG Electronics</MANUFACTURER>"
    		+"     <MODEL> 995E</MODEL>"
    		+"      <COST> 290.00</COST>"
    		+"   </PART>"
    		+"</PARTS>";
    	
    	return strXML;
    }
}