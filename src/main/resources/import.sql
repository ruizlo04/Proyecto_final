INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Ejecutivo', 'Incluye una selección de platos gourmet y postre', 25.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Vegetariano', 'Incluye una selección de platos vegetarianos y postre', 23.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Infantil', 'Incluye plato principal, bebida y postre para los más pequeños', 12.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Mediterráneo', 'Incluye una selección de platos mediterráneos y postre', 27.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Italiano', 'Incluye una selección de platos italianos y postre', 29.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Asiático', 'Incluye una selección de platos asiáticos y postre', 24.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Buffet', 'Incluye una variedad de platos fríos y calientes para servir estilo buffet', 32.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú BBQ', 'Incluye una selección de carnes y acompañamientos para una barbacoa', 35.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú de Mariscos', 'Incluye una selección de mariscos frescos y postre', 39.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Saludable', 'Incluye una selección de platos saludables y postre', 26.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Gourmet', 'Incluye una selección de platos gourmet y postre', 44.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Navideño', 'Incluye una selección de platos navideños y postre', 38.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú para Fiestas', 'Incluye una variedad de platos fríos y calientes para fiestas', 29.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú para Reuniones', 'Incluye una variedad de platos fríos y calientes para reuniones', 28.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú para Bodas', 'Incluye una selección de platos elegantes para bodas y postre', 49.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú para Cumpleaños', 'Incluye una selección de platos y postre para cumpleaños', 21.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú para Aniversarios', 'Incluye una selección de platos y postre para aniversarios', 34.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú de Tapas', 'Incluye una selección de tapas y postre', 19.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Mexicano', 'Incluye una selección de platos mexicanos y postre', 31.99);
INSERT INTO menu (cod_menu, nombre, descripcion, precio) VALUES (DEFAULT, 'Menú Americano', 'Incluye una selección de platos americanos y postre', 33.99);

INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Juan', 'Pérez', '12345678A', '123456789');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'María', 'López', '23456789B', '234567890');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Pedro', 'García', '34567890C', '345678901');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Laura', 'Martínez', '45678901D', '456789012');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Carlos', 'Fernández', '56789012E', '567890123');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Ana', 'Rodríguez', '67890123F', '678901234');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Luis', 'Gómez', '78901234G', '789012345');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Marta', 'Torres', '89012345H', '890123456');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'David', 'Sánchez', '90123456I', '901234567');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Carmen', 'Ramírez', '01234567J', '012345678');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Sergio', 'Navarro', '12345678K', '123456789');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Elena', 'Romero', '23456789L', '234567890');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Diego', 'Hernández', '34567890M', '345678901');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Javier', 'Morales', '56789012O', '567890123');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Raquel', 'Suárez', '67890123P', '678901234');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Adrián', 'Castro', '78901234Q', '789012345');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Isabel', 'Ortega', '89012345R', '890123456');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Hugo', 'Molina', '90123456S', '901234567');
INSERT INTO camareros (cod_camarero, nombre, apellidos, dni, telefono) VALUES (DEFAULT, 'Paula', 'Garrido', '01234567T', '012345678');

INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 1', 'reserva1@example.com', '2023-05-22', 'Boda', 'Salón de eventos');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 2', 'reserva2@example.com', '2023-06-10', 'Aniversario', 'Jardín');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 3', 'reserva3@example.com', '2023-07-05', 'Cumpleaños', 'Restaurante');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 4', 'reserva4@example.com', '2023-08-15', 'Conferencia', 'Centro de convenciones');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 5', 'reserva5@example.com', '2023-09-01', 'Reunión corporativa', 'Oficina');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 6', 'reserva6@example.com', '2023-09-15', 'Boda', 'Playa');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 7', 'reserva7@example.com', '2023-10-10', 'Aniversario', 'Salón de eventos');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 8', 'reserva8@example.com', '2023-11-20', 'Cumpleaños', 'Jardín');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 9', 'reserva9@example.com', '2023-12-05', 'Conferencia', 'Hotel');
INSERT INTO reserva (cod_reserva, nombre, email, fecha, tipo_evento, lugar_evento) VALUES (DEFAULT, 'Reserva 10', 'reserva10@example.com', '2023-12-25', 'Reunión corporativa', 'Oficina');

INSERT INTO reservas (cod_reserva, username, fecha, tipo_evento, menu, lugar_evento, num_personas)
VALUES
  (DEFAULT, 'username1', CURDATE(), 'bodas', 'Menú Ejecutivo', 'Lugar 1', 50),
  (DEFAULT, 'username2', CURDATE(), 'coktail', 'Menú Vegetariano', 'Lugar 2', 80),
  (DEFAULT, 'username3', CURDATE(), 'comunión', 'Menú Infantil', 'Lugar 3', 30),
  (DEFAULT, 'username4', CURDATE(), 'bodas', 'Menú Mediterráneo', 'Lugar 4', 150),
  (DEFAULT, 'username5', CURDATE(), 'coktail', 'Menú Italiano', 'Lugar 5', 70),
  (DEFAULT, 'username6', CURDATE(), 'comunión', 'Menú Buffet', 'Lugar 6', 120),
  (DEFAULT, 'username7', CURDATE(), 'bodas', 'Menú BBQ', 'Lugar 7', 200),
  (DEFAULT, 'username8', CURDATE(), 'coktail', 'Menú de Mariscos', 'Lugar 8', 90),
  (DEFAULT, 'username9', CURDATE(), 'comunión', 'Menú Saludable', 'Lugar 9', 40),
  (DEFAULT, 'username10', CURDATE(), 'bodas', 'Menú Gourmet', 'Lugar 10', 180);
