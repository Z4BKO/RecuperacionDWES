package com.miempresa.concesionarios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miempresa.concesionarios.entidades.Concesionario;

public interface ConcesionarioRepository extends JpaRepository<Concesionario, Long> {
}
