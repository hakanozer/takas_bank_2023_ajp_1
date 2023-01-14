package com.works;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductRestController {

    @Value("${spring.datasource.url}")
    private String dataUrl;

    final DiscoveryClient discoveryClient;
    public ProductRestController(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @GetMapping("/product")
    public Map product() {

        List<ServiceInstance> ls = discoveryClient.getInstances("customer");
        ServiceInstance instance = ls.get(0);
        String  url = instance.getUri().toString();
        url = url + "/single";
        RestTemplate restTemplate = new RestTemplate();
        String stData = restTemplate.getForObject(url,  String.class );

        int i = 1 / 0;
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("productID", "100");
        hm.put("url", url );
        hm.put("customer", stData);
        hm.put("dataUrl", dataUrl);
        return hm;
    }

}
