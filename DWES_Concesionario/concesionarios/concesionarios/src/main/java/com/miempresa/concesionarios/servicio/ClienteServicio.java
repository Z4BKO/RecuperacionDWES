package com.miempresa.concesionarios.servicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miempresa.concesionarios.entidades.Cliente;
import com.miempresa.concesionarios.entidades.SolicitaPrueba;
import com.miempresa.concesionarios.entidades.Vehiculo;
import com.miempresa.concesionarios.excepciones.ClienteException;
import com.miempresa.concesionarios.excepciones.SolicitaPruebaException;
import com.miempresa.concesionarios.repositorios.ClienteRepository;
import com.miempresa.concesionarios.repositorios.SolicitaPruebaRepository;
import com.miempresa.concesionarios.repositorios.VehiculoRepository;

@Service
public class ClienteServicio {

	private static final Logger logger = LoggerFactory.getLogger(ClienteServicio.class);

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private VehiculoRepository vehiculoRepository;
	@Autowired
	private SolicitaPruebaRepository solicitaPruebaRepository;

	// Listar todos los clientes
	public List<Cliente> listarTodosLosClientes() {
		return clienteRepository.findAll();
	}

	// Obtener un cliente por NIF
	public Cliente obtenerClientePorNif(String nif) throws ClienteException {
		return clienteRepository.findByNif(nif).orElseThrow(() -> new ClienteException("Cliente no encontrado"));
	}

	// Borrar un cliente por NIF
	public void borrarClientePorNif(String nif) throws ClienteException {
		Cliente cliente = clienteRepository.findByNif(nif)
				.orElseThrow(() -> new ClienteException("Cliente con NIF: " + nif + " no encontrado"));

		boolean tienePruebas = false;
		try {
			tienePruebas = solicitaPruebaRepository.existsByCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (tienePruebas) {
			throw new ClienteException("El cliente con NIF: " + nif + " ha Solicitado pruebas y no puede ser borrado.");
		}

		clienteRepository.delete(cliente);
	}

	public Cliente crearCliente(Cliente cliente) throws ClienteException {
		// Verificar si ya existe un cliente con el mismo NIF
		if (clienteRepository.existsByNif(cliente.getNif())) {
			throw new ClienteException("El cliente con NIF " + cliente.getNif() + " ya existe");
		}
		// Si no existe, crear el cliente
		return clienteRepository.save(cliente);
	}

	// Actualizar datos de un cliente
	public Cliente actualizarCliente(Long id, Cliente datosActualizados) throws ClienteException {
		Cliente cliente = clienteRepository.findById(id)
				.orElseThrow(() -> new ClienteException("Cliente no encontrado"));
		cliente.setNombre(datosActualizados.getNombre());
		cliente.setApellidos(datosActualizados.getApellidos());
		cliente.setTelefono(datosActualizados.getTelefono());
		cliente.setEmail(datosActualizados.getEmail());

		return clienteRepository.save(cliente);
	}
	
    public void solicitarPrueba(String clienteNif, Long vehiculoId, String fechaHoraString) {
        Cliente cliente = obtenerClientePorNif(clienteNif);
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                                               .orElseThrow(() -> new SolicitaPruebaException("Vehículo con ID " + vehiculoId + " no encontrado"));

        // Convertir la cadena de fecha y hora a un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaHora;
        try {
            fechaHora = dateFormat.parse(fechaHoraString);
        } catch (ParseException e) {
            throw new SolicitaPruebaException("Formato de fecha y hora inválido: " + fechaHoraString);
        }

        // Crear la solicitud de prueba y guardarla en el repositorio
        SolicitaPrueba solicitud = new SolicitaPrueba();
        solicitud.setCliente(cliente);
        solicitud.setVehiculo(vehiculo);
        solicitud.setFechaHora(fechaHora);
        solicitud.setRealizada(false);
        solicitaPruebaRepository.save(solicitud);
    }

    public void realizarPrueba(String clienteNif, Long vehiculoId, String fechaHoraString) {
        Cliente cliente = obtenerClientePorNif(clienteNif);
        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                                               .orElseThrow(() -> new SolicitaPruebaException("Vehículo con ID " + vehiculoId + " no encontrado"));

        // Convertir la cadena de fecha y hora a un objeto Date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date fechaHoraParsed;
        try {
            fechaHoraParsed = dateFormat.parse(fechaHoraString);
        } catch (ParseException e) {
            throw new SolicitaPruebaException("Formato de fecha y hora inválido: " + fechaHoraString);
        }

        // Buscar la solicitud de prueba existente
        List<SolicitaPrueba> solicitudes = solicitaPruebaRepository.findByCliente_NifAndVehiculoIdAndFechaHora(clienteNif, vehiculoId, fechaHoraParsed);
        if (solicitudes.isEmpty()) {
            throw new SolicitaPruebaException("No se encontró ninguna solicitud de prueba para el cliente con NIF " + clienteNif +
                                              ", vehículo con ID " + vehiculoId + " y fecha y hora " + fechaHoraString);
        }

        // Marcar la primera solicitud de prueba encontrada como realizada
        SolicitaPrueba solicitud = solicitudes.get(0);
        solicitud.setRealizada(true);
        solicitaPruebaRepository.save(solicitud);
    }

	public static void clienteActualizado(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}
}
