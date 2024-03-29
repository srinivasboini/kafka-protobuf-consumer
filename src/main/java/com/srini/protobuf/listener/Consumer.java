package com.srini.protobuf.listener;

import com.srini.protobuf.model.Stock;
import com.srini.protobuf.model.Stocks;
import com.srini.protobuf.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.AcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * The type Consumer.
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class Consumer implements AcknowledgingConsumerAwareMessageListener<String,Stock> {

    private final StockRepository stockRepository ;

    @Override
    @KafkaListener(topics = "${app.topic}",  concurrency = "4")
    public void onMessage(ConsumerRecord<String, Stock> record, Acknowledgment acknowledgment, org.apache.kafka.clients.consumer.Consumer<?, ?> consumer) {
        // Process the received message
        log.info(" Received message: {}" ,  record.value());
        Stock stock = record.value();

        stockRepository.save(new Stocks(0,stock.getName(), stock.getIsin(), stock.getVolume())) ;
        // Manually acknowledge the message
        assert acknowledgment != null;
        acknowledgment.acknowledge();
    }

    /**
     * Kafka listener container factory concurrent kafka listener container factory.
     *
     * @param consumerFactory the consumer factory
     * @return the concurrent kafka listener container factory
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
            ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }
}
