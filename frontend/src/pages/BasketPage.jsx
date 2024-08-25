const BasketPage = ({p_basket, p_setBasket}) => {
  return (
    <div className='basket-container'>
      
      <div className="basket">
        <h2>Your Basket</h2>
        {p_basket.map((item) => (
          <div key={item.id}>
            <h4>{item.title}</h4>
            <p>Price: ${item.price}</p>
            <p>Quantity: {item.quantity}</p>
          </div>
        ))}
      </div>

    </div>
  )
}

export default BasketPage