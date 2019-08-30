package ch7;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{wholeConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MVCConfig.class};
	}

	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
