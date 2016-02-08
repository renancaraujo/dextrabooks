# dextrabooks
https://dextrabooks-1207.appspot.com/

# YAWP
http://yawp.io/

# Google Cloud project
https://console.developers.google.com/home/dashboard?project=dextrabooks-1207

# Google Datastore
https://cloud.google.com/appengine/docs/whatisgoogleappengine

# Google Appengine Maven:
https://cloud.google.com/appengine/docs/java/tools/maven



# Helpers cUrl
## Livro
#### Criar
curl -H "Content-type: application/json" -X POST -d "{'name': 'John', 'author': 'John', 'qtd': 4}" http://localhost:8080/api/book
#### Remover
curl -H "Content-type: application/json" -X DELETE http://localhost:8080/api/book/4

##Usuario
#### Criar
curl -H "Content-type: application/json" -X POST -d "{'email': 'dasdasd@sdadsad.com', 'nickname': 'Adasdas','isAdmin':false}" http://localhost:8080/api/user
#### Remover
curl -H "Content-type: application/json" -X DELETE http://localhost:8080/api/user/4

##Emprestimos
#### Emprestar livro
curl -H "Content-type: application/json" -X POST -d "{'email': 'dsadasd@dsadas.com'}" http://localhost:8080/api/book/16/borrow
#### Devolver livro
curl -H "Content-type: application/json" -X PUT http://localhost:8080/api/loan/16/devolve
