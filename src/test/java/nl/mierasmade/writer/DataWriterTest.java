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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.test.AssertFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.test.context.junit4.SpringRunner;

import javafx.embed.swing.JFXPanel;
import nl.mierasmade.fakers.Fakers;
import nl.mierasmade.values.FakerValue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataWriterTest {
	
	private static final String ACTUAL_ADDRESS_FILE = "target/Address.csv";	
	private static final String EXPECTED_ADDRESS_FILE = "src/test/resources/Address.csv";
	
	@Autowired
	private DataWriter dataWriter;
	@Autowired
	private Fakers fakers;
	
	@Before
	public void setUp() {
		new JFXPanel();		
	}
	
	@Test
	public void call_Valid_args() throws Exception {
		dataWriter.setLanguage(Locale.ENGLISH);
		dataWriter.setDelimiter(";");
		dataWriter.setCount(1000);			
		List<FakerValue> columns = new ArrayList<FakerValue>();
		for (FakerValue fakerValue : fakers.getFakerValues()) {
			columns.add(fakerValue);
		}
		dataWriter.setColumns(columns);
		dataWriter.setFile(new File(ACTUAL_ADDRESS_FILE));	
		
		dataWriter.call();	
		
		// Test line count
		AssertFile.assertLineCount(1000, new FileSystemResource(ACTUAL_ADDRESS_FILE));		
	
		// Test uniqueness
		//AssertFile.assertFileEquals(new FileSystemResource(ACTUAL_ADDRESS_FILE), new FileSystemResource(EXPECTED_ADDRESS_FILE));
	}	
}
