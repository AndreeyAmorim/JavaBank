package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import domain.enums.TypeKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data     //Gera o Get, Set, Equals e HashCode
@Builder  //Habilita a criação de um objeto staticamente
@Entity   //Isso aqui define que é uma classe do banco de dados
@NoArgsConstructor  //Cria um construtor vazio
@AllArgsConstructor //Cria um construtor com todos parametros
public class Persona {

    @Id //Define qual é a primary Key do banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Define o tipo de gerador do PK
    private Long id;

    @Column(name = "name", nullable = false) //Define o padrão para a coluna
    private String name;

    @Email  //Faz a validação do tipo email (@ .com)
    private String email;

    @JsonIgnore
    private String password;

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<SavingAccount> savingAccounts = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "persona")
    private List<CurrentAccount> currentAccounts = new ArrayList<>();

    @CPF  //Faz a validação matematica do CPF
    private String cpf;

    private Integer typeKey;

    @Column(length = 1)
    private Character gender;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate lastLogin;

    @JsonIgnore
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate whenCreated;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate birthDay;

    @ElementCollection
    @CollectionTable(name = "PIX_KEYS")
    private Set<String> pixKey;

    public TypeKey getTypeKey(){
        return TypeKey.toEnum(this.typeKey);

    }

    public void setTypeKey(TypeKey typeKey) {
        this.typeKey = typeKey.getCod();

    }
}