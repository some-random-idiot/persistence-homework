# Births and Deaths in New Zealand

## What it does
A simple program that allows the user to manipulate and view a database containing the birth count, and death count of 
people in New Zealand. The data is categorized by year and region, starting in 2005 and ending in 2021.

## Technical details
- This program uses the **ORMLite** library in conjunction with JPA to interface with the database.
- The data must be stored in a **SQLite** database file.
- Run with **Java 11** for best compatibility.

## Running the program
First you need to create an SQLite database file using the following command.

```
sqlite3 database_name.db < database.schema
```

Then you can import the datasets from the CSV files using the following command.

```
sqlite3 database_name.db

sqlite> .mode csv
sqlite> .import data/births_in_new_zealand.csv births_in_new_zealand
sqlite> .import data/deaths_in_new_zealand.csv deaths_in_new_zealand
```