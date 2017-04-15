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
	
	private String locale;
	
	Locales(String locale) {
		this.locale = locale;
	}
	
	@Override
	public String toString() {
		return locale;
	}

}
