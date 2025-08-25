package br.ufop.csi607.sales_microservice.service;

import br.ufop.csi607.sales_microservice.model.Consumer;
import br.ufop.csi607.sales_microservice.repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository consumerRepository;

    public Consumer createConsumer(Consumer consumer) {
        Optional<Consumer> existingConsumer = consumerRepository.findByCpf(consumer.getCpf());
        if (existingConsumer.isPresent()) {
            throw new RuntimeException("CPF já cadastrado no sistema.");
        }

        return consumerRepository.save(consumer);
    }

    public List<Consumer> getAllConsumers() {
        return consumerRepository.findAll();
    }

    public Optional<Consumer> getConsumerById(UUID id) {
        return consumerRepository.findById(id);
    }

    public Consumer updateConsumer(UUID id, Consumer consumerDetails) {
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));

        consumer.setName(consumerDetails.getName());
        consumer.setCpf(consumerDetails.getCpf());
        consumer.setGender(consumerDetails.getGender());

        return consumerRepository.save(consumer);
    }

    public void deleteConsumer(UUID id) {
        Consumer consumer = consumerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com o id: " + id));

        consumerRepository.delete(consumer);
    }
}