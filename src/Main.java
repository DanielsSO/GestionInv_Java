import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id = 0;
        HashMap<Integer ,String> inventario = new HashMap<>();
        inventario.put (id++,"lapiz 100");
        inventario.put (id++,"Libro 40");
        inventario.put (id++,"Cuaderno 60");
        inventario.put (id++,"Lapicero 85");

        System.out.println("Cuantos productos se van agregar? ");
        int cantidad_prod = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad_prod; i++) {
            System.out.println("Ingrese el producto: " + (i + 1));
            String agregar = scanner.nextLine();
            inventario.put(id++, agregar);
        }

        System.out.println("El inventario actual es: " + inventario);


        System.out.println("Indique que producto quiere modificar. Si no quiere modificar poner -1 ");
        int actualizar = scanner.nextInt();
        scanner.nextLine();

        if (actualizar == -1){
            System.out.println("No se modifico nada");
            System.out.println("El inventario quedo como: " + inventario);
        }
        else if (inventario.containsKey(actualizar)){
            System.out.println("Ingresa el nuevo Stock del producto: ");
            String nuevoStock = scanner.nextLine();

            String productoInv = inventario.get(actualizar);
            String producto_nuevo_name = productoInv.split(" ")[0];

            inventario.put(actualizar, producto_nuevo_name + " " + nuevoStock);
            System.out.println("Se actualizo el producto");
            System.out.println("El inventario actualizado es: " + inventario);
        }
        System.out.println("Indique que producto desea eliminar de la lista. Si no desea eliminar poner -1");
        int eliminar = scanner.nextInt();
        if (eliminar == -1){
            System.out.println("No se elimino ningun elemento");
            System.out.println("El inventario queda" + inventario);
        }
        else if (inventario.containsKey(eliminar)){
            inventario.remove(eliminar);
            System.out.println("Se elimino el producto con id " + eliminar);
        }


        System.out.println("Inventario final es: " + inventario);
    }
}