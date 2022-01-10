# Overview

This is a readme file to explain how to run the cake manger microservice

#### Steps

1. issue command mvn clean install -Ptest from the root directory of the project. This can be run from eclipse as well with profile as test
2. Make sure that the mapper file is generated on \target\generated-sources\com\waracle\cakemanager\mapper\ folder
3. The service needs to be started using mvn spring-boot:run -Dspring-boot.run.profiles=dev command. This can also be started from eclipse with "dev" profile. Assumtion is that the keycloak server is up and running separately.
4. Once the service starts the swagger endpoint url is available at http://localhost:8082/swagger-ui/index.html#/
5. In the explore text box search for "/v3/api-docs". all the endpoints will be listed
6. Authentication and authorization should be done done before the endpoints can be used
7. Click the Authorize button, which will take to the page to enter client credentials
8. On successful Autherntication and authorisation the endpoints can be used
9. POST /cakes endpoint can be use to create Cake
10.GET / can be used to retrieve all the Cakes 
11.GET /cakes can be used to download a json file containing all cakes
12. All the above mentioned url's can alo=so be tested using postman

#### prerequisites
1. For the purpose of this exercise the oauth2 has been implemented using the help of keycloak server
2. A verions of a spring boot keycloak server obtained from internet was separately used (which can be passed on if needed) 
3. The key cloak server needs to be up and reunning for the cake manager microservice to work
4. For the purpose of this exercise the key cloak server was running in port 8083.