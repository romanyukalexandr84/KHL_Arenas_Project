### Веб-приложение "Арены клубов Континентальной хоккейной лиги"

##

Сайт о домашних аренах клубов КХЛ. Проект на языке Java (версия 21) и фреймворке Spring (версия Spring Boot 3.2.5) с использованием внешней базы данных с СУБД PostgreSQL.

Перед запуском приложения необходимо развернуть Docker-контейнер (или использовать установленную базу данных Postgres на своём компьютере) с помощью команды в терминале:

###### sudo docker run --name cont-postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=arenas_db -d -p 5432:5432 postgres
####
Для начала работы необходимо запустить файл приложения KhlArenasProjectApp

Проект запускается по адресу http://localhost:8080, также развернут в сети Интернет по адресу http://khl-arenas.ru
####
Вход для обычных пользователей:
логин: user1   пароль: user1pass

логин: user2   пароль: user2pass

логин: user3   пароль: user3pass
###### Вход для администратора:
логин: admin   пароль: adminpass
###
#### Скриншоты:

![Screenshot1.png](https://raw.githubusercontent.com/romanyukalexandr84/Images/main/Screenshot1.png)

![Screenshot2.png](https://raw.githubusercontent.com/romanyukalexandr84/Images/main/Screenshot2.png)

![Screenshot3.png](https://raw.githubusercontent.com/romanyukalexandr84/Images/main/Screenshot3.png)

![Screenshot4.png](https://raw.githubusercontent.com/romanyukalexandr84/Images/main/Screenshot4.png)
