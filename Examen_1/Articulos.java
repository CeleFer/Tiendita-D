
public class Articulos {

    String codigos[];
    String nombres[];
    double datos[][];

    int numArt = 0;

    public Articulos(int x){
        this.codigos  = new String[x];
        this.nombres  = new String[x];
        this.datos    = new double[x][3];

        /** 
         *  datos[x][0] = Cantidad precio  
         *  datos[x][1] = Precio de compra 
         *  datos[x][2] = Precio venta
        */
    }

}
