package cova.rar.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(value = {"cova.rar.controller", "cova.rar.rest.controller"})
public class ServletConfig implements WebMvcConfigurer {
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// adds suffix and prefix "/WEB-INF/" + ".jsp"
		// resolves the view and points tomcat to the right location
		registry.jsp("WEB-INF/view/", ".jsp");
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
		  .addResourceLocations("/WEB-INF/resources/");

    }
	
	
}
