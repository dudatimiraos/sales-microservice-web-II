package br.ufop.csi607.sales_microservice.service;

import br.ufop.csi607.sales_microservice.model.Event;
import br.ufop.csi607.sales_microservice.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Optional<Event> getEventById(UUID id) {
        return eventRepository.findById(id);
    }

    public Event updateEvent(UUID id, Event eventDetails) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com o id: " + id));

        event.setDescription(eventDetails.getDescription());
        event.setType(eventDetails.getType());
        event.setDate(eventDetails.getDate());
        event.setStartSales(eventDetails.getStartSales());
        event.setEndSales(eventDetails.getEndSales());
        event.setPrice(eventDetails.getPrice());

        return eventRepository.save(event);
    }

    public void deleteEvent(UUID id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento não encontrado com o id: " + id));

        eventRepository.delete(event);
    }
}
