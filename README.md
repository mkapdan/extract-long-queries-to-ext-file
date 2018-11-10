## How to Extract Long Queries to External File
The purpose of creating this project is to show you how to extract long queries into an external file.
Native query or JPQL does not matter, you can put them under the resources folder.
The externalized queries can be called via Repository Interface or Entity Manager, it depends on your choice.
For native queries, you should create **sql-result-set-mapping** in order to map results into an object.
Please check **person.xml** file under the resource folder.

## How to create Factory Method
Depending on your user's choice, you can change the implementation without breaking OPEN-CLOSE principle.
Please check **UserBo** and **FactoryService** classes, in order to get further information.
