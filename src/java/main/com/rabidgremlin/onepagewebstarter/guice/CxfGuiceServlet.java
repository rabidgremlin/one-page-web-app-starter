package com.rabidgremlin.onepagewebstarter.guice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxrs.servlet.CXFNonSpringJaxrsServlet;

import com.google.inject.Injector;

@Singleton
public class CxfGuiceServlet extends CXFNonSpringJaxrsServlet {

	
	@Override
	protected Map<Class<?>, ResourceProvider> getResourceProviders(
			ServletConfig servletConfig,
			Map<Class<?>, Map<String, List<String>>> resourceClasses)
			throws ServletException {
		Injector injector = (Injector) servletConfig.getServletContext()
				.getAttribute(Injector.class.getName());

		Map<Class<?>, ResourceProvider> providers = new HashMap<Class<?>, ResourceProvider>();
		for (Map.Entry<Class<?>, Map<String, List<String>>> entry : resourceClasses
				.entrySet()) {
			Class<?> cls = entry.getKey();
			providers.put(cls,
					new SingletonResourceProvider(injector.getInstance(cls)));
		}

		return providers;
	}

	
	@Override
	protected List<Object> getProviders(ServletConfig servletConfig,
			String splitChar) throws ServletException {
		List<Object> providers = new ArrayList<Object>();

		String providersList = servletConfig
				.getInitParameter("jaxrs.providers");
		if (providersList == null) {
			return providers;
		}

		Injector injector = (Injector) servletConfig.getServletContext()
				.getAttribute(Injector.class.getName());

		String[] classNames = StringUtils.split(providersList, splitChar);
		for (String cName : classNames) {
			Class<?> cls = loadClass(StringUtils.strip(cName));
			providers.add(injector.getInstance(cls));
		}

		return providers;
	}

}
