package com.torrefactora.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuración de CORS para la aplicación.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

    /**
     * Configura las políticas de CORS para permitir solicitudes desde cualquier origen
     * y con cualquier método HTTP.
     *
     * @param registry el registro de CORS utilizado para aplicar la configuración.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
    }
}
