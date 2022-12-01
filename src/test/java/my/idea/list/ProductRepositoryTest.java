package my.idea.list;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();
    Product book = new Book(1, "Александр использует XsMax", 1_000, "Александр Веденеев");
    Product smartphone = new Smartphone(2, "XsMax", 35_000, "Apple");
    Product product = new Product(3, "Чехол", 30);

    @Test
    public void ERROR_MSG_test() {
        repository.addNewProduct(book);
        repository.addNewProduct(smartphone);
        repository.addNewProduct(product);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.deleteById(4);
        });
    }

    @Test
    public void shouldFindById() {
        repository.addNewProduct(book);
        repository.addNewProduct(smartphone);
        repository.addNewProduct(product);
        repository.findById(2);
        Product expected = smartphone;
        Product actual = repository.findById(2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteOneProductById() {
        repository.addNewProduct(book);
        repository.addNewProduct(smartphone);
        repository.addNewProduct(product);
        repository.deleteById(2);
        Product[] expected = { book, product };
        Product[] actual = repository.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldDeleteAllProductsById() {
        repository.addNewProduct(book);
        repository.addNewProduct(smartphone);
        repository.addNewProduct(product);
        repository.deleteById(1);
        repository.deleteById(2);
        repository.deleteById(3);
        Product[] expected = {};
        Product[] actual = repository.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneNewProduct() {
        repository.addNewProduct(book);
        Product[] expected = {book};
        Product[] actual = repository.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllProduct() {
        repository.addNewProduct(book);
        repository.addNewProduct(smartphone);
        repository.addNewProduct(product);
        Product[] expected = { book, smartphone, product};
        Product[] actual = repository.findAllProduct();
        Assertions.assertArrayEquals(expected, actual);
    }
}