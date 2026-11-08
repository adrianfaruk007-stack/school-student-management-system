CREATE DATABASE IF NOT EXISTS school_db;
USE school_db;

CREATE TABLE IF NOT EXISTS students (
    student_id     INT AUTO_INCREMENT PRIMARY KEY,
    admission_no   VARCHAR(30)  NOT NULL UNIQUE,
    full_name      VARCHAR(100) NOT NULL,
    gender         VARCHAR(10)  NOT NULL,
    date_of_birth  DATE         NOT NULL,
    class_name     VARCHAR(20)  NOT NULL,
    guardian_name  VARCHAR(100) NOT NULL,
    guardian_phone VARCHAR(20)  NOT NULL,
    address        VARCHAR(150) NOT NULL,
    date_admitted  TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
