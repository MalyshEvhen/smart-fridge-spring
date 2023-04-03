package ua.malysh.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.malysh.domain.Purchase;
import ua.malysh.domain.ShopReceipt;
import ua.malysh.domain.Status;
import ua.malysh.repository.PurchaseRepository;
import ua.malysh.repository.ShopReceiptRepository;
import ua.malysh.service.PurchaseService;
import ua.malysh.service.RecipeService;
import ua.malysh.service.UserService;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    private final ShopReceiptRepository shopReceiptRepository;
    private final PurchaseRepository purchaseRepository;
    private final RecipeService recipeService;
    private final UserService userService;

    public PurchaseServiceImpl(
            ShopReceiptRepository shopReceiptRepository,
            PurchaseRepository purchaseRepository,
            RecipeService recipeService,
            UserService userService) {
        this.shopReceiptRepository = shopReceiptRepository;
        this.purchaseRepository = purchaseRepository;
        this.recipeService = recipeService;
        this.userService = userService;
    }

    @Override
    public ShopReceipt purchaseRecipe(String username, Long recipeId) {
        var shopReceipt = shopReceiptRepository.findByUsernameAndStatus(
                username,
                Status.IN_PROCESS).orElseThrow();

        var recipe = recipeService.findById(recipeId);
        var ingredients = recipe.getIngredients();

        var purchases = ingredients
                .stream()
                .map(i -> new Purchase(
                        i.getProduct(),
                        i.getRecipe(),
                        shopReceipt,
                        i.getAmount(),
                        i.getProduct().getPrice()))
                .toList();

        shopReceipt.addPurchases(purchases);

        return shopReceipt;
    }

    @Override
    public ShopReceipt removeRecipe(String username, Long recipeId) {
        var shopReceipt = shopReceiptRepository.findByUsernameAndStatus(
                username,
                Status.IN_PROCESS).orElseThrow();
        var purchases = purchaseRepository.findByRecipeId(recipeId);
        shopReceipt.removePurchases(purchases);
        purchaseRepository.deleteAll(purchases);

        return shopReceipt;
    }

    @Override
    public ShopReceipt getTotal(String username) {
        var shopReceipt = shopReceiptRepository.findByUsernameAndStatus(
                username,
                Status.IN_PROCESS).orElseThrow();
        shopReceipt.setStatus(Status.FINISHED);

        return shopReceipt;
    }

    @Override
    public void cancelShopRecipe(String username) {
        var shopReceipt = shopReceiptRepository.findByUsernameAndStatus(
                username,
                Status.IN_PROCESS).orElseThrow();
        shopReceipt.setStatus(Status.CANCELED);
    }

    @Override
    public ShopReceipt continuePurchase(String username) {
        return shopReceiptRepository.findByUsernameAndStatus(
                username,
                Status.IN_PROCESS).orElse(createNewShopRecipe(username));
    }

    private ShopReceipt createNewShopRecipe(String username) {
        var user = userService.findByUsername(username);

        return shopReceiptRepository.save(new ShopReceipt(user));
    }
}
