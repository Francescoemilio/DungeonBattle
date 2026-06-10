$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot

Write-Host "Compilazione in corso..."
New-Item -ItemType Directory -Force -Path target\classes | Out-Null
$sources = (Get-ChildItem -Recurse -Filter *.java src\main\java).FullName
javac -encoding UTF-8 -d target\classes @sources
if ($LASTEXITCODE -ne 0) {
    Write-Host "Compilazione fallita." -ForegroundColor Red
    exit $LASTEXITCODE
}

Write-Host "Avvio DungeonBattle..."
java -cp target\classes Main
