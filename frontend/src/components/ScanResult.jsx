import React from 'react';

const ScanResult = ({ result }) => {
  if (!result) {
    return null;
  }

  return (
    <div className="scan-result">
      <div className="scan-result-left">
        <h2>Scan Result</h2>
        <p><strong>Product Name:</strong> {result.productName}</p>
        <p><strong>Country:</strong> {result.country}</p>
        <p><strong>Safe:</strong> {result.safe ? 'Yes' : 'No'}</p>
        <p><strong>Message:</strong> {result.message}</p>
      </div>
      <div className="scan-result-right">
        <div>
          <h3>Ingredients:</h3>
          <ul>
            {result.ingredients &&
              result.ingredients.map((ingredient, index) => (
                <li key={index}>{ingredient}</li>
              ))}
          </ul>
        </div>
        <div>
          <h3>Health Analysis:</h3>
          <p>{result.healthAnalysis}</p>
        </div>
      </div>
    </div>
  );
};

export default ScanResult;
