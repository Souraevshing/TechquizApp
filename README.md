# TechQuiz App

TechQuiz App is a standalone **Java Swing-based examination management system** that provides a complete quiz and exam workflow in a single desktop application.

The application supports **Admin and Student roles**, with role-based access to different features. Administrators can register students, create exams, and manage questions, while students can take exams, receive automatically calculated scores, view their performance, and change their passwords.

## 🚀 Features

### 👨‍💼 Admin

- Admin authentication
- Register new students
- Create and manage exams
- Add exam questions
- Update existing questions
- View student performance
- Manage the overall examination system

### 👨‍🎓 Student

- Student registration and login
- Secure authentication
- View available exams
- Take exams
- Automatic evaluation
- View exam scores and percentages
- View previous exam performance
- Change password

### 📝 Examination System

- Multiple exams and subjects/languages
- Multiple-choice questions
- Tracks:
  - ✅ Correct answers
  - ❌ Wrong answers
  - ⏭️ Unattempted questions
  - 📊 Percentage
- Automatically generates exam results
- Prevents students from repeatedly attempting completed exams

### 🗄️ Database

- MySQL database integration
- JDBC connectivity
- Automatic database/table initialization
- DAO-based database architecture
- Required tables are automatically created when the application starts

### Structure
`
TechQuiz App
│
├── GUI
│   ├── Login
│   ├── Registration
│   ├── Admin Dashboard
│   ├── Student Dashboard
│   └── Examination Screens
│
├── DAO
│   ├── UserDAO
│   ├── ExamDAO
│   ├── QuestionsDAO
│   └── PerformanceDAO
│
├── POJO
│   ├── User
│   ├── Exam
│   ├── Question
│   └── Performance
│
└── Config
    ├── DBConnection
    └── DBInitializer
`