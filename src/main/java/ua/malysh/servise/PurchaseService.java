package ua.malysh.servise;

import ua.malysh.domain.ShopReceipt;

public interface PurchaseService {
    ShopReceipt purchaseRecipe(String username, Long recipeId);
    
    ShopReceipt removeRecipe(String username, Long recipeId);
    
    ShopReceipt getTotal(String username);
    
    void cancelShopRecipe(String username);
    
    ShopReceipt continuePurchase(String username);
}
