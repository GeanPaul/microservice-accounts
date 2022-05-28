package com.nttdata.app.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "currentAccount")
//Clase que representa a una cuenta corriente
public class CurrentAccount {
    //Atributo del número de cuenta corriente
    @Id
    private String idCurrentAccount;
    //Atributo del tipo de cuenta
    private String typeAccount;
    //Atributo del numero de cuenta
    private String numberCurrentAccount;
    //Saldo de la cuenta corriente
    private double accountBalance;
    //Costo de mantenimiento de la cuenta corriente
    private double maintenanceCost;
    //id del tipo de cliente
    private String idCustomer;
}
