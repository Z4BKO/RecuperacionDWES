package com.miempresa.concesionarios.repositorios;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.miempresa.concesionarios.entidades.Cliente;
import com.miempresa.concesionarios.entidades.SolicitaPrueba;

public interface SolicitaPruebaRepository extends JpaRepository<SolicitaPrueba, Long> {
    	
	 List<SolicitaPrueba> findByCliente_NifAndVehiculoIdAndFechaHora(String clienteNif, Long vehiculoId, Date fechaHoraParsed);

	boolean existsByCliente(Cliente cliente);
	}

