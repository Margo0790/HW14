package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    @Test
    public void RemoveWhenProductExists() {
        ShopRepository shopRepository = new ShopRepository();
        Product item1 = new Product(7, "shoes", 70000);
        Product item2 = new Product(15, "bag", 100000);
        Product item3 = new Product(23, "dress", 300000);

        shopRepository.add(item1);
        shopRepository.add(item2);
        shopRepository.add(item3);
        shopRepository.removeById(15);
        Product[] actual = shopRepository.findAll();
        Product[] expected = {item1, item3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotFoundIdItem() {
        ShopRepository shopRepository = new ShopRepository();
        Product item1 = new Product(7, "shoes", 70000);
        Product item2 = new Product(15, "bag", 100000);
        Product item3 = new Product(23, "dress", 300000);

        shopRepository.add(item1);
        shopRepository.add(item2);
        shopRepository.add(item3);

        Assertions.assertThrows(NotFoundException.class, () -> shopRepository.removeById(90));
    }
}
