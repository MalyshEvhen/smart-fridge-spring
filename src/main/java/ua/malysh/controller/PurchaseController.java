package ua.malysh.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ua.malysh.domain.ShopReceipt;
import ua.malysh.service.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/{recipeId}")
    public ShopReceipt addRecipe(
            @PathVariable Long recipeId,
            Principal principal) {
        var username = principal.getName();

        return purchaseService.purchaseRecipe(username, recipeId);
    }

    @PutMapping("/{recipeId}")
    public ShopReceipt removeRecipe(
            @PathVariable Long recipeId,
            Principal principal) {
        var username = principal.getName();

        return purchaseService.removeRecipe(username, recipeId);
    }

    @GetMapping
    public ShopReceipt checkout(Principal principal) {
        var username = principal.getName();

        return purchaseService.continuePurchase(username);
    }

    @GetMapping("/submit")
    public ShopReceipt submitPurchase(Principal principal) {
        var username = principal.getName();

        return purchaseService.getTotal(username);
    }

    @DeleteMapping
    public void cancelPurchase(Principal principal) {
        var username = principal.getName();

        purchaseService.cancelShopRecipe(username);
    }
}
