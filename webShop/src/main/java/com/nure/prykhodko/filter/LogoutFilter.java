package com.nure.prykhodko.filter;

import static com.nure.prykhodko.constants.ApplicationConstants.HOME_URL;
import static com.nure.prykhodko.constants.ApplicationConstants.USER_LOGIN;
import static com.nure.prykhodko.constants.LoggerMessagesConstants.INFO_LOGOUT_FILTER_DESTROY;
import static com.nure.prykhodko.constants.LoggerMessagesConstants.INFO_LOGOUT_FILTER_INIT;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

public class LogoutFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(LogoutFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletRequest.getSession().removeAttribute(USER_LOGIN);
        httpServletResponse.sendRedirect(HOME_URL);
    }

    @Override
    public void init(FilterConfig filterConfig) {
        LOGGER.info(INFO_LOGOUT_FILTER_INIT);
    }

    @Override
    public void destroy() {
        LOGGER.info(INFO_LOGOUT_FILTER_DESTROY);
    }
}
