# Premium Calculator

This project is a simple insurance premium calculator that determines the premium based on customer profile data and selected plan options.

## Project Structure

```
premium-calculator
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           ├── model
│   │   │           │   └── CustomerPolicyRequest.java
│   │   │           ├── service
│   │   │           │   └── PremiumCalculatorService.java
│   │   │           └── PremiumCalculatorApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── service
│       │               └── PremiumCalculatorServiceTest.java
│       └── resources
├── pom.xml
└── README.md
```

## Setup Instructions

1. **Clone the repository:**
   ```
   git clone <repository-url>
   ```

2. **Navigate to the project directory:**
   ```
   cd premium-calculator
   ```

3. **Build the project using Maven:**
   ```
   mvn clean install
   ```

4. **Run the application:**
   ```
   mvn exec:java -Dexec.mainClass="com.example.PremiumCalculatorApplication"
   ```

## Usage

To calculate the insurance premium, create an instance of `CustomerPolicyRequest` with the necessary details (customer name, age, plan type, and smoker status) and pass it to the `PremiumCalculatorService`'s `calculatePremium` method.

## Testing

Unit tests are provided for the `PremiumCalculatorService` class using JUnit 5. To run the tests, use the following command:

```
mvn test
```

## License

This project is licensed under the MIT License. See the LICENSE file for details.