package com.greenfoxacademy.programmerfoxclub.utils;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
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

    public static String queryFromRequestUri(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        String query = request.getQueryString();
        if (StringUtils.hasText(query)) {
            // Extract anchor fragment, if any.
            String fragment = null;
            int anchorIndex = builder.indexOf("#");
            if (anchorIndex > -1) {
                fragment = builder.substring(anchorIndex);
                builder.delete(anchorIndex, builder.length());
            }

            if (builder.toString().indexOf('?') < 0) {
                builder.append('?').append(query);
            }
            else {
                builder.append('&').append(query);
            }
            // Append anchor fragment, if any, to end of URL.
            if (fragment != null) {
                builder.append(fragment);
            }
        }
        return builder.toString();
    }

}
