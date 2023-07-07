
package Usuario;


import com.google.gson.Gson;
import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;


public class ListaDeUsuarios  implements Serializable{
    private TreeMap<String,Usuario> lista;
    

    public ListaDeUsuarios() {
        lista = new TreeMap();
    }
    
    
    public void agregarUsuario(Usuario usu){
        lista.put( usu.getNombre(), usu);
    }
    
    public Boolean validarUsuario(Usuario usu){
        return lista.containsKey(usu.getClass().getName());
    }

    public TreeMap<String, Usuario> getLista() {
        return lista;
    }
    
    public Usuario getUsuario(String key){
        return this.lista.get(key);
    }
    
    public Integer getCantidadUsuarios(){
        return (Integer)lista.size();
    }
    
    public Double promedioDePuntos(){
    Double promedio = 0.0;
        for (Usuario user : lista.values()) {
            promedio = (double) ((user.getMaxSnake() + user.getMaxFrog() + user.getMaxPong() + user.getMaxLab())/3);
        }
    return promedio;
    }
    
    public void agregarTodos(TreeMap<String,Usuario> listaUsuarios){
        this.lista = listaUsuarios;
    }
        
     public void pasarAJson() throws IOException {
        File archivo = new File("src\\Archivos\\listaUsuarios.json");
        BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));
        Gson gson = new Gson();
        String jsonString = "";

        jsonString = gson.toJson(this.lista);
        try{
            buffer.write(jsonString);
            buffer.flush();
            buffer.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            buffer.close();
        }
    }
        

    @Override
    public String toString() {
        return "ListaDeUsuarios{" + "lista=" + lista.toString() + '}';
    }
    
    
    
}
