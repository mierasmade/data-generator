package nl.mierasmade.fakers;

import java.util.Set;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.mierasmade.values.AddressFirstName;
import nl.mierasmade.values.AddressLastName;
import nl.mierasmade.values.BuildingNumber;
import nl.mierasmade.values.City;
import nl.mierasmade.values.CityName;
import nl.mierasmade.values.CityPrefix;
import nl.mierasmade.values.CitySuffix;
import nl.mierasmade.values.Country;
import nl.mierasmade.values.CountryCode;
import nl.mierasmade.values.FakerValue;
import nl.mierasmade.values.FullAddress;
import nl.mierasmade.values.Latitude;
import nl.mierasmade.values.Longitude;
import nl.mierasmade.values.SecondaryAddress;
import nl.mierasmade.values.State;
import nl.mierasmade.values.StateAbbrevation;
import nl.mierasmade.values.StreetAddress;
import nl.mierasmade.values.StreetAddressNumber;
import nl.mierasmade.values.StreetName;
import nl.mierasmade.values.StreetPrefix;
import nl.mierasmade.values.StreetSuffix;
import nl.mierasmade.values.TimeZone;
import nl.mierasmade.values.ZipCode;

@Component
public class Fakers {
	
	@Autowired
	private AddressFirstName addressFirstName;
	@Autowired
	private AddressLastName addressLastName;
	@Autowired
	private BuildingNumber buildingNumber;
	@Autowired
	private City city;
	@Autowired
	private CityName cityName;
	@Autowired
	private CityPrefix cityPrefix;
	@Autowired
	private CitySuffix citySuffix;
	@Autowired
	private Country country;
	@Autowired
	private CountryCode countryCode;
	@Autowired
	private FullAddress fullAddress;
	@Autowired
	private Latitude latitude;
	@Autowired
	private Longitude longitude;
	@Autowired
	private SecondaryAddress secondaryAddress;
	@Autowired
	private State state;
	@Autowired
	private StateAbbrevation stateAbbrevation;
	@Autowired
	private StreetAddress streetAddress;
	@Autowired
	private StreetAddressNumber streetAddressNumber;
	@Autowired
	private StreetName streetName;
	@Autowired
	private StreetPrefix streetPrefix;
	@Autowired
	private StreetSuffix streetSuffix;
	@Autowired
	private TimeZone timeZone;	
	@Autowired
	private ZipCode zipCode;
	
	private Set<FakerValue> fakerValues = new TreeSet<>();
	
	@PostConstruct
	private void initFakervalues() {
		fakerValues.add(addressFirstName);
		fakerValues.add(addressLastName);
		fakerValues.add(buildingNumber);
		fakerValues.add(city);
		fakerValues.add(cityName);
		fakerValues.add(cityPrefix);
		fakerValues.add(citySuffix);
		fakerValues.add(country);
		fakerValues.add(countryCode);
		fakerValues.add(fullAddress);
		fakerValues.add(latitude);
		fakerValues.add(longitude);
		fakerValues.add(secondaryAddress);
		fakerValues.add(state);
		fakerValues.add(stateAbbrevation);
		fakerValues.add(streetAddress);
		fakerValues.add(streetAddressNumber);
		fakerValues.add(streetName);
		fakerValues.add(streetPrefix);
		fakerValues.add(streetSuffix);
		fakerValues.add(timeZone);
		fakerValues.add(zipCode);		
	}

	public Set<FakerValue> getFakerValues() {
		return fakerValues;
	}
}
