package com.danieltrujillo.bb2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Item_supplier")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class ItemSupplier {
    @Id
    @Column(name = "id_item_supplier",
            nullable = false,
            unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_supplier_sequence")
    @SequenceGenerator(name = "id_item_supplier_sequence")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Item> items;
}
