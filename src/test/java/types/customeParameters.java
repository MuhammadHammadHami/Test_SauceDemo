package types;

import io.cucumber.java.ParameterType;
import objects.Product;

public class customeParameters {
    @ParameterType(".*")
    public Product product(String name){
        return new Product(name);
    }
}
