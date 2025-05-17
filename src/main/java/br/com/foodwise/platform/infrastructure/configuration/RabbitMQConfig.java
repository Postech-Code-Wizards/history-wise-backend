package br.com.foodwise.platform.infrastructure.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "history";
    public static final String HISTORY_NEW_QUEUE = "history-new-queue";
    public static final String HISTORY_UPDATE_QUEUE = "history-update-queue";
    public static final String ROUTING_KEY_NEW = "history.new";
    public static final String ROUTING_KEY_UPDATE = "history.update";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue historyQueue() {
        return new Queue(HISTORY_NEW_QUEUE, true);
    }

    @Bean
    public Queue historyUpdateQueue() {
        return new Queue(HISTORY_UPDATE_QUEUE, true);
    }

    @Bean
    public Binding historyBinding(Queue historyQueue, DirectExchange exchange) {
        return BindingBuilder.bind(historyQueue).to(exchange).with(ROUTING_KEY_NEW);
    }

    @Bean
    public Binding historyUpdateBinding(Queue historyUpdateQueue, DirectExchange exchange) {
        return BindingBuilder.bind(historyUpdateQueue).to(exchange).with(ROUTING_KEY_UPDATE);
    }

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}
