import React, { useState, useEffect } from 'react';

const UseEffect = () => {
  const [count, setCount] = useState(0);
  const [data, setData] = useState(null);

  // This useEffect hook runs after every render
  useEffect(() => {
    console.log(`Component has been rendered ${count} times.`);
  });

  // This useEffect hook runs only once when the component is mounted
  useEffect(() => {
    console.log('Component mounted');

    // Simulating a data fetch
    setTimeout(() => {
      setData('Fetched data');
    }, 2000);

    // Cleanup function that runs when the component is unmounted
    return () => {
      console.log('Component will unmount');
    };
  }, []);

  // This useEffect hook runs whenever 'count' changes
  useEffect(() => {
    console.log(`Count has been updated to: ${count}`);
  }, [count]);

  return (
    <div>
      <h1>useEffect Hook Example</h1>
      <p>Count: {count}</p>
      <button onClick={() => setCount(count + 1)}>Increment Count</button>
      <p>{data ? data : 'Loading...'}</p>
    </div>
  );
};

export default UseEffect