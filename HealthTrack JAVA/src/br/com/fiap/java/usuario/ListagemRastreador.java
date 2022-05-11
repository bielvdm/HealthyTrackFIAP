package br.com.fiap.java.usuario;
import java.util.ArrayList;

public class ListagemRastreador {

    public static void main(String[] argsStrings) {
        
        ArrayList<Rastreador> rastreadorsInfos = new ArrayList<>();
        rastreadorsInfos.add( new Rastreador(70,  1,  3));
        rastreadorsInfos.add( new Rastreador(130, 5,  8));
        rastreadorsInfos.add( new Rastreador(100,  5,  7));
        rastreadorsInfos.add( new Rastreador(110,  7,  3));
        rastreadorsInfos.add( new Rastreador(74,  3,  4));
        rastreadorsInfos.add( new Rastreador(67,  1,  3));
        rastreadorsInfos.add( new Rastreador(98,  2,  2));
        rastreadorsInfos.add( new Rastreador(75,  8,  7));
        rastreadorsInfos.add( new Rastreador(67,  7,  1));
        rastreadorsInfos.add( new Rastreador(97,  2,  2));
        rastreadorsInfos.add( new Rastreador(84,  4,  5));

        
        
        for (Rastreador rastreador : rastreadorsInfos) {
            System.out.println(rastreador);
        }
    }   


}
