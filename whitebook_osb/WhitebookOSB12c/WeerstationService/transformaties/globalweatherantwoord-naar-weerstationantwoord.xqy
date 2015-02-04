xquery version "1.0" encoding "utf-8";

(:: OracleAnnotationVersion "1.0" ::)

declare namespace ns2="http://whitehorses.nl/Whitebook_OSB12c/WeerstationService";
(:: import schema at "../wsdl/WeerstationService.xsd" ::)
declare namespace ns1="http://www.webserviceX.NET";
(:: import schema at "../wsdl/globalweather.wsdl" ::)
declare namespace com="http://whitehorses.nl/Whitebook_OSB12c/common";
(:: import schema at "../wsdl/common.xsd" ::)

declare variable $globalweatherantwoord as element() (:: schema-element(ns1:GetCitiesByCountryResponse) ::) external;
declare variable $land as xs:string external;


declare function local:func($globalweatherantwoord as element() (:: schema-element(ns1:GetCitiesByCountryResponse) ::), $land as xs:string)
  as element() (:: schema-element(ns2:WeerstationServiceAntwoord) ::) {
    <ns2:WeerstationServiceAntwoord>
      <com:Land>
        <com:Naam>{$land}</com:Naam>
        <com:Steden>
          {
          for $stad in fn-bea:inlinedXML($globalweatherantwoord/ns1:GetCitiesByCountryResult)/Table
          return
          <com:Stad>
            <com:Naam>{data($stad/City)}</com:Naam>
          </com:Stad>
          } 
        </com:Steden>
      </com:Land>
    </ns2:WeerstationServiceAntwoord>
};

local:func($globalweatherantwoord,$land)
