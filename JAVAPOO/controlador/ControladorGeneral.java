package controlador;
import modelo.Articulo;
import vista.*;

public class ControladorGeneral {

     private VistaGeneral vista;
     private ControladorCliente Ccliente;
     private ControladorProveedor Cproovedor;
     private ControladorArticulo Carticulo;
     private ControladorVenta Cventa;
     private ControladorFactura Cfactura;
        public ControladorGeneral() {
            vista = new VistaGeneral();                    // Inicializar vista
            Ccliente = new ControladorCliente();    // Inicializar cliente
            Cproovedor = new ControladorProveedor();
            Carticulo = new ControladorArticulo(); // Inicializar proveedor
            Cventa = new ControladorVenta();
            Cfactura = new ControladorFactura();
        }
    public void menuPrincipal() {
        int eleccion;
        do {
            eleccion = vista.menuPrincipal();  // Obtener opción del menú
            switch (eleccion) {
                case 1:
                    Ccliente.menuClientes();
                    break;
                case 2:
                    Cproovedor.menuProveedores();
                    break;
                case 3:
                    Carticulo.menuArticulos();
                    break;
                case 4:
                    Cventa.menuVentas();
                    break;
                case 5:
                    Cfactura.menuFacturas();
                    break;
                case 6:
                    eleccion = 6;
                    vista.mostrarMensaje("Hasta la vista!");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (eleccion != 6); // Repite hasta que elija salir
    }
		
	}