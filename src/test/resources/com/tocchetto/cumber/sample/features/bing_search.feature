# language: pt
Funcionalidade: Pesquisar textos no bing
  Teste de pesquisas no bing utilizando cucumber, selenium e CDI.

  Esquema do Cenário: Pesquisar texto no bing
    Dado que ao acessar o site do "bing"
    Quando eu pesquisar no "bing" por "<pesquisar>"
    Então nos resultados do "bing" deve existir o item "<resultado>"

    Exemplos: 
      | pesquisar          | resultado                   |
      | cucumber io        | Cucumber                    |
      | selenium webdriver | Selenium WebDriver          |
      | cdi weld           | Weld: Home                  |
