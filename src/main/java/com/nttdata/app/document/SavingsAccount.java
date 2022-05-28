package com.nttdata.app.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
//Clase que representa a una cuenta de ahorro
@Document(collection = "savingAccount")
public class SavingsAccount {
    @Id
    //id de la cuenta
    private String idSavingsAccount;
    //nombre del tipo de cuenta
    private String typeAccount;
    //Atributo del número de cuenta de ahorro
    private String numberAccount;
    //Saldo de la cuenta de ahorro
    private double accountBalance;
    //Costo de mantenimiento de la cuenta de ahorro
    private double maintenanceCost;
    //Limite de movimientos de la cuenta de ahorro
    private int movementLimit;
    //Id del tipo de cliente
    private String idCustomer;
}
