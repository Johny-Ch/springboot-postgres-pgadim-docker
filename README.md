# springboot-postgres-pgadim-docker
This is a Springboot application 
  * Contains a GET & POST APIs to create and read employees with first & last name fields
      *   POST API can be used to create employee with fields "firstName" & "lastName"
      *   GET API can be used to get all employees stored
  * This application connects to PostgreSQL database that will be running as a containerized service on docker
  * This application also builds and deploys pgadmin as a container on docker that will help us in browsing our postgres database
      * [pgAdmin](https://www.pgadmin.org/) is a commonly used database management tool in the PostgresDB community. It simplifies the creation, maintenance, and use of database objects by offering a clean and intuitive user interface.

# Environment
  * Java 8
  * PostgreSQL, latest version as per https://hub.docker.com/_/postgres
  * pgAdming, latest version as per https://hub.docker.com/r/dpage/pgadmin4/
  * Springboot 2.4.5

# Prerequisites
   1. Download and install [Docker Desktop](https://www.docker.com/products/docker-desktop)
   2. Download and install IntelliJ IDEA Community (Free, open-source) [here](https://www.jetbrains.com/idea/download/)

# Executing Project
   1. Clone the main branch of the project on to your working environment, [clone url](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker.git)
   2. Open cloned project in Intellij
   3. Open [docker-compose.yml](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/docker-compose.yml) file
   4. Execute all services by clicking on two green arrows at line 3 in  [docker-compose.yml](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/docker-compose.yml) file - this is nothing but executing docker-compose up
      ![Execute all services](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/images/docker-compose.yml.png)
   5. Verify if all the containers are up & running on you docker desktop, you see something like this
        * All Containers Running: ![All Containers Running](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/images/all-containers-running.png)
        * Some Containers Not Running: ![Some Containers Not Running](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/images/partial-running-containers.png)
   6. If all containers are up & running, you can go ahead and create some data by calling the APIs below
       * POST API - http://localhost:18080/createEmployee
       * POST API Request Body
        ```
            {
                "firstName": "Docker",
                "lastName": "Desktop"
            }
        ```
       * GET API - http://localhost:18080/getallemployees
       * GET API Response body
        ```
            {
                "id" : "1",
                "firstName": "Docker",
                "lastName": "Desktop"
            }
        ```
      
# Ports
  1. Rest APIs will be running on port 18080 
  2. PostgreSQL database will be running on port 5432
  3. pgAdmin will be running on port 5050

# Accessing pgAdmin
[pgAdmin](https://www.pgadmin.org/) is a commonly used database management tool in the PostgresDB community. It simplifies the creation, maintenance, and use of database objects by offering a clean and intuitive user interface.
   1. pgAdming takes time to boot up
   2. You monitor and confirm it's readiness by looking at the pgadming-container logs as below
       * This is how logs will look like when pgAdmin container is ready for usage ![This is how logs will look like when pgAdmin container is ready for usage](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/images/pgadmin-startup-logs.png)
   3. We have preloaded the servers on to pgAdmin by using environment variable PGADMIN_SERVER_JSON_FILE and supplied servers [here](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/src/main/resources/postgres-servers.json)
   4. We are using default password as "changeme" to login to postgres database
   5. You can login to pgadming at http://localhost:5050/browser/ and browse as below
      * ![Browser pgAdming](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/images/pgadmin-browser.png)

# PostgreSQL Username & Passwords
  * Username: postgres
  * Password: changeme

#Dockerfiles
We have two docker files in this application
    1. Dockerfile-restapi
    2. Dockerfile-pgadmin

##Dockerfile-restapi
This file is used to run the maven build by copying the src directory containing all the java code and pom.xml file
The next section in this file loads JDK and copies the generated jar file as application.jar and then it is launched

##Dockerfile-pgadmin
This file is used to load pgadmin docker image and copy the postgres-servers.json on to container at /pgadmin4/servers.json

#Docker compose
The docker compose file contains 3 services
    1. restapi
    2. pgadmin
    3. postgres

##restapi
This service will invoke the Dockerfile-restapi and is dependent on postgres
We are supplying enviornment variables required for loading postgres database

##pgadmin
This service will invoke the Dockerfile-pgadmin and is dependent on postgres
We are supplying enviornment variables required for preloading servers

##postgres
This service will load postgre image and start the container running postgres database

# Docker Images
  1. springboot-postgres-pgadim-docker
  2. pgadmin4   
  3. postgres
     ![Docker Images](https://github.com/Johny-Ch/springboot-postgres-pgadim-docker/blob/main/images/docker-downloaded-images.png)

# References
   * https://docs.docker.com/develop/develop-images/multistage-build/
   * https://stackoverflow.com/questions/27767264/how-to-dockerize-maven-project-and-how-many-ways-to-accomplish-it
   * https://dzone.com/articles/a-dockerfile-for-maven-based-github-projects
   * https://medium.com/@millet.david.julien/part-4-manage-database-with-pgadmin4-on-a-docker-image-95179b7f595f
