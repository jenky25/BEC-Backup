package com.example.JWTSecure;
import com.example.JWTSecure.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Configuration
@EnableWebMvc
public class JwtSecureApplication {

	public static void main(String[] args) {SpringApplication.run(JwtSecureApplication.class, args);}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8070");
			}
		};
	}

	@Bean
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
		@Bean
		CommandLineRunner run(UserService userService){
		return args -> {
//			userService.saveRole(new Role(null,"ROLE_USER"));
//			userService.saveRole(new Role(null,"ROLE_MANAGER"));
//			userService.saveRole(new Role(null,"ROLE_ADMIN"));
//			userService.saveRole(new Role(null,"ROLE_SUPER_ADMIN"));
//
////
//			String date= "10-03-2021";
//			DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			LocalDate localDate =  LocalDate.parse(date, format);
//
//			userService.saveUser(new User(null,"LoGi","Nguyen Thanh Long","123456","longgi@gmail.com","0971858758","Thai Binh",true));
//			userService.saveUser(new User(null,"LongKame","Hoang Thanh Giang","123456","longthanh@gmail.com","0971858757","Ha Giang",true));

//
//			userService.addRoleToUser("LongKame","ROLE_USER");
//			userService.addRoleToUser("LongSaker","ROLE_USER");
//			userService.addRoleToUser("LongSaker","ROLE_ADMIN");
//			userService.addRoleToUser("LongKame","ROLE_MANAGER");
		};
	}
}
