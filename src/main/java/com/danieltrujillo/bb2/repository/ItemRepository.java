package com.danieltrujillo.bb2.repository;

import com.danieltrujillo.bb2.enums.ItemStateEnum;
import com.danieltrujillo.bb2.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    public List<Item> findItemsByState(ItemStateEnum state);

    public Item findItemByItemCode(Long itemCode);

}
