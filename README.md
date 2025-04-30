
# SauceDemo Playwright Java Automation Framework

🔍 A robust automation framework built using **Playwright**, **Java**, **TestNG**, and **Maven** to perform end-to-end UI testing on the [SauceDemo](https://www.saucedemo.com) web application.

---

## 📂 Project Structure

```
saucedemo-playwright-java/
├── pom.xml                     # Maven dependencies and build config
├── testng.xml                  # TestNG test suite
├── src
│   ├── main
│   │   └── java
│   │       └── com.pwj.saucedemo
│   │            ├── base       # BaseTest class for browser setup/teardown
│   │            └── pages      # Page Object Model classes
│   └── test
│       └── java
│           └── com.pwj.saucedemo.tests  # Test classes using TestNG
```

---

## 🚀 Tech Stack

- **Java 17+**
- **Playwright Java (1.44.0)**
- **TestNG (7.9.0)**
- **Maven (Surefire plugin)**
- **Eclipse / IntelliJ compatible**

---

## 🧪 How to Run Tests

### ➤ Using Terminal (Maven):
```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### ➤ Using Eclipse:
- Right-click `testng.xml` → Run As → **TestNG Suite**

---

## ✅ Available Test Cases

| Test Class | Description |
|------------|-------------|
| `SauceDemoStandardUserLogin` | Tests valid login using a standard user |
| `SauceDemoInvalidLoginTest` | Tests invalid login and error message validation |

---

## 📘 Page Objects Implemented

- `LandingPage.java` — login form interaction
- `InventoryPage.java` *(in progress)* — post-login item and cart interaction

---

## 🧰 Base Class

- `BaseTest.java` handles:
  - Playwright engine start/stop
  - Browser and context lifecycle
  - URL navigation
  - Reduces test class boilerplate

---

## 📦 Build & Dependency Management

This project uses **Maven**. Key dependencies:

```xml
<dependency>
  <groupId>com.microsoft.playwright</groupId>
  <artifactId>playwright</artifactId>
  <version>1.44.0</version>
</dependency>

<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.9.0</version>
  <scope>test</scope>
</dependency>
```

---

## 👨‍💻 Author

**Siddhartha Upadhyay**  
📍 India  
🔗 [GitHub Profile](https://github.com/your-github-profile)

---

## 📄 License

This project is for educational and demo purposes. No official license applied.
