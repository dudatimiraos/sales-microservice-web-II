package br.ufop.csi607.sales_microservice.repository;

import java.util.UUID;

import br.ufop.csi607.sales_microservice.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, UUID> {
}
