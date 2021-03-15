package edu.fateclins.soa;

import com.lavasoft.GeoIPService;
import com.lavasoft.GeoIPServiceSoap;

public class GeoIpClient {
	public static void main(String[] args) {
		
		if(args.length != 1) {
			System.out.println("Digite o IP a ser Localicado!");
		}else {
			String ipAddress = args[0];
			
			System.out.println(ipAddress);
			
			GeoIPService ipService = new GeoIPService();
			GeoIPServiceSoap geoIPServiceSoap = ipService.getGeoIPServiceSoap();
			String ipCodeXml = geoIPServiceSoap.getIpLocation(ipAddress);
			
			System.out.println(ipCodeXml);
			System.out.println(geoIPServiceSoap.getIpLocation(ipAddress));
			
			System.out.println(ipCodeXml.substring(ipCodeXml.indexOf("<Country>")+9, ipCodeXml.indexOf("</Country>")));
			String countryCode = ipCodeXml.substring(ipCodeXml.indexOf("<Country>")+9, ipCodeXml.indexOf("</Country>"));
			System.out.println(geoIPServiceSoap.getCountryNameByISO2(countryCode));
		}
	}
}
