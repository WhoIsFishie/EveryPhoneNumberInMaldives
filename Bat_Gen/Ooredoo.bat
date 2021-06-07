@echo OFF
FOR /L %%y IN (9000000, 1, 9999999) DO ECHO +960-%%y >> ooredoo.csv && ECHO %%y
PAUSE