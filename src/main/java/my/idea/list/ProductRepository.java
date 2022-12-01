package my.idea.list;

public class ProductRepository {

    private Product[] items = new Product[0];

    public Product[] findAllProduct() {
        return items;
    }

    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Товара с таким id не существует:" + id
            );
        }
        Product[] temp = new Product[items.length - 1];
        int copyToIndex = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                temp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        items = temp;
    }

    public void addNewProduct(Product item) {
        int length = items.length + 1;
        Product[] temp = new Product[length];
        System.arraycopy(items, 0, temp, 0, items.length);
        int lastIndex = temp.length - 1;
        temp[lastIndex] = item;
        items = temp;
    }
}