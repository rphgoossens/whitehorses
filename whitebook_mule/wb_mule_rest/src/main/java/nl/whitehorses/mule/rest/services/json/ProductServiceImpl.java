package nl.whitehorses.mule.rest.services.json;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.whitehorses.mule.rest.Product;


@Path("/product")
public class ProductServiceImpl implements ProductService {

	/* (non-Javadoc)
	 * @see nl.whitehorses.mule.rest.services.json.ProductService#getProduct()
	 */
	@Override
	@GET
    @Path("/get")
    @Produces("application/json")
	public Product getProduct() {
		Product prod = new Product();
		prod.setId(1);
		prod.setName("Mattress");
		prod.setDescription("Queen size mattress");
		prod.setPrice(500);

		return prod;
	}

}
