package com.example.lock_test.Product;

import com.example.lock_test.Product.Dto.TestDto;
import com.example.lock_test.Product.Service.ProductSelectService;
import com.example.lock_test.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {
    private final ProductService productService;
    private final ProductSelectService productSelectService;

    @RequestMapping("/test")
    public void test(){
        TestDto testDto = new TestDto();
        testDto.setCount(2);
        testDto.setId("1");
        productService.minusCount(testDto);
    }
    @RequestMapping("/test2")
    public void test2(){
        productSelectService.select();
    }
    @RequestMapping("/test3")
    public void test3(){
        TestDto testDto = new TestDto();
        testDto.setCount(2);
        testDto.setId("1");
        productService.minusCount2(testDto);
    }
}
