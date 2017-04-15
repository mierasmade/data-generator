package nl.mierasmade.values;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

@Component
public interface FakerValue extends Comparable<FakerValue>{

	void setFaker(Faker faker);
	String getValue();	

}
