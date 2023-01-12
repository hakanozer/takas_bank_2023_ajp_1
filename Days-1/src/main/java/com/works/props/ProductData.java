
package com.works.props;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class ProductData {

    private List<Product> products = null;
    private Integer total;
    private Integer skip;
    private Integer limit;

}
