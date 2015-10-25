set JAR="hugb_hello_world.jar"
set LOCATION="C:\temp"

REM Always deploy new version, clean before
call bin\clean.bat
call bin\package.bat

REM If jar file exists under C:\temp, remove it
if exist %LOCATION%%JAR% del /F %LOCATION%%JAR%

REM If destionation folder doesn't exist, create it
if not exist "%LOCATION%" mkdir %LOCATION%

copy build\libs\%JAR% %LOCATION%

REM Run application once
java -jar %LOCATION%\\%JAR%
