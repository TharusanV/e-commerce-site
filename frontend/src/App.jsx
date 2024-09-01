import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from "react-router-dom";
import { useState, useEffect } from 'react';

import products from './productsJson.json'

import MainLayout from "./layouts/MainLayout";
import HomePage from "./pages/HomePage";
import BasketPage from "./pages/BasketPage";
import UnknownPage from "./pages/UnknownPage";
import LoginPage from "./pages/LoginPage";
import RegistrationPage from "./pages/RegistrationPage";
import CreateProductPage from "./pages/CreateProductPage";

function App() {
  const [loggedInUser, setLoggedinUser] = useState("");
  const [basket, setBasket] = useState([]);

  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout loggedInUser={loggedInUser} setLoggedinUser={setLoggedinUser}/>}>
        <Route index element={<HomePage p_products={products} p_basket={basket} p_setBasket={setBasket} />} />
        <Route path='*' element={<UnknownPage/>} />
        <Route path='/basket' element={<BasketPage p_basket={basket} p_setBasket={setBasket}/>} />
        <Route path='/login' element={<LoginPage />} />
        <Route path='/register' element={<RegistrationPage />} />
        <Route path='/createProduct' element={<CreateProductPage />} />
      </Route>
    )
  );

  return <RouterProvider router={(router)} />;
}

export default App
