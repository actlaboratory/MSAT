package org.actlab.msat.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
public class ThymeleafConfig {
    @Primary
    @Bean
    public SpringTemplateEngine pageTemplateEngine() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode( TemplateMode.HTML );
        resolver.setPrefix( "templates/" );
        resolver.setSuffix( ".html" );
        resolver.setCharacterEncoding( "UTF-8" );
        resolver.setCheckExistence(true);
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver( resolver );
        return engine;
    }

    @Bean("messageTemplateEngine") // ⑧
    public SpringTemplateEngine messageTemplateEngine() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setTemplateMode( TemplateMode.TEXT );
        resolver.setPrefix( "configfiles/" );
        resolver.setSuffix( ".txt");
        resolver.setCharacterEncoding( "UTF-8" );
        resolver.setCacheable( true );
        var engine = new SpringTemplateEngine();
        engine.setTemplateResolver( resolver );
        return engine;
    }    
}
