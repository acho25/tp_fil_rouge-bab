# tp_fil_rouge-bab
tp_fil_rouge-bab created by GitHub Classroom

to start the db : docker compose up

Rest command:
to get all the personnes : curl -s -D - http://localhost:8080/myapp/personnes


to add a personne in the db 

curl -s -i -H "Accept: application/json"  \
-H "Content-type: application/json"  \
-X POST \
-d '{"name":"anass"}' \
http://localhost:8080/myapp/personnes/person



command to update a persons name by its id 

curl -s -i -H "Accept: application/json"  \
-H "Content-type: application/json"  \
-X PUT \
-d '{"name":"youness"}' \
http://localhost:8080/myapp/personnes/person/update/1



curl -s -i -X DELETE \
-O http://localhost:8080/myapp/personnes/person/delete/1
