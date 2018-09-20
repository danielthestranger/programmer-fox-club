package com.greenfoxacademy.programmerfoxclub.utils;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

public class UriUtil {
    public static String queryFromRequestParamMap(Map<String, String[]> requestParamMap) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        for (Map.Entry<String, String[]> entry : requestParamMap.entrySet()) {
            for (String value : entry.getValue()) {
                params.add(entry.getKey(), value);
            }
        }

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParams(params).build();

        return uriComponents.toString();
    }
}
