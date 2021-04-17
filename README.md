# springboot-postgres-pgadim-docker
This is a Springboot application connecting to PostgreSQL run on docker compose with pgadmin

# Executing Project
1. Download and install "Docker Desktop"
   
2. Open docker-compose.yml file
3. Execute all services

# TODO
1. Add Junits
2. Update instructions to run project 
3. Upload postman project export
    GET API - http://localhost:18080/getallemployees
    POST API - http://localhost:18080/createEmployee
   {
        "firstName" : "Docker",
        "lastName" :"Desktop"
   }
4. Explain ports used by all containers in this project
5. Explain pgadmin connection setup
6. Takes time to load
    http://localhost:5050/browser/
   
#References
https://docs.docker.com/develop/develop-images/multistage-build/
https://stackoverflow.com/questions/27767264/how-to-dockerize-maven-project-and-how-many-ways-to-accomplish-it
https://dzone.com/articles/a-dockerfile-for-maven-based-github-projects
https://medium.com/@millet.david.julien/part-4-manage-database-with-pgadmin4-on-a-docker-image-95179b7f595f