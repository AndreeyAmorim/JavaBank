package domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(unique = true, nullable = false, length = 4)
    private String number;

    @NotBlank
    @Column(nullable = false)
    private String address;

    @JsonIgnore //Ignora a obrigatoriedade de criar uma requisição http.
    @OneToMany(mappedBy = "agency")
    private List<Persona> customers = new ArrayList <>();

    @OneToMany(mappedBy = "agency")
    private Set <Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "agency")
    private Set <CurrentAccount> currentAccounts = new HashSet<>();

    @OneToMany(mappedBy = "agency")
    private Set <SavingAccount> savingAccounts = new HashSet<>();

}