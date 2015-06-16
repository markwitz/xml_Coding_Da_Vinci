
<xs:schema targetNamespace="http://www.w3.org/2005/sparql-results#" xmlns:xs="http://www.w3.org/2001/XMLSchema">
	<xs:element name="quiz">
		<xs:complexType>
			<xs:sequence>
				<xs:element name="head">
					<xs:complexType>
						<xs:sequence>
						  <xs:element name="artist" type="xs:string"/>
						  <xs:element name="info" type="xs:string"/>
						  <xs:element name="birth" type="xs:string"/>
						  <xs:element name="death" type="xs:string"/>
						  <xs:element name="piclink" type="xs:string"/>
						</xs:sequence>
					</xs:complexType>
				</xs:element>
				<xs:element name="result" maxOccurs="unbounded">
					<xs:complexType>
						<xs:sequence>
						  <xs:element name="artist" type="xs:string"/>
						  <xs:element name="info" type="xs:string"/>
						  <xs:element name="birth" type="xs:string"/>
						  <xs:element name="death" type="xs:string" minOccurs="0"/>
						  <xs:element name="piclink" type="xs:string" minOccurs="0"/>
						</xs:sequence>
					</xs:complexType>
				</xs:element>
			</xs:sequence>
		</xs:complexType>
	</xs:element>
</xs:schema>
