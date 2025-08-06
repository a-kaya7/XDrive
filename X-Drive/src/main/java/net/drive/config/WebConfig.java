package net.drive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	 // Dosya uzantısı olmayan her şeyi index.html'e yönlendir
        registry.addViewController("/{path:[^\\.]+}")
                .setViewName("forward:/index.html");
        
        registry.addViewController("/**/{path:[^\\.]+}")
                .setViewName("forward:/index.html");
    }
    
    
   
     @Override
     public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**")
            .allowedOrigins("http://localhost:3000")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);
        
     
    }
}
