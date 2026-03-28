package com.hms.hospital_management.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    /**
     * ModelMapper Bean for DTO ↔ Entity conversion
     */
    @Bean
    public ModelMapper modelMapper() {

        ModelMapper mapper = new ModelMapper();

        // 🔥 Strict mapping (best practice)
        mapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT)
                .setSkipNullEnabled(true) // prevents null overwrite (PATCH safe)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        return mapper;
    }
}
