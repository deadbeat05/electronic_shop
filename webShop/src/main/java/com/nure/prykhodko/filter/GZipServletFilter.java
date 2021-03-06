package com.nure.prykhodko.filter;

import com.nure.prykhodko.wrapper.GZipServletResponseWrapper;
import com.nure.prykhodko.constants.ApplicationConstants;
import com.nure.prykhodko.constants.LoggerMessagesConstants;
import java.io.IOException;
import java.util.Objects;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class GZipServletFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(GZipServletFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info(LoggerMessagesConstants.INFO_GZIP_FILTER_INIT);
    }

    @Override
    public void destroy() {
        LOGGER.info(LoggerMessagesConstants.INFO_GZIP_FILTER_DESTROY);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (acceptsGZipEncoding(httpRequest)) {
            GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(httpResponse);

            gzipResponse.addHeader(ApplicationConstants.CONTENT_ENCODING, ApplicationConstants.GZIP);
            chain.doFilter(request, gzipResponse);
            gzipResponse.close();

            return;
        }

        chain.doFilter(request, response);
    }

    private boolean acceptsGZipEncoding(HttpServletRequest httpRequest) {
        String acceptEncoding = httpRequest.getHeader(ApplicationConstants.ACCEPT_ENCODING);
        return Objects.nonNull(acceptEncoding) && acceptEncoding.contains(ApplicationConstants.GZIP);
    }
}
