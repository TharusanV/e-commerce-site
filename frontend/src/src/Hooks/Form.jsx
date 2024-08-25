import React, { useState } from 'react';

const Form = () => {
  // State to store form inputs
  const [formData, setFormData] = useState({
    name: '',
    email: '',
    age: ''
  });

  // State to store multiple sets of form data
  const [allFormData, setAllFormData] = useState([]);

  // Handle form input changes
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
  };

  // Handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();

    // Add the current form data to the allFormData array
    setAllFormData([...allFormData, formData]);

    // Reset form data after submission
    setFormData({
      name: '',
      email: '',
      age: ''
    });
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor='name'> Name: </label>
          <input type="text" name="name" value={formData.name} onChange={handleChange} required/>
        </div>
        <div>
          <label htmlFor='email'> Email: </label>
          <input type="email" name="email" value={formData.email} onChange={handleChange} required/>
        </div>
        <div>
          <label htmlFor='number'> Age: </label>
          <input type="number" name="age" value={formData.age} onChange={handleChange} required/>  
        </div>
        
        <button type="submit">Confirm</button>
      </form>

      <h3>Submitted Data:</h3>
      <ul>
        {allFormData.map((data, index) => (
          <li key={index}>
            <strong>Entry {index + 1}:</strong> Name: {data.name}, Email: {data.email}, Age: {data.age}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default Form;
