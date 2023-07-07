package Usuario;

import java.io.Serializable;


public class Usuario implements Serializable{
    private Integer  tipo;           /// 1 admin y 0 usuario
    private Integer  activo;        /// 1 ativo y 0 de baja
    private String   nombre;
    private String   clave;
    private Integer  coins;
    private Integer  maxFrog;           /// Maxima puntuacion en Frog
    private Integer  maxSnake;         /// Maxima puntuacion en Snake
    private Integer  maxPong;         /// Maxima puntuacion (partidos ganados) en Pong
    private Integer  maxLab;         /// Maxima puntuacion
    private Integer  totalPuntaje;  /// Total de puntos(Promedio)
    

    public Usuario() {
    }

    public Usuario(Integer tipo, Integer activo, String nombre, String clave, Integer coins, Integer maxFrog, Integer maxSnake, Integer maxPong, Integer maxLab) {
this.tipo = tipo;
        this.activo = activo;
        this.nombre = nombre;
        this.clave = clave;
        this.coins = coins;
        this.maxFrog = maxFrog;
        this.maxSnake = maxSnake;
        this.maxPong = maxPong;
        this.maxLab = maxLab;
        this.totalPuntaje = puntajeTotal();
    }

    public int puntajeTotal(){
        return this.totalPuntaje =(int)(maxFrog+maxLab+maxPong+maxSnake)/4;
    }
    
    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getCoins() {
        return coins;
    }

    public void setCoins(Integer coins) {
        this.coins = coins;
    }

    public Integer getMaxFrog() {
        return maxFrog;
    }

    public void setMaxFrog(Integer maxFrog) {
        this.maxFrog = maxFrog;
    }

    public Integer getMaxSnake() {
        return maxSnake;
    }

    public void setMaxSnake(Integer maxSnake) {
        this.maxSnake = maxSnake;
    }

    public Integer getMaxPong() {
        return maxPong;
    }

    public void setMaxPong(Integer maxPong) {
        this.maxPong = maxPong;
    }

    public Integer getMaxLab() {
        return maxLab;
    }

    public void setMaxLab(Integer maxLab) {
        this.maxLab = maxLab;
    }

    public Integer getTotalPuntaje() {
        return totalPuntaje;
    }

    public void setTotalPuntaje(Integer totalPuntaje) {
        this.totalPuntaje = totalPuntaje;
    }


    @Override
    public String toString() {
        return"--------------------------"
              +"\n Nombre:   " + this.nombre 
              +"\n Tipo:   " + this.tipo
              +"\n Estado:   " + this.activo
              +"\n Maximo puntaje en Frog:      " + this.maxFrog
              +"\n Maximo puntaje en Snake:   " + this.maxSnake
              +"\n Maximo puntaje en Pong:     " + this.maxPong
              +"\n Maximo puntaje en Mario:   " + this.maxLab
              +"\n Puntaje total:   " + this.totalPuntaje
              +"\n--------------------------";
    }
    
}

