# Веб-сервис по управлению контактами

Для работы приложения используется БД PostgreSQL, развернутая в Docker-контейнере.</br>

<u>Запуск приложения</u>

1. Клонировать репозиторий;
2. Запустить Docker-контейнер, последовательно выполнив команды:
```
    cd docker
    docker compose up
```
По умолчанию, для доступа к БД используются следующие данные:
```
    url: jdbc:postgresql://localhost:5433/contacts
    username: postgres
    password: postgres
```
3. Запустите java/com/example/springApplication/Application.java
4. Открыть в браузере веб-приложение по адресу http://localhost:8080/contacts

<u>Возможности приложения</u>
1. При нажатии кнопки "Add Contact" будет открыта форма добавления нового контакта;
2. Поле сохранения контакта в таблице отобразится новый контакт;
3. У каждого контакта в таблице есть 2 кнопки:
- "Edit" - позволяет редактировать данные контакта;
- "Delete" - удаляет контакт из списка.

<u>Стек технологий</u>
- Java Core
- Spring Boot
- Hibernate
- PostgreSQL
- Docker
- Lombok
- Thymeleaf


