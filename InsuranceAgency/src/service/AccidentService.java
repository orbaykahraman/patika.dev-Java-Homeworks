package service;

import model.Accident;

import java.math.BigDecimal;
import java.util.Date;

public class AccidentService {

    public Accident createAccident(Date accidentDAte, String description,
                                   BigDecimal damagePrice, int failureRate) {
        Accident accident = new Accident();
        accident.setAccidentDate(accidentDAte);
        accident.setDescription(description);
        accident.setDamagePrice(damagePrice);
        accident.setFailureRate(failureRate);
        return accident;
    }

}
