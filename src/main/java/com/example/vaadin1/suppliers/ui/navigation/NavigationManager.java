package com.example.vaadin1.suppliers.ui.navigation;

import com.example.vaadin1.suppliers.app.security.SecurityUtils;
import com.example.vaadin1.suppliers.backend.Role;
import com.example.vaadin1.suppliers.ui.views.AdminView;
import com.example.vaadin1.suppliers.ui.views.GuestView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.internal.Conventions;
import com.vaadin.spring.navigator.SpringNavigator;
import org.springframework.stereotype.Component;

/**
 * Governs ui navigation of the app.
 */
@Component
@UIScope
public class NavigationManager extends SpringNavigator {

	/**
	 * Find the ui id (URI fragment) used for a given ui class.
	 *
	 * @param viewClass
	 *            the ui class to find the id for
	 * @return the URI fragment for the ui
	 */
	public String getViewId(Class<? extends View> viewClass) {
		SpringView springView = viewClass.getAnnotation(SpringView.class);
		if (springView == null) {
			throw new IllegalArgumentException("The target class must be a @SpringView");
		}

		return Conventions.deriveMappingForView(viewClass, springView);
	}

	/**
	 * Navigate to the given ui class.
	 *
	 * @param targetView
	 *            the class of the target ui, must be annotated using
	 *            {@link SpringView @SpringView}
	 */
	public void navigateTo(Class<? extends View> targetView) {
		String viewId = getViewId(targetView);
		navigateTo(viewId);
	}

	public void navigateTo(Class<? extends View> targetView, Object parameter) {
		String viewId = getViewId(targetView);
		navigateTo(viewId + "/" + parameter.toString());
	}

	public void navigateToDefaultView() {
		// If the user wants a specific ui, it's in the URL.
		// Otherwise admin goes to AdminView and everybody else to
		// GuestView
		if (!getState().isEmpty()) {
			return;
		}

		navigateTo(SecurityUtils.isCurrentUserInRole(Role.ADMIN) ? AdminView.class : GuestView.class);
	}

	/**
	 * Update the parameter of the the current ui without firing any
	 * navigation events.
	 *
	 * @param parameter
	 *            the new parameter to set, never <code>null</code>,
	 *            <code>""</code> to not use any parameter
	 */
	public void updateViewParameter(String parameter) {
		String viewName = getViewId(getCurrentView().getClass());
		String parameters;
		if (parameter == null) {
			parameters = "";
		} else {
			parameters = parameter;
		}

		updateNavigationState(new ViewChangeEvent(this, getCurrentView(), getCurrentView(), viewName, parameters));
	}

}
