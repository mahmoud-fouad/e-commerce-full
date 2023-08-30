package com.mfouad.configurations;

import org.springframework.context.annotation.Bean;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "topic")
@Getter
@Setter
public class KafkaConfiguration {
	
	String name;
	int partitions;
	
	
	@Bean
	public NewTopic productsCategoriesTopic(){

		return  TopicBuilder.name(name)
		.partitions(partitions).build();
	}
	
	 
}
