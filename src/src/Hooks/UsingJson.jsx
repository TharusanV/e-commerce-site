import TestJson from '../product.json'

const UsingJson = () => {
  return (
    <div>
      {TestJson.map(aJson => {
        return(
          <div key={aJson.id}>
            {aJson.title}
          </div>
        )
      })}

      
    </div>
  )
}

export default UsingJson