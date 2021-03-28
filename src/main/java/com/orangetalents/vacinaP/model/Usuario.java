package com.orangetalents.vacinaP.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Usuario extends AbstractEntity {

   // @NotNull
  //  @Column(unique = true)
    private String nome ;
//    @CPF
    private String cpf ;

}
