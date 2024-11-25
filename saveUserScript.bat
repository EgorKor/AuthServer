@echo off
REM Проверяем, указаны ли четыре параметра
if "%~4"=="" (
    echo Использование: %~nx0 param1 param2 param3 param4
    exit /b 1
)

REM Считываем параметры
set "param1=%~1"
set "param2=%~2"
set "param3=%~3"
set "param4=%~4"

REM Формируем JSON
set "json={\"hash\":\"%param1%\",\"name\":\"%param2%\",\"surname\":\"%param3%\",\"secondName\":\"%param4%\"}"

REM Отправляем HTTP POST запрос
curl -s -X POST ^
    -H "Content-Type: application/json" ^
    -d "%json%" ^
    http://localhost:8082/api/v1/users/save

REM Выходим
exit /b 0