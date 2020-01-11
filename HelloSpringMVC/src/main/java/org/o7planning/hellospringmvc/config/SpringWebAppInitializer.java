package org.o7planning.hellospringmvc.config;
 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
public class SpringWebAppInitializer implements WebApplicationInitializer {
 
    public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);

		// Dispatcher Servlet
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
				new DispatcherServlet(appContext));
		
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");       
    }
 
}