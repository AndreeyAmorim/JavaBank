package domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data

public abstract class Account {

    @ManyToOne
    @JoinColumn(name = "agency_id")
    private Agency agency;

    @NotNull
    private String number;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona customer;

    private BigDecimal balance = new BigDecimal(BigInteger.ZERO);

    private List<Extract> extractList = new ArrayList<>();

}