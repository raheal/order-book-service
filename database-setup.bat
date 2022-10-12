call setenv.bat

cd %CD%\database\scripts\release
mysql -uroot -proot < v1_init.sql
mysql -uroot -proot < v1_1__seed.sql