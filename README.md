Desafio de Código Vaga Desenvolver de Software
Desenvolver uma api rest que atenda os requesitos de negócios abaixo.

Proposta de valor
A proposta da aplicação é disponibilizar aos clientes e parceiros as modalidades de empréstimo as quais ela tem acesso de acordo com algumas variáveis.

Prover os seguintes modelos de empréstimo: - Empréstimo pessoal. Taxa de juros: 4% - Empréstimo com garantia. Taxa de juros: 3% - Consignado. Taxa de juros: 2%

Abaixo seguem as regras de negócio relacionadas a concessão de empréstimo de acordo com o perfil do cliente:

Empréstimo pessoal	Empréstimo c/ garantia	Consignado
Salário <= 3000	Sim	Sim***	Não
Salário >= 3000	Sim	Sim**	Não
Salário >= 5000	Sim	Sim*	Sim
Regras adicionais - * Clientes com menos de 30 anos - ** Clientes que residem em SP - *** Clientes com menos de 30 anos que residem em SP

Utilização da aplicação:
A aplicação deve receber como entrada as seguintes informações:

Dados de entrada (Exemplo)
{
  "cliente": {
    "name": "teste teste",
    "cpf": "123.456.789-10",
    "age": 29,
    "uf": "SP",
    "renda_mensal": 3000
  }
}
Para fins de simplicidade, considere que vamos sempre receber os dados corretos (tipos e formatos).

A aplicação deve responder com o seguinte modelo de informações:

Dados de saída (Exemplo)
{
  "numero_solicitacao": "745f2812-c3f4-42ce-93fb-e119e643bda2",
  "data_solicitacao": "2021-11-20T21:32:58.787",
  "cliente": {
      "name": "teste teste",
      "cpf": "123.456.789-10",
      "age": 29,
      "uf": "SP",
      "renda_mensal": 3000
  },
  "produtos_emprestimo": [
    {
      "tipo_emprestimo": "EMPRESTIMO_CONSIGNADO",
      "taxa": 1
    },
    {
      "tipo_emprestimo": "EMPRESTIMO_PESSOAL",
      "taxa": 1
    }
  ]
}
Domínio dos tipos de empréstimo
EMPRESTIMO_CONSIGNADO
EMPRESTIMO_PESSOAL
EMPRESTIMO_GARANTIA
Fique a vontade para definir e utilizar o melhor padrão de arquitetura e partner para resolver o problema proposto.

Prezamos muito por qualidade de código, logo gostaríamos de ver os testes de unidades para garantir que tudo está funcionando sem intervensão manual.

Para facilitar a execução da aplicação independente de ambiente (rodar essa api em um container docker seria interessante).

Ponto importante: Utilizamos como base na maioria de nossas aplicações a linguagem java com spring boot.
