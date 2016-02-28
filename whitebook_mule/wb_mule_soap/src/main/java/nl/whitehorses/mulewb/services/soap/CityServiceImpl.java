package nl.whitehorses.mulewb.services.soap;

import javax.jws.WebService;

import nl.whitehorses.mulewb.services.cityservice.CitiesType;
import nl.whitehorses.mulewb.services.cityservice.CityServiceResponse;
import nl.whitehorses.mulewb.services.cityservice.CityType;
import nl.whitehorses.mulewb.services.cityservice.FindAllCities;

@WebService(targetNamespace = "http://services.mulewb.whitehorses.nl/CityService", name = "FindAllCities")
public class CityServiceImpl implements FindAllCities {

	@Override
	public CityServiceResponse findAllCities(Object in) {
		
		return makeCityServiceResponse();
		
	}

	private CityServiceResponse makeCityServiceResponse() {
		CityServiceResponse resp = new CityServiceResponse();
		CitiesType citiesType = new CitiesType();
	
		CityType ct1 = new CityType();
		ct1.setName("Antwerpen");
		CityType ct2 = new CityType();
		ct2.setName("Brussel");
		CityType ct3 = new CityType();
		ct3.setName("Charleroi");
		CityType ct4 = new CityType();
		ct4.setName("Gent");
		
		citiesType.getCity().add(ct1);
		citiesType.getCity().add(ct2);
		citiesType.getCity().add(ct3);
		citiesType.getCity().add(ct4);
		
		resp.setCities(citiesType);
		return resp;
	}

}
