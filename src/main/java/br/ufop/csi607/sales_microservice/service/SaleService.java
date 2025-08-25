package br.ufop.csi607.sales_microservice.service;

import br.ufop.csi607.sales_microservice.model.Consumer;
import br.ufop.csi607.sales_microservice.model.Event;
import br.ufop.csi607.sales_microservice.model.Sale;
import br.ufop.csi607.sales_microservice.repository.ConsumerRepository;
import br.ufop.csi607.sales_microservice.repository.EventRepository;
import br.ufop.csi607.sales_microservice.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private ConsumerRepository consumerRepository;

    public Sale createSale(Sale sale) {
        UUID eventId = sale.getEvent().getId();
        UUID consumerId = sale.getConsumer().getId();

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar venda: Evento com ID " + eventId + " não encontrado."));

        Consumer consumer = consumerRepository.findById(consumerId)
                .orElseThrow(() -> new RuntimeException("Erro ao criar venda: Consumidor com ID " + consumerId + " não encontrado."));

        return saleRepository.save(sale);
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Optional<Sale> getSaleById(UUID id) {
        return saleRepository.findById(id);
    }

    public Sale updateSale(UUID id, Sale saleDetails) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com o id: " + id));

        sale.setSaleStatus(saleDetails.getSaleStatus());

        return saleRepository.save(sale);
    }

    public void deleteSale(UUID id) {
        Sale sale = saleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com o id: " + id));

        saleRepository.delete(sale);
    }
}
