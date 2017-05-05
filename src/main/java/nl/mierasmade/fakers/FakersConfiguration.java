/*******************************************************************************
 * Copyright 2017 Mieras Made
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package nl.mierasmade.fakers;

import java.util.Set;
import java.util.TreeSet;
import javax.annotation.PostConstruct;
import nl.mierasmade.values.ASINCode;
import nl.mierasmade.values.AddressFirstName;
import nl.mierasmade.values.AddressLastName;
import nl.mierasmade.values.AncientGod;
import nl.mierasmade.values.AncientHero;
import nl.mierasmade.values.AncientPrimordial;
import nl.mierasmade.values.AncientTitan;
import nl.mierasmade.values.AppAuthor;
import nl.mierasmade.values.AppName;
import nl.mierasmade.values.AppVersion;
import nl.mierasmade.values.ArtistName;
import nl.mierasmade.values.BeerHop;
import nl.mierasmade.values.BeerMalt;
import nl.mierasmade.values.BeerName;
import nl.mierasmade.values.BeerStyle;
import nl.mierasmade.values.BeerYeast;
import nl.mierasmade.values.BookAuthor;
import nl.mierasmade.values.BookGenre;
import nl.mierasmade.values.BookPublisher;
import nl.mierasmade.values.BookTitle;
import nl.mierasmade.values.Boolean;
import nl.mierasmade.values.BuildingNumber;
import nl.mierasmade.values.CatBreed;
import nl.mierasmade.values.CatName;
import nl.mierasmade.values.CatRegistry;
import nl.mierasmade.values.ChuckNorrisFact;
import nl.mierasmade.values.City;
import nl.mierasmade.values.CityName;
import nl.mierasmade.values.CityPrefix;
import nl.mierasmade.values.CitySuffix;
import nl.mierasmade.values.Country;
import nl.mierasmade.values.CountryCode;
import nl.mierasmade.values.CreditCardExpirty;
import nl.mierasmade.values.CreditCardNumber;
import nl.mierasmade.values.CreditCardType;
import nl.mierasmade.values.EAN13Code;
import nl.mierasmade.values.EAN8Code;
import nl.mierasmade.values.FakerValue;
import nl.mierasmade.values.FullAddress;
import nl.mierasmade.values.GTIN13Code;
import nl.mierasmade.values.GTIN8Code;
import nl.mierasmade.values.IMEICode;
import nl.mierasmade.values.ISBN10Code;
import nl.mierasmade.values.ISBN13Code;
import nl.mierasmade.values.ISBNGroupCode;
import nl.mierasmade.values.ISBNGs1Code;
import nl.mierasmade.values.ISBNRegistrantCode;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakersConfiguration {
	
	@Autowired
	private AddressFirstName addressFirstName;
	@Autowired
	private AddressLastName addressLastName;
	@Autowired
	private AncientGod ancientGod;
	@Autowired
	private AncientHero ancientHero;
	@Autowired
	private AncientPrimordial ancientPrimordial;
	@Autowired
	private AncientTitan ancientTitan;
	@Autowired
	private AppAuthor appAuthor;
	@Autowired
	private AppName appName;
	@Autowired
	private AppVersion appVersion;
	@Autowired
	private ArtistName artistName;
	@Autowired
	private ASINCode asinCode;
	@Autowired
	private BuildingNumber buildingNumber;
	@Autowired
	private BeerHop beerHop;
	@Autowired
	private BeerMalt beerMalt;
	@Autowired
	private BeerName beerName;
	@Autowired
	private BeerStyle beerStyle;
	@Autowired
	private BeerYeast beerYeast;
	@Autowired
	private BookAuthor bookAuthor;
	@Autowired
	private BookGenre bookGenre;
	@Autowired
	private BookPublisher bookPublisher;
	@Autowired
	private BookTitle bookTitle;
	@Autowired
	private Boolean bool;
	@Autowired
	private CreditCardExpirty creditCardExpirty;
	@Autowired
	private CreditCardNumber creditCardNumber;
	@Autowired
	private CreditCardType creditCardType;
	@Autowired
	private CatBreed catBreed;
	@Autowired
	private CatName catName;
	@Autowired
	private CatRegistry catRegistry;
	@Autowired
	private ChuckNorrisFact chuckNorrisFact;
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
	private EAN8Code ean8Code;
	@Autowired
	private EAN13Code ean13Code;
	@Autowired
	private FullAddress fullAddress;
	@Autowired
	private GTIN8Code gtin8Code;
	@Autowired
	private GTIN13Code gtin13Code;
	@Autowired
	private IMEICode imeiCode;
	@Autowired
	private ISBN10Code isbn10Code;
	@Autowired
	private ISBN13Code isbn13Code;
	@Autowired
	private ISBNGroupCode isbnGroupCode;
	@Autowired
	private ISBNGs1Code isbnGs1Code;
	@Autowired
	private ISBNRegistrantCode isbnRegistrantCode;
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
	
	private final Set<FakerValue> fakerValues = new TreeSet<>();

	//TODO: use reflection to load all fields into the fakerValues list
	//  FieldUtils.getFieldsListWithAnnotation(...)
	@PostConstruct
	private void addFakerValues() {
		fakerValues.add(addressFirstName);
		fakerValues.add(addressLastName);
		fakerValues.add(ancientGod);
		fakerValues.add(ancientHero);
		fakerValues.add(ancientPrimordial);
		fakerValues.add(ancientTitan);
		fakerValues.add(appAuthor);
		fakerValues.add(appName);
		fakerValues.add(appVersion);
		fakerValues.add(artistName);
		fakerValues.add(asinCode);
		fakerValues.add(buildingNumber);
		fakerValues.add(beerHop);
		fakerValues.add(beerMalt);
		fakerValues.add(beerName);
		fakerValues.add(beerStyle);
		fakerValues.add(beerYeast);
		fakerValues.add(bookAuthor);
		fakerValues.add(bookGenre);
		fakerValues.add(bookPublisher);
		fakerValues.add(bookTitle);
		fakerValues.add(bool);
		fakerValues.add(catBreed);
		fakerValues.add(catName);
		fakerValues.add(catRegistry);
		fakerValues.add(chuckNorrisFact);
		fakerValues.add(creditCardExpirty);
		fakerValues.add(creditCardNumber);
		fakerValues.add(creditCardType);
		fakerValues.add(ean8Code);
		fakerValues.add(ean13Code);
		fakerValues.add(city);
		fakerValues.add(cityName);
		fakerValues.add(cityPrefix);
		fakerValues.add(citySuffix);
		fakerValues.add(country);
		fakerValues.add(countryCode);
		fakerValues.add(fullAddress);
		fakerValues.add(gtin8Code);
		fakerValues.add(gtin13Code);
		fakerValues.add(imeiCode);
		fakerValues.add(isbn10Code);
		fakerValues.add(isbn13Code);
		fakerValues.add(isbnGroupCode);
		fakerValues.add(isbnGs1Code);
		fakerValues.add(isbnRegistrantCode);
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
