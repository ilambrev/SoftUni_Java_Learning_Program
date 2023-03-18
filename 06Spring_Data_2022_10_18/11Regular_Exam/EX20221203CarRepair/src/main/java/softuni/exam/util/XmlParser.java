package softuni.exam.util;

import javax.xml.bind.JAXBException;

public interface XmlParser {

    <T> T parseXML(Class<T> objectClass, String fileContent) throws JAXBException;

}