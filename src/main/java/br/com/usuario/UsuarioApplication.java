package br.com.usuario;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsuarioApplication implements CommandLineRunner {

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(UsuarioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));
	}
}
