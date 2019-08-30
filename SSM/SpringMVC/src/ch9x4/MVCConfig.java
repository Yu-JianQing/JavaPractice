package ch9x4;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan
@EnableWebMvc
public class MVCConfig extends WebMvcConfigurationSupport{
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/ch9x4/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}

	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor interceptor=new LocaleChangeInterceptor();
		registry.addInterceptor(interceptor);
		super.addInterceptors(registry);
	}
	
	@Bean
	public LocaleResolver resolver(){
		SessionLocaleResolver localeResolver=new SessionLocaleResolver();
		localeResolver.setDefaultLocale(Locale.getDefault());
		return localeResolver;
	}
	
	@Bean
	public ReloadableResourceBundleMessageSource bundleMessageSource(){
		ReloadableResourceBundleMessageSource bdleMsg=new ReloadableResourceBundleMessageSource();
		bdleMsg.addBasenames("classpath:/ch9x4/msg");
		return bdleMsg;
	}
	
}
