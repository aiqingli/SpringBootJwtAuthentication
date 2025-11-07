This project demonstrates how to use JWT to protect REST API
To Verify:
1. Run SpringSecurityJwtApplication
2. GET  http://localhost:8080/api/v1/welcome  ==> 200 OK
3. GET  http://localhost:8080/api/v1/user  ==> 401 Unauthorized
4. POST  http://localhost:8080/api/v1/auth/signup with { "username": "user", "password": "pwd"} ==> 200 OK
5. POST  http://localhost:8080/api/v1/auth/signin with { "username": "user", "password": "pwd"} ==> 200 OK and token
6. GET  http://localhost:8080/api/v1/user with Authorization token ==> 200 OK