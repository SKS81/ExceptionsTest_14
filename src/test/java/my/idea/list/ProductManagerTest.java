package my.idea.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductManagerTest {

    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book = new Book(1, "Александр использует XsMax", 1_000, "Александр Веденеев");
    Product smartphone = new Smartphone(2, "XsMax", 35_000, "Apple");
    Product product = new Product(3, "Чехол", 30);

    @Test
    void shouldSearchByName() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "Александр";
        Product[] expected = {book};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchProductIsOutList() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "KIA";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchSomeProducts() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "XsMax";
        Product[] expected = { book, smartphone };
        Product[] actual = manager.searchBy(name);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddProduct() {
        manager.add(book);
        Product[] expected = {book};
        Product[] actual = repository.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAllProducts() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        Product[] expected = { book, smartphone, product };
        Product[] actual = repository.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }
}