import {FaShoppingBasket} from 'react-icons/fa'
import { Link } from 'react-router-dom';
import React, {useEffect, useState} from "react";
import { useOutletContext } from 'react-router-dom';
import axios from "axios";

const Navbar = () => {
  //const [loggedInUser, setLoggedinUser] = useOutletContext();
  const [userdata, setUserdata] = useState("");

  const subNavBarList = [
    { id: 1, name: "Home", destination: "/" },
  ];

  /*
  useEffect(()=>{
    if(loggedInUser!==""){
        const jwt = sessionStorage.getItem('jwt');
        console.log(jwt);
        axios({
            method: 'get',
            url: 'http://localhost:8080/user/findByEmail',
            params: {email: loggedInUser},
            headers: {"Authorization" : `Bearer ${jwt}`}
        }).then((response) => {
            if (response.status === 200){
                console.log(response.data);
                console.log(response.data.userType);
                setUserdata(response.data.userType);
            }
        }).catch(err => {
            console.log(err.response);
            setUserdata("Data failure");
        })
    }
  },[loggedInUser]);
  */

  return (
    <>
      <nav className="navbar">
        <h2 className="navbar-heading">CompanyNameHere</h2>

        <ul className="navbar-menu">
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
  
  if (loggedInUser==="") {
    return (
      <>
        <nav className="navbar">
          <h2 className="navbar-heading">CompanyNameHere</h2>

          <ul className="navbar-menu">
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
  else{
    return (
      <>
        <nav className="navbar">
          <h2 className="navbar-heading">CompanyNameHere</h2>

          <ul className="navbar-menu">
            <li className="navbar-item">
              <Link to='/basket' className="navbar-link">
                <p>View Basket</p>
                <FaShoppingBasket size={20}/>
              </Link>
            </li>
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
*/