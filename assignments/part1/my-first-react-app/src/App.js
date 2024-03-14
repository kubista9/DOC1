import React, { useEffect } from 'react';
import './App.css';

function App() {
  useEffect(() => {
    fetch('http://localhost:8080/greeting')
      .then(response => response.text())
      .then(data => console.log(data))
      .catch(error => console.error('There was an error!', error));
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        {/* Your content here */}
        <p>Check the console for the greeting!</p>
      </header>
    </div>
  );
}

export default App;
