package besysoft.tienda.service.impl;

import besysoft.tienda.dto.ProductDTO;
import besysoft.tienda.entity.Product;
import besysoft.tienda.repository.ProductRepository;
import besysoft.tienda.repository.SellerRepository;
import besysoft.tienda.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceI implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void create(ProductDTO productDto) {
        Product entity = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .category(productDto.getCategory())
                .seller(sellerRepository.getReferenceById(productDto.getSeller_id()))
                .build();
        productRepository.save(entity);
    }

    @Override
    public void update(Long id, Product product) {

    }

    @Override
    public void update(Long productId, ProductDTO productDTO) {
        Product entity = productRepository.getReferenceById(productId);
        entity.setSeller(sellerRepository.getReferenceById(productDTO.getSeller_id()));

    }



    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> findAllPriceLow(Double price) {
        return productRepository.findAllByPriceIsLessThanEqual(price);
    }

    @Override
    public List<Product> findAllPriceGreat(Double price) {
        return productRepository.findAllByPriceIsGreaterThanEqual(price);
    }

    @Override
    public List<Product> findAllByPrice(Double price) {
        return productRepository.findAllByPrice(price);
    }
}
