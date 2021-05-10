# Jugadores

####POST
curl -X POST -d '{"nickname":"Necca", "name":"Luis", "apellidos": "Gómez", "puntuacion":1000, "pj_name1": "Asuka", "org_name": "Catalonia ESports"}' -H "Content-Type: application/json" http://localhost:8080/api/jugadores

####GET
curl http://localhost:8080/api/jugadores

####PUT
curl -X PUT -H "Content-Type: application/json" -d '{"puntuacion": 1300, "pj_name1": "Jin"}' http://localhost:8080/api/jugadores/Necca

####DELETE
curl -X DELETE http://localhost:8080/api/jugadores/Necca


# Organizadores

####POST
curl -X POST -d '{"id_organizador":"01", "name":"GG Stadium", "canal": "www.twitch.tv/ggstadium"}' -H "Content-Type: application/json" http://localhost:8080/api/organizadores

####GET
curl http://localhost:8080/api/organizadores

####PUT
curl -X PUT -H "Content-Type: application/json" -d '{"canal": "www.twitch.tv/stadiumgg"}' http://localhost:8080/api/organizadores/01

####DELETE
curl -X DELETE http://localhost:8080/api/organizadores/01


# Partidos

####POST
curl -X POST -d '{"resultadoLocal":"10", "resultadoVisitante":"5", "jugadorLocal": "Necca", "jugadorVisitante": "Zafrinha", "org_name": "GG Stadium"}' -H "Content-Type: application/json" http://localhost:8080/api/partidos

####GET
curl http://localhost:8080/api/partidos

####PUT
curl -X PUT -H "Content-Type: application/json" -d '{"resultadoLocal":"10", "resultadoVisitante":"5", "jugadorLocal": "Necca", "jugadorVisitante": "Zafrinha", "org_name": "GG Stadium"}' http://localhost:8080/api/partidos/01

####DELETE
curl -X DELETE http://localhost:8080/api/partidos/01
