package nl.whitehorses.mulewb.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class City {
	@XmlElement(name="Name")
	private String name;

	public City(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static List<City> findAll() {

		List<City> cities = new ArrayList<City>();

		cities.add(new City("Antwerpen"));
		cities.add(new City("Bruxelles"));
		cities.add(new City("Charleroi"));
		cities.add(new City("Gent"));

		return cities;
	}

}
