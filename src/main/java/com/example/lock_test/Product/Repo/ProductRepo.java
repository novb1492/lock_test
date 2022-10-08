package com.example.lock_test.Product.Repo;

import com.example.lock_test.Product.Model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from ProductEntity p where p.id=:id")
    Optional<ProductEntity>findByIdAndLock(@Param("id")long id);

    @Modifying
    @Query("update ProductEntity p set p.count=:count where p.id=:id")
    Integer updateCount(@Param("count") int count, @Param("id") long id);

    @Modifying
    @Query("update ProductEntity p set p.count=p.count-:count where p.id=:id")
    Integer updateCountOther(@Param("count") int count, @Param("id") long id);
}
