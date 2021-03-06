# Novas funcionalidades

Nesta API foi adicionado novas funcionalides que não estavam descritas no documento de requisitos.

## Validação de Erros
Em qualquer rota que necessite do usuário, caso ele não seja encontrado, o sistema exibe uma mensagem de erro com status 404:
```
Exemplo de requisição: /users/123232/follow/6
```
```javascript
{
  "error": "Usuário não encontrado"
}
```

A mesma lógica se aplica para o vendedor:
```
Exemplo de requisição: /users/1/follow/2342342342
```
```javascript
{
  "error": "Vendedor não encontrado"
}
```

Caso cada uma dessas rotas sejam executadas duas vezes seguidas, o sistema irá exibir uma mensagem de erro com status 400, pois a ação da mesma já foi executada.
```
Requisição executada duas vezes: /users/123232/follow/6
```
```javascript
{
  "error": "Este usuário já segue este vendedor"
}
```
```
Requisição executada duas vezes: /users/1/unfollow/4
```
```javascript
{
  "error": "Este usuário não segue este vendedor"
}
```

Nas rotas `products/newpost` e `products/newpromopost` é necessário informar manualmente o `userId` e o `id_post`, para não haja conflito nas informações salvas, caso o usuário informe o mesmo `id_post` o sistema exibe uma mensagem de erro com status 409:
```javascript
{
  "error": "Já existe um Post com este ID"
}
```

Nestas mesmas rotas, caso seja informado campos inválidos para o sistema, será retornando uma mensagem de erro com status 400 com todos os campos que apresentaram algum problema, como por exemplo:
```javascript
{
  "error": [
    {
      "field": "category",
      "error": "deve ser maior que ou igual à 0"
    },
    {
      "field": "detail",
      "error": "não deve ser nulo"
    },
    {
      "field": "userId",
      "error": "não deve ser nulo"
    },
    {
      "field": "date",
      "error": "não deve ser nulo"
    },
    {
      "field": "price",
      "error": "não deve ser nulo"
    },
    {
      "field": "id_post",
      "error": "não deve ser nulo"
    }
  ]
}
```

Caso o seja informado o campo mas com um tipo diferente do previsto, o sistema irá exibir uma mensagem de erro com status 400, como por exemplo:
```javascript
{
  "error": {
    "field": "date",
    "error": "Valor 32-07-2021 não é válido para o campo"
  }
}
```

Se nas rotas que utilizam ordenação não for passado o parâmetro correto, o sistema exibe uma mensagem de erro com status 400:
```javascript
{
  "error": "Este valor de ordenação não é válido"
}
```

## Nova ordenação
Na rota do requisito US0012 foi incluído a opção de ordernar por nome do produto (que estava descrito no documento do projeto). Assim, é preciso informar o parâmetro `order=name_asc` ou `order=name_desc` na requisição:
```
Exemplo de requisição: /products/4/list/?order=name_desc
```
```javascript
Exemplo de resposta:
{
  "userId": 4,
  "userName": "vendedor1",
  "posts": [
    {
      "id_post": 2,
      "date": "09-07-2021",
      "detail": {
        "product_id": 1,
        "productName": "Cadeira Gamer2",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": "100",
      "price": 1500.5,
      "hasPromo": true,
      "discount": 0.25
    },
    {
      "id_post": 1,
      "date": "09-07-2021",
      "detail": {
        "product_id": 1,
        "productName": "Cadeira Gamer1",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
      },
      "category": "100",
      "price": 1500.5,
      "hasPromo": true,
      "discount": 0.25
    }
  ]
}
```