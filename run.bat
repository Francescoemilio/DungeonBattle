@echo off
setlocal enabledelayedexpansion
cd /d "%~dp0"
echo Compilazione in corso...
if not exist target\classes mkdir target\classes
set "SOURCES="
for /r "src\main\java" %%f in (*.java) do set "SOURCES=!SOURCES! "%%f""
javac -encoding UTF-8 -d target\classes !SOURCES!
if errorlevel 1 (
    echo Compilazione fallita.
    pause
    exit /b 1
)
echo Avvio DungeonBattle...
java -cp target\classes Main
pause
