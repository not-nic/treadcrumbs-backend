package uk.notnic.fsdashboard.service;

import org.dom4j.DocumentException;

import javax.xml.bind.JAXBException;

public abstract interface ServiceHelper {

    default void createEntityFromXML(String filepath) throws DocumentException, JAXBException {
        System.out.println(filepath);
    }

    default void createEntityFromXMLs(String... filenames) throws JAXBException {
        System.out.println(filenames);
    };

}
