package ua.malysh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.malysh.domain.ShopReceipt;
import ua.malysh.domain.Status;

import java.util.Optional;

public interface ShopReceiptRepository extends JpaRepository<ShopReceipt, Long> {
    
    @Query(
        """
            select sr_ from ShopReceipt sr_
            left join sr_.user u_
            where u_.username = :username
            and sr_.status = :status
            """
    )
    Optional<ShopReceipt> findByUsernameAndStatus(String username, Status status);
    
}