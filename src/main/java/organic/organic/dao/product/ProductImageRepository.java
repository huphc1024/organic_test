package organic.organic.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import organic.organic.model.shop.Shop;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<Shop, Integer> {
    @Query( value = "SELECT u.id, u.image FROM tbl_product_image u WHERE u.tbl_product_id = ?1",  nativeQuery = true)
    public List<Shop> findAllByIdProdut( Integer id);
    @Query( value = "SELECT u.id, u.image FROM tbl_product_image u inner Join tbl_product p on u.tbl_product_id = p.id WHERE u.tbl_product_id = ?1 limit 1",  nativeQuery = true)
    public Shop getImageIndexByIdProduct( Integer id);
}
