# Product Scanner

This project is a single-page React application that uses the device's camera to scan product barcodes and retrieve information from a backend service.

## Features

- **Barcode Scanning:** Accesses the user's camera to scan various barcode formats, including QR codes, EAN, UPC, and more.
- **Manual Entry:** Allows users to manually enter a barcode number.
- **Backend Communication:** Sends the scanned barcode to a backend service to retrieve product information.
- **Result Display:** Displays the product information in a clean, landscape-oriented layout.

## Tech Stack

- **Frontend:** React (bootstrapped with Vite)
- **Barcode Scanning:** `html5-qrcode`
- **HTTP Client:** `axios`

## Getting Started

### Prerequisites

- Node.js and npm (or yarn) installed.
- A running backend service that accepts POST requests at `/api/scan`.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/BharathMopuru/ProductScanner.git
   ```
2. Navigate to the `frontend` directory:
   ```bash
   cd ProductScanner/frontend
   ```
3. Install the dependencies:
   ```bash
   npm install
   ```

### Running the Application

1. Start the development server:
   ```bash
   npm run dev
   ```
2. Open your browser and navigate to the URL provided by Vite (usually `http://localhost:5173`).

## Usage

1. Click the "Start Scanner" button to activate the camera.
2. Position a barcode within the scanner's view.
3. Once the barcode is scanned, the product information will be displayed.
4. To scan another barcode, click the "New Scan" button.
5. Alternatively, you can manually enter a barcode and click "Submit."