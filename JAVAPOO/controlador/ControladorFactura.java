package controlador;

import vista.*;
import modelo.Factura;
import java.sql.Date;

public class ControladorFactura {
    private VistaGeneral vista;
    private VistaFactura vFactura;
    private Factura factura;

    public ControladorFactura() {
        vista = new VistaGeneral();              
        factura = new Factura();  
        vFactura = new VistaFactura(); 
    }

    public void menuFacturas() {
        int eleccion;
        do {
            eleccion = vista.menuOperaciones();
            switch (eleccion) {
                case 1:
                    agregarFactura();
                    break;
                case 2:
                    factura.mostrarFacturas();
                    break;
                case 3:
                    modificarFactura();
                    break;
                case 4:
                    eliminarFactura();
                    break;
                case 5:
                    eleccion = 5;
                    vista.mostrarMensaje("Hasta la vista!");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        } while (eleccion != 5);
    }

    public void agregarFactura() {
        Object[] datos = vFactura.obtenerDatosFactura();
        int idProveedor = (int) datos[0];
        Date fecha = (Date) datos[1];
        double total = (double) datos[2];

        if (factura.insertarFactura(idProveedor, fecha, total)) {
            vista.mostrarMensaje("Factura añadida correctamente.");
        } else {
            vista.mostrarMensaje("Error al añadir factura.");
        }
    }

    public void modificarFactura() {
        int idFactura = vFactura.obtenerIdFactura();
        Object[] nuevosDatos = vFactura.obtenerDatosFactura();
        int idProveedor = (int) nuevosDatos[0];
        Date fecha = (Date) nuevosDatos[1];
        double total = (double) nuevosDatos[2];

        if (factura.editarFactura(idFactura, idProveedor, fecha, total)) {
            vista.mostrarMensaje("Factura actualizada.");
        } else {
            vista.mostrarMensaje("Error al editar factura.");
        }
    }

    public void eliminarFactura() {
        int idFactura = vFactura.obtenerIdFactura();
        if (factura.eliminarFactura(idFactura)) {
            vista.mostrarMensaje("Factura eliminada.");
        } else {
            vista.mostrarMensaje("Error al eliminar factura.");
        }
    }
}





