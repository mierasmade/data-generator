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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import javafx.concurrent.Task;
import nl.mierasmade.data.Record;
import nl.mierasmade.values.FakerValue;

@Component
public class DataWriter extends Task<Integer> {
	
	private Locale language;
	private String delimiter;
	private int count;
	private List<FakerValue> columns;
	private File file;
	
	@Override
	protected Integer call() throws Exception {		
		Faker faker = new Faker(language);
		
		int totalPercentage = 0;
		int percentageIndex = (count / 1000);		
		
		try (OutputStream os = new FileOutputStream(file); BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, StandardCharsets.UTF_8))){			
			os.write(239);
		    os.write(187);
		    os.write(191);			
			int currentIndex = 0;
			for (int i = 0; i < count; i++) {	
				String[] fakeValues = getFakeValues(columns, faker);
				Record record = new Record(delimiter, fakeValues);
				writer.write(record.toString());
				writer.newLine();
				currentIndex++;
				if (currentIndex == percentageIndex) {
					totalPercentage++;
					updateProgress(totalPercentage, 1000);					
					currentIndex = 0;
				}
			}			
		} catch (IOException e) {						
			e.printStackTrace();
		}		
		return null;
	}	

	private String[] getFakeValues(List<FakerValue> columns, Faker faker) {
		String[] fakeValues = new String[columns.size()];
		for (int j = 0; j < columns.size(); j++) {
			columns.get(j).setFaker(faker);
			fakeValues[j] = columns.get(j).getValue();
		}
		return fakeValues;
	}	

	@Override
	protected void updateProgress(double workDone, double max) {
		super.updateProgress(workDone, max);
	}	

	@Override
	protected void updateMessage(String message) {		
		super.updateMessage(message);
	}

	public void setLanguage(Locale language) {
		this.language = language;
	}

	public void setDelimiter(String delimiter) {
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
