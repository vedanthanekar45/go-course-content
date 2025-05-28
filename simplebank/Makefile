opensh:
	docker exec -it postgres17 /bin/sh

postgres:
	docker run --name postgres17 -p 5000:5000 -e POSTGRES_PASSWORD=secret -d postgres:17.5-alpine

createdb:
	docker exec -it postgres17 createdb --username=postgres --owner=postgres bank

dropdb:
	docker exec -it postgres17 dropdb bank

.PHONY: opensh postgres createdb dropdb