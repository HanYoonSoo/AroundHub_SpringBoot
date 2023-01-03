package com.example.aroundhub.data.repository;

import com.example.aroundhub.data.entity.ProductEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void GenerateData(){
        int count = 1;
        productRepository.save(getProduct(Integer.toString(count), count++, 2000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 3000, 9000));
        productRepository.save(getProduct(Integer.toString(--count), count = count + 2, 1500, 200));
        productRepository.save(getProduct(Integer.toString(count), count++, 4000, 5000));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1500));
        productRepository.save(getProduct(Integer.toString(count), count++, 1000, 1000));
        productRepository.save(getProduct(Integer.toString(count), count++, 500, 10000));
        productRepository.save(getProduct(Integer.toString(count), count++, 8500, 3500));
        productRepository.save(getProduct(Integer.toString(count), count++, 7200, 2000));
        productRepository.save(getProduct(Integer.toString(count), count++, 5100, 1700));

    }

    private ProductEntity getProduct(String id, int nameNumber, int price, int stock){
        return new ProductEntity(id, "상품" + nameNumber, price, stock);
    }

    @Test
    void findTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        List<ProductEntity> foundEntities = productRepository.findByProductName("상품4");

        for(ProductEntity productEntity : foundEntities){
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> queryEntites = productRepository.queryByProductName("상품4");

        for(ProductEntity productEntity : queryEntites){
            System.out.println(productEntity.toString());
        }
    }

    @Test
    void existTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.existsByProductName("상품4"));
        System.out.println(productRepository.existsByProductName("상품2"));
    }

    @Test
    void countTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");

        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.countByProductName("상품4"));
    }

    @Test
    @Transactional
    void deleteTest(){
        System.out.println("before : " + productRepository.count());

        productRepository.deleteByProductId("1");
        productRepository.removeByProductId("9");

        System.out.println("After: " + productRepository.count());
    }

    @Test
    void topTest(){
        productRepository.save(getProduct("100", 123, 1500, 5000));
        productRepository.save(getProduct("101", 123, 2500, 5000));
        productRepository.save(getProduct("102", 123, 3500, 5000));
        productRepository.save(getProduct("103", 123, 4500, 5000));
        productRepository.save(getProduct("104", 123, 1000, 5000));
        productRepository.save(getProduct("105", 123, 2000, 5000));
        productRepository.save(getProduct("106", 123, 3000, 5000));
        productRepository.save(getProduct("107", 123, 4000, 5000));

        List<ProductEntity> foundEntities = productRepository.findFirst5ByProductName("상품123");
        for(ProductEntity productEntity : foundEntities){
            System.out.println(productEntity.toString());
        }

        List<ProductEntity> foundEntities2 = productRepository.findTop3ByProductName("상품123");
        for(ProductEntity productEntity : foundEntities2){
            System.out.println(productEntity.toString());
        }
    }

    /* 조건자 키워드 테스트 */

    @Test
    void isEqualTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.findByProductIdIs("1"));
        System.out.println(productRepository.findByProductIdEquals("1"));
    }

    @Test
    void notTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.findByProductIdNot("1"));
        System.out.println(productRepository.findByProductIdIsNot("1"));
    }

    @Test
    void nullTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.findByProductStockIsNull());
        System.out.println(productRepository.findByProductStockIsNotNull());
    }

    @Test
    void andTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.findTopByProductIdAndProductName("1", "상품1"));
    }

    @Test
    void greaterTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        List<ProductEntity> productEntities = productRepository.findByProductPriceGreaterThan(5000);

        for(ProductEntity productEntity : productEntities){
            System.out.println(productEntity.toString());
        }
    }

    @Test
    void containTest(){
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("==== Test Data ====");
        for(ProductEntity productEntity : foundAll){
            System.out.println(productEntity.toString());
        }
        System.out.println("==== Test Data ====");

        System.out.println(productRepository.findByProductNameContaining("상품1"));
    }

}