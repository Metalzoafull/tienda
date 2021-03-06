package besysoft.tienda.repository;

import besysoft.tienda.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByName(String name);

    List<Product> findByCategory(String category);

    List<Product> findAllByPriceIsLessThanEqual(Double price);

    List<Product> findAllByPriceIsGreaterThanEqual(Double price);

    List<Product> findAllByPrice(Double price);
}
