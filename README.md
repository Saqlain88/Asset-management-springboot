# Asset Management Springboot

Asset Management contains set of REST API for management of assets for any company.

# Technologies used
- Java
- Spring boot
- H2 Database

# Tools used
- Eclipse IDE
- Postman

# Description

On running the application Employees( id, fullname, designation) will be added automatically using CommandLineRunner. There are 6 packages created which are following:
- com.asset.springboot :-
  This contains the Application class with main method i.e AssetManagementSpringApplication.java .
- com.asset.springboot.exception :-
  This package contains all the exception(error) files such as :-
  - AlreadyAssignedException : if an asset is already assigned, then this exception will occur.
  - CannotRemoveAssignedAsset : if an asset is assigned it cannot be deleted.
  - EmployeeNotFound : if wrong id for an employee is added while assigning asset.
  - ResourceNotFoundException : If entered asset id doesn't exist.
- com.asset.springboot.model :- 
  This package all the model(bean) class files such as Employee.java, Category.java and Asset.java.
- com.asset.springboot.repository :-
  This package contains java files having interfaces that inherits JpaRepository. Files in this package are AssetRepository.java , CategoryRepository.java and EmployeeRepository.java .
- com.asset.springboot.service :- 
  This package contains java classes and interfaces for handling(Service and Transaction) every request that has been passed from RestController . Some files in this package are AssetService, AssetServiceImpl, CategoryService, CategoryService Impl, EmployeeService, and EmployeeServiceImpl.
- com.asset.springboot.controller :-
  This package contains all the RestController class files which will do mapping of request(POST, PUT and DELETE) by the help of methods. And the methods can have specific path with path variables which will be defined in these classes. Files in this package are AssetController and CategoryController.
  
# Usage & APIs

- Get Employees (GET)
  http://localhost:8080/employee

- Get All Categories (GET)
  http://localhost:8080/category

- Create a category (POST)
  http://localhost:8080/category/create
  Params: {
            "name":"categoryName",
            "description": "description of category"
          }

- Update a category (PUT)
  http://localhost:8080/category/update/{id}
  Params: {
            "name":"categoryName",
            "description": "description of category"
          }

- View a single category (GET)
  http://localhost:8080/category/view/{id}
  
- Delete a category (DELETE)
  http://localhost:8080/category/delete/{id}

  
  - ![#c5f015](https://via.placeholder.com/15/c5f015/000000?text=+) `NOTE: For assignmentStatus  '0' is for available, '1' is for assigned and '2' is assigned for recovered`

- Create an asset 
  Request Type: POST
  http://localhost:8080/asset/create
  Params: {
            "name": "chair",
            "purchaseDate" : "2010-08-12",
            "conditionNote" : "arm rest broken",
            "categoryId" : 1
          }
          
- Get an asset by name :
  Request Type : GET
  http://localhost:8080/asset/getbyname/{name}

- Update an asset :
  Request Type : PUT
  http://localhost:8080/asset/update/{id}
  
- Assign an asset :
  Request Type : PUT
  http://localhost:8080/asset/assign/{assetId}
  Params: {
            //enter the employee's id (fetch the employee id from [GET] http://localhost:8080/employee )
              "assignedTo" : 1 
          }
          
          
- Recover an asset :
  Request Type : PUT
  http://localhost:8080/asset/recover/{assetId}
  
- Delete an asset :- 
  Request Type: DELETE
  http://localhost:8080/asset/delete/2
  
