//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
//import org.thymeleaf.spring4.view.ThymeleafViewResolver;
//
//@Configuration
//public class ThymeleafConfig {
//
//    @Bean
//    public ViewResolver viewResolver() {
//        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//        resolver.setTemplateEngine(templateEngine());
//        return resolver;
//    }
//
//    @Bean
//    public TemplateEngine templateEngine() {
//        SpringTemplateEngine engine = new SpringTemplateEngine();
//        engine.setTemplateResolver(templateResolver());
//        return engine;
//    }
//
//    @Bean
//    public ServletContextTemplateResolver templateResolver() {
//        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
//        resolver.setPrefix("/WEB-INF/templates/"); // Localização dos templates Thymeleaf
//        resolver.setSuffix(".html");
//        resolver.setTemplateMode("HTML");
//        return resolver;
//    }
//}
