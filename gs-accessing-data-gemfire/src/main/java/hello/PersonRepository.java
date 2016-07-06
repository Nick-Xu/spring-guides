package hello;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

	public Person findByName(String name);

	public Iterable<Person> findByAgeGreaterThan(int age);

	public Iterable<Person> findByAgeLessThan(int age);

	public Iterable<Person> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);

}
