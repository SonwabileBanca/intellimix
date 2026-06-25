# 📈 Intelimix Basket Commodity Tracker

[![Spring Boot](https://shields.io)](https://spring.io)
[![Java](https://shields.io)](https://oracle.com)
[![PostgreSQL](https://shields.io)](https://postgresql.org)
[![License](https://shields.io)](LICENSE)

A lightweight, high-performance web application built with **Spring Boot 3.x**, **Spring Data JPA (Spring ORM)**, **Spring MVC (Thymeleaf)**, and **PostgreSQL**. The platform serves as an intuitive portal for tracking a fundamental basket of basic consumer goods, traditional commodities (Metals, Energy, Agriculture), and officially recognized digital crypto commodities.

---

## ✨ Features

* **Full CRUD Lifecycle**: Create, Read, Update, and Delete tracked assets directly from the graphical web interface.
* **Spring ORM Persistence**: Native object-to-relational table mapping (`@Entity`) handling data without manual SQL boilerplate code.
* **Cascading Price Streams**: Append multiple sequential historical price records to a single asset using relational mapping structures.
* **Dynamic Grid UI**: Responsive user dashboard utilizing Spring MVC form processing and the Thymeleaf rendering engine.

---

## 🛠️ Tech Stack & Dependencies

* **Core Backend**: Java 17+, Spring Boot 3.x
* **ORM Engine**: Spring Data JPA / Hibernate Core
* **Database Management**: PostgreSQL (Native Driver)
* **Frontend UI Engine**: Spring MVC Web + Thymeleaf Template Engine
* **Build Architecture**: Apache Maven 3.x

---

## 📂 Project Structure

```text
src/main/java/com/auber/intelimix/
│
├── IntelimixApplication.java     # Framework main launcher entry point
│
├── entity/
│   ├── Commodity.java            # Primary asset structural model (@Entity)
│   └── PriceRecord.java          # Relational pricing history node (@Entity)
│
├── repository/
│   └── CommodityRepository.java  # ORM Query Abstraction / Database Layer Interface
│
├── service/
│   └── CommodityService.java     # Core business logic processing and transaction boundaries
│
└── controller/
    └── CommodityController.java  # Spring MVC UI route handling, parameter ingestion
```

---

## ⚙️ Local Environment Configuration

### 1. Provision the PostgreSQL Environment
Open your local `psql` interactive terminal prompt or database admin console and establish the database instance workspace:

```sql
-- 1. Create the application database
CREATE DATABASE commodity_db;

-- 2. Provision a dedicated system account
CREATE USER noluth WITH PASSWORD '';

-- 3. Authorize account access to the target database
GRANT ALL PRIVILEGES ON DATABASE commodity_db TO noluth;

-- 4. Switch connections and explicitly grant public schema privileges
\c commodity_db
GRANT ALL ON SCHEMA public TO noluth;
```

### 2. Configure System Properties
Verify your project's local variables are properly matched. Paste these parameters directly into your configuration block located at `src/main/resources/application.properties`:

```properties
spring.application.name=intelimix

# Database Server Connection Parameters
spring.datasource.url=jdbc:postgresql://localhost:5432/commodity_db
spring.datasource.username=
spring.datasource.password=
spring.datasource.driver-class-name=org.postgresql.Driver

# Spring ORM Database Initialization Strategy
spring.jpa.hibernate.ddl-auto=update

# Automated Runtime SQL Debugging Telemetry
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 🗄️ Optional Testing Seed Query
To immediately generate visualization cards on your screen, copy and parse this sample data array block directly into your interactive query prompt connected to `commodity_db`:

```sql
-- Create reference commodity indices
INSERT INTO commodities (symbol, name, category, unit_of_measure) VALUES 
('GC', 'Gold', 'Metals', 'Per Ounce'),
('CL', 'Crude Oil', 'Energy', 'Per Barrel'),
('KC', 'Coffee', 'Agriculture', 'Per Pound'),
('BTC', 'Bitcoin', 'Crypto', 'Per Token'),
('ETH', 'Ethereum', 'Crypto', 'Per Token');

-- Assign current market values to generated entries
INSERT INTO price_records (commodity_id, price, timestamp) VALUES 
((SELECT id FROM commodities WHERE symbol='GC'), 2350.75, NOW()),
((SELECT id FROM commodities WHERE symbol='CL'), 78.40, NOW()),
((SELECT id FROM commodities WHERE symbol='KC'), 2.25, NOW()),
((SELECT id FROM commodities WHERE symbol='BTC'), 67250.00, NOW());
```

---

## 🏃 Running the Application Globally

Clone this repository to your local directory and run the application engine using your workstation terminal:

```bash
# Clone down repository targets
git clone https://github.com
cd intelimix

# Package and execute application using Maven Wrapper
./mvnw spring-boot:run
```

Once the application initializes cleanly on the terminal logging deck, open your web browser and navigate directly to your local server deployment port:
👉 **`http://localhost:8080/`**

---

## 📌 Control Dashboard Mapping Reference

| Operation Module | Action Point on UI Dashboard | Internal Architecture Action |
| :--- | :--- | :--- |
| **[C]reate** | Green Interface Box: *"Add New Commodity Type"* | Inserts a root configuration row target to `commodities`. |
| **[R]ead** | Main Panel: *"Tracked Commodities Grid"* | Triggers `findAll()` and loops entries to view state. |
| **[U]pdate** | Blue Interface Box: *"Log New Price Entry"* | Creates a foreign-key mapped record to `price_records`. |
| **[D]elete** | Individual Card Element: *"Delete Flag Button"* | Triggers a cascading drop removal constraint action across database layers. |

---

## 📄 License
Distributed under the MIT License. See `LICENSE` for more information.
