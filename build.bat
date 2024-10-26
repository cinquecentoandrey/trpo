@echo off

mvn clean install test

echo Сборка и тестирование завершены. Результаты доступны в папке target\site\jacoco\index.html
pause