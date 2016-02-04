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

# Post
curl -H "Content-type: application/json" -X POST -d "{'desc': 'John'}" http://localhost:8080/api/sample/1/see

#operacoes de livro
##Emprestar livro
curl -H "Content-type: application/json" -X POST -d "{'email': 'dsadasd@dsadas.com'}" http://localhost:8080/api/book/16/borrow
##Devolver livro
curl -H "Content-type: application/json" -X POST -d "{'id': '/loan/18'}" http://localhost:8080/api/book/16/devolve
