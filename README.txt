To try framework:

1) Run the app 

2) POST localhost:8080/ping 
   (
    headers:
        Content-Type: application/json
    body:
        {"name": "Something"}
   )

    Result: Creates entry in Mongo. (see message on screen)
    
3) GET localhost:8080/ping/Something 

    Result: finds ping in Mongo, and prints it. (see message on screen)
    
4) GET localhost:8080/ping

   Result: prints all pings saved in Mongo. (see message on screen)
   
   