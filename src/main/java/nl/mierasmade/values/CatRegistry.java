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
package nl.mierasmade.values;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;

@Component
public class CatRegistry implements FakerValue {

	private static final String NAME = "Cat Registry";

	private Faker faker;

	@Override
	public void setFaker(Faker faker) {
		this.faker = faker;
	}

	@Override
	public String getValue() {
		return faker.cat().registry();
	}

	@Override
	public String toString() {
		return NAME;
	}

	@Override
	public int compareTo(FakerValue other) {
		return this.toString().compareTo(other.toString());
	}

}
