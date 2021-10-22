# Asset-management-springboot

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
  This package contains all the exception(error) files such as :
      1- AlreadyAssignedException : if an asset is already assigned, then this exception will occur.
      2- CannotRemoveAssignedAsset : if an asset is assigned it cannot be deleted.
      3- EmployeeNotFound : if wrong id for an employee is added while assigning asset.
      4- ResourceNotFoundException : If entered asset id doesn't exist.
- com.asset.springboot.model :- 
  This package all the model(bean) class files such as Employee.java, Category.java and Asset.java.
- com.asset.springboot.repository :-
  This package contains java files having interfaces that inherits JpaRepository. Files in this package are AssetRepository.java , CategoryRepository.java and EmployeeRepository.java .
- com.asset.springboot.service :- 
  This package contains java classes and interfaces for handling(Service and Transaction) every request that has been passed from RestController . Some files in this package are AssetService, AssetServiceImpl, CategoryService, CategoryService Impl, EmployeeService, and EmployeeServiceImpl.
- com.asset.springboot.controller :-
  This package contains all the RestController class files which will do mapping of request(POST, PUT and DELETE) by the help of methods. And the methods can have specific path with path variables which will be defined in these classes. Files in this package are AssetController and CategoryController.
