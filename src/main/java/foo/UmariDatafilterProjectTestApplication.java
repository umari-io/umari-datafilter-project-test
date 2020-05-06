package foo;

import foo.domain.Departamento;
import foo.domain.Pessoa;
import foo.repository.DepartamentoRepository;
import foo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class UmariDatafilterProjectTestApplication implements CommandLineRunner {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public static void main(String[] args) {
        SpringApplication.run(UmariDatafilterProjectTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Pessoa pessoa1 = new Pessoa(1L, "Ribamar");
        Pessoa pessoa2 = new Pessoa(2L, "Lúcia");
        Pessoa pessoa3 = new Pessoa(3L, "Rafael");
        Pessoa pessoa4 = new Pessoa(4L, "Deane");
        Pessoa pessoa5 = new Pessoa(5L, "Letícia");
        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5));

        Departamento departamento1 = new Departamento(1L, "SDS", 3, 302);
        Departamento departamento2 = new Departamento(2L, "SBD", 3, 302);
        Departamento departamento3 = new Departamento(3L, "SCDW", 3, 302);
        Departamento departamento4 = new Departamento(4L, "STI-GAB", 1, 402);

        departamentoRepository.saveAll(Arrays.asList(departamento1, departamento2, departamento3, departamento4));
    }
}
