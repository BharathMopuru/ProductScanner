# Project: Ingredient Safety Scanner

## 1. Introduction & Vision

The Ingredient Safety Scanner is a mobile-first application designed to empower health-conscious consumers. By scanning a product's barcode, users can quickly verify if the product contains ingredients that they consider unsafe or wish to avoid. If a product is not in an existing database, the application will allow users to scan the product's ingredient list directly to perform the analysis.

## 2. Functional Requirements

### 2.1. Core Scanning & Verification
- **FR1: Barcode Scanning:** The application must use the device's camera to scan standard product barcodes (UPC, EAN).
- **FR2: Product Lookup (API First):**
    - Upon a successful scan, the app will query an external product database (e.g., Open Food Facts API) using the barcode.
    - If the product is found, the app will retrieve its ingredient list.
- **FR3: Ingredient Analysis:**
    - The retrieved ingredients will be cross-referenced with a predefined list of unsafe ingredients.
    - The app will display a clear result:
        - **Safe:** No flagged ingredients found.
        - **Unsafe:** One or more flagged ingredients found.
- **FR4: OCR for Manual Scanning (Fallback):**
    - If a product is not found via the barcode lookup, the user will be prompted to take a picture of the ingredient list on the product's packaging.
    - The application must use Optical Character Recognition (OCR) to extract the text from the image.
    - The extracted text will be parsed to identify individual ingredients.
    - The parsed ingredients will then be analyzed as per **FR3**.

## 3. Non-Functional Requirements

### 3.1. Performance
- **NFR1:** Barcode lookups should return a result in under 3 seconds on a stable internet connection.
- **NFR2:** OCR processing of a clear image should complete in under 5 seconds.

### 3.2. Accuracy
- **NFR3:** Barcode scanning accuracy must be above 99%.
- **NFR4:** OCR ingredient extraction accuracy must be at least 95% for clear, well-lit images of standard packaging text.

### 3.3. Usability & UI/UX
- **NFR5:** The user interface must be clean, intuitive, and provide clear, easy-to-understand feedback (e.g., using green/red/yellow color codes for results).
- **NFR6:** The process from opening the app to getting a result should require minimal taps.

### 3.4. Data & Security
- **NFR7:** All communication with the backend and external APIs must be over HTTPS.

### 3.5. Technical
- **NFR8:** The backend must be a RESTful API.
- **NFR9:** The system must integrate with at least one external, public-facing food product database.

## 4. Assumptions & Dependencies
- The user's device has a functional camera.
- The user has a stable internet connection for API lookups.
- A reliable external API for food products is available (e.g., Open Food Facts).
- OCR technology is sufficiently mature to handle various packaging fonts and styles.

## 5. Out of Scope
- This application provides information, not medical advice. A disclaimer will be prominently displayed.
- Social sharing features.
- Product purchasing or price comparison.
