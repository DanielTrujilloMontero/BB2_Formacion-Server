package com.danieltrujillo.bb2.repository;

import com.danieltrujillo.bb2.dto.ItemSupplierDTO;
import com.danieltrujillo.bb2.model.ItemSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemSupplierRepository extends JpaRepository<ItemSupplier, Long> {
    @Modifying
    @Query(value = "insert into Item_supplier_item (item_id, item_supplier_id) values (:item_id, :item_supplier_id)",
            nativeQuery = true)
    void asociateItemSupplier(@Param("item_id") Long item_id, @Param("item_supplier_id") Long item_supplier_id);

    public ItemSupplier findItemSupplierByName(String name);
}
