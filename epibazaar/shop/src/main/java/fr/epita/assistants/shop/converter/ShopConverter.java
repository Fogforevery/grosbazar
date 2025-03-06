package fr.epita.assistants.shop.converter;

import fr.epita.assistants.shop.data.model.ShopModel;
import fr.epita.assistants.shop.domain.entity.ShopEntity;

public class ShopConverter {
    public ShopModel toShopModel(ShopEntity entity) {
        ShopModel shop = new ShopModel();
        shop.id = entity.getId();
        shop.priceMultiplier = entity.getPrice_multiplier();
        shop.upgradePrice = entity.getUpgrade_price();
        return shop;
    }
    public ShopEntity toShopEntity(ShopModel model) {
        ShopEntity shop = new ShopEntity();
        shop.id = model.getId();
        shop.price_multiplier = model.getPriceMultiplier();
        shop.upgrade_price = model.getUpgradePrice();
        return shop;
    }
}
