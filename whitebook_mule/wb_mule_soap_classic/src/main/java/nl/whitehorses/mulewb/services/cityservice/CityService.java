package nl.whitehorses.mulewb.services.cityservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.5
 * 2016-02-28T21:16:39.032+01:00
 * Generated source version: 3.1.5
 * 
 */
@WebServiceClient(name = "CityService", 
                  wsdlLocation = "file:CityService.wsdl",
                  targetNamespace = "http://services.mulewb.whitehorses.nl/CityService") 
public class CityService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://services.mulewb.whitehorses.nl/CityService", "CityService");
    public final static QName FindAllCitiesSoap12 = new QName("http://services.mulewb.whitehorses.nl/CityService", "FindAllCitiesSoap12");
    static {
        URL url = null;
        try {
            url = new URL("file:CityService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(CityService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:CityService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public CityService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public CityService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CityService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public CityService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public CityService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public CityService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns FindAllCities
     */
    @WebEndpoint(name = "FindAllCitiesSoap12")
    public FindAllCities getFindAllCitiesSoap12() {
        return super.getPort(FindAllCitiesSoap12, FindAllCities.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FindAllCities
     */
    @WebEndpoint(name = "FindAllCitiesSoap12")
    public FindAllCities getFindAllCitiesSoap12(WebServiceFeature... features) {
        return super.getPort(FindAllCitiesSoap12, FindAllCities.class, features);
    }

}
