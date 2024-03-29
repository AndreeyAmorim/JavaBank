package domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import domain.enums.CardIdentification;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;


@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreditCardNumber
    private String number;

    @ManyToOne
    @JoinColumn(name = "currentAccount_id")
    private CurrentAccount account;

    @Length(max = 3, min = 3)
    private Integer cvv;


    private Boolean credit;

    private BigDecimal limit = new BigDecimal(0);

    private Boolean blocked;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDate validity;

    private Boolean onlineShopping;

    private Integer identification;

    public CardIdentification getIdentification(){
        return CardIdentification.toEnum(this.identification);
    }

}