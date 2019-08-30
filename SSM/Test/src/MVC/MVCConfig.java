package MVC;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
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
@EnableWebMvc
@ComponentScan(basePackages={"Test","Service","MVC"})
public class MVCConfig extends WebMvcConfigurationSupport{
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/shopping/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setExposeContextBeansAsAttributes(true);
		return viewResolver;
	}

	@Override
	protected void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
		messageSource.setBasename("Resource/msg");
		return messageSource;
	}
	
	@Bean
	public LocaleResolver localeResolver(){
		SessionLocaleResolver resolver=new SessionLocaleResolver();
		resolver.setDefaultLocale(Locale.getDefault());
		return resolver;
	}
	
	@Bean//配置文件上传解析器
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(1000000);
		return resolver;
	}

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		LocaleChangeInterceptor changeInterceptor=new LocaleChangeInterceptor();
		changeInterceptor.setParamName("locale");
		registry.addInterceptor(changeInterceptor);
		super.addInterceptors(registry);
	}
	
	
}
