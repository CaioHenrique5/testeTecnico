# testeTecnico

Exemplos de Requests:
  1.Cadastrar uma nova pauta:
    Método: POST
    URL: /pauta
    Corpo da requisição:
    {
      "descricao": "Descrição da pauta"
    }
    Resposta esperada: 201 Created
  2.Abrir uma sessão de votação em uma pauta:
      Método: POST
      URL: /sessaoVotacao
      Corpo da requisição:
      {
        "tempoAberturaSessao": 5,
        "idPauta": 1
      }
      Resposta esperada: 201 Created
  3.Contabilizar os votos e dar o resultado da votação na pauta:
      Método: GET
      URL: /pauta/resultado/{id}
      Resposta esperada:
      {
        "pautaId": 1,
        "descricao": "Descrição da pauta",
        "votosSim": 10,
        "votosNao": 5,
        "resultado": "APROVADA"
      }
