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
package nl.mierasmade.writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;
import com.opencsv.CSVWriter;

import nl.mierasmade.values.FakerValue;

@Component
public class DataWriter {
	
	private Locale language;
	private char delimiter;
	private int count;
	private List<FakerValue> columns;
	private File file;
	
	public void write() {
		Faker faker = new Faker(language);	
		
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(file), delimiter);
			for (int i = 0; i < count; i++) {
				String[] fakeValues = getFakeValues(columns, faker);			
				writer.writeNext(fakeValues);			
			}
			writer.close();				
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}	

	private String[] getFakeValues(List<FakerValue> columns, Faker faker) {
		String[] fakeValues = new String[columns.size()];
		for (int j = 0; j < columns.size(); j++) {
			columns.get(j).setFaker(faker);
			fakeValues[j] = columns.get(j).getValue();
		}
		return fakeValues;
	}

	public void setLanguage(Locale language) {
		this.language = language;
	}

	public void setDelimiter(char delimiter) {
		this.delimiter = delimiter;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setColumns(List<FakerValue> columns) {
		this.columns = columns;
	}

	public void setFile(File file) {
		this.file = file;
	}
}
