package edu.upc.dsa;

import edu.upc.dsa.models.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class ProductManagerTest {

    ProductsManager productManager = null;

    @Before
    public void setUp ()  {
        productManager = new ProductsManagerImp();

        productManager.addProduct("COCA", 2, 2);
        productManager.addProduct("PEPSI", 3, 1);
        productManager.addProduct("BOCATA-JAMON", 1, 5);
        productManager.addProduct("BOCATA-PAVO", 5, 4);

    }

    @Test
    public void addProduct() {
        Assert.assertEquals("ProductManager addProduct", 4, productManager.size());
    }

    @Test
    public void numSalesByProductId() {
        Assert.assertEquals("ProductManager numSalesByProductId ", 2, productManager.numSalesByProductId("COCA"));
    }

    @Test
    public void productsOrderedByPrice() {
        List<Product> list = new LinkedList<Product>();
        list = productManager.productsOrderedByPrice();
        System.out.println("Listado ordenado de forma ascendiente por número de precio:");
        for (Product product: list){
            String name = product.getId();
            System.out.println(name+ " "+product.getPrice());
        }
    }

    @Test
    public void productsOrderedBynumSales() {
        List<Product> list = new LinkedList<Product>();
        list = productManager.productsOrderedBynumSales();
        System.out.println("Listado ordenado de forma descendiente por número de ventas:");
        for (Product product: list){
            String name = product.getId();
            System.out.print(name+ " "+product.getAmount()+" ");
        }
    }
    @Test
    public void deleteProduct() {
        List<Product> list = new LinkedList<Product>();
        list = productManager.getProducto();
        productManager.deleteProduct("PEPSI");
        System.out.println("Listado de productos eliminando el producto con esa id:");
        for (Product product: list){
            String name = product.getId();
            System.out.print(name+" ");
        }
    }
}
