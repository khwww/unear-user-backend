/*
package com.unear.userservice.notification.redis;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;

import jakarta.annotation.PostConstruct;
import java.util.Map;

@Configuration
public class RedisStreamConfig {

    private static final Logger log = LoggerFactory.getLogger(RedisStreamConfig.class);

    @Autowired
    private RedisConnectionFactory connectionFactory;

    @Bean
    public StreamMessageListenerContainer<String, MapRecord<String, String, String>> streamContainer(
            RedisConnectionFactory connectionFactory) {
        return StreamMessageListenerContainer.create(connectionFactory);
    }

    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        mapper.configure(JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);

        return mapper;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(new GenericJackson2JsonRedisSerializer());
        return template;
    }

    @PostConstruct
    public void initializeStreams() {
        log.info("Initializing Redis Stream Consumer Groups...");

        createConsumerGroup("pos-notification-stream", "notification-consumer-group");

        log.info("Redis Stream Consumer Groups initialization completed");
    }

    private void createConsumerGroup(String streamName, String groupName) {
        try {
            RedisTemplate<String, Object> template = redisTemplate(connectionFactory);
            template.opsForStream().createGroup(streamName, groupName);
            log.info("Created consumer group: {} for stream: {}", groupName, streamName);
        } catch (Exception e) {
            log.warn("Consumer group creation failed (might already exist): {} for stream: {}", groupName, streamName);
        }
    }
}
*/