package fr.epita.assistants.shop.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShopEntity {
    public int id;
    public float price_multiplier;
    public float upgrade_price;
}
