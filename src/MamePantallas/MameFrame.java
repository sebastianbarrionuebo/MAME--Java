package MamePantallas;

import FrogPantallas.GameFrog;
import LaberintoPantallas.JuegoPanel;
import LaberintoPantallas.MuertoPanel;
import LaberintoPantallas.VictoyPanel;
import FrogPantallas.DeadFrog;
import PingPong.*;
import Snake.GameOverSNAKE;
import Snake.pSnakeGame;
import Usuario.ListaDeUsuarios;
import Usuario.Usuario;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MameFrame extends JFrame {
    //TOTAL DE USUSARIOS Y USUARIO VALIDADO
    private ListaDeUsuarios listaUsuarios;
    private Usuario userActivo = new Usuario();
    
    //PANELES DE MENU
    private InicioSecion           inicSecionP     = new InicioSecion(this);
    private LobyPanel              lobyP           = new LobyPanel(this);
    private LobyAdminPanel         lobyAdminP      = new LobyAdminPanel(this);
    private SeleccionDeJuegoPanel  selecionarJuego = new SeleccionDeJuegoPanel(this);
    private UserInvalid            userInvalidP    = new UserInvalid(this);
    private UsuarioBajaPanel       userBajaP       = new UsuarioBajaPanel(this);
    private CrearUsuarioPanel      crearUserP      = new CrearUsuarioPanel(this);
    private ModificacionUsuarioPanel modUserP;
    private BuscarUserPanel        buscarUserP;
    private Perfil                 perfil;
    private ListaUsuariosPanel     TablaUsuarios;

    
    public MameFrame(ListaDeUsuarios lista) {
        this.listaUsuarios = lista;
        this.buscarUserP = new BuscarUserPanel(this,lista);
        this.add(inicSecionP);
        this.setTitle("M-A-M-E");
        this.setLocationRelativeTo(null); ///Pantalla centrada en el centro de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public ListaDeUsuarios getListaUsuarios() {
        return listaUsuarios;
    }
    public void persitenciaDeDatgos(){
        try {
            this.listaUsuarios.pasarAJson();
        } catch (IOException ex) {
            Logger.getLogger(MameFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     ///fUNCION DE CAMBIO DE PANEL
    public void cambioDePanel(JPanel panelToSwitch, JPanel currentPanel) {
        this.add(panelToSwitch);
        currentPanel.setVisible(false);
        panelToSwitch.setVisible(true);
        panelToSwitch.requestFocus();
        this.revalidate();
    }
    
    public void deModificacionAPerfil(){
        cambioDePanel(perfil,modUserP);
    }
    
    //<editor-fold desc="DE INICIO SESION A...">
    public void deInicioSecionALobyAdmin(){
        cambioDePanel(lobyAdminP,inicSecionP);
    }
    public void deInicSecionALoby(){
        cambioDePanel(lobyP,inicSecionP);
    }
    public void deInicSecionAUsuarioBaja(){
        cambioDePanel(userBajaP,inicSecionP);
    }
    public void deInicioSecionAUserInvalid(){
        cambioDePanel(userInvalidP,inicSecionP);
    }
    public void deInicioDeSecionACrearUser(){
        cambioDePanel(crearUserP,inicSecionP);
    }
    //</editor-fold>
    
    public void deUsuarioBajaAInicioSecion(){
        cambioDePanel(inicSecionP,userBajaP);
    }
    public void deUserInvalidAInicioSecion(){
        cambioDePanel(inicSecionP,userInvalidP);
    }
    public void deBuscarUserAUsuario(){  ///Falta la pantalla Usuario
        cambioDePanel(userInvalidP,buscarUserP);
    }
    public void deBuscarUserALobyAdmin(){  ///Falta la pantalla Usuario
        cambioDePanel(lobyAdminP,buscarUserP);
    }
    public void deCrearUserAUserInvalid(){
        cambioDePanel(userInvalidP,crearUserP);
    }
    public void deBuscarUserAUsuarioInex(){ 
        cambioDePanel(userInvalidP,buscarUserP);
    }
    
    //<editor-fold desc="DE LOBY A...">
    public void deLobyAdminAInicioSecion(){
        cambioDePanel(inicSecionP,lobyAdminP);
    }
    public void deLobyAInicioSecion(){
        cambioDePanel(inicSecionP,lobyP);
    }
    public void deLobyAdminAVerPerfil(){
        perfil = new Perfil(this, userActivo);
        cambioDePanel(perfil,lobyAdminP);
    }
    public void dePerfilAModificacion(){
        modUserP = new ModificacionUsuarioPanel(this, userActivo);
        cambioDePanel(modUserP,perfil);
    }
    public void deLobyAdminABuscarUser(){
        cambioDePanel(buscarUserP,lobyAdminP);
    }
    public void deLobyAdminAselectJuegos(){
        cambioDePanel(selecionarJuego,lobyAdminP);
    }
    public void deLobyUsuAselectJuegos(){
        cambioDePanel(selecionarJuego,lobyP);
    }
    public void deLobyUsuAPerfil(){
        perfil = new Perfil(this, userActivo);
        cambioDePanel(perfil,lobyP);
    }
    public void deLobyAdmAListaUsuarios(){
        TablaUsuarios = new ListaUsuariosPanel(this);
        cambioDePanel(TablaUsuarios,lobyAdminP);
    }
    //</editor-fold>
    
    public void delistaUsuariosAlobyAdmin(){
        cambioDePanel(lobyAdminP,TablaUsuarios);
    }
    public void deSeleccionJuegoToLobyUsuario(){
        cambioDePanel(lobyP,selecionarJuego);
    }
    public void dePerfilAUsu(){
        cambioDePanel(lobyP,perfil);
    }
    public void dePerfilALobyAdmin(){
        cambioDePanel(lobyAdminP,perfil);
    } 
    public void deCrearUserALoby(){
        cambioDePanel(lobyP,crearUserP);
    }
     public void deSeleccionJuegoToLobyAdmin(){
        cambioDePanel(lobyAdminP,selecionarJuego);
    }
     
     
    //<editor-fold desc="REGION PONG">
     private pPong juegopong;
     private PongRedGameOver GMR = new PongRedGameOver(this);
     private PongBlueGameOver GMB = new PongBlueGameOver(this);
     
    public void deSeleccionJuegoToPong(){
        juegopong  = new pPong(this, this.userActivo);
        cambioDePanel(juegopong,selecionarJuego);
        juegopong.initPong();
        this.setBackground(Color.BLACK);
    }
    public void dePongAgameOverBlue(){
        cambioDePanel(GMB,juegopong);
    }
    public void dePongAgameOverRed(){
        cambioDePanel(GMR   ,juegopong);
    }
    public void ReplayBlue(){
        cambioDePanel(juegopong,GMB);
        juegopong.initPong();
    }
    public void ReplayRed(){
        cambioDePanel(juegopong,GMR);
        juegopong.initPong();
    }
    public void deGameOverASeleccionDeJuegoBlue(){
        cambioDePanel(selecionarJuego,GMB);
    }
    public void deGameOverASeleccionDeJuegoRed(){
        cambioDePanel(selecionarJuego,GMR);
    }
    //</editor-fold>
    
    //<editor-fold desc="REGION SNAKE">
    private pSnakeGame snake;
    private GameOverSNAKE GMS = new GameOverSNAKE(this);
    public void deSeleccionJuegoToSnake(){
        snake = new pSnakeGame(this, this.userActivo);
        cambioDePanel(snake,selecionarJuego);
        snake.initJuego();
        this.setBackground(Color.BLACK);
    }
    public void ReplaySnake(){
        cambioDePanel(snake,GMS);
        snake.initJuego();
    }
    public void GameOverSnake(){
        cambioDePanel(GMS,snake);
    }
    public void GameOverSnakeEXIT(){
        cambioDePanel(selecionarJuego,GMS);
    }
    //</editor-fold>
    
    //<editor-fold desc="REGION MARIO">
    private JuegoPanel juegoP;
    private MuertoPanel muertoP = new MuertoPanel(this);
    private VictoyPanel victoryP = new VictoyPanel(this);
    
    public void inicMarioGame(){
        juegoP = new JuegoPanel(this, userActivo);
        juegoP.resetGame();
        cambioDePanel(juegoP,selecionarJuego);
        juegoP.initJuego();
    }
    ///onGameOver
    public void deJuegoAMuerto() {
        cambioDePanel(muertoP,juegoP);
    }
    ///loadGetComplete
    public void deJuegoaVictory(){
        cambioDePanel(victoryP,juegoP);
    }
    ///onReplay
    public void replayJuegoLab(Boolean victory) {
        if(victory){ /// Reset to lvl uno
            juegoP.resetGame();
            cambioDePanel(juegoP,victoryP);
        }else{
            cambioDePanel(juegoP,muertoP);
        }
        juegoP.initJuego();
    }
    public void onExitLab(Boolean victory) {
        if(victory){ /// Reset to lvl uno
            cambioDePanel(selecionarJuego,victoryP);
        }else{
            cambioDePanel(selecionarJuego,muertoP);
        }
    }
    //</editor-fold>
    
    //<editor-fold desc="REGION FROG">
    ///Game Frog
    private DeadFrog muertoFrogP = new DeadFrog(this);
    private GameFrog juegoFrogP = new GameFrog(this);
    public void inicFrogGame(){
        //juegoP.resetGame();
        cambioDePanel(juegoFrogP,selecionarJuego);
        juegoFrogP.initGame();
    }
    
    public void deFrogAMuerte() {
        cambioDePanel(muertoFrogP,juegoFrogP);
    }
    ///onReplay
    public void replayJuegoFrog() {
        cambioDePanel(juegoFrogP,muertoFrogP);
        juegoFrogP.resetGame();
    }
    
    public void onExitFrog() {
        juegoFrogP.resetGame();
        cambioDePanel(selecionarJuego,muertoFrogP);
    }
    //</editor-fold>
    
    //<editor-fold desc="REGION VALIDACION USUARIO ACTIVO">
    public Usuario validarUsuario(String name,String pass){
        Usuario user = null;
        if( listaUsuarios.getUsuario(name) != null ){
            if( pass.equals(listaUsuarios.getUsuario(name).getClave()) ){
                user = listaUsuarios.getUsuario(name);
            }
        }
        return user;
    }
    
    public void setUser(Usuario userOn) {
        this.userActivo = userOn;
    }

    public Usuario getUserActivo() {
        return userActivo;
    }
    //</editor-fold>
    
}
