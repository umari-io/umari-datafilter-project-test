package foo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class Departamento {
    @Id
    private Long id;

    private String nome;

    private Integer andar;

    private Integer numero;
}
