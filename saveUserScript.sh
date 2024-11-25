#!/bin/bash

# Проверяем, указаны ли четыре параметра
if [ "$#" -ne 4 ]; then
  echo "Использование: $0 param1 param2 param3 param4"
  exit 1
fi

# Считываем параметры
param1=$1
param2=$2
param3=$3
param4=$4

# Формируем JSON
json=$(cat <<EOF
{
  "hash": "$param1",
  "name": "$param2",
  "surname": "$param3",
  "secondName": "$param4"
}
EOF
)

# Отправляем HTTP POST запрос
response=$(curl -s -X POST \
  -H "Content-Type: application/json" \
  -d "$json" \
  http://localhost:8082/api/v1/users/save)

# Выводим ответ
echo "Ответ сервера:"
echo "$response"