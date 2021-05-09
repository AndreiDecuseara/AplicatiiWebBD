package com.example.webapp.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;


    @ManyToMany(mappedBy = "tags",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Items> items;


}
