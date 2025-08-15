# 🚖 Tripease – Cab Booking Service

Tripease is a Spring Boot–based cab booking application that allows customers to:
- Register & book available cabs.
- Get assigned drivers automatically.
- Receive booking confirmation via email.
- Make secure online payments via **Razorpay API**.

---

## 📌 Features
- **Customer Management**: Register, update, delete customers.
- **Cab Availability**: Assign the nearest available cab.
- **Driver Assignment**: Map a driver to the booked cab.
- **Booking Service**:
  - Create booking with per-km rate calculation.
  - Store booking data in a relational database.
- **Email Notification**: Send booking confirmation to customer via SMTP.
- **Razorpay Integration**:
  - Create payment orders.
  - Capture payments.
  - Handle payment callbacks/webhooks.
- **Exception Handling**: Custom exceptions for `CustomerNotFound` and `CabNotAvailable`.

---

## 🛠️ Tech Stack
- **Backend**: Java 17, Spring Boot, Spring Data JPA
- **Database**: MySQL
- **Email Service**: JavaMailSender
- **Payment Gateway**: Razorpay API
- **Build Tool**: Maven/Gradle
- **API Documentation**: Swagger

---

## 📂 Project Structure
