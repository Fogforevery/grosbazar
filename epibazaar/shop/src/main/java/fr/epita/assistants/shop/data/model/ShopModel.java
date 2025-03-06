package fr.epita.assistants.shop.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shop")
public class ShopModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "price_multiplier", nullable = false)
    public float priceMultiplier;

    @Column(name = "upgrade_price", nullable = false)
    public float upgradePrice;
}
