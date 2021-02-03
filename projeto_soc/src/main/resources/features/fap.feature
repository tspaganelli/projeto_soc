# language: pt
Funcionalidade: Preencher
  Formulario FAP

@fluxopadrao
  Esquema do Cenario: Deve preencher formulario de busca
    Dado que estou na home page
    E clicar botao cookie
    E clicar em recursos
    E clicar em FAP
    Quando preencher nome empresa <nomeEmpresa>
    E preencher numero FAP <nFap>
    E preencher valor projecao <vProjecao>
    E selecionar valor RAT
    E clickar botao estipular
    Entao validar que formulario foi gerado

    Exemplos: 
      | nomeEmpresa | nFap | vProjecao |
      | "Teste"     |    "1" |    "200000" |
      | "Thiago"    |    "2" |    "200000" |
