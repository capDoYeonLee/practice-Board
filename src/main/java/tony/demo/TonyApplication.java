package tony.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@EnableJpaAuditing // Jap Auditing 기능이 무엇인지 찾아보자 #TODO
@SpringBootApplication
public class TonyApplication {

	public static void main(String[] args) {
		SpringApplication.run(TonyApplication.class, args);
	}

	@Bean // 이게 무슨 기능을 하는건지 모르겠다
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
