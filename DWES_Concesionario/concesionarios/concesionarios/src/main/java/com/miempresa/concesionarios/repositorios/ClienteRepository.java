package com.miempresa.concesionarios.repositorios;

import com.miempresa.concesionarios.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByNif(String nif);
    boolean existsByNif(String nif);
}

