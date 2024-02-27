package AndreeyAmorim.com.github.JavaBank;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@Builder
@Entity //Isso aqui define que é uma classe do banco
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    @Id //Define qual é a primary key do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name", nullable = false) // define o padrão para a coluna
    private String name;

    @Email
    private String email;

    @CPF
    private String cpf;

    private String password;

    private LocalDate birthDay;

    private Character gender;


    private LocalDate whenCreated;

    private LocalDate lastLogin;
}
