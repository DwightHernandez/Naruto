/**
 * The {@code ProductBuilder} interface defines a contract for building {@link Product} objects
 * with a fluent builder pattern. It is designed to handle the construction of complex {@link Product}
 * instances with multiple attributes.
 * <p>
 * The builder pattern is implemented to simplify the creation of {@link Product} objects, especially
 * when there are many attributes involved in the process. Each method in this interface represents
 * a specific attribute of the product that can be set during the building process.
 * </p>
 * <p>
 * Example usage:
 * </p>
 * <pre>{@code
 * Product product = new ProductBuilderImpl()
 *     .productId(1)
 *     .storeId(123)
 *     .nameProduct("Example Product")
 *     .productPrice(49.99)
 *     .description("A sample product for demonstration purposes.")
 *     .manufacturer("Sample Manufacturer")
 *     .quantity(10)
 *     .type("SampleType")
 *     .build();
 * }</pre>
 * <p>
 * Implementations of this interface should provide a concrete implementation of the builder methods
 * and the {@code build()} method to construct the final {@link Product} object.
 * </p>
 * <p>
 * Note: The {@code type} attribute is expected to be a String representation, such as the name of an enum,
 * for better flexibility.
 * </p>
 * <p>
 * The {@code ProductBuilder} interface aims to enhance the readability and maintainability of code
 * when creating instances of the {@link Product} class.
 * </p>
 *
 * @author Kevin Jimenez and sneiderEsteban
 */
package Ninja.model.classes.builder;

import Ninja.model.classes.Ninja;


public interface NinjaBuilder {


    NinjaBuilder ninjaID(long ninjaID);

    NinjaBuilder nombreNinja(String nombreNinja);


    NinjaBuilder rangoNinja(String rangoNinja);


    NinjaBuilder aldeaNinja(String aldeaNinja);



    Ninja build();
}
