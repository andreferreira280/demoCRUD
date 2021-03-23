package br.com.afs.registro;

import java.util.stream.LongStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.afs.registro.entities.Contato;

@SpringBootApplication
public class RegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroApplication.class, args);
		System.out.println("testes rodando run");
	}

	@Bean
	CommandLineRunner criarTabelaComAlgunsDados(br.com.afs.registro.repository.ContatoRepository repository) {
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 3).mapToObj(i -> {
				Contato c = new Contato();
				c.setNome("teste " + i);
				c.setCelular("11 987654321");
				c.setEmail("teste" + i + "@teste.com.br");
				return c;
			}).map(v -> repository.save(v)).forEach(System.out::println);
		};
	}
}
