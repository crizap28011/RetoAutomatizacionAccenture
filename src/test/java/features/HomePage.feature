Feature: Seccion Reserva Vuelos
  Como usuario quiero resevar un vuelo seleccionando el origen, el destino, los dias de ida y regreso.

  Scenario: Ingresar informacion de vuelo
    Given El usuario se encuentra en la pagina principal de despegar.com
    When Llena el formulario con los datos del origen, el destino, los dias de ida y regreso, y dar click en buscar.
      And filtra por precio
      And Selecciona el de menor precio
      And Click en continuar
    Then Redirecciona a la pagina de seleccion de vuelos




