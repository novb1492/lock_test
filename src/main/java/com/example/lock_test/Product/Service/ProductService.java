package com.example.lock_test.Product.Service;

import com.example.lock_test.Product.Dto.TestDto;
import com.example.lock_test.Product.Model.ProductEntity;
import com.example.lock_test.Product.Repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepo productRepo;

    @Transactional
    public void minusCount(TestDto testDto){
        long id = Long.parseLong(testDto.getId());
        ProductEntity productEntity = productRepo.findByIdAndLock(id).orElseThrow();
        log.info("상품정보:{}", productEntity.toString());
        int originCount = productEntity.getCount();
        int newCount = originCount - testDto.getCount();
        log.info("수정 결과:{}", productRepo.updateCount(newCount, id));

    }
    @Transactional
    public void minusCount2(TestDto testDto){
        long id = Long.parseLong(testDto.getId());
        log.info("수정 결과:{}", productRepo.updateCountOther(testDto.getCount(), id));

    }
}
