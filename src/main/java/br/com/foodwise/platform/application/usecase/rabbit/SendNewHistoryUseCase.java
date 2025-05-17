package br.com.foodwise.platform.application.usecase.rabbit;

import br.com.foodwise.platform.infrastructure.configuration.RabbitMQConfig;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendNewHistoryUseCase {

    private final RabbitTemplate rabbitTemplate;

    public void execute(PreviousConsultationsRequest previousConsultations) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_NEW, previousConsultations);
    }
}
