package com.platform.booking.theatres.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;

@Configuration
public class JacksonConfiguration implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
        objectMapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationFeature.FAIL_ON_UNWRAPPED_TYPE_IDENTIFIERS, false);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }
}
