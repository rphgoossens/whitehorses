
package nl.whitehorses.mulewb.services.cityservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.whitehorses.mulewb.services.cityservice package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CityServiceRequest_QNAME = new QName("http://services.mulewb.whitehorses.nl/CityService", "CityServiceRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.whitehorses.mulewb.services.cityservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CityServiceResponse }
     * 
     */
    public CityServiceResponse createCityServiceResponse() {
        return new CityServiceResponse();
    }

    /**
     * Create an instance of {@link CitiesType }
     * 
     */
    public CitiesType createCitiesType() {
        return new CitiesType();
    }

    /**
     * Create an instance of {@link CityType }
     * 
     */
    public CityType createCityType() {
        return new CityType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.mulewb.whitehorses.nl/CityService", name = "CityServiceRequest")
    public JAXBElement<Object> createCityServiceRequest(Object value) {
        return new JAXBElement<Object>(_CityServiceRequest_QNAME, Object.class, null, value);
    }

}
