package br.ufop.csi607.sales_microservice.repository;

import br.ufop.csi607.sales_microservice.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, UUID> {
    Optional<Consumer> findByCpf(String cpf);
}
