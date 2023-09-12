package com.imd.humberto789.sistemausuariowebii.repositories;

import com.imd.humberto789.sistemausuariowebii.domain.entity.AbstractEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface GenericRepository<T extends AbstractEntity> extends JpaRepository<T, Integer>, JpaSpecificationExecutor {
    @Query("select e from #{#entityName} e where e.ativo = true")
    List<T> findAll();

    @Query("select e from #{#entityName} e where e.ativo = true")
    Page<T> findAllPage(Pageable pageable);

    @Query("select e from #{#entityName} e where e.id = ?1 and e.ativo = true")
    Optional<T> findById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE #{#entityName} SET ativo=false where id = ?1")
    void deleteById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE #{#entityName} e SET e.ativo=false where e = ?1")
    void delete(T entity);

    default void deleteAll(Iterable<? extends T> arg0) {
        arg0.forEach((entity) -> {
            this.deleteById(entity.getId());
        });
    }

    @Query("select count(e) from #{#entityName} e where e.ativo = true")
    long countAtivo();
}