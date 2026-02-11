This project is a Java-based console application developed using JDBC and Oracle Database. The system is designed to manage pet adoption processes and
maintain medical records of pets in an organized manner. It allows users to add new pets, view pet details, update medical status, adopt pets, cancel adoptions, 
and remove pets from the system.The application follows a layered architecture using packages such as bean (model classes), dao (database operations), service 
(business logic), util (database connection and custom exceptions), and app (main class). JDBC is used to connect Java with Oracle XE Database.

Two main tables are used in the database: PET_TBL to store pet details and ADOPTION_TBL to store adoption records. A sequence is used to generate unique
adoption IDs. 
Custom exceptions are implemented to handle cases like invalid input, pet not available for adoption, and active adoption restrictions.

This project demonstrates the implementation of CRUD operations, database connectivity, exception handling, and layered architecture using Core Java and JDBC.

project structure:
<img width="351" height="575" alt="image" src="https://github.com/user-attachments/assets/f8e8f8c7-a71e-444d-ad61-b93995ab7ade" />

output:
<img width="875" height="383" alt="image" src="https://github.com/user-attachments/assets/4595e2b9-2278-4d1d-b484-69ef73201f82" />
