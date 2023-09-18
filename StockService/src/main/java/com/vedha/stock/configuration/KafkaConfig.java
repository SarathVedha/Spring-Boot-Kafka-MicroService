package com.vedha.stock.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    @Value("${kafka.topic.json.email.name}")
    private String emailTopicName;

    @Bean
    NewTopic initializeEmailTopic() {

        return TopicBuilder.name(emailTopicName).build();
    }
}
