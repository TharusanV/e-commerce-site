import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from "react-router-dom";

import { useState, useEffect } from 'react';

import products from './oldProducts.json'

import MainLayout from "./layouts/MainLayout";
import HomePage from "./pages/HomePage";
import BasketPage from "./pages/BasketPage";
import UnknownPage from "./pages/UnknownPage";

const App = () => {

  /*
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const res = await fetch('http://localhost:5000/products'); 
        const data = await res.json();
        setProducts(data);
      } catch (error) {
        console.log('Error fetching data', error);
      }
    }

    fetchProducts();
  }, []);
  */

  const [basket, setBasket] = useState([]);

  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout/>}>
        <Route index element={<HomePage p_products={products} p_basket={basket} p_setBasket={setBasket} />} />
        <Route path='*' element={<UnknownPage/>} />
        <Route path='/basket' element={<BasketPage p_basket={basket} p_setBasket={setBasket}/>} />
      </Route>
    )
  );

  return <RouterProvider router={(router)} />;
}

export default App
