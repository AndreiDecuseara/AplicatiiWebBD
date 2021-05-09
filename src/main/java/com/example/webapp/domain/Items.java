package com.example.webapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;


@Entity
@Setter
@Getter
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String code;
    private String status;

    private Double price;


    @OneToOne(mappedBy = "items",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Infos infos;

    @ManyToOne
    private Users user;

    @OneToMany(mappedBy = "items")
    private List<Orders> orders;

    @ManyToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "item_tag",
            joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id",
                    referencedColumnName = "id"))
    private List<Tags> tags;

    public void removeTag(Tags tag) {
        tag.getItems().remove(this);
        tags.remove(tag);
    }
}
