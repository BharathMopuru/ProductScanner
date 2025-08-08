import React, { useState, useRef, useEffect } from 'react';
import axios from 'axios';
import { Html5QrcodeScanner, Html5QrcodeSupportedFormats } from 'html5-qrcode';
import ScanResult from './ScanResult';
import ManualInput from './ManualInput';

const BarcodeScanner = () => {
  const [scanResult, setScanResult] = useState(null);
  const [error, setError] = useState(null);
  const [isScanning, setIsScanning] = useState(false);
  const scannerRef = useRef(null);

  const sendBarcode = async (barcode) => {
    try {
      const response = await axios.post('http://localhost:8080/api/scan', { barcode });
      setScanResult(response.data);
      setError(null);
    } catch (error) {
      setError('Failed to fetch product information.');
      setScanResult(null);
    }
  };

  const handleScanSuccess = (decodedText) => {
    console.log(`Scanned barcode: ${decodedText}`);
    sendBarcode(decodedText);
    setIsScanning(false);
    if (scannerRef.current) {
      scannerRef.current.clear();
      scannerRef.current = null;
    }
  };

  const handleScanFailure = (err) => {
    setError(`Code scan error = ${err}`);
  };

  useEffect(() => {
    if (isScanning) {
      const scanner = new Html5QrcodeScanner(
        'reader',
        {
          qrbox: {
            width: 250,
            height: 250,
          },
          fps: 5,
          formatsToSupport: [
            Html5QrcodeSupportedFormats.QR_CODE,
            Html5QrcodeSupportedFormats.CODE_128,
            Html5QrcodeSupportedFormats.EAN_13,
            Html5QrcodeSupportedFormats.EAN_8,
            Html5QrcodeSupportedFormats.UPC_A,
            Html5QrcodeSupportedFormats.UPC_E,
            Html5QrcodeSupportedFormats.ITF,
          ],
        },
        /* verbose= */ false
      );
      scanner.render(handleScanSuccess, handleScanFailure);
      scannerRef.current = scanner;
    }

    return () => {
      if (scannerRef.current) {
        scannerRef.current.clear();
        scannerRef.current = null;
      }
    };
  }, [isScanning]);

  const startScanner = () => {
    setIsScanning(true);
  };

  const handleNewScan = () => {
    setScanResult(null);
    setError(null);
    setIsScanning(true);
  };

  return (
    <div className="barcode-scanner-container">
      <h1>Barcode Scanner</h1>
      {error && <p style={{ color: 'red', marginTop: '20px' }}>{error}</p>}

      {!isScanning && !scanResult && (
        <button onClick={startScanner} style={{ padding: '10px', marginTop: '20px' }}>
          Start Scanner
        </button>
      )}

      {isScanning && <div id="reader" width="600px"></div>}

      {scanResult && (
        <>
          <button onClick={handleNewScan} style={{ padding: '10px', marginTop: '20px' }}>
            New Scan
          </button>
          <ScanResult result={scanResult} />
        </>
      )}

      {!isScanning && <ManualInput onSubmit={sendBarcode} />}
    </div>
  );
};

export default BarcodeScanner;
