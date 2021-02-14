# person-handler
This repository provides APIs to add, update, fetch and delete data related a specific person.

This app run on port:8082

This app provides a service to maintain person records in in-memory H2 database.
To login to H2 DB, you need to start the App and access "http://localhost:8082/console/"

pre-requisires: 
java8
local machine should have docker installed.

Steps to run this micro-service on local:

git clone git@github.com:sudheerjay/personhandler.git
goto the personhandler folder and run,
./gradlew clean build 
-> the above step will create a jar file with name "personhandler-0.0.1-SNAPSHOT.jar" under /build/libs.
-> this jar can be used for containerisation of this app on docker. 

creating image and running the docker container:

once you are in personhandler directory please run the following
"docker build -t personhandler" ->this will build the docker image from our app.jar
"docker image ls" -> to check if the image has been created.
"docker run -p8082:8080 personhandler" -> this will create a container and runs the image on it. 

once the app is up and running, you can verify it by access with localhost:8082/console. 
which should redirect you to H2 DB console use embl/ebi as username/password

I'm attaching the API postman collections and working images here for your reference.
https://github.com/sudheerjay/personhandler/blob/main/EBI-EndPoints.postman_collection.json 
please export these to your postman app so these will start working immediately. 

