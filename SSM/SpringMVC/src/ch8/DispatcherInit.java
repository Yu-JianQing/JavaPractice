package ch8;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherInit extends AbstractAnnotationConfigDispatcherServletInitializer{

	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{WholeConfig.class};
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{MVCConfig.class};
	}

	protected String[] getServletMappings() {
		return new String[]{"/"};
	}

}
