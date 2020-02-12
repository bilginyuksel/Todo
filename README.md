

Todo App
Introduction

What does your API do?
Overview

Things that the developers should know about
Authentication

What is the preferred way of using the API?
Error Codes

What errors and status codes can a user expect?
Rate limit

Is there a limit to the number of requests an user can send?
Language
POST localhost:8080/api/user/register?username=bilginyuksel&password=123456&email=email@email.com
localhost:8080/api/user/register?username=bayro&password=123456&email=bayro@email.com
PARAMS
username
bayro
password
123456
email
bayro@email.com


Example Request
localhost:8080/api/user/register?username=bilginyuksel&password=123456&email=email@email.com

curl --location --request POST 'localhost:8080/api/user/register?username=bayro&password=123456&email=bayro@email.com'

POST localhost:8080/api/user/login?username=bilginyuksel&password=123456
localhost:8080/api/user/login?username=bayro&password=123456
PARAMS
username
bayro
password
123456


Example Request
localhost:8080/api/user/login?username=bilginyuksel&password=123456

curl --location --request POST 'localhost:8080/api/user/login?username=bayro&password=123456'

POST localhost:8080/api/user/logout
localhost:8080/api/user/logout
HEADERS
Authorization
934c00e3-b712-4edb-8b8c-ab2ab32725cc


Example Request
localhost:8080/api/user/logout

curl --location --request POST 'localhost:8080/api/user/logout' \
--header 'Authorization: 934c00e3-b712-4edb-8b8c-ab2ab32725cc'

POST localhost:8080/api/category/category?title=Family&description=Some family stuff
localhost:8080/api/category/category?title=Family&description=Some family stuff
HEADERS
Authorization
c3b25925-6eda-49fa-b988-596d4f00ba24
PARAMS
title
Family
description
Some family stuff


Example Request
localhost:8080/api/category/category?title=Family&description=Some family stuff

curl --location --request POST 'localhost:8080/api/category/category?title=Family&description=Some%20family%20stuff' \
--header 'Authorization: c3b25925-6eda-49fa-b988-596d4f00ba24'

GET localhost:8080/api/category/categories
localhost:8080/api/category/categories
HEADERS
Authorization
255ecd0a-0f17-4226-a140-49b6a5bb23e0


Example Request
localhost:8080/api/category/categories

curl --location --request GET 'localhost:8080/api/category/categories' \
--header 'Authorization: 255ecd0a-0f17-4226-a140-49b6a5bb23e0'

POST localhost:8080/api/todo/todo?title=Shopping List&content=Get this. Get this. bla bla.
localhost:8080/api/todo/todo?title=Bayram's first todo&content=Bayram trying to make his game famous!
HEADERS
Authorization
70e15694-1b73-4ef2-b264-77ce111f0ed7
PARAMS
title
Bayram's first todo
content
Bayram trying to make his game famous!


Example Request
localhost:8080/api/todo/todo?title=Shopping List&content=Get this. Get this. bla bla.

curl --location --request POST 'localhost:8080/api/todo/todo?title=Bayram%27s%20first%20todo&content=Bayram%20trying%20to%20make%20his%20game%20famous%21' \
--header 'Authorization: 70e15694-1b73-4ef2-b264-77ce111f0ed7'

PUT localhost:8080/api/todo/todo?todoId=4&content=Bunu al sunu al herseyi al
localhost:8080/api/todo/todo?todoId=4&content=Bunu al sunu al herseyi al
HEADERS
Authorization
c3b25925-6eda-49fa-b988-596d4f00ba24
PARAMS
todoId
4
content
Bunu al sunu al herseyi al


Example Request
localhost:8080/api/todo/todo?todoId=4&content=Bunu al sunu al herseyi al

curl --location --request PUT 'localhost:8080/api/todo/todo?todoId=4&content=Bunu%20al%20sunu%20al%20herseyi%20al' \
--header 'Authorization: c3b25925-6eda-49fa-b988-596d4f00ba24'

GET localhost:8080/api/todo/todo-details?todoId=4
localhost:8080/api/todo/todo-details?todoId=17
HEADERS
Authorization
70e15694-1b73-4ef2-b264-77ce111f0ed7
PARAMS
todoId
17


Example Request
localhost:8080/api/todo/todo-details?todoId=4

curl --location --request GET 'localhost:8080/api/todo/todo-details?todoId=17' \
--header 'Authorization: 70e15694-1b73-4ef2-b264-77ce111f0ed7'

POST localhost:8080/api/todo/share-todo?todoId=7&userId=1
localhost:8080/api/todo/share-todo?todoId=17&userId=1
HEADERS
Authorization
70e15694-1b73-4ef2-b264-77ce111f0ed7
PARAMS
todoId
17
userId
1


Example Request
localhost:8080/api/todo/share-todo?todoId=7&userId=1

curl --location --request POST 'localhost:8080/api/todo/share-todo?todoId=17&userId=1' \
--header 'Authorization: 70e15694-1b73-4ef2-b264-77ce111f0ed7'

GET localhost:8080/api/todo/share-e08d7fc8-b2a0-4cdd-87f7-b0958c33e400
localhost:8080/api/todo/share-c01c7c23-1d8e-47fe-8c17-37d57a44dac2
HEADERS
Authorization
c3b25925-6eda-49fa-b988-596d4f00ba24
