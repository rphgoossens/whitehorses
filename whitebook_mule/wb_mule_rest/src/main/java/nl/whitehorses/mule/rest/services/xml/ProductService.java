package nl.whitehorses.mule.rest.services.xml;

import javax.xml.bind.JAXBElement;

import nl.whitehorses.mule.rest.Product;

public interface ProductService {

	public abstract JAXBElement<Product> getProduct();

}