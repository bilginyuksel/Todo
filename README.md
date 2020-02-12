<h1>Todo</h1>

I created todo app REST service. I tried to create my own security on that service. I didn't use spring security. I added safe share for todos.
And i wrote bunch of tests.
<br>
I mentioned some of the api calls of that application below.

<strong>POST</strong> localhost:8080/api/user/register?username=bilginyuksel&password=123456&email=email@email.com
```shell
>> curl --location --request POST 'localhost:8080/api/user/register?username=bayro&password=123456&email=bayro@email.com'
```

<strong>POST</strong> localhost:8080/api/user/login?username=bayro&password=123456
```shell
>> curl --location --request POST 'localhost:8080/api/user/login?username=bayro&password=123456'
```

<strong>POST</strong> localhost:8080/api/user/logout
```shell
>> curl --location --request POST 'localhost:8080/api/user/logout' \
--header 'Authorization: 934c00e3-b712-4edb-8b8c-ab2ab32725cc'
```

<strong>POST</strong> localhost:8080/api/category/category?title=Family&description=Some family stuff
```shell
>> curl --location --request POST 'localhost:8080/api/category/category?title=Family&description=Some%20family%20stuff' \
--header 'Authorization: c3b25925-6eda-49fa-b988-596d4f00ba24'
```

<strong>GET</strong> localhost:8080/api/category/categories
```shell
>> curl --location --request GET 'localhost:8080/api/category/categories' \
--header 'Authorization: 255ecd0a-0f17-4226-a140-49b6a5bb23e0'
```

<strong>POST</strong> localhost:8080/api/todo/todo?title=Shopping List&content=Get this. Get this. bla bla.

```shell
>> curl --location --request POST 'localhost:8080/api/todo/todo?title=Bayram%27s%20first%20todo&content=Bayram%20trying%20to%20make%20his%20game%20famous%21' \
--header 'Authorization: 70e15694-1b73-4ef2-b264-77ce111f0ed7'
```

<strong>PUT</strong> localhost:8080/api/todo/todo?todoId=4&content=Bunu al sunu al herseyi al

```shell
>> curl --location --request PUT 'localhost:8080/api/todo/todo?todoId=4&content=Bunu%20al%20sunu%20al%20herseyi%20al' \
--header 'Authorization: c3b25925-6eda-49fa-b988-596d4f00ba24'
```

<strong>GET</strong> localhost:8080/api/todo/todo-details?todoId=4

```shell
>> curl --location --request GET 'localhost:8080/api/todo/todo-details?todoId=17' \
--header 'Authorization: 70e15694-1b73-4ef2-b264-77ce111f0ed7'
```

<strong>POST</strong> localhost:8080/api/todo/share-todo?todoId=17&userId=1
```shell
>> curl --location --request POST 'localhost:8080/api/todo/share-todo?todoId=17&userId=1' \
--header 'Authorization: 70e15694-1b73-4ef2-b264-77ce111f0ed7'
```

<strong>GET</strong> localhost:8080/api/todo/share-e08d7fc8-b2a0-4cdd-87f7-b0958c33e400
```shell
>> curl --location --request GET 'localhost:8080/api/todo/share-c01c7c23-1d8e-47fe-8c17-37d57a44dac2' \
--header 'Authorization: c3b25925-6eda-49fa-b988-596d4f00ba24'
```
