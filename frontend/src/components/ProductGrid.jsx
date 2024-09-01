import { useState, useEffect } from 'react';

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
          
          <div style={{display: 'flex', justifyContent: 'center'}}>
            <img src={`src/assets/${product.image}`} alt="Product Image" className="icon"/>
          </div>

          <div className="product-info-price-container">
            <p style={{fontWeight: "bold"}}>£{product.price}</p>
          </div>

          <div className="product-info-container">
            <p > {product.title.length > 50 ? `${product.title.slice(0, product.title.slice(0, 50).lastIndexOf(' '))}...` : product.title} </p>
          </div>
          
          <button onClick={() => addToBasket(product)}>
            Add to Cart
          </button> 
        </div>
      ))}
    </div>
  );
};

export default ProductGrid;
