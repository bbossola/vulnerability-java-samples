package io.meterian.samples.jackson;
 
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
 
public class ProductsDatabase {
 
    private Map<String, Product> products = new HashMap<>();
    private AtomicInteger idGenerator = new AtomicInteger(0);
    
    public ProductsDatabase() {
        add(new Product(0,"apple", "Real apple from Italy", randomData()));
        add(new Product(0,"orange", "Real orange from Italy", randomData()));
        add(new Product(0,"kiwi", "Real kiwi from Italy", randomData()));
    }
    
    public Collection<Product> list() {
        return Collections.unmodifiableCollection(products.values());
    }

    public Product findById(String id) {
        return products.get(id);
    }
 
    public Product add(Product newProduct) {
        Integer newId = idGenerator.incrementAndGet();
        Product product = newProduct.duplicate(newId);
        products.put(newId.toString(), product);
        return product;
    }
 
    public Product update(String id, Product newProduct) {
        Product oldProduct = products.get(id);
        if (oldProduct == null)
            return null;
        
        products.put(id, newProduct);
        return newProduct;
    }
 
    public Product delete(String id) {
        return products.remove(id);
    }
    
    private Object randomData() {
        String[] colors = {"yellow", "red", "green"};
        
        Map<String,Object> data = new HashMap<>();
        data.put("cost", (int)(1+Math.random()*5));
        data.put("color", colors[new Random().nextInt(colors.length)]);
        return data;
    }


}
