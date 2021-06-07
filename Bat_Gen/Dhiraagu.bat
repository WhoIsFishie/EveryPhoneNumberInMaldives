@echo OFF
FOR /L %%y IN (7000000, 1, 7999999) DO ECHO +960-%%y >> dhiraagu.csv && ECHO %%y
PAUSE