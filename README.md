# Product Scanner

This project is a full-stack application that allows users to scan product barcodes and retrieve information about the product and its ingredients.

## Features

- **Barcode Scanning:** Scan product barcodes using your device's camera.
- **Manual Entry:** Manually enter a barcode if the scanner is unable to read it.
- **Ingredient Analysis:** View a list of ingredients and their safety information.

## Tech Stack

### Frontend

- **Framework:** React (bootstrapped with Vite)
- **Barcode Scanning:** `html5-qrcode`
- **HTTP Client:** `axios`

### Backend

- **Framework:** Spring Boot
- **Language:** Java 17
- **API Layer:** Spring Web
- **Build Tool:** Maven

## Getting Started

### Prerequisites

- Node.js and npm (or yarn)
- Java 17 or higher
- Maven
- Ollama (with `ollama run llama3.1:8b` model pulled and running locally)

### Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/BharathMopuru/ProductScanner.git
   ```

2. **Backend Setup:**
   ```bash
   cd backend
   mvn clean install
   ```

3. **Frontend Setup:**
   ```bash
   cd ../frontend
   npm install
   ```

### Running the Application

1. **Start the backend:**
   ```bash
   cd backend
   java -jar target/bobby-backend-0.0.1-SNAPSHOT.jar
   ```

2. **Start the frontend:**
   ```bash
   cd ../frontend
   npm run dev
   ```

3. Open your browser and navigate to the URL provided by Vite (usually `http://localhost:5173`).