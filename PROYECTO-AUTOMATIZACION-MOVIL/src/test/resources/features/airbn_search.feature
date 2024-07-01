Feature: Búsqueda en Airbnb

  @test
  Scenario: Búsqueda exitosa de hospedajes

    Given ingreso a la aplicacion y cierro cualquier ventana popup
    When En el formulario de Where To? busco "Hoteles en Vichayito"
    Then muestra el formulario de When's your trip? y selecciono SKIP
    And  luego hago click en  Search
    And Valido la pantalla con resultados mayores a 1 y el mensaje "Over 1,000 places"