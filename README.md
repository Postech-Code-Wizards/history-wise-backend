# 🏥 history-wise-backend

🌟 Overview
The History Service is responsible for storing all previous patient consultations, including details about diagnoses, 
prescribed medication and symptoms. It allows appointments made or cancelled to be recorded and linked to 
information about medical treatment, facilitating ongoing monitoring of patients’ health. 
This service ensures that medical history is complete and accessible to doctors and other healthcare professionals, 
providing a comprehensive report on the patient’s condition over time.

---

### **Database Schema🗃️**
![History Service Database Diagram](https://github.com/user-attachments/assets/3499e837-e99e-417e-bd27-2e44241394d0)

### **Good Practices in Modeling and Design**

#### **1. Clear Relational Structure**
- The tables are organized to allow **clear relationships** between queries, diagnoses, symptoms, and prescriptions, ensuring an **efficient relational structure** for fast and integrated queries.
- The use of **foreign keys** between the **`PreviousConsultations`**, **`Diagnostics`**, **`Symptoms`**, and **`PrescriptionDetails`** tables ensures the **referential integrity** of the data, 
- facilitating queries with multiple relationships between the tables.

#### **2. Complete and Detailed History**
- Each **consultation** in the history contains not only the basic information of when the consultation was carried out, but also the **medical diagnoses** and **prescriptions**, allowing for **detailed monitoring** of the patient over time.

#### **3. Table flexibility**
- The **`Symptoms`** table, for example, allows **symptoms** to be chosen from a predefined set, but can easily be **expanded** to include more symptoms or conditions as needed, 
- ensuring the **flexibility** of the system while also saving time, if it is something simple already registered in the database.

---

## 🛠️ Technologies Used

- **Java JDK 21**: Core programming language.
- **Spring Boot**: Framework for building microservices.
- **Maven**: Dependency management and build tool.
- **PostgreSQL**: Database for storing history.
- **RabbitMQ**: Message broker for asynchronous communication.
- **Docker**: Application containerization, MongoDB, RabbitMQ.

---

## 🚀 How to Run
- **1. Clone the repository**  
  Clone the repository to your development environment:
    ```bash
    git clone https://github.com/Postech-Code-Wizards/history-wise-backend
    ```
  In the terminal, navigate to the root of your project:
    ```bash
    cd history-wise-backend
    ```

  Run the project:
    ```bash
    docker-compose up -d --build
    ```
  Access the API:
  - The application will be available at the URL: http://localhost:8080
  - GraphQL Playground: http://localhost:8080/graphiql?path=/graphql