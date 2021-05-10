# Equipo (funciona)
curl -X POST -d '{"id_equipo":"38","nombre":"rubencin"}' -H "Content-Type: application/json" http://localhost:8080/api/equipo

curl http://localhost:8080/api/equipo

curl -X PUT -H "Content-Type: application/json" -d '{"id_equipo":"38","nombre":"ruben"}' http://localhost:8080/api/equipo/38

curl -X DELETE http://localhost:8080/api/equipo/38
