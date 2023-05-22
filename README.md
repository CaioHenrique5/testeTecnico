# testeTecnico

Exemplos de Requests:
  1.Cadastrar uma nova pauta:
    Método: POST
    URL: /api/pautas
    Corpo da requisição:
    {
      "descricao": "Descrição da pauta"
    }
    Resposta esperada: 201 Created
  2.Abrir uma sessão de votação em uma pauta:
      Método: POST
      URL: /api/pautas/{pautaId}/sessoes
      Corpo da requisição (opcional):
      {
        "duracao": 5
      }
      Resposta esperada: 201 Created
  3.Contabilizar os votos e dar o resultado da votação na pauta:
      Método: GET
      URL: /api/pautas/{pautaId}/resultado
      Resposta esperada:
      {
        "pautaId": 1,
        "descricao": "Descrição da pauta",
        "votosSim": 10,
        "votosNao": 5,
        "resultado": "APROVADA"
      }
  4. Exemplo de registrarVoto.
      Método: POST
      URL: /api/votos
      Corpo da requisição:
      {
        "pautaId": 1,
        "cpf": "12345678900",
        "voto": "SIM",
        "associadoId": "1"
      }
      Resposta esperada: 201 Created
