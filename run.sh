#!/bin/sh
# Компиляция и запуск. Числа после ./run.sh уходят в args (задача 7.3): ./run.sh 2 10
cd "$(dirname "$0")"
javac -encoding UTF-8 -d out $(find src -name "*.java") && java -cp out ru.rasov.main.Main "$@"
