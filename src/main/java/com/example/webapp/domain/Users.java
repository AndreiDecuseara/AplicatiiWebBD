package com.example.webapp.domain;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String lastName;

    private String firstName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private java.util.Date birthDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Items> items;

    @OneToMany(mappedBy = "buyer")
    private List<Orders> orders;

    private String  username;
    private String  password;
    private Integer enabled;

}
