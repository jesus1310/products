import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        if (findProduct(item.getID()) == null){
            stock.add(item);
        }
        else {
            System.out.println("Ya existe un objeto con ese id");
        }
    }

    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if (findProduct(id) != null){
            findProduct(id).increaseQuantity(amount);
        }
        else{
            System.out.println("El id seleccionado no existe");
        }
    }

    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product encontrado = null;
        int indice = 0;
        while (encontrado == null && indice < stock.size()){
            if (id == stock.get(indice).getID()){
                encontrado = stock.get(indice);
            }
            indice = indice + 1;
        }
        return encontrado;
    }

    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int cantidad = 0;
        if (findProduct(id) != null){
            cantidad = findProduct(id).getQuantity();
        }
        return cantidad;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        for (Product producto : stock){
            System.out.println(producto);
        }
    }

    /**
     * M�todo que imprime los detalles de todos los productos que tienen un stock por debajo del par�metro indicado
     */
    public void underGivenNumberInStock(int numeroStock){
        for (Product producto : stock){
            if (producto.getQuantity() < numeroStock){
                System.out.println(producto);
            }
        }
    }
    
    /**
     * M�todo que busca productos pasando por par�metro el nombre del producto
     */
    public Product findProduct(String name){
        Product encontrado = null;
        int indice = 0;
        while (encontrado == null && indice < stock.size()){
            if (name.equals(stock.get(indice).getName())){
                encontrado = stock.get(indice);
            }
            indice = indice + 1;
        }
        return encontrado;
    }
}
