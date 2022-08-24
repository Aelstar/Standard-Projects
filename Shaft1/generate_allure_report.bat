@echo off
set path=C:\Users\ahmed.abdelstar\.m2\repository\allure\allure-2.17.2\bin;C:\Program Files\Java\jdk-17\bin;%path%
allure serve allure-results
pause
exit