package besysoft.tienda.controller;


import besysoft.tienda.dto.ProductDTO;
import besysoft.tienda.entity.Product;
import besysoft.tienda.service.impl.ProductServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceI productService;


    @PostMapping("/create")
    ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO product){
        productService.create(product);
        return ResponseEntity.ok("fue creado exitosamente");
    }

    @GetMapping("/getAll")
    ResponseEntity<?> getAllProduct(){
        return ResponseEntity.ok(productService.getAll());
    }

    @GetMapping("/getLowPrice/{price}")
    ResponseEntity<?> getLowPrice(@PathVariable Double price){
        return ResponseEntity.ok(productService.findAllPriceLow(price));
    }

    @GetMapping("/getGreatPrice/{price}")
    ResponseEntity<?> getGreatPrice(@PathVariable Double price){
        return ResponseEntity.ok(productService.findAllPriceGreat(price));
    }

    @GetMapping("/getPrice/{price}")
    ResponseEntity<?> getPrice(@PathVariable Double price){
        return ResponseEntity.ok(productService.findAllByPrice(price));
    }

    @GetMapping("/getName/{name}")
    ResponseEntity<?> getName(@PathVariable String name){
        return ResponseEntity.ok(productService.findByName(name));
    }

    @GetMapping("/getCategory/{category}")
    ResponseEntity<?> getCategory(@PathVariable String category){
        return ResponseEntity.ok(productService.findByCategory(category));
    }





}
