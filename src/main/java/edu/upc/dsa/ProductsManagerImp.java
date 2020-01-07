package edu.upc.dsa;

import edu.upc.dsa.models.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class ProductsManagerImp implements ProductsManager{
  //  private static TracksManager instance;
    protected List<Product> products;
    final static Logger logger = Logger.getLogger(ProductsManagerImp.class);

    public ProductsManagerImp() {
        this.products = new LinkedList<>();
    }

    public void addProduct(String id, int amount, double price) {
        Product product = new Product(id, amount, price);
        logger.info(product+" añadido ");

        this.products.add(product);
    }

    public int size() {
        int ret = this.products.size();
        logger.info("size " + ret);

        return ret;
    }

    public List<Product> getProducto(){
        return this.products;
    }

    public Product getProductById(String id) {
        logger.info("getProduct("+id+")");

        for (Product p: this.products) {
            if (p.getId().equals(id)) {
                logger.info("getProduct("+id+"): "+p);

                return p;
            }
        }
        logger.warn("not found " + id);
        return null;
    }

    public int numSalesByProductId(String productId){
        int numSales = 0;

        for (Product product: this.products) {
            if (productId == product.getId())
                numSales = numSales + product.getAmount();
        }
        return numSales;
    }

    public List<Product> productsOrderedByPrice(){

        List<Product> sortedList = new LinkedList<Product>();
        sortedList.addAll(this.products);
/*        for (Product product: this.products) {   //se puede hacer de las dos formas (añadir todos los productos en la lista, o recorrer la lista y añadirlos despues)
            sortedList.add(product);
        }
  */      Collections.sort(sortedList, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
        return sortedList;
    }

    public List<Product> productsOrderedBynumSales() {
        List<Product> sortedList = new LinkedList<Product>();
        for (Product product: this.products) {
            sortedList.add(product);
        }
        Collections.sort(sortedList, new Comparator<Product>() {
            public int compare(Product p1, Product p2) {
                return Double.compare(p2.getAmount(), p1.getAmount());
            }
        });
        return sortedList;
    }

    public void deleteProduct(String id) {

        Product p = this.getProductById(id);
        if (p==null) {
            logger.warn("not found " + p);
        }
        else logger.info(p+" deleted ");

        this.products.remove(p);
    }


}
