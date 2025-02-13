# Student Management System

## Description
This is a **Spring Boot** web application for managing students. The application allows users to add, view, edit, and delete student records. It features **Thymeleaf** for the frontend, **Spring Security** for authentication, and **PostgreSQL** as the database.

## Features
- User authentication with **Spring Security**
- Add, edit, view, and delete student records
- Display logged-in user's students
- Bootstrap-powered responsive UI


## Technologies Used
- **Spring Boot**
- **Spring Security**
- **Thymeleaf**
- **PostgreSQL**
- **Bootstrap**

## Setup Instructions

### 1. Clone the Repository
```sh
git clone https://github.com/your-username/student-management-system.git
cd student-management-system
```

### 2. Configure PostgreSQL
Ensure you have PostgreSQL installed and running. Update the **application.properties** file:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build and Run the Project
```sh
mvn clean install
mvn spring-boot:run
```

### 4. Access the Application
Open your browser and go to:
```
http://localhost:8080
```
### Screenshots
![image](https://github.com/user-attachments/assets/62241ed8-c4e8-4114-9fa7-2a201f783c9b)
![image](https://github.com/user-attachments/assets/62da5f70-a3b0-43c1-8fd2-c6e4c6f882bb) ![image](https://github.com/user-attachments/assets/b6502ea4-f5ae-4ad8-b837-2383c42485db)
![image](https://github.com/user-attachments/assets/4706aa65-1b3c-4b34-b657-f1707f25fab6)
![image](https://github.com/user-attachments/assets/5bdf0cdd-5e32-4db3-a35f-c80274598815)






## Endpoints
| Endpoint | Description |
|----------|-------------|
| `/allStudents` | View all students |
| `/allStudents/my` | View logged-in user's students |
| `/students/new` | Add a new student |
| `/students/edit/{id}` | Edit a student |
| `/students/delete/{id}` | Delete a student |
| `/logout` | Logout |

## Contributing
Feel free to fork this repository and contribute! Pull requests are welcome.

## License
This project is open-source and available under the **MIT License**.
