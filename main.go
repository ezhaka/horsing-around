// package main

// import (
// 	"log"
// 	"net"
// 	"net/http"
// 	"os"
// 	"os/signal"
// 	"syscall"
// )

// type AppHandler struct{}

// func (h AppHandler) ServeHTTP(resp http.ResponseWriter, req *http.Request) {
//     if req.Method == "GET" && req.URL.Path == "/ping" {
//         resp.WriteHeader(200)
//     } else if req.Method == "POST" && req.URL.Path == "/convert" {
// 		if err := ProcessConvertRequest(resp, req); err != nil {
// 			Error.Printf(err.Error())
// 			resp.WriteHeader(500)
// 		}
// 	} else {
// 		resp.WriteHeader(404)
// 	}
// }

// func app() error {
//     err := InitVips()
//     if err != nil {
//         return err
//     }

//     listener, err := net.Listen("tcp", "0.0.0.0:8080")
// 	if err != nil {
// 		return err
// 	}

// 	Info.Printf("Starting server on %s...", listener.Addr().String())

	server := &http.Server{
		Handler: AppHandler{},
	}

	go func() {
		err = server.Serve(listener)
		if err != nil {
			Error.Printf(err.Error())
		}
	}()

	stop := make(chan os.Signal, 1)
	signal.Notify(stop, syscall.SIGINT, syscall.SIGTERM)

	select {
	case <-stop:
	}

	return nil
}

func main() {
	if err := app(); err != nil {
		log.Fatal(err)
	}
}
