package hello;

import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

import com.gemstone.gemfire.cache.GemFireCache;

@SpringBootApplication
@EnableGemfireRepositories
public class Application {

	@Bean
	public Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "DataGemFireRestApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}

	@Bean
	public CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	public LocalRegionFactoryBean<String, Person> helloRegion(GemFireCache cache) {
		LocalRegionFactoryBean<String, Person> helloRegion = new LocalRegionFactoryBean<>();
		helloRegion.setCache(cache);
		helloRegion.setClose(false);
		helloRegion.setName("hello");
		helloRegion.setPersistent(false);
		return helloRegion;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
