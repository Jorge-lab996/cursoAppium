package testClases;


import pages.BorrarClientePage;
import pages.CarruselPage;
import pages.RegistroPage;

public class BorrarCliente {

    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    BorrarClientePage borrarClientePage = new BorrarClientePage();

    public void flujoBorrarCliente() {

        String nombreCliente = "jijiji";

        carruselPage.validarVistaDesplegable();
        carruselPage.validartextoVistaCarrusel1();
        carruselPage.recorrerCarrusel();
        carruselPage.btnDone();

        registroPage.validaVistaregistro();

        borrarClientePage.seleccionarCliente(nombreCliente);
        borrarClientePage.validaVistaDetalleCliente();
        borrarClientePage.tapBorrarCliente();
        borrarClientePage.validaPopUpConfirmacion();
        borrarClientePage.ingreasarBorrar();

        registroPage.validaVistaregistro();

        borrarClientePage.verificarClienteNoExiste(nombreCliente);

    }
}
