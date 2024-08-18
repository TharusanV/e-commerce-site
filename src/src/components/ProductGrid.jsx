import { useState, useEffect } from 'react';
import image from "../assets/1.jpg"

const ProductGrid = ({p_products, p_basket, p_setBasket}) => {

  function addToBasket(product){
    // Check if the product already exists in the basket
    const existingProductIndex = p_basket.findIndex(item => item.id === product.id);

    if (existingProductIndex !== -1) {
      // Product exists, update its quantity
      const updatedBasket = p_basket.map((item, index) =>
        index === existingProductIndex ? { ...item, quantity: item.quantity + 1 } : item
      );
      p_setBasket(updatedBasket);
    }
    else {
      // Product does not exist, add it to the basket with quantity 1
      const newProduct = { ...product, quantity: 1 };
      p_setBasket([...p_basket, newProduct]);
    }
    
    console.log(`${product.title} added to basket`);
  }

  return (
    <div className="product-container">
      {p_products.map(product => (
        <div key={product.id} className="product-item">
          
          <img src={image} alt="Product Image" className="icon"/>

          <div className="product-info-container">
            <p style={{fontWeight: "bold"}}>{product.title}</p>
            <p>£{product.price}</p>
          </div>

          <p >{product.sku}</p>
          
          <button onClick={() => addToBasket(product)}>
            Add to Cart
          </button> 
        </div>
      ))}
    </div>
  );
};

export default ProductGrid;
