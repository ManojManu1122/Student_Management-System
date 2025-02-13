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
