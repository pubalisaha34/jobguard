# 🛡️ JobGuard

**Recruitment scams are annoying. I built a backend to stop them.**

JobGuard is a security engine that verifies if a recruiter is actually from the company they claim to be. If someone emails you from "Oracle" but uses a Gmail address, this system flags it instantly.

It also features a **"Vigilante Mode"** users can report scammers to a live blacklist database so the community stays protected.

## ⚡ What it actually does
* **Verification Engine:** Checks the sender's domain against a trusted registry (Oracle, Google, etc.).
* **Live Reporting:** If you spot a scammer, you can add them to the system with one click.
* **Real-time Dashboard:** A dark-mode UI to scan emails and view the active blacklist.
* **Automated Testing:** I wrote JUnit integration tests to guarantee the security logic catches bad emails every time.

## 🛠️ Tech Stack
* **Java 21** (Latest LTS)
* **Spring Boot 3** (Backend Logic)
* **Spring Data JPA & H2** (In-Memory Database)
* **REST API** (Endpoint architecture)
* **HTML/CSS** (Frontend Dashboard)

## 📦 How to Run it
1.  Clone this repo.
2.  Run the app: `mvn spring-boot:run`
3.  Open `http://localhost:8080` in your browser.

---
*Built by Pubali as a specialized backend security project.*
