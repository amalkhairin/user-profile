# Image upload with Spring boot

### Group members:
- Athallah
- Nabila
- Saydova
- Amal

### features:
- CRUD user
- Update user's profile picture
- Save user's profile picture to pdf

### API
base url
```shell
http://localhost:8080
```
User endpoints

| Name                              | Method | Endpoint                    |
|-----------------------------------|--------|-----------------------------|
| Create User                       | POST   | `/users`                      |
| Get All User                      | GET    | `/users`                      |
| Update Profile Picture            | PUT    | `/users/update_image/{id}`    |
| Get PDF of user's profile picture | GET    | `/users/get_picture_pdf/{id}` |
| Get User's profile picture url    | GET    | `/users/get_img_url/{id}`     |
