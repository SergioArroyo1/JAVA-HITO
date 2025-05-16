package controlador;

import vista.*;
import modelo.Proveedor;

public class ControladorProveedor {
    private VistaGeneral vista;
    private VistaProveedor vProveedor;
    private Proveedor proveedor;

    public ControladorProveedor() {
        vista = new VistaGeneral();              
        proveedor = new Proveedor();      
        vProveedor = new VistaProveedor();  
    }

    public void menuProveedores() {
        int eleccion;
        do {
            eleccion = vista.menuOperaciones();
            switch (eleccion) {
                case 1:
                    agregarProveedor();
                    break;
                case 2:
                    proveedor.mostrarProveedores();
                    break;
                case 3:
                    datosProveedores();
                    break;
                case 4:
                    eliminarProveedor();
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

    public void agregarProveedor() {
        String[] datos = vProveedor.obtenerDatosProveedor();
        String nombre = datos[0];
        String cif = datos[1];
        String telefono = datos[2];

        if (proveedor.insertarProveedor(nombre, cif, telefono)) {
            vista.mostrarMensaje("Proveedor añadido correctamente.");
        } else {
            vista.mostrarMensaje("Error al añadir proveedor.");
        }
    }

    public void datosProveedores() {
        String cifOriginal = vProveedor.obtenerCif(); // CIF actual

        if (proveedor.buscarProveedor(cifOriginal)) {
            String[] nuevosDatos = vProveedor.obtenerDatosProveedor();
            String nombreNuevo = nuevosDatos[0];
            String cifNuevo = nuevosDatos[1];
            String telefonoNuevo = nuevosDatos[2];

            if (proveedor.editarProveedor(nombreNuevo, telefonoNuevo, cifNuevo, cifOriginal)) {
                vista.mostrarMensaje("Proveedor actualizado.");
            } else {
                vista.mostrarMensaje("Error al editar proveedor.");
            }
        } else {
            vista.mostrarMensaje("El CIF proporcionado no existe.");
        }
    }

    public void eliminarProveedor() {
        String cifEliminar = vProveedor.obtenerCif();
        if (proveedor.eliminarProveedor(cifEliminar)) {
            vista.mostrarMensaje("Proveedor eliminado.");
        } else {
            vista.mostrarMensaje("Error al eliminar proveedor.");
        }
    }
}

