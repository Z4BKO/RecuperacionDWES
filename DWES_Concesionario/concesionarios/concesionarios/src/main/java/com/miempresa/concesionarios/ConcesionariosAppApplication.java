package com.miempresa.concesionarios;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import com.miempresa.concesionarios.servicio.ClienteServicio;
import com.miempresa.concesionarios.entidades.Cliente;
import com.miempresa.concesionarios.repositorios.ClienteRepository;
import com.miempresa.concesionarios.repositorios.VehiculoRepository;
import com.miempresa.concesionarios.entidades.Vehiculo;
import com.miempresa.concesionarios.excepciones.ClienteException;
import com.miempresa.concesionarios.excepciones.SolicitaPruebaException;



import java.util.Date;

@SpringBootApplication
public class ConcesionariosAppApplication {

    @Autowired
    private ClienteServicio clienteServicio;
    
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;


    public static void main(String[] args) {
        SpringApplication.run(ConcesionariosAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runApplication() {
        return args -> {
        	// Crear y guardar un nuevo cliente
            Cliente nuevoCliente = new Cliente("99999998X", "Francisco", "Castro", "654123789", "Fran@example.com", new Date());
            nuevoCliente = clienteServicio.crearCliente(nuevoCliente);
            
            // Ejemplo de cómo crear un vehículo antes de buscarlo
            Vehiculo nuevoVehiculo = new Vehiculo("9G37A876A43313334", "9579-BZC", "Ford", "Focus", 92, 42, 15000.0, 2002);
            nuevoVehiculo = vehiculoRepository.save(nuevoVehiculo);


            // Listar todos los clientes
            System.out.println("Listado de clientes:");
            clienteServicio.listarTodosLosClientes().forEach(System.out::println);

            // Obtener un cliente por NIF
            System.out.println("Obtener cliente por NIF:");
            Cliente cliente = clienteServicio.obtenerClientePorNif(nuevoCliente.getNif());
            System.out.println(cliente);

            // Actualizar datos de un cliente
            cliente.setNombre("Paco");
            cliente.setApellidos("Salas");
            clienteServicio.actualizarCliente(cliente.getId(), cliente);
            System.out.println("Cliente actualizado: " + cliente);

            // Definir clienteId y vehiculoId con valores válidos que existan en la base de datos
            String clienteNif = "12345678D"; // 
            Long vehiculoId = 1L ; 
            String fechaHoraString = "2024-02-21 09:00:00"; 

            // Solicitar una prueba de vehículo
            Cliente clienteEncontrado = clienteRepository.findByNif(clienteNif)
                .orElseThrow(() -> new ClienteException("Cliente no encontrado con ID: " + clienteNif));
            Vehiculo vehiculoEncontrado = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new SolicitaPruebaException("Vehículo no encontrado con ID: " + vehiculoId));

            // Realizar una prueba de vehículo
            clienteServicio.realizarPrueba(clienteNif, vehiculoId, fechaHoraString);
            System.out.println("Prueba de vehículo realizada.");

            // Borrar un cliente por NIF
            clienteServicio.borrarClientePorNif(cliente.getNif());
            System.out.println("Cliente borrado: " + cliente.getNif());
        };
    }
}

