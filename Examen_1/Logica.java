import biblioteca.*;

public class Logica {

    double ganancia_total = 0;
    int    total_cant = 0;

    /** 
    *  datos[x][0] = Cantidad precio  
    *  datos[x][1] = Precio de compra 
    *  datos[x][2] = Precio venta
    */

    public void ingresar(Articulos art){

        int vr = art.numArt;
        
        art.codigos[vr] = LE.leerString("Ingrese el codigo del producto # "+vr);
        art.nombres[vr] = LE.leerString("Ingrese el nombre del producto # "+vr);

        /** 
         *  datos[x][0] = Cantidad precio  
         *  datos[x][1] = Precio de compra 
         *  datos[x][2] = Precio venta
        */
        art.datos[vr][0] = LE.leerDouble("Ingrese la cantidad del producto # "+vr);
        art.datos[vr][1] = LE.leerDouble("Ingrese el precio de compra del producto # "+vr);
        art.datos[vr][1] = LE.leerDouble("Ingrese el precio de venta del producto # "+vr);

        art.numArt++;
    }

    public  int busqueda(Articulos art){
        int vector = -1;

        String busca = LE.leerString("Ingrese el nombre del producto que desea verificar : ");

        for(int x = 0 ; x < art.numArt ; x++){

            if(busca.equalsIgnoreCase(art.codigos[x])){
                vector = x;
                LE.mostrarInformacion("Valor encontrado con exito");
            }

        }

        if(vector == -1 ){
            LE.mostrarAdvertencia("El valor no se encuentra en la BD, ingrese un dato valido");
        }
        return vector;

    }

    public void eliminar(Articulos art){

        int vr = busqueda(art);
        
        if(vr != -1){
        /** 
         *  datos[x][0] = Cantidad precio  
         *  datos[x][1] = Precio de compra 
         *  datos[x][2] = Precio venta
        */
            for(int x = vr; x < art.numArt; x++ ){
                art.nombres[x]     =  art.nombres[x+1];
                art.datos[x][0]    =  art.datos[x+1][0];
                art.datos[x][1]    =  art.datos[x+1][1];
                art.datos[x][2]    =  art.datos[x+1][2];
            }
            art.numArt--;
        } 

    }

    // Sobrecarga de metodos : Eliminar , Sin busqueda.
    public void eliminar(Articulos art, int vr){

        // Vr = Vector

        /** 
         *  datos[x][0] = Cantidad precio  
         *  datos[x][1] = Precio de compra 
         *  datos[x][2] = Precio venta
        */

            for(int x = vr; x < art.numArt; x++ ){
                art.nombres[x]     =  art.nombres[x+1];
                art.datos[x][0]    =  art.datos[x+1][0];
                art.datos[x][1]    =  art.datos[x+1][1];
                art.datos[x][2]    =  art.datos[x+1][2];
            }
            art.numArt--;
        

    }

    public void modificar(Articulos art){

        int vr = busqueda(art);

        String num = art.codigos[vr];

        if(vr != -1){

            art.nombres[vr]     =  LE.leerString("Ingrese un  nuevo nombre   / Producto # "+num);
            art.datos[vr][0]    =  LE.leerDouble("Ingrese una nueva cantidad / Producto # "+num);
            art.datos[vr][1]    =  LE.leerDouble("Ingrese un  nuevo P.Compra / Producto # "+num);
            art.datos[vr][2]    =  LE.leerDouble("Ingrese un nuevo P.Venta   / Producto # "+num);

        }

    }

    public void ordenarCodigo(Articulos art){

        String codi;      // Variable de paso de los codigos
        String nom;       // Variable de paso de los nombres  
        double canti;     // Variable de paso de los cantidad
        double compra;    // Variable de paso de la compra
        double venta;     // Variable de paso de la venta

        // El poderosisimo metodo burbuja para ordenar , usando cTIc para comparar Strings.

        for (int i = 0; i < art.numArt - 1; i++) {

            for (int j = i + 1; j < art.numArt; j++) {
                if (art.codigos[i].compareToIgnoreCase(art.codigos[j]) > 0) {
                    codi = art.codigos[j];
                    art.codigos[j] = art.codigos[i];
                    art.codigos[i] = codi;

                    nom = art.nombres[j];
                    art.nombres[j] = art.nombres[i];
                    art.nombres[i] = nom;

                    canti = art.datos[j][0];
                    art.datos[j][0] = art.datos[i][0];
                    art.datos[i][0] = canti;

                    compra = art.datos[j][1];
                    art.datos[j][1] = art.datos[i][1];
                    art.datos[i][1] = compra;

                    venta = art.datos[j][2];
                    art.datos[j][2] = art.datos[i][2];
                    art.datos[i][2] = venta;
                }
            }
        }
        LE.mostrarAdvertencia("Su BD se Reordeno por CODIGO");
    }

