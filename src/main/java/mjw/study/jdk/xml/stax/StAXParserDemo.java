/*
 * Copyright 2017 JiaweiMao jiaweiM_philo@hotmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package mjw.study.jdk.xml.stax;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class StAXParserDemo {
	public static void main(String[] args) {
		boolean bFirstName = false;
		boolean bLastName = false;
		boolean bNickName = false;
		boolean bMarks = false;
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("students.xml"));

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				switch (event.getEventType()) {
				case XMLStreamConstants.START_ELEMENT:
					StartElement startElement = event.asStartElement();
					String qName = startElement.getName().getLocalPart();
					if (qName.equalsIgnoreCase("student")) {
						System.out.println("Start Element : student");
						Iterator<Attribute> attributes = startElement.getAttributes();
						String rollNo = attributes.next().getValue();
						System.out.println("Roll No : " + rollNo);
					} else if (qName.equalsIgnoreCase("firstname")) {
						bFirstName = true;
					} else if (qName.equalsIgnoreCase("lastname")) {
						bLastName = true;
					} else if (qName.equalsIgnoreCase("nickname")) {
						bNickName = true;
					} else if (qName.equalsIgnoreCase("marks")) {
						bMarks = true;
					}
					break;
				case XMLStreamConstants.CHARACTERS:
					Characters characters = event.asCharacters();
					if (bFirstName) {
						System.out.println("First Name: " + characters.getData());
						bFirstName = false;
					}
					if (bLastName) {
						System.out.println("Last Name: " + characters.getData());
						bLastName = false;
					}
					if (bNickName) {
						System.out.println("Nick Name: " + characters.getData());
						bNickName = false;
					}
					if (bMarks) {
						System.out.println("Marks: " + characters.getData());
						bMarks = false;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equalsIgnoreCase("student")) {
						System.out.println("End Element : student");
						System.out.println();
					}
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}
}