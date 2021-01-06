package testClases;

import pages.AgregarProductoPage;
import pages.CarruselPage;
import pages.RegistroPage;

public class AgregarProducto {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    AgregarProductoPage agregarProducto = new AgregarProductoPage();

    public void flujoCrearProducto(){
        String nombre = "lavadora";
        String precio = "250000";

        carruselPage.validarVistaDesplegable();
        carruselPage.validartextoVistaCarrusel1();
        carruselPage.recorrerCarrusel();
        carruselPage.btnDone();

        registroPage.validaVistaregistro();
        registroPage.tapBtnPlus();
        registroPage.tapBtnCrearProducto();

        agregarProducto.validaVistaCrearCliente();
        agregarProducto.ingresoDatosProducto(nombre,precio);
        agregarProducto.tapBtnConfirmar();

        registroPage.validaVistaregistro();

        agregarProducto.validaVistaProductos();
        agregarProducto.validarProductoAgregado(nombre);
    }
}
