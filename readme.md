# Docker
Mysql Sql DB 
```bash
docker run -p 3306:3306 --detach --name mariadb -e MARIADB_ROOT_PASSWORD=superadmin  mariadb:latest
```

myphpadmin
```bash
docker run -d --link mariadb --name phpmyadmin -e PMA_HOST=mariadb -e  MYSQL_ROOT_PASSWORD=superadmin -e PMA_USER=root -e PMA_PASSWORD=superadmin -p 8080:80 phpmyadmin 
```
login phpadmin at http://localhost:8080 with username/password=  root/superadmin