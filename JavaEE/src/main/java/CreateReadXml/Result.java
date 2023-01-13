package CreateReadXml;

import java.util.ArrayList;

public class Result {

    public ArrayList<Product> data() {
        ArrayList<Product> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setPid(i);
            product.setPrice(i * 10);
            product.setTitle("Title: " + i);
            Category category = new Category();
            category.setCid(i+1);
            category.setTitle("Category: " + i);
            product.setCategory(category);
            list.add(product);
        }
        return list;
    }

}
