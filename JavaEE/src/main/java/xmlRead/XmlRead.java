package xmlRead;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class XmlRead {

    public List<Currency> xml() {
        List<Currency> ls = new ArrayList<>();
       try {

           String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
           String stData = Jsoup.connect(url).timeout(15000).ignoreContentType(true).get().toString();
           Document document = Jsoup.parse(stData, Parser.xmlParser());
           Elements elements = document.getElementsByTag("Currency");
            for(Element item : elements) {
                String currencyName = item.getElementsByTag("CurrencyName").text();
                String forexBuying = item.getElementsByTag("ForexBuying").text();
                String forexSelling = item.getElementsByTag("ForexSelling").text();
                Currency currency = new Currency(currencyName, forexBuying, forexSelling);
                ls.add(currency);
            }
       }catch (Exception ex) {
           System.err.println("Error Xml : " + ex);
       }
       return ls;
    }

}
