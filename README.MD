## setup mysql db and run app
1. start mysql docker-container: docker-compose up -d db
1. setup admin username and password in .properties
1. start app
1. http.get localhost:9456/users/init
1. http.post localhost:9456/authenticate body: {'username': xxx, 'password': xxx}

## what is done in this example
1. connection between the app and mysql-db
2. enable and implemention of spring security
3. jwt-application
4. graphql

## graphql
1. graphql tools and graphql query resolver
1. graphiql
1. graphql endpoint gql, graphiql endpoint: giql