package com.virtusa.BT;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class XMLParserPersonExample {

	public static void main(String[] args) throws FileNotFoundException,
			XMLStreamException {

		List<Person> persons = null;
		Person pers = null;
		String text = null;

		boolean flag = false;
		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader reader = factory
				.createXMLStreamReader(new FileInputStream(
						new File(
								"../BTTest/src/main/resources/person.xml")));

		while (reader.hasNext()) {
			int Event = reader.next();

			switch (Event) {
			case XMLStreamConstants.START_ELEMENT: {
				if ("person".equals(reader.getLocalName())) {
					if (null != persons)
						persons.add(pers);
					if (!flag) {
						persons = new ArrayList<Person>();
						flag = true;
					}
					pers = new Person();
				}
				break;
			}
			case XMLStreamConstants.CHARACTERS: {
				text = reader.getText().trim();
				break;
			}
			case XMLStreamConstants.END_ELEMENT: {
				switch (reader.getLocalName()) {
				case "person": {
					persons.add(pers);
					break;
				}
				case "first_name": {
					pers.setFirstName(text);
					break;
				}
				case "last_name": {
					pers.setLastname(text);
					break;
				}
				case "line_1": {
					pers.setLine_1(text);
					break;
				}
				case "line_2": {
					pers.setLine_2(text);
					break;
				}
				case "line_3": {
					pers.setLine_3(text);
					break;
				}
				}
				break;
			}
			}
		}

		for (Person p : persons)
			System.out.println(p.toString());
	}

}
