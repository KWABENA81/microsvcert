package com.edu.oauth2.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;


@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Entity
//@Table(name = "CUSTOMER_TB")
public class Customer  {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Integer id;

  //  @Column(name = "firstname", nullable = false, length = 45)
    private String firstname;

   // @Column(name = "lastname", nullable = false, length = 45)
    private String lastname;

   // @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    //@Column(name = "email", nullable = false, length = 35)
    private String email;


}
