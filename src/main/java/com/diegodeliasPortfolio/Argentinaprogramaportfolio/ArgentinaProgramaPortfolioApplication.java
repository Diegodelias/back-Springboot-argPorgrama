package com.diegodeliasPortfolio.Argentinaprogramaportfolio;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.User;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Usuario;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.UserRepository;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.UsuarioRepository;



@SpringBootApplication
@CrossOrigin(origins = "*")
public class ArgentinaProgramaPortfolioApplication {

	@Autowired
	private UserRepository repository;
	@PostConstruct
	public void initUsers(){

		User user = new User( 1 , "usuarioUno" , "123456", "usuario1@gmail.com" ,"ADMIN");
		repository.save(user);

	}
	@Bean 
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("https://portfoliobackdiegodelias.herokuapp.com").allowedHeaders("*").allowedOriginPatterns("*").allowedMethods("*")
				.allowCredentials(true);
				
			}
			
		};
		



	}

	public static void main(String[] args) {
		SpringApplication.run(ArgentinaProgramaPortfolioApplication.class, args);
	}
	

	// @Bean
	// public PasswordEncoder passwordEncoder() {
	// 	return NoOpPasswordEncoder.getInstance();
	// }

}
