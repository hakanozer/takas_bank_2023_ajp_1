package CreateReadXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreateXml {

    public void create() {

        try {
            Result result = new Result();
            Products products = new Products();
            products.setProducts(result.data());

            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("products.xml");
            marshaller.marshal( products, file );

        }catch (Exception ex) {
            System.err.println("Xml Create Error : " + ex);
        }

    }

}
