package ru.slobevg.model;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;

import ru.slobevg.model.User;

import static org.junit.Assert.*;

public class UserTest {

	@Test
	public void testMarshal() {
		User user = new User();
		user.setId(100);
		user.setName("slobevg");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			StringWriter sw = new StringWriter();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false);
			jaxbMarshaller.marshal(user, sw);
			
			assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><user id=\"100\"><name>slobevg</name></user>", sw.toString());
		} catch (JAXBException e) {
			fail("JAXBException has been thrown");
		}
	}

}
