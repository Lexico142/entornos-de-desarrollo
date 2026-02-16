package PracticaUM;

public class Tienda {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Carlos", "carlos@email.com", "Calle Principal 1");

        Producto p1 = new Producto(20, "Camiseta", 50);
        Producto p2 = new Producto(45, "Pantalón", 30);

        Producto[] listaComprada = { p1, p2 };

        Pedido pedido = new Pedido("11/02/2026", cliente1, listaComprada);


        System.out.println("=== PEDIDO ===");

        System.out.println("Cliente: " + pedido.getCliente().getNombre());
        System.out.println("Fecha: " + pedido.getFecha());
        System.out.println("Productos comprados:");

        int total = 0;

        Producto[] productosDelPedido = pedido.getProductos();

        for (int i = 0; i < productosDelPedido.length; i++) {
            String nombreProd = productosDelPedido[i].getNombre();
            int precioProd = productosDelPedido[i].getPrecio();

            System.out.println("- " + nombreProd + " (" + precioProd + "€)");

            total = total + precioProd;
        }

        System.out.println("Total a pagar: " + total + "€");
    }
}