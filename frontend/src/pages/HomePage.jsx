import ProductGrid from "../components/ProductGrid";
import Banner from "../components/Banner";

const HomePage = ({p_products, p_basket, p_setBasket}) => {

  const slicedProducts = p_products;

  return (
    <div style={{marginTop: "1rem"}}>
      <Banner/>

      <div className="hero-header">
        <p style={{fontWeight: "bolder", fontSize: "24px", marginTop: "1rem", marginBottom: "1rem"}}>Featured Products</p>
      </div>
      

      <ProductGrid p_products={p_products} p_basket={p_basket} p_setBasket={p_setBasket}/>

    </div>
  )
}

export default HomePage;
