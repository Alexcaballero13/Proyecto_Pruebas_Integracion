@echo off
if exist "C:\Program Files\BellSoft\LibericaJDK-21" (
    set "JAVA_HOME=C:\Program Files\BellSoft\LibericaJDK-21"
) else if exist "C:\Program Files\Java\jdk-17" (
    set "JAVA_HOME=C:\Program Files\Java\jdk-17"
) else (
    echo ERROR: No se encontro JDK 17 o superior.
    exit /b 1
)
set "PATH=%JAVA_HOME%\bin;%PATH%"
echo Usando Java:
java -version
echo.
call mvnw.cmd clean verify %*
