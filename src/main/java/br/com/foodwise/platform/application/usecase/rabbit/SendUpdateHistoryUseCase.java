package br.com.foodwise.platform.application.usecase.rabbit;

import br.com.foodwise.platform.infrastructure.configuration.RabbitMQConfig;
import br.com.foodwise.platform.infrastructure.graphql.dtos.request.PreviousConsultationsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class SendUpdateHistoryUseCase {

    private final RabbitTemplate rabbitTemplate;

    public void execute(PreviousConsultationsRequest previousConsultations) {

        log.info("Sending update history usecase {}",  previousConsultations.getId());
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.ROUTING_KEY_UPDATE, previousConsultations);
    }
}
