---

# Hospital Management System

## Overview

The Hospital Management System is a Java application that simulates the process of managing patients in a hospital setting. It allows users to add patients, find existing patients by ID, assign roles to healthcare professionals, and manage the flow of patient care from admission to discharge.

## Features

- **Patient Management**: Add new patients and view existing patient details.
- **Role-Based Access**: Different roles such as Doctor, Nurse, Receptionist, and Pharmacy handle specific duties.
- **Patient Treatment Flow**: Simulates the patient treatment process, including testing, surgery, and billing.

## Structure

### Classes

1. **HospitalManagementSystem**
   - The main entry point of the application.
   - Provides a menu-driven interface for user interaction.

2. **Patient**
   - Represents a patient with attributes like ID, name, and whether a test is required.

3. **PatientData**
   - Manages the details of patients, including generating unique IDs.

4. **PatientDetails**
   - Contains a list of patients and methods for adding, finding, and displaying patients.
   - Initializes a set of default patients.

5. **Role Interface**
   - Defines the contract for roles in the hospital (e.g., Doctor, Nurse, Pharmacy).

6. **DoctorRole, NurseRole, ReceptionistRole, PharmacyRole, SurgeryRole, BillingRole, LabRole**
   - Implement the Role interface and handle specific duties related to patient care.

7. **HospitalMediator**
   - Interface for managing communication between different roles.

8. **HospitalMediatorImpl**
   - Implements the mediator pattern to coordinate tasks between various roles.

## Usage

### Running the Application

1. Ensure you have JDK installed on your machine.
2. Clone or download the repository to your local machine.
3. Open a terminal and navigate to the project directory.
4. Compile the Java files:

### Menu Options

- **1. Show all existing patients**: Displays a list of all registered patients.
- **2. Add new patient**: Prompts the user to enter patient details and adds a new patient.
- **3. Find existing patient by ID**: Allows the user to search for a patient using their ID.
- **4. Assign Patients**: Assigns a patient to the appropriate role for further actions.
- **5. Exit**: Terminates the application.

### Role Functions

- Each role (Doctor, Nurse, etc.) has specific duties that can be performed based on patient ID.
- The flow of the application simulates real-world hospital procedures, guiding users through patient management.

## Example Patient Initialization

The system initializes with a few example patients:
- **Hari Dass** (30)
- **Jane Alam** (25)
- **Ali Haidar** (40)
- **Harish Kumar** (50)
- **Kamla Devi** (35)

## Dependencies

- Java SE Development Kit (JDK)

## Conclusion

This Hospital Management System project serves as a practical demonstration of object-oriented programming concepts, design patterns, and role-based access control in Java. It can be further expanded with features like persistent storage, user authentication, and a graphical user interface.

---
