package com.example.lock_test.Product.Service;

import com.example.lock_test.Product.Repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductSelectService {
    private final ProductRepo productRepo;

    public void select(){
        productRepo.findById(1L);

    }
}
