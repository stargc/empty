package com.ehualu.data.common.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    /** 不需要打印入参出参log的方法   */
    private static final List filterList = Arrays.asList("/census/actuator/health");

    private static final String REQUEST_PREFIX = "收到请求: ";
    private static final String RESPONSE_PREFIX = "返回响应: ";
    private AtomicLong id = new AtomicLong(1);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, final FilterChain filterChain) throws ServletException, IOException {
        long requestId = id.incrementAndGet();
        request = new RequestWrapper(requestId, request);
        response = new ResponseWrapper(requestId, response);
        try {
            filterChain.doFilter(request, response);
        } finally {
            if (request.getRequestURI().startsWith("/census/img")) return;
            if(!filterList.contains(request.getRequestURI())){
                logRequest(request);
                logResponse((ResponseWrapper) response,request);
            }
        }

    }

    private void logRequest(final HttpServletRequest request) {
        StringBuilder msg = new StringBuilder();
        msg.append(REQUEST_PREFIX);
        if (request instanceof RequestWrapper) {
            msg.append("request id=").append(((RequestWrapper) request).getId()).append("; ");
        }
        HttpSession session = request.getSession(false);
        if (session != null) {
            msg.append("session id=").append(session.getId()).append("; ");
        }
        if (request.getMethod() != null) {
            msg.append("method=").append(request.getMethod()).append("; ");
        }
        if (request.getContentType() != null) {
            msg.append("content type=").append(request.getContentType()).append("; ");
        }
        msg.append("uri=").append(request.getRequestURI());
        if (request.getQueryString() != null) {
            msg.append('?').append(request.getQueryString());
        }

        if (request instanceof RequestWrapper && !isMultipart(request) && !isBinaryContent(request)) {
            RequestWrapper requestWrapper = (RequestWrapper) request;
            try {
                String charEncoding = requestWrapper.getCharacterEncoding() != null ? requestWrapper.getCharacterEncoding() :
                        "UTF-8";
                msg.append("; payload=").append(new String(requestWrapper.toByteArray(), charEncoding)
                        .replaceAll("\r|\n", "").replaceAll("\t",""));
            } catch (UnsupportedEncodingException e) {
                logger.warn("Failed to parse request payload", e);
            }
            if(isApplicationForm(request)){
                Map map = request.getParameterMap();
                Set<String> set = map.keySet();
                for(String name : set){
                    String[] vals = (String[]) map.get(name);
                    msg.append(name+":");
                    for(String val : vals){
                        msg.append(val+"; ");
                    }
                }
            }

        }
        logger.info(msg.toString());
    }

    private boolean isBinaryContent(final HttpServletRequest request) {
        if (request.getContentType() == null) {
            return false;
        }
        return request.getContentType().startsWith("image") || request.getContentType().startsWith("video") || request.getContentType().startsWith("audio");
    }

    private boolean isMultipart(final HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("multipart/form-data");
    }

    private boolean isBinaryContent(final HttpServletResponse response) {
        if (response.getContentType() == null) {
            return false;
        }
        return response.getContentType().startsWith("image") || response.getContentType().startsWith("video") || response.getContentType().startsWith("audio");
    }

    private boolean isMultipart(final HttpServletResponse response) {
        return response.getContentType() != null && response.getContentType().startsWith("multipart/form-data");
    }

    private boolean isApplicationForm(final HttpServletRequest request) {
        return request.getContentType() != null && request.getContentType().startsWith("application/x-www-form-urlencoded");
    }

    private void logResponse(final ResponseWrapper response, HttpServletRequest request) {

        StringBuilder msg = new StringBuilder();
        msg.append(RESPONSE_PREFIX);
        msg.append("request id=").append((response.getId()));
        try {
            if (request instanceof RequestWrapper && !isMultipart(response) && !isBinaryContent(response)) {
                String charEncoding = response.getCharacterEncoding() != null ? response.getCharacterEncoding() : "UTF-8";
                String requestUri = request.getRequestURI();
                msg.append("; payload=").append(new String(response.toByteArray(), charEncoding)
                        .replaceAll("\r|\n", "").replaceAll("\t",""));
            }
            } catch (UnsupportedEncodingException e) {
            logger.warn("Failed to parse response payload", e);
        }
        logger.info(msg.toString());
    }


}
