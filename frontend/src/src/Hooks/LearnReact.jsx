import React from 'react'
import { useState, useEffect } from 'react'

const LearnReact = () => {

  const name = "TTTTT";
  const x = 10;
  const y = 20;
  const names = ["Brad", "Jane", "Smith"];
  const loggedIn = true;

  const showingStyles = {
    color: "blue",
    fontSize: "32px",
  };

  //Whatever data that changes put it in a state
  const [count, setCount] = useState(0)
  const [title, setTitle] = useState("")


  const [countries, setCountries] = useState([])

  function addCountryToList(){
    setCountries((currentCountries) => {
      return [
        ...currentCountries, 
        {name: "France"} //Now you can use a map like countries.map(country -> ...) and then do country.name 
      ]
    })
  }

  return (
    <> {/*Fragment can be used instead of a <div> for the parent container*/}
      <h1>Learn React</h1>

      <div className="card">
        <button onClick={() => setCount((count) => count + 1)}>
          count is {count}
        </button>
      </div>

      <p style={{color : "red", fontSize : "24px" }}>
        Name variable is : {name}
      </p>

      <p style={showingStyles}>
        The sum of {x} and {y} is {x + y}
      </p>

      <ul> {/*As index is dynamic with put it in {} */}
        {names.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>

      <input 
        value={title}
        onChange={e => setTitle(e.target.value)}
        type='text'
        id='item'
      />

      {loggedIn ? <p>LoggedIn is true</p> : <p>LoggedIn is false</p>}

      {loggedIn && <p>If loggedIn is true then this will be shown</p>}

      <p className="read-the-docs">
        Please get a job - Past T
      </p>
    </>
  )
}

export default LearnReact