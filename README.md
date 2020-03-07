## SpringBoot security with OAuth 2.0 and JWT

SpringBoot application with OAuth 2.0 security, using JWT with custom claims as access and refresh tokens. Application consists separate authorization and resource servers. Path and endpoints authorization based on roles. 

#### Usage:

##### Generating pair of tokens:
 `
curl --location --request POST 'http://localhost:8080/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic YXBwX2lkOmFwcF9zZWNyZXQ=' \
--data-urlencode 'username=admin' \
--data-urlencode 'password=admin' \
--data-urlencode 'grant_type=password'
`
##### Refreshing tokens:
`
curl --location --request POST 'http://localhost:8080/oauth/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Authorization: Basic YXBwX2lkOmFwcF9zZWNyZXQ=' \
--data-urlencode 'grant_type=refresh_token' \
--data-urlencode 'refresh_token=<refresh token>'
`

Authorization header can be build from client id and client secret

##### Example of usage:
`
curl --location --request GET 'http://localhost:8081/users' \
--header 'Authorization: Bearer <access token>'
`
