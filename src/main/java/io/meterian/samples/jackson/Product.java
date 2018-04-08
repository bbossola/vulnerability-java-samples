package io.meterian.samples.jackson;

import net.jcip.annotations.Immutable;

@Immutable
public class Product {
 
    private int id;
    private String name;
    private String description;
    private Object data;
 
    protected Product() {
    }

    public Product(int id, String name, String description, Object data) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.data = data;
    }

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", data=" + data + "]";
    }
    
    public Product duplicate(int id) {
        return new Product(
            id,
            this.name,
            this.description,
            this.data);                
    }
    
}
