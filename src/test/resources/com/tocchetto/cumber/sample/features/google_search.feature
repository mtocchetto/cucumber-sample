# language: pt
Funcionalidade: Pesquisar textos no google
  Teste de pesquisas no google utilizando cucumber, selenium e CDI.

  Esquema do Cenário: Pesquisar texto no google
    Dado que ao acessar o site do "google"
    Quando eu pesquisar no "google" por "<pesquisar>"
    Então nos resultados do "google" deve existir o item "<resultado>"

    Exemplos: 
      | pesquisar          | resultado                   |
      | cucumber io        | Cucumber.io                 |
      | selenium webdriver | Selenium WebDriver          |
      | cdi weld           | Weld: Home - CDI            |
