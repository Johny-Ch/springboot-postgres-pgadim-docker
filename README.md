# springboot-postgres-pgadim-docker
This is a Springboot application 
  * Contains a GET & POST APIs to create and read employees with first & last name fields
      *   POST API can be used to create employee with fields "firstName" & "lastName"
      *   GET API can be used to get all employees stored
  * This application connects to PostgreSQL database that will be running as a containerized service on docker
  * This application also build and deploys pgadmin as a container on docker that will help us in browsing our database
      * pgAdmin is the most popular and feature rich Open Source administration and development platform for PostgreSQL https://www.pgadmin.org/

# Enviornment
  * Java 8
  * PostgreSQL, latest version as per https://hub.docker.com/_/postgres
  * pgAdming, latest version as per https://hub.docker.com/r/dpage/pgadmin4/
  * 

# Executing Project
1. Download and install [Docker Desktop]: https://www.docker.com/products/docker-desktop)
2. Open [docker-compose.yml] (https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/docker-compose.yml) file
3. Execute all services using docker-compose up at line 3
4. APIs to create and read data from postgres are
   * GET API - http://localhost:18080/getallemployees
   * POST API - http://localhost:18080/createEmployee
   ```
   {
        "firstName": "Docker",
        "lastName": "Desktop"
    }
   ```

# TODO
1. Add Junits
2. Update instructions to run project 
3. Explain ports used by all containers in this project
4. Explain pgadmin connection setup
5. pgadmin takes time to load http://localhost:5050/browser/
   
# References
* https://docs.docker.com/develop/develop-images/multistage-build/
* https://stackoverflow.com/questions/27767264/how-to-dockerize-maven-project-and-how-many-ways-to-accomplish-it
* https://dzone.com/articles/a-dockerfile-for-maven-based-github-projects
* https://medium.com/@millet.david.julien/part-4-manage-database-with-pgadmin4-on-a-docker-image-95179b7f595f
