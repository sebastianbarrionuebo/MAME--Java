package Mame;

import MamePantallas.MameFrame;
import Usuario.ListaDeUsuarios;
import Usuario.Tienda;
import Usuario.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mame {

    public static void main(String[] args) {
        ListaDeUsuarios lista = new ListaDeUsuarios();
        /*
        lista.agregarUsuario(new Usuario(1, 1, "Trahear", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(1, 1, "Damian", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(1, 1, "Nahuel", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(1, 1, "Carla", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(0, 1, "Dinius", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(0, 1, "TutiFruti", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(0, 1, "DarthBaston", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(0, 1, "BarackOrcBama", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(0, 0, "ElPunga", "1234", 1000, 150, 150, 150, 150));
        lista.agregarUsuario(new Usuario(0, 0, "TopDPS", "1234", 1000, 150, 150, 150, 150));
        */
        /*
        try {
            lista.pasarAJson();
        } catch (IOException ex) {
            Logger.getLogger(Mame.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
        lista.agregarTodos(extraerGson("src\\Archivos\\listaUsuarios.json"));
        MameFrame mame = new MameFrame(lista);

    }
    
    public static TreeMap<String,Usuario> extraerGson(String archivo) {
        try (FileReader reader = new FileReader(archivo)) {

            Gson gson = new Gson();
            java.lang.reflect.Type nuevoTypo = new TypeToken<TreeMap<String,Usuario>>(){}.getType();
            TreeMap<String,Usuario> ususarios = gson.fromJson(reader, nuevoTypo);

            reader.close();
            return ususarios;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     
}
