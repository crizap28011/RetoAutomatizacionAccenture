package seleniumgluecode;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class Test extends TestBase{

    @Given("^El usuario se encuentra en la pagina principal de despegar\\.com$")
    public void el_usuario_se_encuentra_en_la_pagina_principal_de_despegar_com() throws Throwable {
        Assert.assertTrue(homePage.homePageIsDisplayed());
    }

    @When("^Llena el formulario con los datos del origen, el destino, los dias de ida y regreso, y dar click en buscar\\.$")
    public void llena_el_formulario_con_los_datos_del_origen_el_destino_los_dias_de_ida_y_regreso_y_dar_click_en_buscar() throws Throwable {
        homePage.fillForm();
        homePage.waitElementInReservationPage();
    }

    @When("^filtra por precio$")
    public void filtra_por_precio() throws Throwable {
        homePage.clickOnSelect();
    }

    @When("^Selecciona el de menor precio$")
    public void selecciona_el_de_menor_precio() throws Throwable {
        homePage.clickOnBestButton();
    }

    @When("^Click en continuar$")
    public void click_en_continuar() throws Throwable {
        homePage.selectOptionsBaggage();
    }

    @Then("^Redirecciona a la pagina de seleccion de vuelos$")
    public void redirreciona_a_la_pagina_de_seleccion_de_vuelos() throws Throwable {
    }

}
