

---

# Hospital Management System

## Project Title
### *Hospital Management System*

## Overview
The Hospital Management System is designed to efficiently manage hospital operations, focusing on patient handling and medical procedures. Using Java and the Mediator design pattern, this project simulates a simplified, interactive console-based hospital environment. The system organizes roles such as Doctor, Nurse, Receptionist, Lab, Pharmacy, Surgery, and Billing to provide seamless patient care and operational coordination.

## Features
1. **Patient Management**: Add, view, and search for patients by ID.
2. **Role-Based Actions**:
   - **Doctor**: Examines patients, decides if medication or further testing is needed, and refers critical cases to appropriate roles.
   - **Nurse**: Assists patients in the treatment process.
   - **Pharmacy**: Dispenses prescribed medication.
   - **Lab**: Conducts tests and forwards results.
   - **Billing**: Generates invoices for discharged patients.
3. **Process Workflow**:
   - Each patient’s condition is assessed and routed based on health needs.
   - Supports critical workflows, including test requests, surgery scheduling, medication dispensation, and discharge.
4. **Console-Based User Interface**: Allows users to interact with the system using console input, making the program easy to navigate and test.

## Design Pattern
This project leverages the **Mediator Design Pattern**. The `HospitalMediator` interface and `HospitalMediatorImpl` implementation enable centralized communication between different roles, minimizing direct dependencies between components.

## Classes

- **Main Class** (`HospitalManagementSystem`): Initializes roles, patients, and the mediator, and handles user input for system operations.
- **Role Classes** (`DoctorRole`, `NurseRole`, `ReceptionistRole`, `LabRole`, `PharmacyRole`, `BillingRole`, `SurgeryRole`): Each role class encapsulates specific responsibilities.
- **Mediator** (`HospitalMediatorImpl`): Manages interactions between roles, facilitating actions like assigning rooms, notifying doctors, and generating invoices.
- **Patient Management** (`Patient`, `PatientData`, `PatientDetails`): Manages patient details and provides methods to add, retrieve, and display patient information.

## Getting Started
1. **Compile and Run**: Ensure Java is installed on your system, then compile and run the `HospitalManagementSystem` class to start the console interface.
2. **Interaction**: Follow on-screen prompts to perform various hospital management tasks, such as adding new patients or assigning them to doctors.

## Usage Example

1. Show all existing patients
2. Add new patient
3. Find existing patient by ID
4. Assign Patient to Doctor
5. Exit

- Choose an option to manage patients, assign duties, and simulate hospital operations.
  
## Key Functions and Commands
- **Patient Management**: Adds and retrieves patient information.
- **Role-based Commands**: Each role performs specific duties (e.g., `DoctorRole.performDuty()` for patient examination).
- **Mediation**: `HospitalMediatorImpl` manages inter-role communication.

## Future Enhancements
- Add a graphical interface for better usability.
- Introduce a database for persistent patient and role data storage.
- Expand role functionality and improve patient flow management.

## Conclusion
This project offers a basic yet comprehensive simulation of a hospital management system, focusing on operational coordination and patient management. By using the Mediator pattern, the system achieves modularity and efficient role interactions.

--- 
