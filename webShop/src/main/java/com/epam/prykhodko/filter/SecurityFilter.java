package com.epam.prykhodko.filter;

import static com.epam.prykhodko.constants.ApplicationConstants.PREVIOUS_URL;
import static com.epam.prykhodko.constants.ApplicationConstants.USER_LOGIN;
import static com.epam.prykhodko.constants.ApplicationConstants.USER_SERVICE;
import static com.epam.prykhodko.constants.LoggerMessagesConstants.INFO_SECURITY_FILTER_DESTROY;

import com.epam.prykhodko.entity.User;
import com.epam.prykhodko.exception.NoAccessRightsException;
import com.epam.prykhodko.exception.NoUserLoginException;
import com.epam.prykhodko.mananger.AccessManager;
import com.epam.prykhodko.service.UserService;
import com.epam.prykhodko.util.XMLParser;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

public class SecurityFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(SecurityFilter.class);
    private Map<String, List<String>> urlMap;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = ((HttpServletRequest) request).getSession();
        ServletContext servletContext = request.getServletContext();
        String url = httpServletRequest.getRequestURI();

        if (url.matches("^(.+)(\\..+)$")) {
            chain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        String userLogin = (String) session.getAttribute(USER_LOGIN);
        UserService userService = (UserService) servletContext.getAttribute(USER_SERVICE);
        User user = userService.getByLogin(userLogin);
        AccessManager accessManager = new AccessManager(url, urlMap, user);

        try {

            if (accessManager.checkAccess()) {
                chain.doFilter(httpServletRequest, httpServletResponse);
            }
        } catch (NoAccessRightsException noAccessRightsException) {
            httpServletRequest.getRequestDispatcher("jsp/403Error.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (NoUserLoginException e) {
            session.setAttribute(PREVIOUS_URL, url);
            httpServletResponse.sendRedirect("/login");
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        String path = servletContext.getInitParameter("securityFilePath");
        urlMap = XMLParser.securityXMLParse(path);
    }

    @Override
    public void destroy() {
        LOGGER.info(INFO_SECURITY_FILTER_DESTROY);
    }
}
