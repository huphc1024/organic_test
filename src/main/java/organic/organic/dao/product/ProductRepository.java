package organic.organic.dao.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import organic.organic.model.product.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query( value = "SELECT * FROM tbl_product u WHERE u.sale = 1",  nativeQuery = true)
    public List<Product> findAllBySale();
    @Query( value = "SELECT * FROM tbl_product where buy = (SELECT MAX(buy) FROM tbl_product) and hotdeal !=  0 LIMIT 1\n",  nativeQuery = true)
    public Optional<Product> findByHotDeal();
}