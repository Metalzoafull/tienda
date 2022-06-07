package besysoft.tienda.service;

import besysoft.tienda.entity.Seller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SellerService {

    void create(Seller seller);

    void update(Long id, Seller seller);

    void delete(Long id);

    List<Seller> getAll();

    Double comision(Long id);
}
