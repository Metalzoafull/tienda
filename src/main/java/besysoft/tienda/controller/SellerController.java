package besysoft.tienda.controller;


import besysoft.tienda.entity.Seller;
import besysoft.tienda.service.impl.SellerServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerServiceI sellerService;

    @PostMapping("/create")
    ResponseEntity<?> createSeller(@Valid @RequestBody Seller seller){
        sellerService.create(seller);
        return ResponseEntity.ok("fue creado exitosamente");
    }

    @GetMapping("/getAll")
    ResponseEntity<?> getAllSeller(){
        return ResponseEntity.ok(sellerService.getAll());
    }

    @GetMapping("/comision/{id}")
    ResponseEntity<?> getComision(@PathVariable Long id){
        return ResponseEntity.ok(sellerService.comision(id));
    }





}
