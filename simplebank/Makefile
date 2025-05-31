opensh:
	docker exec -it postgres17 /bin/sh

postgres:
	docker run --name postgres17 -p 5432:5432 -e POSTGRES_PASSWORD=secret -d postgres:17.5-alpine

createdb:
	docker exec -it postgres17 createdb --username=postgres --owner=postgres bank

dropdb:
	docker exec -it postgres17 dropdb bank

migrateup:
	migrate -path db/migration -database "postgresql://postgres:root@localhost:5432/bank?sslmode=disable" --verbose up

migratedown:
	migrate -path db/migration -database "postgresql://postgres:root@localhost:5432/bank?sslmode=disable" --verbose down

sqlc:
	sqlc generate

.PHONY: opensh postgres createdb dropdb migrateup sqlc