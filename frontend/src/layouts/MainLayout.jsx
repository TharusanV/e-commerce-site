import { Outlet } from 'react-router-dom'

import Navbar from "../components/Navbar";
import Footer from '../components/Footer';

const MainLayout = ({loggedInUser,setLoggedinUser}) => {
  return (
    <>
      <Navbar context={[loggedInUser,setLoggedinUser]}/>
      <Outlet context={[loggedInUser,setLoggedinUser]}/>
      <Footer/>
    </>
  )
}

export default MainLayout