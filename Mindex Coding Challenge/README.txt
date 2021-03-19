For the coding challenge I did the following:
Task 1:
    1. Created a Reportee Model for data response.
    2. Added a REST endpoint Reportee which creates a Map and checks the reportee based on the Employee id .It also creates a reportee string and counter to send as a response.
    
    Employee Id 03aa1462-ffa9-4978-901b-7c001562cf6f
Reporting Structure: 
Ringo Starr
        George Harrison
        Pete Best

No of Reportees: 2

Task 2:
    1. Created a Compension Model for storing the compensation data.
    2. Added inputStream in DataBootStrap for creating a bootstrap connection to insert and read.
    3. Created a ComepnsationnDao for connecting to MongoRepository.
    4.Created Functions in EmployeeService to create and read compensation.
    5. Overrided the function with exception handling and data handling.
    6. Added the REST endpoint functions to controller for creating and reading. 
    
    {
    "employeeId": "16a596ae-edd3-4847-99fe-c4518e82c86f",
    "effectiveDate": "2018-03-29T13:34:00.000+0000",
    "salary": 150000
}