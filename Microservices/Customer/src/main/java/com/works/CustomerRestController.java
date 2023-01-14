package com.works;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class CustomerRestController {

    @GetMapping("/single")
    public Map single() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", "Ali Bilmem");
        return hm;
    }

}
