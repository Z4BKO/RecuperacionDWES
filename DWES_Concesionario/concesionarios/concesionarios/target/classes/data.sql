-- Insertar datos de clientes
INSERT INTO clientes (nif, nombre, apellidos, telefono, email, fecha_alta) 
VALUES
('12345678D', 'Elena', 'Pérez', '912345678', 'elena@example.com', '2024-01-10 10:23:00'),
('23456789A', 'Javier', 'Gómez', '923456789', 'javier@example.com', '2024-01-11'),
('34567890B', 'Ana', 'López', '934567890', 'ana@example.com', '2024-01-12'),
('45678901C', 'Pedro', 'Sánchez', '945678901', 'pedro@example.com', '2024-01-13'),
('56789012D', 'David', 'Rodríguez', '956789012', 'david@example.com', '2024-01-14'),
('67890123E', 'Laura', 'García', '967890123', 'laura@example.com', '2024-01-15'),
('78901234F', 'Antonio', 'Fernández', '978901234', 'antonio@example.com', '2024-01-16'),
('89012345G', 'Sara', 'Martínez', '989012345', 'sara@example.com', '2024-01-17'),
('90123456H', 'Daniel', 'Gonzalez', '990123456', 'daniel@example.com', '2024-01-18'),
('01234567I', 'María', 'López', '801234567', 'maria@example.com', '2024-01-19'),
('12345678J', 'Carlos', 'Martínez', '812345678', 'carlos@example.com', '2024-01-20')
ON DUPLICATE KEY UPDATE
nombre = VALUES(nombre),
apellidos = VALUES(apellidos),
telefono = VALUES(telefono),
fecha_alta = VALUES(fecha_alta);


-- Datos concesionarios
INSERT INTO concesionarios (nombre, direccion, email, horario, telefono, anio_apertura)
VALUES 
('Automóviles del Sol', 'Paseo Marítimo 112', 'info@autossol.com', 'Martes a Domingo, 11am a 8pm', '3452342345', 2015),
('Carros y Carretas', 'Camino Real 345', 'info@carrosycarretas.com', 'Lunes a Viernes, 8am a 6pm', '6789012345', 1970),
('Velocidad y Estilo', 'Calle del Progreso 234', 'info@veloestilo.com', 'Lunes a Jueves, 9 am a 7pm', '9874567890', 2023),
('Movilidad Futura', 'Plaza de la Tecnología 12', 'info@movilidadfutura.com', 'Lunes a Martes, 12am a 1 pm', '1234567890', 2022),
('Aventuras sobre Ruedas', 'Carretera Nacional 678', 'info@aventuraruedas.com', 'Lunes a Domingo, 12 am a 11 am', '5678901234', 1965)
ON DUPLICATE KEY UPDATE
nombre = VALUES(nombre),
direccion = VALUES(direccion),
telefono = VALUES(telefono),
email = VALUES(email),
anio_apertura = VALUES(anio_apertura);

-- Datos vehiculos
INSERT INTO vehiculos (numero_bastidor, matricula, marca, modelo, potencia, cilindrada, precio_venta, anio_fabricacion)
VALUES 
('87654321098765432', '1234-ABC', 'Audi', 'R8', 570, 5200, 200000.0, 2023),
('12345678901234567', '4567-DEF', 'BMW', 'M8 Gran Coupe', 625, 4400, 185000.0, 2022),
('23456789012345678', '7890-GHI', 'Mercedes', 'AMG GT Black Series', 730, 4000, 175000.0, 2021),
('34567890123456789', '0123-JKL', 'Porsche', '911 Turbo S', 650, 3800, 220000.0, 2020),
('45678901234567890', '3456-MNO', 'Ferrari', '812 Superfast', 800, 6500, 350000.0, 2019),
('56789012345678901', '6789-PQR', 'Lamborghini', 'Huracán Performante', 640, 5200, 280000.0, 2018),
('67890123456789012', '9012-STU', 'McLaren', '720S', 720, 4000, 275000.0, 2017),
('78901234567890123', '2345-VWX', 'Aston Martin', 'DBS Superleggera', 725, 5200, 300000.0, 2016),
('89012345678901234', '5678-YZA', 'Bugatti', 'Chiron Super Sport 300+', 1600, 8000, 6000000.0, 2019),
('90123456789012345', '8901-BCD', 'Koenigsegg', 'Jesko Absolut', 1600, 5000, 3000000.0, 2020),
('01234598468736487', '8901-BCL', 'Chevrolet', 'Corvette Z06', 670, 6200, 120000.0, 2023),
('93764876443812331', '0020-CDE', 'Smart', 'Fortwo Cabrio', 90, 900, 35000.0, 2022),
('51234598468736487', '0021-EFG', 'Fiat', '500e', 118, 42, 32000.0, 2023)
ON DUPLICATE KEY UPDATE
matricula = VALUES(matricula),
marca = VALUES(marca),
modelo = VALUES(modelo),
potencia = VALUES(potencia),
cilindrada = VALUES(cilindrada),
precio_venta = VALUES(precio_venta),
anio_fabricacion = VALUES(anio_fabricacion);


-- Insertar datos de solicita_prueba
INSERT INTO solicita_prueba (cliente_id, vehiculo_id, fecha_hora, realizada)
VALUES
(1, 1, '2024-02-21 09:00:00', false),
(1, 2, '2024-02-21 10:00:00', false),
(2, 3, '2024-02-21 11:00:00', false),
(2, 4, '2024-02-21 12:00:00', false),
(3, 5, '2024-02-21 13:00:00', false),
(3, 6, '2024-02-21 14:00:00', false),
(4, 7, '2024-02-21 15:00:00', false),
(5, 8, '2024-02-21 17:00:00', false),
(6, 9, '2024-02-21 18:00:00', false),
(7, 10, '2024-02-21 19:00:00', false),
(8, 11, '2024-02-22 09:00:00', false),
(9, 12, '2024-02-22 10:00:00', false),
(10, 13, '2024-02-22 11:00:00', false);
