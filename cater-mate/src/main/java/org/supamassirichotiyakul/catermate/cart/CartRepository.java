package org.supamassirichotiyakul.catermate.cart;

import org.supamassirichotiyakul.catermate.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
}
