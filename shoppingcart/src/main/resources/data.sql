insert into product_entity (id, name, description) values
(1, 'Alexa', 'Alexa es el servicio de voz ubicado en la nube de Amazon disponible en los dispositivos de Amazon'),
(2, 'Conga', 'Conga el Robot Aspirador que Friega y Diseño Español. 2 años de garantía'),
(3, 'Chromecast', 'Google Chrome es un navegador web de código cerrado desarrollado por Google, aunque derivado de proyectos de código abierto."');

insert into shopping_cart_entity (id, status) values
(1,1), (2,1);

insert into shopping_cart_product (shopping_cart_entity_id, product_entity_id) values
(1, 1), (2,2);