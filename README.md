# Магазин, торгующий компьютерами и комплектующими со следующим типом товаров:
● Настольные компьютеры
● Ноутбуки
● Мониторы
● Жесткие диски

# Каждый товар имеет следующие свойства:
● номер серии
● производитель
● цена
● количество единиц продукции на складе

# Дополнительные свойства:
● Настольные компьютеры имеют форм-фактор: десктопы, неттопы, моноблоки
● Ноутбуки подразделяются по размеру: 13, 14, 15, 17 дюймовые
● Мониторы имеют диагональ
● Жесткие диски имеют объем

# Необходимо реализовать back-end приложение, которое имеет RESTful HTTP методывыполняющие:
1. Добавление товара
2. Редактирование товара
3. Просмотр всех существующих товаров по типу
4. Просмотр товара по идентификатору


### Как пользоваться:

Запускаем проект!

Переходим в браузере http://localhost:8080/h2 
 
User Name: admin

остальные поля оставляем пустыми! нажимаем Connect
 
1)db/migration/v1_create_tables.sql
копируем скрипт делаем нативный запрос в H2

2)db/migration/v2_isert_pc_tables.sql
копируем скрипт делаем нативный запрос в H2

Json-формат всех свойств товаров описан следующим образом:

"id":             <bigserial>
"serialNumber":   <int8>
"manufacturer":   "<varchar(255)>"
"price":          <int8>
"unitsInStock":   <int8>

"formFactor":     <varchar(255)>
"screenDiagonal": <int4>
"diagonal"        <int8>
"capacity":       <int8>

На задаваемые свойства накладываются следующие ограничения:
serialNumber не может повторяться в пределах продукции одного типа
formFactor описан перечислением и ограничен вариациями чисел от 0 до 2 (десктопы, неттопы, моноблоки)
screenDiagonal также описана перечислением и ограничена вариациями чисел от 0 до 3 (13, 14, 15, 17 дюймовые соответственно)
id задается автоматически и, если не опущен, будет проигнорирован в запросах отличных от поиска по id.

# Post-запросы на добавление товаров обрабатываются по адресам:

http://localhost:8080/api/v1/pc/add
http://localhost:8080/api/v1/laptop/add
http://localhost:8080/api/v1/monitor/add
http://localhost:8080/api/v1/hdd/add

# Пример тела такого рода запроса на адрес "http://localhost:8080/api/v1/pc/add":
{
"serial_number": 777,
"manufacturer": "Company",
"price": 5000,
"units_in_stock": 2020,
"form_factor": "LAPTOP"
}
# Get-запросы на получение списка товаров по типу, а также Post-запросы на поиск товаров по одному из его свойств обрабатываются по адресам:

http://localhost:8080/api/v1/pc/all
http://localhost:8080/api/v1/laptop/all
http://localhost:8080/api/v1/monitor/all
http://localhost:8080/api/v1/hdd/all

# Пример тела Post-запроса на адрес "http://localhost:8080/api/v1/laptop/all":

{
"manufacturer": "Company"
}

# Post-запросы на поиск товаров по серийному номеру или id в базе обрабатываются по адресам:
http://localhost:8080/api/v1/pc/find
http://localhost:8080/api/v1/laptop/find
http://localhost:8080/api/v1/monitor/find
http://localhost:8080/api/v1/hdd/find
Пример тела Post-запроса на адрес "http://localhost:8080/api/v1/monitor/find":

{
"serial_number": 123
}
# Post-запросы на изменение товара по серийному номеру обрабатываются по адресам:
http://localhost:8080/api/v1/pc/update
http://localhost:8080/api/v1/laptop/update
http://localhost:8080/api/v1/monitor/update
http://localhost:8080/api/v1/hdd/update
Пример тела Post-запроса на адрес "http://localhost:8080/api/v1/hdd/update":
{
"serial_number": 777,
"manufacturer": "Company name",
"units_in_stock": 666
}
Опущенные свойства товара будут оставлены без изменений