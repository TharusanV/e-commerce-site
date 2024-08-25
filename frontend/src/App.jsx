import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from "react-router-dom";
import { useState, useEffect } from 'react';

import products from './productsJson.json'

import MainLayout from "./layouts/MainLayout";
import HomePage from "./pages/HomePage";
import BasketPage from "./pages/BasketPage";
import UnknownPage from "./pages/UnknownPage";

function App() {
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
