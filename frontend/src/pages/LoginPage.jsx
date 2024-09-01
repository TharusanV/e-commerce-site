import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import axios from "axios";

function LoginPage() {
  const navigate = useNavigate(); // Use the hook inside the component
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");

  useEffect(() => {
    const storedEmail = localStorage.getItem('emailData');
    if (storedEmail) {
      navigate("/");
    }
  }, []);

  function handleSubmit(e) {
    e.preventDefault();

    axios.get("http://localhost:8080/user").then((response) => {
      // Use .find() to check if any user matches the username and password
      const foundUser = response.data.find(
        (user) => username === user.email && password === user.password
      );

      if (foundUser) {
        console.log(1);
        // If a user is found, store their info in localStorage
        localStorage.setItem("emailData", foundUser.email);
        localStorage.setItem("userID", foundUser.userID);
        localStorage.setItem("seller", foundUser.userType);
        navigate("/"); // Correct usage of navigate function here
      } else {
        // If no user matches, show an error message
        setError("Invalid username or password. Please try again.");
      }
    });
  }

    return (
      <form className="form" noValidate onSubmit={handleSubmit}>
        <label className="labelText">Email:</label>
        <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} required/>

        <label className="labelText">Password:</label>
        <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} required/><br/><br/>
          
        <button type="submit">Submit</button>
      </form>
    )
}


export default LoginPage