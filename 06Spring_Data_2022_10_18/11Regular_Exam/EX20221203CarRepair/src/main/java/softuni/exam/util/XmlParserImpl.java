package softuni.exam.util;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

@Component
public class XmlParserImpl implements XmlParser {

    @Override
    public <T> T parseXML(Class<T> objectClass, String fileContent) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(objectClass);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader reader = new StringReader(fileContent);

        return (T) unmarshaller.unmarshal(reader);
    }

}