# AutomationExercise UI Testing Project

This project is a hybrid test automation framework built to validate the functionality of the [AutomationExercise](https://automationexercise.com) website using **Java**, **Selenium WebDriver**, **TestNG**, and **Cucumber**. It follows the Page Object Model (POM) design and supports parallel execution, dynamic test data, and rich reporting with **Allure**.

---

## 📌 Project Features

- ✅ UI automation of key features (Authentication, Product Search, Contact Form, etc.)
- ✅ Dual support for TestNG and Cucumber
- ✅ Page Object Model (POM) with reusable components
- ✅ Dynamic test data using Java Faker
- ✅ Parallel execution via TestNG XML
- ✅ Rich test reporting with Allure
- ✅ Logging via Log4j

---

## 🛠️ Tech Stack

| Tool               | Purpose                        |
|--------------------|---------------------------------|
| Java 21             | Programming Language            |
| Selenium WebDriver | UI Test Automation Framework    |
| TestNG             | Test Management & Execution     |
| Cucumber           | BDD Style Test Execution        |
| Maven              | Build & Dependency Management   |
| WebDriverManager   | Auto Browser Driver Management  |
| Allure             | Reporting Tool                  |
| Java Faker         | Test Data Generator             |
| Log4j              | Logging                         |

---

## 🧩 Project Structure

```
src/
├── main/
│   └── java/
│       ├── Pages/            # Page Object Model classes
│       └── Utils/            # BaseTest, TestDataGenerator, helpers
├── test/
│   └── java/
│       ├── Tests/            # TestNG test classes
│       ├── stepDefinitions/  # Cucumber step definitions
│       └── runners/          # Cucumber runner classes
├── test/
│   └── resources/
│       └── features/         # Gherkin feature files
├── testng.xml                # TestNG suite configuration
├── pom.xml                   # Maven build config
```

---

## 🚀 How to Run Tests

### ▶ Run TestNG Tests (with Parallel Execution)
```bash
  mvn clean test
```
> Ensure `testng.xml` is configured with parallel="classes"

### ▶ Run Cucumber Tests
```bash
  mvn test -Dcucumber.features=src/test/resources/features
```

---

## 📊 Allure Report Generation

### Step 1: Run Tests (TestNG or Cucumber)
```bash
  mvn clean test
```

### Step 2: Generate Allure Report
```bash
  allure serve target/allure-results
```
> Make sure Allure CLI is [installed and added to PATH](https://docs.qameta.io/allure/#_installing_a_commandline)

---

## ✅ Sample Test Areas

- 🔐 **AuthenticationTest** — Sign up, login, logout, duplicate email
- 🛒 **ProductsTest** — Search products, view product details
- ✉️ **ContactUsTest** — Fill and submit Contact Us form
- 📄 **TestCasesPageTest** — Navigation to Test Cases page
- 🧪 **Cucumber** — Mirrors TestNG logic using Gherkin scenarios

---

## 🧠 Best Practices Applied

- Page Object Model (POM)
- Thread-safe WebDriver with ThreadLocal
- Shared test logic across TestNG and Cucumber
- Allure annotations: `@Epic`, `@Feature`, `@Severity`, `@Description`
- Dynamic user data via Java Faker
- Logging and alert handling helpers

---

## 🧪 Parallel Execution

Enabled in `testng.xml`:
```xml
<suite name="Automation Suite" parallel="classes" thread-count="4">
```

This launches multiple browser sessions for faster execution.

---

## 🤝 Contributing
Pull requests and suggestions are welcome. Please fork the repo and create a branch for any enhancements or bug fixes.

---

## 📄 License
This project is provided for educational and automation demonstration purposes.
