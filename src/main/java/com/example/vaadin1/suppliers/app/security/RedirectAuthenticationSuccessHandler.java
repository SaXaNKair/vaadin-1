package com.example.vaadin1.suppliers.app.security;

import com.example.vaadin1.suppliers.app.Application;
import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Redirects to the application after successful authentication.
 */
@SpringComponent
@ApplicationScope
public class RedirectAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private final String location;

	@Autowired
	private ServletContext servletContext;

	public RedirectAuthenticationSuccessHandler() {
		location = Application.APP_URL;
	}

	private String getAbsoluteUrl(String url) {
		final String relativeUrl;
		if (url.startsWith("/")) {
			relativeUrl = url.substring(1);
		} else {
			relativeUrl = url;
		}
		return servletContext.getContextPath() + "/" + relativeUrl;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
		response.sendRedirect(getAbsoluteUrl(location));

	}

}