    public void ordenarNombres(Articulos art){

        String codi;      // Variable de paso de los codigos
        String nom;       // Variable de paso de los nombres  
        double canti;     // Variable de paso de los cantidad
        double compra;    // Variable de paso de la compra
        double venta;     // Variable de paso de la venta

        // El poderosisimo metodo burbuja para ordenar , usando cTIc para comparar Strings.

        for (int i = 0; i < art.numArt - 1; i++) {

            for (int j = i + 1; j < art.numArt; j++) {
                if (art.nombres[i].compareToIgnoreCase(art.nombres[j]) > 0) {
                    codi = art.codigos[j];
                    art.codigos[j] = art.codigos[i];
                    art.codigos[i] = codi;

                    nom = art.nombres[j];
                    art.nombres[j] = art.nombres[i];
                    art.nombres[i] = nom;

                    canti = art.datos[j][0];
                    art.datos[j][0] = art.datos[i][0];
                    art.datos[i][0] = canti;

                    compra = art.datos[j][1];
                    art.datos[j][1] = art.datos[i][1];
                    art.datos[i][1] = compra;

                    venta = art.datos[j][2];
                    art.datos[j][2] = art.datos[i][2];
                    art.datos[i][2] = venta;
                }
            }
        }
        LE.mostrarAdvertencia("Su BD se Reordeno por NOMBRE");
    }

    public double gananciaParcial(Articulos art, int vr){
        double salida = 0;
        salida = art.datos[vr][2] - art.datos[vr][1];
        return salida;
    }

    public void venta(Articulos art){

        double cant     = 0; 
        double aux      = 0;
        int vr          = 0;

        // 1.) Verificar si el valor buscado para vender existe
        while(vr != -1){
            vr = busqueda(art);
        }

        // 2.) Los valores se pasan a variables auxiliares

        aux   = art.datos[vr][0];

        // 3.) Verificar si la cantidad ingresada excede la cantidad exsistente
        while( aux < 0  ){
          aux   = art.datos[vr][0];
          cant = LE.leerInt("Ingrese la cantidad del producto que desea comprar"
                                +"\n"+"Producto : "+art.nombres[vr]
                                +"\n"+"Cantidad disponible : "+art.datos[vr][0]);

          aux = aux - cant ;

            if(aux < 0){
                LE.mostrarAdvertencia("Cantidad ingresada excede el stock del producto"
                                    +"\n"+"Ingrese valores validos");
            }
        }

        art.datos[vr][0] = aux;

        total_cant += cant;

        ganancia_total += cant*gananciaParcial(art, vr);
        // Productos con una cantidad de 0 son eliminados de la BD

        LE.mostrarInformacion("Producto comprado "+"\n"
                             +"Codigo   : "+art.codigos[vr]+"\n"
                             +"Cantidad : "+art.datos[vr][0]+"\n"
                             +"Venta    : "+art.datos[vr][2]+"\n" 
                             +"Ganancia : "+gananciaParcial(art, vr)
                             );

        eliminar(art, vr); // Sobrecarga de metodos

        
    }

    public String listar(Articulos art){
        String txt = "";

        txt = "Cod" +"\t"+"Art."+"\t"+"Cant."+"\t"+"P.C"+"\t"+"P.V"+"Gan. P.";
        
        for(int x = 0 ; x < art.numArt; x++){
            txt += art.codigos[x]+"\t"+art.nombres[x]+"\t"+art.datos[x][0]
                                                     +"\t"+art.datos[x][1]
                                                     +"\t"+art.datos[x][2]
                                                     +"\t"+gananciaParcial(art, x);
        }
        return txt;
    }

    public void mostrar(Articulos art){
        String txt = listar(art);
        LE.mostrarInformacion("Celefer","Lista de productos", txt , "ok" , null);
    }

    public void menu(Articulos art){

        boolean salida = true ;
        int op = 0; 

        String txt = "";        

        while(salida){

            txt = "            Celefer             ";
            txt += "-------------------------------";
            txt += "Ganancia total : "+ganancia_total;
            txt += "Total de productos vendidos: "+total_cant;
            txt += "-------------------------------";
            txt += "[0]Ingresar";
            txt += "[1]Eliminar";
            txt += "[2]Modificar";
            txt += "    [3]Ordenar por codigo";
            txt += "    [4]Ordenar por nombre";
            txt += "[5]Venta";
            txt += "-------------------------------";
            txt += "[6]Salida";
            txt += "-------------------------------";

            op = LE.leerInt(txt);

            switch(op){
                case 0:
                    ingresar(art);
                    break;
                case 1:
                    eliminar(art);
                    break;
                case 2:
                    modificar(art);
                    break;
                case 3:
                    ordenarCodigo(art);
                    break;
                case 4:
                    ordenarNombres(art);
                    break;
                case 5:
                    venta(art);
                    break;
                case 6:
                    salida = false;
                    break;
                default:
                    LE.mostrarAdvertencia("ingrese una opcion valida");
            }

        }

        

    }

}
