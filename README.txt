To try framework:

1) Run the app 

2) POST localhost:8080/ping (header=> Content-Type: application/json; body: { "name": "Something"})

    Creates entry in Mongo
    
3) GET localhost:8080/ping/Something 

    finds ping in Mongo, and prints it.
    
4) GET localhost:8080/ping

   prints all pings saved in Mongo
   
   