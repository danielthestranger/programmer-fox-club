package com.greenfoxacademy.programmerfoxclub.utils;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class UriUtil {
    public static String getFullUriQueryFromRequest(HttpServletRequest request) {
        String requestMethod = request.getMethod();
        switch (requestMethod) {
            case "GET":
                return queryFromRequestUri(request);
            case "POST":
                return queryFromPostRequestParams(request);
            default:
                throw new NotImplementedException();
        }
    }

    private static String queryFromRequestUri(HttpServletRequest request) {
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

    private static String queryFromPostRequestParams(HttpServletRequest request) {
        return queryFromRequestParamMap(request);
    }

    private static String queryFromRequestParamMap(HttpServletRequest request) {
        Map<String, String[]> requestParamMap = request.getParameterMap();
        UriComponents uriComponents =
                UriComponentsBuilder.newInstance()
                        .queryParams(multiValueMapFromRequestParamMap(requestParamMap))
                        .build();
        return uriComponents.toString();
    }

    private static MultiValueMap<String, String> multiValueMapFromRequestParamMap(
                                                    Map<String, String[]> requestParamMap) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
        for (Map.Entry<String, String[]> entry : requestParamMap.entrySet()) {
            for (String value : entry.getValue()) {
                params.add(entry.getKey(), value);
            }
        }
        return params;
    }
}
