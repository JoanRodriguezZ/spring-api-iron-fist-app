CREATE TABLE jugador (nickname VARCHAR(40) PRIMARY KEY, apellidos VARCHAR(100) NOT NULL, puntuacion INTEGER NOT NULL, pj_name1 VARCHAR(20) NOT NULL, pj_name2 VARCHAR(20) DEFAULT NULL, org_name VARCHAR(60) DEFAULT NULL) INHERITS (usuario);
ALTER TABLE jugador ADD CONSTRAINT jugador_pj_name_fkey FOREIGN KEY (pj_name1) REFERENCES personaje(pj_name);
ALTER TABLE jugador ADD CONSTRAINT jugador_org_name_fkey FOREIGN KEY (org_name) REFERENCES organizacion(org_name);

CREATE TABLE usuario (user_name VARCHAR (40) PRIMARY KEY);

CREATE TABLE personaje (pj_name VARCHAR(20) PRIMARY KEY);

CREATE TABLE organizacion(org_name VARCHAR(60) PRIMARY KEY);

CREATE TABLE partido (id_partido NUMERIC(4,0) PRIMARY KEY, fecha DATE NOT NULL, jugadorLocal VARCHAR(40) NOT NULL, jugadorVisitante VARCHAR(40) NOT NULL, resultadoLocal INTEGER NOT NULL, resultadoVisitante INTEGER NOT NULL, puntuacionLocal INTEGER NOT NULL, puntuacionVisitante INTEGER NOT NULL);
ALTER TABLE partido ADD CONSTRAINT partido_jugador_local_fkey FOREIGN KEY (jugadorLocal) REFERENCES jugador(nickname);
ALTER TABLE partido ADD CONSTRAINT partido_jugador_visitante_fkey FOREIGN KEY (jugadorVisitante) REFERENCES jugador(nickname);

CREATE TABLE organizador (id_organizador NUMERIC(4,0) PRIMARY KEY, canal VARCHAR(2048) NOT NULL) INHERITS (usuario);
CREATE TABLE organizador (id_organizador INT AUTO_INCREMENT, canal VARCHAR(2048) NOT NULL, PRIMARY KEY(id_organziador)) INHERITS (usuario);
