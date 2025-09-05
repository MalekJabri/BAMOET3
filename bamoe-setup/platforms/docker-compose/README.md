# IBM Business Automation Manager Open Editions - Docker Compose
If you are currently running docker, podman, or Rancher Desktop, you can utilize the docker compose configuration scripts in this section of the repository.  You can use `Docker Compose` to run the BAMOE images locally and the easiest way is to use `Rancher Desktop`.  Click [here](https://docs.rancherdesktop.io/getting-started/installation/) in order to get instructions on how to install Rancher Desktop in Docker mode.  

## Container Images
All published BAMOE images can be pulled directly from Quay.io.  Here are the steps to follow:

1.  Navigate to the appropriate folder under `docker-compose`, for the BAMOE version you are installing, and then...
2.  To install the basic BAMOE services, use the supplied `docker-compose.yml` in the `docker-compose` folder:

    ```bash
    docker compose up [optional]<service-name> -d
    ```

    where `<service-name>` equals the name of the service in compose file (optional, leaving this off will install all services in the `docker-compose.yml` file.)

    The images will start containers on the following ports:

    | Service                  | Port @ localhost              |
    | ------------------------ | ----------------------------- |
    | BAMOE 921 Maven          | [9021](http://localhost:9021) |
    | BAMOE Canvas             | [9090](http://localhost:9090) |
    | BAMOE Management Console | [8380](http://localhost:8380) |

2.  To install the extended infrastructure services, mostly used by PAMOE, use the supplied `docker-compose-infrastructure.yml` in the `docker-compose` folder:

    ```bash
    docker compose -f docker-compose-infrastructure.yml --profile=container up [optional]<service-name> -d
    ```

    where `<service-name>` equals the name of the service in compose file (optional, leaving this off will install all services in the `docker-compose-infrastructure.yml` file.)

    The images will start containers on the following ports:
    
    | Service                   | Port @ localhost              |
    | ------------------------- | ----------------------------- |
    | BAMOE Postgres            | [5432](http://localhost:5432) |
    | BAMOE pgAdmin             | [8055](http://localhost:8055) |
    | BAMOE KeyCloak            | [8055](http://localhost:8180) |








