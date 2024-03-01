package com.miempresa.concesionarios.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.miempresa.concesionarios.entidades.Cliente;
import com.miempresa.concesionarios.servicio.ClienteServicio;

import java.util.*;

@RestController
@RequestMapping("/clients")
public class ControladorCliente {

    @Autowired
    private ClienteServicio clienteServicio;

    // Listar todos los clientes
    @GetMapping
    public List<Cliente> listarClientes() {
        return clienteServicio.listarTodosLosClientes();
    }

    // Obtener un cliente por NIF
    @GetMapping("/{nif}")
    public ResponseEntity<Cliente> obtenerClientePorNif(@PathVariable String nif) {
        try {
            Cliente cliente = clienteServicio.obtenerClientePorNif(nif);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Borrar un cliente por NIF
    @DeleteMapping("/{nif}")
    public ResponseEntity<?> borrarCliente(@PathVariable String nif) {
        try {
            clienteServicio.borrarClientePorNif(nif);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<?> crearCliente(@RequestBody Cliente cliente) {
        try {
            Cliente nuevoCliente = clienteServicio.crearCliente(cliente);
            return new ResponseEntity<>(nuevoCliente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Actualizar un cliente
    @PutMapping
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente) {
        try {
            Cliente clienteActualizado = clienteServicio.actualizarCliente(cliente.getId(), cliente);
            return new ResponseEntity<>(clienteActualizado, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Solicitar prueba de vehículo
    @PostMapping("/{clienteId}/{vehiculoId}/{dia}/{mes}/{anio}/{hora}/{minuto}")
    public ResponseEntity<?> solicitarPrueba(@PathVariable Long clienteId, @PathVariable Long vehiculoId,
                                             @PathVariable int dia, @PathVariable int mes, @PathVariable int anio,
                                             @PathVariable int hora, @PathVariable int minuto) {
        String fechaHoraString = String.format("%d-%02d-%02d %02d:%02d:00", anio, mes, dia, hora, minuto);
        try {
            clienteServicio.solicitarPrueba(clienteId.toString(), vehiculoId, fechaHoraString);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Marcar prueba de vehículo como realizada
    @PutMapping("/{clienteId}/{vehiculoId}/{dia}/{mes}/{anio}/{hora}/{minuto}")
    public ResponseEntity<?> realizarPrueba(@PathVariable Long clienteId, @PathVariable Long vehiculoId,
                                            @PathVariable int dia, @PathVariable int mes, @PathVariable int anio,
                                            @PathVariable int hora, @PathVariable int minuto) {
        String fechaHoraString = String.format("%d-%02d-%02d %02d:%02d:00", anio, mes, dia, hora, minuto);
        try {
            clienteServicio.realizarPrueba(clienteId.toString(), vehiculoId, fechaHoraString);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}


//package com.miempresa.concesionarios.controladores;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
//
//import com.miempresa.concesionarios.entidades.Cliente;
//import com.miempresa.concesionarios.servicio.ClienteServicio;
//
//import java.net.URI;
//import java.util.List;
//
//@RestController
//@RequestMapping("/clients")
//public class ControladorCliente {
//
//    @Autowired
//    private ClienteServicio clienteServicio;
//
//    // Obtener todos los clientes
//    @GetMapping
//    public ResponseEntity<List<Cliente>> obtenerTodosLosClientes() {
//        return ResponseEntity.ok(clienteServicio.listarTodosLosClientes());
//    }
//
//    // Obtener un cliente por NIF
//    @GetMapping("/{nif}")
//    public ResponseEntity<Cliente> obtenerClientePorNif(@PathVariable String nif) {
//        return ResponseEntity.ok(clienteServicio.obtenerClientePorNif(nif));
//    }
//
//    @DeleteMapping("/{variableNIF}")
//    public ResponseEntity<Void> borrarClientePorNif(@PathVariable String nif) {
//        clienteServicio.borrarClientePorNif(nif);
//        return ResponseEntity.noContent().build();
//    }
//
//    // Crear un nuevo cliente
//    @PostMapping
//    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
//        Cliente nuevoCliente = clienteServicio.crearCliente(cliente);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                          .path("/{id}")
//                          .buildAndExpand(nuevoCliente.getId())
//                          .toUri();
//        return ResponseEntity.created(location).body(nuevoCliente);
//    }
//
//    // Actualizar un cliente existente
//    @PutMapping("/{variableNif}")
//    public ResponseEntity<Void> actualizarCliente(@RequestBody Cliente cliente) {
//        ClienteServicio.clienteActualizado(cliente.getId(), cliente);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
//    // Solicitar una prueba de vehículo
//    @PostMapping("/{idCliente}/{idVehiculo}/{dia}/{mes}/{año}/{hora}/{minuto}")
//    public ResponseEntity<Void> solicitarPrueba(
//            @PathVariable Long idCliente,
//            @PathVariable Long idVehiculo,
//            @PathVariable int dia,
//            @PathVariable int mes,
//            @PathVariable int año,
//            @PathVariable int hora,
//            @PathVariable int minuto) {
//        return ResponseEntity.ok().build();
//    }
//
//    // Marcar una prueba de vehículo como realizada
//    @PutMapping("/{idCliente}/{idVehiculo}/{dia}/{mes}/{año}/{hora}/{minuto}")
//    public ResponseEntity<Void> realizarPrueba(
//            @PathVariable Long idCliente,
//            @PathVariable Long idVehiculo,
//            @PathVariable int dia,
//            @PathVariable int mes,
//            @PathVariable int año,
//            @PathVariable int hora,
//            @PathVariable int minuto) {
//        return ResponseEntity.ok().build();
//    }
//}
