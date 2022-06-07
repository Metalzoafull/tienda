package besysoft.tienda.service.impl;

import besysoft.tienda.entity.Product;
import besysoft.tienda.entity.Seller;
import besysoft.tienda.repository.ProductRepository;
import besysoft.tienda.repository.SellerRepository;
import besysoft.tienda.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerServiceI implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(Seller seller) {
        sellerRepository.save(seller);

    }

    @Override
    public void update(Long id, Seller seller) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Seller> getAll() {
        return sellerRepository.findAll();
    }

    @Override
    public Double comision(Long id) {
        Seller entity = sellerRepository.getReferenceById(id);
        double result = 0.0;
        if (entity.getProductList().size() > 1){
            result = entity.getProductList().stream()
                    .map(Product::getPrice)
                    .reduce(Double::sum).orElse((0.0));
            if (entity.getProductList().size() == 2){
                result = (5 * result)/100;

            }else{
                result = (10 * result)/100;
            }
        }else {
            result = 0.0;
        }
        return result;

    }
}
