package com.danieltrujillo.bb2.model;

import com.danieltrujillo.bb2.enums.ItemStateEnum;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Item")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Item {
    @Id
    @Column(name = "id_item",
            nullable = false,
            unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_seq")
    @SequenceGenerator(name = "id_item_sequence")
    private Long id;

    @Column(name="item_code",
            nullable = false,
            unique = true)
    @SequenceGenerator(name = "item_code_sequence")
    private Long itemCode;

    @Column(name = "description")
    private String description;

    @Column(name = "price",
            nullable = false)
    private double price;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "Item_supplier_item",
            joinColumns = {@JoinColumn(name = "item_id",
                    referencedColumnName = "id_item",
                    nullable = false,
                    updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "item_supplier_id",
                    referencedColumnName = "id_item_supplier",
                    nullable = false,
                    updatable = false)}
    )
    private Set<ItemSupplier> suppliers;

    @Column(name = "state")
    @Enumerated(EnumType.ORDINAL)
    private ItemStateEnum state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private Set<PriceReduction> priceReductions;

    @Column(name = "creation_date")
    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User creator;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<DeactivationReason> deactivationReasons;

    public double applyPriceReduction() {
        Date today = new Date();
        for (PriceReduction pr: priceReductions) {
            if(!today.before(pr.getStartDate()) && today.after(pr.getEndDaTE())) {
                return getNewPrice(pr.getReducedPrice());
            }
        }
        return price;
    }

    private double getNewPrice(int priceReduction) {
        return price - ((price / 100)*priceReduction);
    }
}
