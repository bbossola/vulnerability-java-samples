package io.meterian.samples.jackson;
 
import static spark.Spark.*;

import java.io.IOException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spark.Request;
 
public class Main {
    
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    private static ProductsDatabase products = new ProductsDatabase();
    private static ObjectMapper deserializer = new ObjectMapper().enableDefaultTyping();
    private static ObjectMapper serializer = new ObjectMapper();
 
    public static void main(String[] args) {
 
        port(8888);
        
        get("/products", (request, response) -> {
            Collection<Product> res = products.list();
            log.info("/products -> {}", res);
            return serializer.writeValueAsString(res);
        });
        
        post("/products", (request, response) -> {
            Product product = deserialize(request);
            if (product != null) {
                Product res = products.add(product);
                response.status(201);
                return serializer.writeValueAsString(res);
            } else {
                response.status(400);
                return "Invalid content";
            }
        });
    }

    private static Product deserialize(Request request) throws IOException, JsonParseException, JsonMappingException {
        try {
            return deserializer.readValue(request.body(), Product.class);
        } catch (Exception any) {
            log.warn("Unexpected exception deserializing content: {}", any.getClass());
            return null;
        }
    }
}
