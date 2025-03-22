import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        Inventario_prod inventario = new Inventario_prod(scanner);
        boolean menu = true;

        int seleccion = 0;
        HashMap<Integer, String> opciones = new HashMap<>();
        opciones.put(1, "Agregar productos");
        opciones.put(2, "Modificar productos");
        opciones.put(3, "Eliminar productos");
        opciones.put(4, "Ver inventario");
        opciones.put(5, "Salir");

        while (menu) {
            System.out.println("Porfavor seleccione alguna opcion para continuar");
            for (Integer key : opciones.keySet()) {
                System.out.println(key + ". " + opciones.get(key));
            }
            seleccion = scanner.nextInt();
            scanner.nextLine();

            if (seleccion == 1) {
                inventario.agregar_Productos();
            } else if (seleccion == 2) {
                inventario.Modificar();
            } else if (seleccion == 3) {
                inventario.Eliminar();
            } else if (seleccion == 4) {
                inventario.mostrar_Elinventario();
            } else if (seleccion == 5) {
                menu = false;
                break;
            }
        }

        System.out.println("Se termino el proceso.");
        scanner.close();
    }
}

class Inventario_prod {
    private HashMap<Integer, String> inventario;
    private int id = 0;
    private Scanner scanner;

    public Inventario_prod(Scanner scanner) {
        this.inventario = new HashMap<>();
        this.id = 1;
        this.scanner = scanner;
        inventario.put(id++, "lapiz 100");
        inventario.put(id++, "Libro 50");
        inventario.put(id++, "Cuaderno 100");
        inventario.put(id++, "Lapicero 95");
    }

    public void agregar_Productos(){

        System.out.println("Cuantos productos se van agregar? ");
        int cantidad_prod = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < cantidad_prod; i++) {
            System.out.println("Ingrese el producto: " + (i + 1));
            String agregar = scanner.nextLine();
            inventario.put(id++, agregar);
        }

        System.out.println("El inventario actual es: " + inventario);
    }

    public void Modificar(){
        String modificar = "";
            System.out.println("Indique que producto quiere modificar. Si no quiere modificar poner -1 ");
            System.out.println(inventario);
            int actualizar = scanner.nextInt();
            scanner.nextLine();

            if (actualizar == -1) {
                System.out.println("No se modifico nada");
                System.out.println("El inventario quedo como: " + inventario);
            } else if (inventario.containsKey(actualizar)) {
                System.out.println("Ingresa el nuevo Stock del producto: ");
                String nuevoStock = scanner.nextLine();

                String productoInv = inventario.get(actualizar);
                String producto_nuevo_name = productoInv.split(" ")[0];

                inventario.put(actualizar, producto_nuevo_name + " " + nuevoStock);
                System.out.println("Se actualizo el producto");
                System.out.println("El inventario actualizado es: " + inventario);
            }
    }

    public void Eliminar(){
        String repetir_eliminar;
            System.out.println("Indique que producto desea eliminar de la lista. Si no desea eliminar poner -1");
            System.out.println(inventario);
            int eliminar = scanner.nextInt();
            scanner.nextLine();
            if (eliminar == -1) {
                System.out.println("No se elimino ningun elemento");
                System.out.println("El inventario queda" + inventario);
            } else inventario.remove(eliminar);
            System.out.println("Se elimino el producto con id " + eliminar);
            System.out.println("El inventario actualizado es: " + inventario);
    }

    public void mostrar_Elinventario(){
        System.out.println("Inventario final es: " + inventario);
    }
}