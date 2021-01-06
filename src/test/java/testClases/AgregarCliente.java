package testClases;

import pages.CarruselPage;
import pages.CrearCliente;
import pages.RegistroPage;

public class AgregarCliente {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearCliente crearCliente = new CrearCliente();
    String nombre = "Juan Perez";
    String id = "1234";
    String telefono = "99999999";
    String direccion = "Calle uno";
    String notas = "Sin notas";
    public void flujo(){
        carruselPage.validarVistaDesplegable();
        carruselPage.validartextoVistaCarrusel1();
        carruselPage.recorrerCarrusel();
        carruselPage.btnDone();

        registroPage.validaVistaregistro();
        registroPage.tapBtnPlus();
        registroPage.tapBtnCrearCliente();

        crearCliente.validaVistaregistro();
        crearCliente.ingresoDatosCrearCliente(nombre,id,telefono,direccion,notas);
        crearCliente.tapBtnGuardar();

        registroPage.validaVistaregistro();
    }
}
