package crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.RequestMapping;

@EntityScan(
        basePackageClasses = {CrmApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class CrmApplication extends SpringBootServletInitializer {

	@RequestMapping("/")
	String home() {
		SpringApplication.run(CrmApplication.class);
		return "Hello World!";
	}
    public static void main(String[] args) {
    	System.out.print("sadsadasdasdasdasdasdasdas");
        SpringApplication.run(CrmApplication.class, args);
    }

}
