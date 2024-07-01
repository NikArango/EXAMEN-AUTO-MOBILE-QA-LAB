package com.nttdata.steps;

import com.nttdata.screens.LoginScreen;

import net.thucydides.core.annotations.Step;

public class AirbnbSearchSteps {

    LoginScreen loginScreen;

  //  @Step("Click en cerrar")


    public void  cerrarVentana(){
        loginScreen.cerrarVentana();
    };
    public void  buscarTexto(String textbuscar){
        loginScreen.buscarTexto(textbuscar);
    };
    public void   seleccionarOpcion(){
        loginScreen.seleccionarOpcionSkip();
    };
    public void presionarBotn(){
        loginScreen.presionarBotnBuscar();
    };
    public void  validar(int nresults,String textvalidar){
        loginScreen.validar(nresults,textvalidar);
    };


}
