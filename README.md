# 💲 Finance Analyzer (Motor de Analytics Financeiro)

![Status do Projeto](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)
![Tecnologia Principal](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)

## 📌 Sobre o Projeto

O **Finance Analyzer** é um motor de processamento de dados focado em transformar registros brutos de transações
financeiras em informações gerenciais claras e acionáveis. Desenvolvido inteiramente em Java puro via CLI (Interface de
Linha de Comando), o projeto foi desenhado para consolidar o domínio sobre o **Paradigma de Programação Funcional**,
utilizando amplamente a **Java Stream API** para realizar filtros, somas, extrações e agrupamentos complexos sem a
utilização de laços de repetição tradicionais.

## ⚙️ Arquitetura e Padrões (Diferencial para o Portfólio)

* **Arquitetura:** MVC (Model-View-Controller) adaptado para terminal CLI, garantindo total separação entre regras de
  negócio, acesso a dados e interface com o usuário.
* **Design Patterns:** * **Repository Pattern:** Simulação de um banco de dados em memória encapsulado.
    * **Injeção de Dependências:** `TransactionService` recebe seus dados via construtor, reduzindo o acoplamento.
* **Boas Práticas:** * Princípios SOLID (SRP - Princípio da Responsabilidade Única).
    * Programação Funcional (Java Streams, Optionals, Map/Set).
    * Programação Defensiva e Tratamento de Exceções customizadas (`NegativeAmountException`).
    * Imutabilidade de Coleções (`Collections.unmodifiableList`).

## 🚀 Funcionalidades Principais

* [x] **Calcular Saldo Total:** Soma inteligente de transações do tipo `INCOME` subtraídas das de tipo `EXPENSE`.
* [x] **Filtragem Temporal:** Busca exata de transações parametrizada por Mês e Ano.
* [x] **Maior Despesa:** Busca otimizada (O(n)) utilizando `Comparator` para encontrar o maior gasto, retornando um
  `Optional` seguro.
* [x] **Categorias Únicas:** Varredura do banco retornando um `Set<String>` para garantir listagem de categorias sem
  duplicação.
* [x] **Agrupamento Analítico:** Geração de relatórios (Dicionário/Map) somando o total gasto por cada categoria
  específica utilizando `Collectors.groupingBy`.

## 💻 Tecnologias Utilizadas

### 🔙 Backend

* **Linguagem:** Java (Foco em Stream API e recursos modernos)
* **Framework:** Nenhum (Java Puro)
* **Banco de Dados:** Em memória (Base de dados simulada e imutável para testes analíticos)

## 🛠️ Como Executar o Projeto

### Pré-requisitos

* Java JDK 17 (ou superior) instalado na máquina.
* IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code) ou terminal compatível com `javac`/`java`.

### Passo a Passo

```bash
# 1. Clone este repositório
$ git clone [https://github.com/aggxb/finance-analyzer.git](https://github.com/aggxb/finance-analyzer.git)

# 2. Acesse a pasta do projeto
$ cd finance-analyzer

# 3. Abra o projeto na sua IDE e execute a classe Main localizada em:
# src/br/com/aggxb/financeanalyzer/Main.java