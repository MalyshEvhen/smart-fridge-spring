package ua.malysh.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.malysh.domain.ShopReceipt;
import ua.malysh.servise.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;
    
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }
    
    @PostMapping("/{recipeId}")
    public ShopReceipt addRecipe(
        @PathVariable Long recipeId,
        Authentication authentication
    ) {
        var username = authentication.getName();
        
        return purchaseService.purchaseRecipe(username, recipeId);
    }
    
    @PutMapping("/{recipeId}")
    public ShopReceipt removeRecipe(
        @PathVariable Long recipeId,
        Authentication authentication
    ) {
        var username = authentication.getName();
        
        return purchaseService.removeRecipe(username, recipeId);
    }
    
    @GetMapping
    public ShopReceipt checkout(Authentication authentication) {
        var username = authentication.getName();
        
        return purchaseService.continuePurchase(username);
    }
    
    @GetMapping("/submit")
    public ShopReceipt submitPurchase(Authentication authentication) {
        var username = authentication.getName();
        
        return purchaseService.getTotal(username);
    }
    
    @DeleteMapping
    public void cancelPurchase(Authentication authentication) {
        var username = authentication.getName();
        
        purchaseService.cancelShopRecipe(username);
    }
}
