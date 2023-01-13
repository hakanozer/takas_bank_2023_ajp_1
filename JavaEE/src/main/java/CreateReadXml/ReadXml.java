package CreateReadXml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ReadXml {

    public void read(){
        try {

            File file = new File("products.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Products products = (Products) unmarshaller.unmarshal(file);
            for (Product item : products.getProducts()) {
                System.out.println(item.getTitle());
            }
        }catch (Exception ex) {
            System.err.println("Read Xml Error : " + ex);
        }
    }

}
