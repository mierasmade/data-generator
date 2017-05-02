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
package nl.mierasmade.language;

public enum Locales {
	
	CA("ca"),
	CA_CAT("ca-CAT"),
	DA_DK("da-DK"),
	DE("de"),
	DE_AT("de-AT"),
	DE_CH("de-CH"),
	EN("en"),
	EN_AU("en-AU"),
	EN_AU_OCKER("en-au-ocker"),
	EN_BORK("en-BORK"),
	EN_CA("en-CA"),
	EN_GB("en-GB"),
	EN_IND("en-IND"),
	EN_NEP("en-NEP"),
	EN_NG("en-NG"),
	EN_NZ("en-NZ"),
	EN_PAK("en-PAK"),
	EN_SG("en-SG"),
	EN_UG("en-UG"),
	EN_US("en-US"),
	EN_ZA("en-ZA"),
	ES("es"),
	ES_MX("es-MX"),
	FA("fa"),
	FI_FI("fi-FI"),
	FR("fr"),
	HE("he"),
	IN_ID("in-ID"),
	IT("it"),
	JA("ja"),
	KO("ko"),
	NB_NO("nb-NO"),
	NL("nl"),
	PL("pl"),
	PT("pt"),
	PT_BR("pt-BR"),
	RU("ru"),
	SK("sk"),
	SV("sv"),
	SV_SE("sv-SE"),
	TR("tr"),
	UK("uk"),
	VI("vi"),
	ZH_CN("zh-CN"),
	ZH_TW("zh-TW");
	
	private final String locale;
	
	Locales(String locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		return locale;
	}

}
