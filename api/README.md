# Automated Postman Colllection using Newman

- Simple collection performing CRUD operation
- Added some endpoint response body validation

note: 
- Since it's using reqres.in, fake endpoint provider for debugging, it is impossible to persist/save data when hitting Create User endpoint
- So in Get User endpoint, it is impossible to retrieve user id created beforehand
- [Reference](https://stackoverflow.com/q/62580163/1435275)