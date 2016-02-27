package nl.whitehorses.mulewb.services.soap;

import java.util.List;

import javax.jws.WebService;

import nl.whitehorses.mulewb.model.City;
import nl.whitehorses.mulewb.services.cityservice.CitiesType;
import nl.whitehorses.mulewb.services.cityservice.CityServiceResponse;
import nl.whitehorses.mulewb.services.cityservice.CityType;
import nl.whitehorses.mulewb.services.cityservice.FindAllCities;

@WebService(targetNamespace = "http://services.mulewb.whitehorses.nl/CityService", name = "FindAllCities")
public class CityServiceImpl implements FindAllCities {

	@Override
	public CityServiceResponse findAllCities(Object in) {
		
		CityServiceResponse resp = new CityServiceResponse();

		CitiesType citiesType = new CitiesType();
		
		List<City> cities = City.findAll();
		for (City city : cities) {
			CityType ct = new CityType();
			ct.setName(city.getName());
			citiesType.getCity().add(ct);
		}
		
		resp.setCities(citiesType);
		
		return resp;
		
	}

}
