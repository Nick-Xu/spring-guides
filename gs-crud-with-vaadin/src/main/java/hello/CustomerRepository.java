package hello;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public List<Customer> findByLastNameStartsWithIgnoreCase(String lastName);

}