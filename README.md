Выполнить:
- mvn clean
- mvn test
- mvn allure:serve

Javadoc:
- mvn javadoc:test-javadoc
- Находятся в /target/site/testapidocs/index.html

Логирвоание:
- Запись происходит автоматически после каждого теста
- Текст ошибки берется из ошибок, (ошибки хранятся в листе errors в ErrorCollector)
- Логи находся в папке logs
- Имеет вид log-{className}.txt

Доп. зависимости:
- webdrivermanager

Доп. плагины:
- allure-maven
