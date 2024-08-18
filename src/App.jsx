import { Route, createBrowserRouter, createRoutesFromElements, RouterProvider } from "react-router-dom";
import { useState, useEffect } from 'react';

function App() {

  const router = createBrowserRouter(
    createRoutesFromElements(
      <Route path='/' element={<MainLayout/>}>
        <Route index element={<HomePage/>} />
        <Route path='*' element={<UnknownPage/>} />
        <Route path='/basket' element={<BasketPage/>} />
      </Route>
    )
  );

  return <RouterProvider router={(router)} />;
}

export default App
