<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="xml" encoding="utf-8" indent="no" />

	<xsl:template match="/">

		<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
			<soap:Body>
				<CityServiceResponse
					xmlns="http://services.mulewb.whitehorses.nl/CityService">
					<Cities>
						<xsl:for-each select="//*[local-name()='City']">
							<City>
								<Name>
									<xsl:value-of select="concat(*[local-name()='Name'],', Belgie')" />

								</Name>
							</City>
						</xsl:for-each>
					</Cities>
				</CityServiceResponse>
			</soap:Body>
		</soap:Envelope>

	</xsl:template>

</xsl:stylesheet>