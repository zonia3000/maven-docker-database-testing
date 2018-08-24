# Example of Maven project using Docker plugin for integration testing on real databases

When you test applications performing queries on a database, it's not always possible to rely on mocks or embedded databases (e.g. H2): sometimes you need to execute the application in an environment as similar as possible to the production one. In this situations using Docker could be a good idea.

This example shows a Maven project using the [docker-maven-plugin](https://github.com/fabric8io/docker-maven-plugin) for testing a SQL query both on MariaDB and PostgreSQL databases.

## How it works

During the `pre-integration-test` phase the plugin starts 2 Docker images (one for MariaDB and one for PostgreSQL).

Inside the `src/test/docker` directory there are 2 SQL files used to create an example table on both databases. The plugin copies these files in the `docker-entrypoint-initdb.d` directory inside each Docker image. This directory is used by [both](https://hub.docker.com/_/mariadb/) [images](https://hub.docker.com/_/postgres/) for performing custom initialization.

The plugin is also configured to wait until the databases are up and running (listening on their default ports).

The plugin sets the IP address of the running image inside a Maven property having the following format: `docker.container.<image-alias>.ip`. In this way it is possible to fill the configuration files inside the `src/test/resources` directory using Maven properties filtering. Thus, it is possible to read the proper connection configuration from the `IntegrationTest` class.

Please, have a look to the pom.xml and the other files: there are some additional tips and information contained in the comments.

## How to debug the integration test

    mvn -Dmaven.failsafe.debug verify
