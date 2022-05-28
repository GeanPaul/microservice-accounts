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
//Clase que representa a una cuenta de ahorro a plazo fijo
@Document(collection = "fixedTermAccount")
public class FixedTermAccount {
    //Id de registro de la cuenta
    @Id
    private String idFixedTermAccount;
    //Nombre del tipo de cuenta
    private String typeAccount;
    //Atributo del número de cuenta de ahorro a plazo fijo
    private String numberFixedTermAccount;
    //Saldo de la cuenta de ahorro a plazo fijo
    private double accountBalance;
    //Límite de movimientos de la cuenta de ahorro a plazo fijo
    private int movementLimit;
    //Fecha en la que puede realizar cualquier movimiento
    private String moveDate;
    //id del cliente de la cuenta
    private String idCustomer;
}
