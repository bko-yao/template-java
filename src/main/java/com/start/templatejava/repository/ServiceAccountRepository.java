package com.start.templatejava.repository;

import com.start.templatejava.entity.ServiceAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

/**
 * Service Account Repository
 */
@Repository
public interface ServiceAccountRepository extends JpaRepository<ServiceAccount, Long> {
    Optional<ServiceAccount> findByEmailAndAssetTrue(String email);

    boolean existsByEmail(String email);

    boolean existsByPhoneNumber(String phoneNumber);

    @Query("SELECT sa FROM ServiceAccount sa " +
            "WHERE sa.asset = true and sa.id in (?1)")
    Set<ServiceAccount> findByIdsAndAsset(long[] ids);
}
