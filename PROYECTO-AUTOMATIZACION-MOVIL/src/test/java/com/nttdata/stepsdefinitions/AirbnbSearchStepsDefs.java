package com.nttdata.stepsdefinitions;

import com.nttdata.steps.AirbnbSearchSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.io.File;

public class AirbnbSearchStepsDefs {

    @Steps
    AirbnbSearchSteps airbnbSearchSteps;

    @Given("ingreso a la aplicacion y cierro cualquier ventana popup")
    public void ingresoALaAplicacionYCierroCualquierVentanaPopup() {
        airbnbSearchSteps.cerrarVentana();



    }

    @When("En el formulario de Where To? busco {string}")
    public void enElFormularioDeWhereToBusco(String arg0) {
        airbnbSearchSteps.buscarTexto(arg0);

    }

    @Then("muestra el formulario de When's your trip? y selecciono SKIP")
    public void muestraElFormularioDeWhenSYourTripYSeleccionoSKIP() {
        airbnbSearchSteps.seleccionarOpcion();

    }

    @And("luego hago click en  Search")
    public void luegoHagoClickEnSearch() {
        airbnbSearchSteps.presionarBotn();

    }

    @And("Valido la pantalla con resultados mayores a {int} y el mensaje {string}")
    public void validoLaPantallaConResultadosMayoresAYElMensaje(int arg0, String arg1) {
        airbnbSearchSteps.validar(arg0,arg1);


    }
}
