xquery version "1.0" encoding "utf-8";

(:: OracleAnnotationVersion "1.0" ::)

declare namespace ns1="http://whitehorses.nl/Whitebook_OSB12c/WeerstationService";
(:: import schema at "../wsdl/WeerstationService.xsd" ::)
declare namespace ns2="http://www.webserviceX.NET";
(:: import schema at "../wsdl/globalweather.wsdl" ::)

declare namespace com = "http://whitehorses.nl/Whitebook_OSB12c/common";

declare variable $weerstationverzoek as element() (:: schema-element(ns1:WeerstationServiceVerzoek) ::) external;

declare function local:func($weerstationverzoek as element() (:: schema-element(ns1:WeerstationServiceVerzoek) ::))
  as element() (:: schema-element(ns2:GetCitiesByCountry) ::) {
    <ns2:GetCitiesByCountry>
        <ns2:CountryName>{dvmtr:lookup('WeerstationService/transformaties/Landen-naar-Countries', 'land', $weerstationverzoek/com:Land/com:Naam, 'country', '')}</ns2:CountryName>
    </ns2:GetCitiesByCountry>
};

local:func($weerstationverzoek)
