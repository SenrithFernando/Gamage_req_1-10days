# DEMO — Library Management (Spring Boot + Next.js)

A small demo application that manages students/members and books.

## 🔧 Tech stack

- Backend: Spring Boot (Java, Maven)
- Frontend: Next.js + React + TypeScript (located in `library_ui`)
- Database: My SQL

---

## 🚀 Quick start

### Prerequisites

- Java 17+ (or compatible JDK)
- Maven (or use the included `mvnw` wrapper)
- Node 18+ and npm

### Start backend

From project root:

```bash
# run with the embedded maven wrapper
./mvnw spring-boot:run
```

Backend runs by default on http://localhost:8081

### Start frontend

Open a second terminal and run:

```bash
cd library_ui
npm install
npm run dev
```

Frontend runs by default on http://localhost:3000

---

## 📡 API (selected endpoints)

- `GET /student/getAllStudent` — list all students
- `GET /student/getStudent?id={id}` — get student by id
- `POST /student/addStudent` — add student (JSON body)
- `PUT /student/updateStudent?id={id}` — update student (JSON body)
- `DELETE /student/deleteStudent?id={id}` — delete student

Use the UI at `/members` to interact with the members (students) endpoints.

---

## 📝 Notes & suggestions

- Passwords are currently stored as provided — consider adding hashing (BCrypt) for any real deployment.
- The frontend `AddStudentForm` allows editing a student but leaves the password blank to keep the existing password.

---

## ✅ Tests & build

- Backend: `./mvnw test` and `./mvnw package`
- Frontend: run `npm test` from the `library_ui` folder (if tests are added)

---

## 📞 Contact / Next steps

If you want, I can:
- Add password hashing (recommended)
- Add validation and better error messages
- Add seed data or Docker setup for DB


Enjoy the demo! 🎉
