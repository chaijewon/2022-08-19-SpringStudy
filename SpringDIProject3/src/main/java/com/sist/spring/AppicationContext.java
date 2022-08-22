package com.sist.spring;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.io.*;
public class AppicationContext {
   private Map map=new HashMap();
   String path="C:\\springDev\\springStudy\\SpringDIProject3\\src\\main\\java\\com\\sist\\spring\\";
   public AppicationContext(String filename)
   {
	   try
	   {
		   SAXParserFactory spf=SAXParserFactory.newInstance();
		   SAXParser sp=spf.newSAXParser();
		   XMLParser xml=new XMLParser();
		   sp.parse(new File(path+filename), xml);
		   map=xml.map;
	   }catch(Exception ex) {}
   }
   public Object getBean(String id)
   {
	   return map.get(id);
   }
}
