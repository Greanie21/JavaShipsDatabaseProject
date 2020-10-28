USE navios;

SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = "navios" AND TABLE_NAME = "navioMercante";
SELECT AUTO_INCREMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = "navios" AND TABLE_NAME = "navioCruzador";




SELECT navio.id, navio.nome, navio.tripulantes, 
navioDeGuerra.idNavioDeGuerra, navioDeGuerra.blindagem, navioDeGuerra.ataque, cruzador.idNavioCruzador, 
cruzador.numCanhoes 
FROM cruzador 
INNER JOIN navioDeGuerra ON cruzador.idNavioCruzador = navioDeGuerra.idNavioCruzador 
INNER JOIN navio ON navioDeGuerra.idNavioDeGuerra = navio.idNavioDeGuerra;

SELECT navio.id, navio.nome, navio.tripulantes, 
navioDeGuerra.idNavioDeGuerra, navioDeGuerra.blindagem, navioDeGuerra.ataque, cruzador.idNavioCruzador, 
cruzador.numCanhoes 
FROM cruzador 
INNER JOIN navioDeGuerra ON cruzador.idNavioCruzador = navioDeGuerra.idNavioCruzador 
INNER JOIN navio ON navioDeGuerra.idNavioDeGuerra = navio.idNavioDeGuerra WHERE navio.id = 7;