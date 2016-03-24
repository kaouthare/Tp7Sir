import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

public class main {

	public static void main( String[] args ) throws UnknownHostException
	{
		Morphia morphia = new Morphia();	
		Mongo mongo = new Mongo();
		morphia.map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");
		
		Person p = new Person();
		p.setName("Tintin");
		List<Address> listAdress = new ArrayList<Address>();
		Address address = new Address();
		address.setStreet("123 Some street");
		address.setCity("Some city");
		address.setPostCode("123 456");
		address.setCountry("Some country");
		listAdress.add(address);
		//set address
		p.setAddress(listAdress);
		
		Person p2 = new Person();
		p2.setName("Dupont");
		List<Address> listAdress2 = new ArrayList<Address>();
		Address address2 = new Address();
		address2.setStreet("263 Avenue General leclerc");
		address2.setCity("Rennes");
		address2.setPostCode("35000");
		address2.setCountry("France");
		listAdress2.add(address2);
		//set address
		p2.setAddress(listAdress2);
		
		Person p3 = new Person();
		p3.setName("Jack");
		List<Address> listAdress3 = new ArrayList<Address>();
		Address address3 = new Address();
		address3.setStreet("Wall Street");
		address3.setCity("Now york");
		address3.setPostCode("45663");
		address3.setCountry("USA");
		listAdress3.add(address3);
		//set address
		p3.setAddress(listAdress3);
		
		//Article
		Article a = new Article();
		a.setName("Marche verte");
		a.setStars(4);
		List<Person> listPerson =new ArrayList<Person>();
		listPerson.add(p3);
		listPerson.add(p2);
		a.setBuyers(listPerson);
		// Save the POJO
		ds.save(p);
		ds.save(p2);
		ds.save(p3);
		
		ds.save(a);
		
		
		// 
		
		
		for (Person e : ds.find(Person.class)){
			 System.err.println(e);
		System.err.println(e.getAddress());
		
		}
			
		for (Article e : ds.find(Article.class)){
			 System.err.println(e);
		System.err.println(e.getName());
		System.err.println(e.getStars());
		
		}
	}

}
