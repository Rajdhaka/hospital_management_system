# Hospital Management System


## Built With
* `Java 17`
* `Maven 4.0.0`
* `MySql Ver 8.0.32`
* `Spring Boot 3.0.5`
* `IntelliJ IDEA 2023.1 (Community Edition)`
## Data Flow

### 1. Models:
* It consists of **Doctor**, **Patient** entity classes along with their data members and member functions
* Used **_@Table_** and **_@Entity_** annotations inside the entity class.
* Used Lombok to reduce boilerplate code for pojo class.By using Lombok annotations like _**@Data,**_ **@_NoArgsConstructor_**, **_@AllArgsConstructor_** getters and setters for those object generate automatically.

### 2. Controllers:
* It consists of  **DoctorController** ,**PatientController** classes in which used the annotations like **@RestController** to annotate the class as Controller.
* Used annotation **_@GetMapping_** , **_@PostMapping_** , **_@PutMapping_** , **_@DeleteMapping_** to map the HTTP web requests to the specific handler methods.

<br>

### API Reference:
<br>

>Doctor's API References
<br>

* Add Doctor:
```*.sh-session
  http://localhost:8080/doctor
```

* Get All Doctor:
```*.sh-session
 http://localhost:8080/doctor/all
```
<br>

* Delete Doctor:

```*.sh-session
 http://localhost:8080/doctor/docId/{docId}
```
<br>


>Patient's API References:
<br>

* Add Patient 
```*.sh-session
  http://localhost:8080/patient
```

* Get All Patient:
```*.sh-session
http://localhost:8080/patient/all
```
* Delete Patient:
```*.sh-session
http://localhost:8080/patient/patientId/{patientId}
```

* Suggest Doctors:
```*.sh-session
http://localhost:8080/patient/patientId/{patientId}
```
### 3. Services:
* It consists of **DoctorService** ,**PatientService** classes in which provide some business functionalities of every handler methods.
* Used _**@Service**_ annotation to indicate that a class belongs to the service layer.

### 4. Repositories:
* It consists of **IDoctorRepo** ,**IPatientRepo** interfaces that extends JpaRepository which is interface for generic inbuilt CRUD operations on a repository for a specific type. Usually represent the database access layer in an application.
* Used **Iterable** to manage the data of entity classes by performing CRUD operations.
* Used _**@Repository**_ annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.

## Project Summary:
* The Doctor-Patient Management System is a backend API project developed using Java and the Spring Boot framework. It provides functionalities to add doctors, add patients, remove doctor, remove patient along with their symptoms, and suggest doctors based on patient symptoms and location.

* The Suggesting Doctors API accepts a patient ID as input and suggests doctors based on the patient's symptom and location. The suggested doctor is determined based on the patient's symptom, which corresponds to the doctor's specialty. If there are no doctors available in the patient's location or no doctors specialized in treating the patient's symptom, appropriate error responses are returned.

* The project utilizes the Spring Boot framework for core functionalities and Hibernate for performing database operations and enforces validations for various fields.. Swagger can be optionally used to list all the APIs and provide detailed documentation.
