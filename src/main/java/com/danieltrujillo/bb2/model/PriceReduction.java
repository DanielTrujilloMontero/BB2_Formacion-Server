package com.danieltrujillo.bb2.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Price_reduction")
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class PriceReduction {
    @Id
    @Column(name="id_price_reduction",
            nullable = false,
            unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "price_reduction_sequence")
    @SequenceGenerator(name = "id_price_reduction_sequence")
    private Long id;

    @Column(name = "reduced_price")
    private int reducedPrice;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDaTE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
