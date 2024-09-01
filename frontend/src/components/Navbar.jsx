import {FaShoppingBasket} from 'react-icons/fa'
import { Link } from 'react-router-dom';
import React, {useEffect, useState} from "react";
import axios from "axios";

const Navbar = () => {
  const [emailData, setEmailData] = useState(null);

  const subNavBarList = [
    { id: 1, name: "Home", destination: "/" },
    { id: 2, name: "Best Sellers", destination: "/" },
    { id: 3, name: "New Releases", destination: "/" },
    { id: 4, name: "Current Deals", destination: "/" },
    { id: 5, name: "Electronics", destination: "/" },
    { id: 6, name: "Grocery", destination: "/" },
    { id: 7, name: "Fashion", destination: "/" },
    { id: 8, name: "Beauty & Personal Care", destination: "/" },
    { id: 9, name: "Toys & Games", destination: "/" },
    { id: 10, name: "Sports & Outdoors", destination: "/" },
    { id: 12, name: "Books", destination: "/" },
    { id: 14, name: "Home & Kitchen", destination: "/" },
    { id: 15, name: "Pet Supplies", destination: "/" }
  ];
  

  useEffect(() => {
    const storedEmail = localStorage.getItem('emailData');
    if (storedEmail) {
      setEmailData(storedEmail);
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem('emailData');  // Remove email from localStorage
    setEmailData(null);  // Clear emailData in the state
  };
  

    return (
      <>
        <nav className="navbar">
          <h2 className="navbar-heading">CompanyNameHere</h2>

          <ul className="navbar-menu">
            {(emailData == null) ? (
              <>
                <li className="navbar-item">
                  <Link to='/register' className="navbar-link">
                    <p>Register</p>
                  </Link>
                </li>

                <li className="navbar-item">
                  <Link to='/login' className="navbar-link">
                    <p>Login</p>
                  </Link>
                </li>
              </>
            ) : (
              <>
                <li className="navbar-item">
                  <Link to='/basket' className="navbar-link">
                    <p>View Basket</p>
                    <FaShoppingBasket size={20}/>
                  </Link>
                </li>
                <li className="navbar-item">
                  <button onClick={handleLogout}>Logout</button>
                </li>
              </>
            )}
          </ul>
        </nav>

        <nav className="sub-navbar">
          <ul className="navbar-menu">
            {subNavBarList.map(menuItem => (
              <li key={menuItem.id} className="navbar-item">
                <Link to={menuItem.destination}>
                  {menuItem.name}
                </Link>
              </li>
            ))}
          </ul>
        </nav>
      </>
    );
}


export default Navbar;

/*
  
 
*/