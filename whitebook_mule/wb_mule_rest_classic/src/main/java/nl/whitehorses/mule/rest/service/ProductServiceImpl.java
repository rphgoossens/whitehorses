package nl.whitehorses.mule.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.whitehorses.mule.rest.model.Product;

@Path("/product")
public class ProductServiceImpl implements ProductService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.whitehorses.mule.rest.services.json.ProductService#getProduct()
	 */
	@Override
	@GET
	@Path("/get")
	@Produces("application/json")
	public Product getProduct() {
		Product prod = new Product(1, "Matress", "Queen size mattress", 500);

		return prod;
	}

}
