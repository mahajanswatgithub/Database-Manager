# Database Manager
This is a simple Java program that implements a basic database system. It allows you to create tables, insert values into them and shows the Table content
The program uses text files to store metadata and records.

## Usage
You can use the following commands:
- CREATE TABLE <table_name> (col1 <datatype>, col2 <datatype>,...) - Create a table with the specified columns and data types.
- INSERT INTO <table_name> VALUES (val1,val2,...) - Insert values into a table.
  
## Technical Stack Used
  - JAVA 
  
## Example Commands
Here are some example commands you can try:

- ### Create a table:
```
  CREATE TABLE table_name (col1 INTEGER, col2 STRING)
```
  
- ### Insert values into a table:
```
  INSERT INTO table_name VALUES (11, 'Hello World')
```
   
- ### Show table specific content:
```
   Show Table Content
```

- ### Terminate the program:
```
   Exit
```
  
## File Structure
    The program uses one file And a Folder :

- metadata.txt : Stores the metadata of the tables created.

- tables Directory : Stores the .txt files in the directory created by the CREATE Command for the Tables And inserts records in those files according to table name of each Table using INSERT Command .

