package org.example.presentation.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ServletUtils {
    public static String parseRequestBody(HttpServletRequest request) throws IOException {
        return IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
    }
}
