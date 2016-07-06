package hello;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {

	public Person findByName(String name);

	public List<Person> findByTeammatesName(String name);

}
