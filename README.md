# Ecommerce Automation Framework

A comprehensive test automation framework built with **Katalon Studio** to support both **UI and API testing** for e-commerce web applications. It implements data-driven testing, custom keywords, and integrated reporting.

---

## Table of Contents

1. [Overview](#overview)  
2. [Features](#features)  
3. [Project Structure](#project-structure)  
4. [Getting Started](#getting-started)  
   - Prerequisites  
   - Installation  
   - Configuration  
5. [Usage](#usage)  
   - Running Tests  
   - Data-Driven Testing  
   - Custom Keywords  
   - Reporting  
6. [Integration & CI/CD](#integration--cicd)  
7. [Best Practices & Contributions](#best-practices--contributions)  
8. [License](#license)  
9. [Contact](#contact)

---

## Overview

This framework streamlines automated testing for e-commerce applications, combining:

- **Web UI Testing** via Katalon's WebUI capabilities  
- **API Testing** through RESTful and/or SOAP tests  
- **Data-driven execution** using spreadsheets or other external data sources  
- **Reusable custom keywords** for modularity and scalability  
- **Integrated reporting** for insight into test outcomes

---

## Features

- **Full-stack support**: Automate E2E workflows across UI and backend APIs  
- **Low-code flexibility**: Mix codeless design with Groovy scripting for custom logic  
- **Scalable data handling**: Leverage external data files for robust testing scenarios  
- **Unified reporting**: Consolidated execution logs and reports for both UI and API tests  
- **Cross-platform execution**: Compatible with Windows, macOS, and Linux environments  

---

## Project Structure

```text
Ecommerce_automation/
├── Include/
│   └── config/            # Configuration files
├── Data Files/
│   └── TestData/          # External test data
├── Keywords/
│   └── common/            # Custom reusable keywords
├── Object Repository/     # Web element locators
├── Profiles/              # Environment profiles
├── Scripts/               # API testing scripts
├── Test Cases/            # Individual test scenarios
├── Test Suites/           # Logical groupings of test cases
├── Test Listeners/        # Execution event hooks
├── .gitignore
├── build.gradle
├── ResumeReadyAutomationFramework.prj
├── console.properties
├── run_tests.bat
└── run_tests.sh
```

*(Adjust names if needed to match your actual structure.)*

---

## Getting Started

### Prerequisites
- [ ] Katalon Studio (latest version recommended)  
- [ ] Java Runtime Environment (JRE) compatible version  
- [ ] Git for version control (optional but recommended)

### Installation
1. Clone this repo:
   ```bash
   git clone https://github.com/nitinyxko/Ecommerce_automation.git
   cd Ecommerce_automation
   ```
2. Open the project in **Katalon Studio**:
   - Launch Katalon Studio → *File* → *Open Project* → select the project directory.

### Configuration
- Adjust environment-specific values in the `Include/config` folder or within Profiles.  
- Add test data under `Data Files/TestData/` (e.g., Excel or CSV files).  
- Customize or import additional dependencies via `build.gradle` (if applicable).  

---

## Usage

### Running Tests
- Launch tests using either:
  - Katalon Studio’s IDE: Navigate to Test Suites → Select a suite → Click **Run**
  - Command‑line execution for CI:
    ```bash
    ./run_tests.sh  # Unix/macOS
    run_tests.bat   # Windows
    ```

### Data-Driven Testing
- Configure external datasets in *TestData* and link them within test cases to support parameterized testing.

### Custom Keywords
- Leverage reusable logic in `Keywords/common/` to simplify actions like login, cart operations, or validations.

### Reporting
- Generate consolidated test reports via Katalon’s built-in reporting features or integrate with Katalon TestOps for analytics.

---

## Integration & CI/CD

This framework supports seamless integration with automation pipelines:

- **Runtime Engine**: Execute tests via CLI in CI tools like Jenkins, Azure DevOps, or TeamCity  
- **CI/CD Integration**: Embed test executions in build pipelines for continuous feedback  
- **Version Control**: Leverage Git for tracking and collaboration

---

## Best Practices & Contributions

- Maintain modular, reusable keywords to simplify maintenance and scale test logic  
- Keep test data externalized for flexible test coverage  
- Use clear naming conventions for test cases and keywords  
- Contributions are welcome! Feel free to:  
  - Open issues for bugs or enhancements  
  - Submit pull requests with new features  
  - Suggest improvements via GitHub discussions or issues  

---

## License

*(Add your preferred license)*  
e.g., Licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

---

## Contact

For questions or feedback, reach out to **nitinyxko** via GitHub.

---

**Happy testing!**  
Empower your e-commerce automation with reliability, scalability, and clarity.
