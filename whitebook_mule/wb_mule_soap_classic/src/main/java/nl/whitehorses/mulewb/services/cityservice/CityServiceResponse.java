
package nl.whitehorses.mulewb.services.cityservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Cities" type="{http://services.mulewb.whitehorses.nl/CityService}citiesType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cities"
})
@XmlRootElement(name = "CityServiceResponse")
public class CityServiceResponse {

    @XmlElement(name = "Cities")
    protected CitiesType cities;

    /**
     * Gets the value of the cities property.
     * 
     * @return
     *     possible object is
     *     {@link CitiesType }
     *     
     */
    public CitiesType getCities() {
        return cities;
    }

    /**
     * Sets the value of the cities property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitiesType }
     *     
     */
    public void setCities(CitiesType value) {
        this.cities = value;
    }

}
