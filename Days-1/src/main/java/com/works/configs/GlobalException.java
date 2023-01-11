package com.works.configs;

import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity methodArgumentNotValid(MethodArgumentNotValidException ex) {
        List ls = parseError(ex.getFieldErrors());
        Map<REnum, Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status, false);
        hm.put(REnum.errors, ls);
        return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }


    private List parseError(List<FieldError> errors) {
        List ls = new ArrayList();
        for( FieldError error : errors ) {
            Map<String, String> hm = new HashMap<>();
            hm.put("field", error.getField());
            hm.put("defaultMessage", error.getDefaultMessage());
            ls.add(hm);
        }
        return ls;
    }

}
