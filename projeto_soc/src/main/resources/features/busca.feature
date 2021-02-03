# language: pt
Funcionalidade: Busca
  Acessando homepage
  Utilizar barra de busca

@fluxopadrao2
  Esquema do Cenario: Deve mostrar resultado da busca
    Dado que estou na home page
    E clicar botao cookie
    Quando preencher campo busca <textoBusca>
    E clickar botao busca
    Entao validar resultado busca <textoBusca>

    Exemplos: 
      | textoBusca                                                   |
      | "ANALISTA DE TESTE"                                          |
      | "LLANFAIRPWLLGWYNGYLLGOGERYCHWYRNDROBWLLLLANTYSILIOGOGOGOCH" |
      | "0"                                                          |
