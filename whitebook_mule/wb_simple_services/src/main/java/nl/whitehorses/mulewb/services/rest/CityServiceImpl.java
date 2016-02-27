package nl.whitehorses.mulewb.services.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import nl.whitehorses.mulewb.model.City;

@Path("/cities")
public class CityServiceImpl implements CityService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.whitehorses.mulewb.services.CityService#getCities()
	 */
	@Override
	@GET
	@Produces("application/json")
	@Path("/list")
	public List<City> getCities() {
		return City.findAll();
	}

}
