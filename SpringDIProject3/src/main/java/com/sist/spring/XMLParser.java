package com.sist.spring;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Method;
import java.util.*;
public class XMLParser extends DefaultHandler{
     Map map=new HashMap();
     Class clsName;
     Object obj;
     /*
      *   id="sa" class="com.sist.spring.Sawon"
		    p:sabun="1"
		    p:name="홍길동"
		    p:dept="개발부"
      */
	 @Override
	 public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				clsName=Class.forName(cls);
				obj=clsName.getDeclaredConstructor().newInstance();
				String attr1=attributes.getValue("p:sabun");
				Method[] methods=clsName.getDeclaredMethods();
				String name=attributes.getQName(2);
				String name_1=name.substring(name.indexOf(":")+1);
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name_1))
					{
						m.invoke(obj, Integer.parseInt(attr1));
					}
				}
				
				
				String attr2=attributes.getValue("p:name");
				name=attributes.getQName(3);
				name_1=name.substring(name.indexOf(":")+1);
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name_1))
					{
						m.invoke(obj, attr2);
					}
				}
				
				String attr3=attributes.getValue("p:dept");
				name=attributes.getQName(4);
				name_1=name.substring(name.indexOf(":")+1);
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name_1))
					{
						m.invoke(obj, attr3);
					}
				}
				map.put(id,obj);
			}
			
			
		}catch(Exception ex){}
	 }
     
}
