This project demonstrates how to use JWT to protect REST API
To Verify:
1. Run SpringSecurityJwtApplication
2. GET  http://localhost:8080/api/v1/welcome  ==> 200 OK
3. GET  http://localhost:8080/api/v1/user  ==> 401 Unauthorized
4. POST  http://localhost:8080/api/v1/auth/signup with { "username": "user", "password": "pwd"} ==> 200 OK
5. POST  http://localhost:8080/api/v1/auth/signin with { "username": "user", "password": "pwd"} ==> 200 OK and token
6. GET  http://localhost:8080/api/v1/user with Authorization token ==> 200 OK
To enforce https over http
1. Generate a self-signed SSL certificate with the following command, Sonyymm
   keytool -genkeypair -alias my-app-cert -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore keystore.p12 -validity 3650 -dname "CN=localhost, OU=IT, O=MyCompany, L=MyCity, S=MyState, C=US"
2. The keystore.p12 file will be created in the current directory. Move it into the src/main/resources folder of the Spring Boot project