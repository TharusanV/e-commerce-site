import {FaShoppingBasket} from 'react-icons/fa'
import { Link } from 'react-router-dom';

const Navbar = () => {

  const subNavBarList = [
    { id: 1, name: "Home", destination: "/" },
  ];

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


export default Navbar;
