package api


import (
	"github.com/gin-gonic/gin"
)

// Server serves HTTP requests coming from the clients
type Server struct {
	store *db.Store
	router *gin.Engine
}

// New server instance
func NewServer (store *db.Store) *Server {
	server := &Server{store: store}
	router := gin.Default()

	router.POST('/accounts', server.createAccount)
	// adding routes

	server.router = router
	return server
}