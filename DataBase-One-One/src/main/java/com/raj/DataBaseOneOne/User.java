package com.raj.DataBaseOneOne;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "users")
@Entity
@Data
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "user_name")
    private String username;

    private String email;

    /*
    jeśli jest robione save to ma działać na powiązanym rekordzie
    CascadeType.All - wtedy kaskadowość działa wszędzie
    CascadeType.Persist - przy dodawaniu kaskada działa,
     ale przy usuwaniu już nie
     */
    // OneToOne
    //@OneToOne(mappedBy ="user", cascade = CascadeType.PERSIST)
    //@OneToOne(mappedBy = "user")
    //@JoinColumn(name = "user_id")
    // @OneToOne(mappedBy = "id")
    //
   // @OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name = "userDetails_id")
    private UserDetails userDetails;
    // private Integer userDetails;
}
