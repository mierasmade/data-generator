package nl.mierasmade.data;

import org.springframework.util.StringUtils;

public class Record {
	
	private String[] columns;
	private String delim;
	
	public Record(String delim, String... columns) {
		this.columns = columns;
		this.delim = delim;
	}
	
	@Override
	public String toString() {		
		return StringUtils.arrayToDelimitedString(columns, delim);
	}
}
