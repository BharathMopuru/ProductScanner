import React, { useState } from 'react';

const ManualInput = ({ onSubmit }) => {
  const [manualBarcode, setManualBarcode] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    if (manualBarcode) {
      onSubmit(manualBarcode);
    }
  };

  return (
    <div style={{ marginTop: '20px' }}>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          value={manualBarcode}
          onChange={(e) => setManualBarcode(e.target.value)}
          placeholder="Enter barcode manually"
          style={{ padding: '10px', marginRight: '10px' }}
        />
        <button type="submit" style={{ padding: '10px' }}>
          Submit
        </button>
      </form>
    </div>
  );
};

export default ManualInput;
