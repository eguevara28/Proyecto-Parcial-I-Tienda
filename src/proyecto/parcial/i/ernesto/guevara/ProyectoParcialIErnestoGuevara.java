package proyecto.parcial.i.ernesto.guevara;

import java.util.Scanner;

/**
 *
 * @author ernes
 */
public class ProyectoParcialIErnestoGuevara {

    public static void main(String[] args) {

        //Inicializacion del Scanner
        Scanner lea = new Scanner(System.in);

        //Variables
        int dia = 1, azucar = 0, maiz = 0, avena = 0, trigo = 0, azucarvendido = 0, maizvendido = 0, avenavendida = 0, trigovendido = 0, dinerorecaudado = 0, compras = 0, ventas = 0, dinerogastado = 0;
        double caja = 0, masganancia = 0, masgasto = 0;
        String listamasganancia = "", listamasgasto = "";

        while (true) {
            System.out.println("*** BIENVENIDO A LA TIENDA ***");
            System.out.println("Dia: " + dia);
            System.out.println("Seleccione una opcion:");
            System.out.println("1) Abrir Caja");
            System.out.println("2) Salir del Sistema");
            int op = lea.nextInt();

            if (op == 1) {
                System.out.println("*** Bienvenido a la Caja ***");
                System.out.println("Cantidas de Efectivo en Caja actualmente: " + caja);

                System.out.println("Cuanto desea añadir a Caja? :");
                double añadir = lea.nextDouble();

                caja += añadir;

                System.out.println("La nueva cantidad de Efectivo en Caja es: " + caja);

                if (caja > 0) {
                    while (true) {
                        System.out.println("*** BIENVENIDO A LA TIENDA ***");
                        System.out.println("Dia: " + dia);
                        System.out.println("Seleccione una opcion:");
                        System.out.println("1) Abrir Caja");
                        System.out.println("2) Vender");
                        System.out.println("3) Comprar");
                        System.out.println("4) Reportes");
                        System.out.println("5) Cerrar Caja");
                        System.out.println("6) Salir del Sistem");
                        int op2 = lea.nextInt();

                        if (op2 == 1) {
                            System.out.println("*** Bienvenido a la Caja ***");
                            System.out.println("Cantidas de Efectivo en Caja actualmente: " + caja);
                            System.out.println("Cuanto desea añadir a Caja? :");
                            añadir = lea.nextDouble();

                            caja += añadir;

                            System.out.println("La nueva cantidad de Efectivo en Caja es: " + caja);
                        }

                        if (op2 == 2) {
                            while (true) {
                                String lista = "", producto;
                                double subtotal = 0;
                                int kg;
                                int precioventa;

                                if (maiz == 0 && azucar == 0 && trigo == 0 && avena == 0) {
                                    System.out.println("No hay productos en el inventario para vender");
                                    break;
                                }

                                System.out.println("Que tipo de cliente es usted?: ");
                                char tipocliente = lea.next().charAt(0);
                                char TipoCliente = Character.toUpperCase(tipocliente);

                                if (TipoCliente != 'A' && TipoCliente != 'B' && TipoCliente != 'C') {
                                    System.out.println("Este Tipo de Cliente No Existe");
                                }

                                if (TipoCliente == 'A') {
                                    while (true) {

                                        int contador = 0;

                                        System.out.println("----------------------------------------");
                                        System.out.println("Codigo      Producto      Precio / Kg");
                                        System.out.println("1           Azucar        Lps. 30");
                                        System.out.println("2           Avena         Lps. 25");
                                        System.out.println("3           Trigo         Lps. 32");
                                        System.out.println("4           Maiz          Lps. 20");
                                        System.out.println("----------------------------------------");

                                        System.out.println("Ingrese el codigo del producto que desea?: ");
                                        int codigop = lea.nextInt();

                                        producto = (codigop == 1) ? "Azucar"
                                                : (codigop == 2) ? "Avena"
                                                        : (codigop == 3) ? "Trigo"
                                                                : (codigop == 4) ? "Maiz" : "No Existe";

                                        precioventa = (producto.equals("Azucar")) ? 30
                                                : (producto.equals("Avena")) ? 25
                                                : (producto.equals("Trigo")) ? 32
                                                : (producto.equals("Maiz")) ? 20 : 0;

                                        System.out.println("Cuantos kilogramos de este producto desea?: ");
                                        kg = lea.nextInt();

                                        if (codigop == 1 && azucar >= kg || codigop == 2 && avena >= kg || codigop == 3 && trigo >= kg || codigop == 4 && maiz >= kg) {

                                            contador++;

                                            if (producto.equals("Azucar")) {
                                                azucar -= kg;
                                                azucarvendido += kg;
                                            }

                                            if (producto.equals("Avena")) {
                                                avena -= kg;
                                                avenavendida += kg;
                                            }

                                            if (producto.equals("Trigo")) {
                                                trigo -= kg;
                                                trigovendido += kg;
                                            }

                                            if (producto.equals("Maiz")) {
                                                maiz -= kg;
                                                maizvendido += kg;
                                            }

                                            double pago = kg * precioventa;
                                            subtotal += pago;

                                            lista += "Producto: " + producto + "\nCantidad (kg): " + kg + "\nPrecio por kilogramo: " + precioventa + "\n";

                                            System.out.println("Desea comprar otro producto? (s/n): ");
                                            char otro = lea.next().charAt(0);
                                            char otroM = Character.toUpperCase(otro);

                                            if (otroM == 'N') {

                                                double porcentajedescuento = 0;
                                                int displaydescuento = 0;

                                                if (subtotal > 1000) {
                                                    porcentajedescuento = 0.05;
                                                    displaydescuento = 5;
                                                }

                                                if (subtotal > 5000) {
                                                    porcentajedescuento = 0.1;
                                                    displaydescuento = 10;
                                                }

                                                System.out.println("****************** FACTURA ******************");
                                                System.out.println(lista);
                                                double descuento = subtotal * porcentajedescuento;
                                                double impuesto = subtotal * 0.07;
                                                double total = subtotal + impuesto - porcentajedescuento;
                                                System.out.println("Subtotal: " + subtotal);
                                                System.out.println("Impuestos (7%) :" + impuesto);
                                                System.out.println("Tienes un descuento de " + displaydescuento + "% :" + descuento);
                                                System.out.println("El total a pagar es de: " + total);
                                                dinerorecaudado += total;
                                                caja += total;
                                                ventas += contador;

                                                if (total > masganancia) {
                                                    masganancia = total;
                                                    listamasganancia = lista;
                                                }

                                                System.out.println("*******************************************\n");
                                                break;
                                            }
                                        } else {
                                            System.out.println("Lo sentimos, no hay inventario suficiente");
                                        }

                                    }
                                }

                                if (TipoCliente == 'B') {
                                    while (true) {

                                        int contador = 0;

                                        System.out.println("----------------------------------------");
                                        System.out.println("Codigo      Producto      Precio / Kg");
                                        System.out.println("1           Azucar        Lps. 30");
                                        System.out.println("2           Avena         Lps. 25");
                                        System.out.println("3           Trigo         Lps. 32");
                                        System.out.println("----------------------------------------");

                                        //El usuario escribe el codigo del producto que desea comprar
                                        System.out.println("Ingrese el codigo del producto que desea?: ");
                                        int codigop = lea.nextInt();

                                        //Dependiendo del codigo elegido la variable "producto" almacena el nombre del producto
                                        producto = (codigop == 1) ? "Azucar"
                                                : (codigop == 2) ? "Avena"
                                                        : (codigop == 3) ? "Trigo" : "No Existe";

                                        //Dependiendo del nombre de producto la variable "precioventa" almacena el precio de venta del producto
                                        precioventa = (producto.equals("Azucar")) ? 30
                                                : (producto.equals("Avena")) ? 25
                                                : (producto.equals("Trigo")) ? 32 : 0;

                                        if (codigop == 4) {
                                            System.out.println("No puedes comprar este producto");
                                        }

                                        if (codigop != 1 && codigop != 2 && codigop != 3 && codigop != 4) {
                                            System.out.println("Este producto no existe");
                                        }

                                        if (codigop == 1 || codigop == 2 || codigop == 3) {
                                            System.out.println("Cuantos kilogramos de este producto desea?: ");
                                            kg = lea.nextInt();

                                            if (codigop == 1 && azucar >= kg || codigop == 2 && avena >= kg || codigop == 3 && trigo >= kg) {

                                                contador++;

                                                if (producto.equals("Azucar")) {
                                                    azucarvendido += kg;
                                                    azucar -= kg;
                                                }

                                                if (producto.equals("Avena")) {
                                                    avenavendida += kg;
                                                    avena -= kg;
                                                }

                                                if (producto.equals("Trigo")) {
                                                    trigovendido += kg;
                                                    trigo -= kg;
                                                }

                                                double pago = kg * precioventa;
                                                subtotal += pago;

                                                lista += "Producto: " + producto + "\nCantidad (kg): " + kg + "\nPrecio por kilogramo: " + precioventa + "\n";

                                                System.out.println("Desea comprar otro producto? (s/n): ");
                                                char otro = lea.next().charAt(0);
                                                char otroM = Character.toUpperCase(otro);

                                                if (otroM == 'S') {

                                                }

                                                if (otroM == 'N') {
                                                    double porcentajedescuento = 0;
                                                    int displaydescuento = 0;

                                                    if (subtotal > 1000) {
                                                        porcentajedescuento = 0.05;
                                                        displaydescuento = 5;
                                                    }

                                                    if (subtotal > 5000) {
                                                        porcentajedescuento = 0.1;
                                                        displaydescuento = 10;
                                                    }

                                                    System.out.println("****************** FACTURA ******************");
                                                    System.out.println(lista);
                                                    double descuento = subtotal * porcentajedescuento;
                                                    double impuesto = subtotal * 0.07;
                                                    double total = subtotal + impuesto - porcentajedescuento;
                                                    System.out.println("Subtotal: " + subtotal);
                                                    System.out.println("Impuestos (7%) :" + impuesto);
                                                    System.out.println("Tienes un descuento de " + displaydescuento + "% :" + descuento);
                                                    System.out.println("El total a pagar es de: " + total);
                                                    caja += total;
                                                    dinerorecaudado += total;

                                                    if (total > masganancia) {
                                                        masganancia = total;
                                                        listamasganancia = lista;
                                                    }

                                                    System.out.println("*******************************************\n");
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }

                                if (TipoCliente == 'C') {
                                    while (true) {
                                        System.out.println("----------------------------------------");
                                        System.out.println("Codigo      Producto      Precio / Kg");
                                        System.out.println("4           Maiz          Lps. 20");
                                        System.out.println("----------------------------------------");

                                        //El usuario escribe el codigo del producto que desea comprar
                                        System.out.println("Ingrese el codigo del producto que desea?: ");
                                        int codigop = lea.nextInt();

                                        //Dependiendo del codigo elegido la variable "producto" almacena el nombre del producto
                                        producto = (codigop == 4) ? "Maiz" : "No Existe";

                                        //Dependiendo del nombre de producto la variable "precioventa" almacena el precio de venta del producto
                                        precioventa = (producto.equals("Maiz")) ? 20 : 0;

                                        if (codigop == 1 || codigop == 2 || codigop == 3) {
                                            System.out.println("No puedes comprar este producto");
                                        }

                                        if (codigop != 1 && codigop != 2 && codigop != 3 && codigop != 4) {
                                            System.out.println("Este producto no existe");
                                        }

                                        if (codigop == 4) {
                                            System.out.println("Cuantos kilogramos de este producto desea?: ");
                                            kg = lea.nextInt();

                                            if (kg <= maiz) {

                                                if (producto.equals("Maiz")) {
                                                    maizvendido += kg;
                                                }

                                                double pago = kg * precioventa;
                                                subtotal += pago;

                                                lista += "Producto: " + producto + "\nCantidad (kg): " + kg + "\nPrecio por kilogramo: " + precioventa + "\n";

                                                System.out.println("Desea comprar otro producto? (s/n): ");
                                                char otro = lea.next().charAt(0);
                                                char otroM = Character.toUpperCase(otro);

                                                if (otroM == 'N') {
                                                    double porcentajedescuento = 0;
                                                    int displaydescuento = 0;

                                                    if (subtotal > 1000) {
                                                        porcentajedescuento = 0.05;
                                                        displaydescuento = 5;
                                                    }

                                                    if (subtotal > 5000) {
                                                        porcentajedescuento = 0.1;
                                                        displaydescuento = 10;
                                                    }

                                                    System.out.println("****************** FACTURA ******************");
                                                    System.out.println(lista);
                                                    double descuento = subtotal * porcentajedescuento;
                                                    double impuesto = subtotal * 0.07;
                                                    double total = subtotal + impuesto - porcentajedescuento;
                                                    System.out.println("Subtotal: " + subtotal);
                                                    System.out.println("Impuestos (7%) :" + impuesto);
                                                    System.out.println("Tienes un descuento de " + displaydescuento + "% :" + descuento);
                                                    System.out.println("El total a pagar es de: " + total);
                                                    caja += total;
                                                    dinerorecaudado += total;

                                                    if (total > masganancia) {
                                                        masganancia = total;
                                                        listamasganancia = lista;
                                                    }

                                                    System.out.println("*******************************************\n");
                                                    break;
                                                }
                                            }else System.out.println("Lo sentimos, no hay inventario suficiente");
                                        }
                                    }
                                }
                            }
                        }

                        if (op2 == 3) {
                            String lista = "", producto;
                            double subtotal = 0;
                            int kg;
                            int preciocompra;

                            System.out.println("Ingrese que tipo de proveedor es usted: ");
                            char TipoProveedor = lea.next().charAt(0);

                            if (TipoProveedor != 'A' && TipoProveedor != 'B' && TipoProveedor != 'C') {
                                System.out.println("Este Tipo de Proveedor No Existe");
                            }

                            if (TipoProveedor == 'A') {
                                while (true) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Codigo      Producto      Precio / Kg");
                                    System.out.println("1           Azucar        Lps. 25");
                                    System.out.println("4           Maiz          Lps. 18");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Ingrese el codigo del producto que desea: ");
                                    int codigop = lea.nextInt();

                                    producto = (codigop == 1) ? "Azucar"
                                            : (codigop == 4) ? "Maiz" : "No Existe";

                                    //Dependiendo del nombre de producto la variable "preciocompra" almacena el precio de venta del producto
                                    preciocompra = (producto.equals("Azucar")) ? 25
                                            : (producto.equals("Maiz") ? 18 : 0);

                                    if (codigop == 1 || codigop == 4) {
                                        System.out.println("Cuantos kilos comprara?: ");
                                        kg = lea.nextInt();

                                        double pago = kg * preciocompra;

                                        if (pago <= caja) {

                                            if (producto.equals("Azucar")) {
                                                azucar += kg;
                                            }

                                            if (producto.equals("Maiz")) {
                                                maiz += kg;
                                            }

                                            lista += "Producto: " + producto + "\nCantidad (kg): " + kg + "\nPrecio por kilogramo: " + preciocompra + "\n";

                                            subtotal = pago;
                                            double impuesto = subtotal * 0.07;
                                            double total = subtotal + impuesto;

                                            System.out.println("****************** FACTURA ******************");
                                            System.out.println(lista);
                                            System.out.println("Subtotal: " + subtotal);
                                            System.out.println("Impuestos (7%) :" + impuesto);
                                            System.out.println("El total a pagar es de: " + total);
                                            caja -= total;
                                            compras++;
                                            dinerogastado += total;

                                            if (total > masgasto) {
                                                masgasto = total;
                                                listamasgasto = lista;
                                            }

                                            System.out.println("*********************************************\n");
                                            break;
                                        } else {
                                            System.out.println("No hay suficiente dinero en clase");
                                        }
                                    } else {
                                        System.out.println("No puede comprar este producto");
                                    }
                                }
                            }

                            if (TipoProveedor == 'B') {
                                while (true) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Codigo      Producto      Precio / Kg");
                                    System.out.println("2           Avena         Lps. 20");
                                    System.out.println("3           Trigo         Lps. 30");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Ingrese el codigo del producto que desea: ");
                                    int codigop = lea.nextInt();

                                    producto = (codigop == 2) ? "Avena"
                                            : (codigop == 3) ? "Trigo" : "No Existe";

                                    preciocompra = (producto.equals("Avena")) ? 20
                                            : (producto.equals("Trigo") ? 30 : 0);

                                    if (codigop == 2 && codigop == 3) {
                                        System.out.println("Cuantos kilos comprara?: ");
                                        kg = lea.nextInt();

                                        double pago = kg * preciocompra;

                                        if (pago <= caja) {

                                            if (producto.equals("Azucar")) {
                                                azucar += kg;
                                            }

                                            if (producto.equals("Maiz")) {
                                                maiz += kg;
                                            }

                                            lista += "Producto: " + producto + "\nCantidad (kg): " + kg + "\nPrecio por kilogramo: " + preciocompra + "\n";

                                            subtotal = pago;
                                            double impuesto = subtotal * 0.07;
                                            double total = subtotal + impuesto;

                                            System.out.println("****************** FACTURA ******************");
                                            System.out.println(lista);
                                            System.out.println("Subtotal: " + subtotal);
                                            System.out.println("Impuestos (7%) :" + impuesto);
                                            System.out.println("El total a pagar es de: " + total);
                                            caja -= total;
                                            compras++;
                                            dinerogastado += total;

                                            if (total > masgasto) {
                                                masgasto = total;
                                                listamasgasto = lista;
                                            }

                                            System.out.println("*********************************************\n");
                                            break;
                                        } else {
                                            System.out.println("No hay suficiente dinero en caja para comprar");
                                            break;
                                        }
                                    } else {
                                        System.out.println("No vende este producto");
                                        break;
                                    }
                                }
                            }

                            if (TipoProveedor == 'C') {
                                while (true) {
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Codigo      Producto      Precio / Kg");
                                    System.out.println("2           Avena         Lps. 18");
                                    System.out.println("--------------------------------------------------");
                                    System.out.println("Ingrese el codigo del producto que desea: ");
                                    int codigop = lea.nextInt();

                                    producto = (codigop == 2) ? "Avena" : "No Existe";

                                    //Dependiendo del nombre de producto la variable "preciocompra" almacena el precio de venta del producto
                                    preciocompra = (producto.equals("Avena")) ? 18 : 0;

                                    if (codigop == 2) {
                                        System.out.println("Cuantos kilos comprara?: ");
                                        kg = lea.nextInt();

                                        double pago = kg * preciocompra;

                                        if (pago <= caja) {

                                            if (producto.equals("Avena")) {
                                                avena += kg;
                                            }

                                            lista += "Producto: " + producto + "\nCantidad (kg): " + kg + "\nPrecio por kilogramo: " + preciocompra + "\n";

                                            subtotal = pago;
                                            double impuesto = subtotal * 0.07;
                                            double total = subtotal + impuesto;

                                            System.out.println("****************** FACTURA ******************");
                                            System.out.println(lista);
                                            System.out.println("Subtotal: " + subtotal);
                                            System.out.println("Impuestos (7%) :" + impuesto);
                                            System.out.println("El total a pagar es de: " + total);
                                            caja -= total;
                                            compras++;
                                            dinerogastado += total;

                                            if (total > masgasto) {
                                                masgasto = total;
                                                listamasgasto = lista;
                                            }

                                            System.out.println("*********************************************\n");
                                            break;
                                        }
                                    } else {
                                        System.out.println("No vende este producto");
                                    }
                                }
                            }
                        }

                        if (op2 == 5) {
                            System.out.println("Cerrando caja");
                            dia++;
                            break;
                        }

                        if (op2 == 6) {
                            System.out.println("Saliendo del Sistema...");
                            System.exit(0);
                        }

                        if (op2 == 4) {
                            System.out.println("Dinero en caja actualmente: " + caja + "\n");
                            System.out.println("Compras realizadas: " + compras + "\n");
                            System.out.println("Ventas realizadas: " + ventas + "\n");
                            System.out.println("Cantidad de dinero en ventas: " + dinerorecaudado + "\n");
                            System.out.println("Cantidad de dinero en compras: " + dinerogastado);
                            System.out.println("Margen de dinero obtenido: " + (dinerorecaudado - dinerogastado) + "\n");
                            System.out.println("Promedio de Ventas: " + dinerorecaudado / ventas + "\n");
                            System.out.println("Promedio de Compras: " + dinerogastado / compras + "\n");

                            if (maizvendido > trigovendido && maizvendido > avenavendida && maizvendido > azucarvendido) {
                                System.out.println("El producto mas vendido es: Maiz");
                                System.out.println("Se vendieron: " + maizvendido + " kg");
                            }

                            if (trigovendido > maizvendido && trigovendido > avenavendida && trigovendido > azucarvendido) {
                                System.out.println("El producto mas vendido es: Trigo");
                                System.out.println("Se vendieron: " + trigovendido + " kg\n");
                            }

                            if (avenavendida > maizvendido && avenavendida > trigovendido && avenavendida > azucarvendido) {
                                System.out.println("El producto mas vendido es: Avena");
                                System.out.println("Se vendieron: " + avenavendida + " kg\n");
                            }

                            if (azucarvendido > maizvendido && azucarvendido > trigovendido && azucarvendido > maizvendido) {
                                System.out.println("El producto mas vendido es: Azucar");
                                System.out.println("Se vendieron: " + azucarvendido + " kg\n");
                            }

                            System.out.println("La compra con mas gasto fue: " + listamasgasto);
                            System.out.println("El gasto fue de: " + masgasto + "\n");

                            System.out.println("La venta mas grande fue de: " + listamasganancia);
                            System.out.println("La venta fue de: " + masganancia + "\n");
                        }
                        
                        if(op2!=1 && op2!=2 && op2!=3 && op2!=4 && op2!=5 && op2!=6){
                            System.out.println("Esta opcion no existe");
                        }
                    }
                }
            } else if (op == 2) {
                System.out.println("Cerrando el Sistema...");
                break;
            }else if(op!=1 && op!=2){
                System.out.println("No existe esta opcion");
            }
        }
    }
}
