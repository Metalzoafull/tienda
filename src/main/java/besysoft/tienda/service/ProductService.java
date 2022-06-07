package besysoft.tienda.service;

import besysoft.tienda.dto.ProductDTO;
import besysoft.tienda.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    void create(ProductDTO productDto);

    void update(Long id, Product product);

    void update(Long productId, ProductDTO productDTO);

    void delete(Long id);

    List<Product> getAll();

    Product findByName(String name);

    List<Product> findByCategory(String category);

    List<Product> findAllPriceLow(Double price);

    List<Product> findAllPriceGreat(Double price);

    List<Product> findAllByPrice(Double price);
}
