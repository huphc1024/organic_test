package organic.organic.dao.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import organic.organic.model.shop.Shop;

public interface ShopRepository  extends JpaRepository<Shop, Integer> {
    String findImageById(int id);
}
