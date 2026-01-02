### Trabalho final da disciplina de POO 2025.2.

Apesar de só haverem contribuições com a conta Davi Lisboa, os demais membros participaram ativamente de atividades como:
- Idealização do sistema
- Sugestões de funcionalidades
- Testes de cada funcionalidade
- Feedback ativo para a melhoria do código
- Confecção dos documentos presentes na entrega final pelo Solar


# 📀 Sistema de Gerenciamento de Mídias (Locadora POO)

**Disciplina:** Programação Orientada a Objetos (SMD0017) – 2025.2

**Linguagem:** Java

**Prazo:** 16/01/2026

---

## 1. Pré-requisitos

* **Java JDK 21** instalado (foi a versão utilizada no desenvolvimento)

  * Para verificar, execute no terminal:

    ```bash
    java -version
    ```

* **Sistema operacional:** Windows, Linux ou macOS

---

## 2. Como clonar o repositório no seu computador

Acesse o repositório no GitHub

Clique em Code → Download ZIP

Extraia o arquivo ZIP em uma pasta de sua preferência

---

## 3. Como executar (passo a passo)

### Passo 1: Extrair os arquivos

1. Extraia o arquivo **`LocadoraPOO-main.zip`** em uma pasta de sua preferência.

Exemplo:

```text
C:\Users\Gilvan\Documents\LocadoraPOO-main\
```

---

### Passo 2: Abrir o terminal / prompt de comando

* **Windows:** pressione `Windows + R`, digite `cmd` e pressione Enter
* **Linux / macOS:** abra o Terminal

---

### Passo 3: Navegar até a pasta do projeto

No terminal, digite:

```bash
cd "caminho/para/sua/pasta/LocadoraPOO-main/src"
```

Exemplo:

```bash
cd "C:\Users\Gilvan\Documents\LocadoraPOO-main\src"
```

---

### Passo 4: Compilar o programa

```bash
javac *.java
```

---

### Passo 5: Executar a classe principal

A classe `Locadora` contém o método `main` do sistema.

```bash
java Locadora
```

➡️ O menu principal será exibido no terminal.

---

## 4. Usando o sistema (fluxo básico)

Ao executar o programa, o seguinte menu será exibido:

```text
===== LOCADORA DE MÍDIAS =====
1. Cadastrar mídia
2. Cadastrar cliente
3. Realizar empréstimo
4. Realizar devolução
5. Listar catálogo completo
6. Listar clientes
7. Relatório geral
8. Listar mídias disponíveis
9. Exibir detalhes das mídias (Polimorfismo)
10. Distribuição por tipo
0. Sair
```

### Para testar rapidamente:

- Digite **1** e cadastre uma mídia (filme ou série)
- Digite **2** e cadastre um cliente
- Digite **3** para realizar um empréstimo
- Digite **4** para realizar uma devolução
- Digite **5** para listar o catálogo completo
- Digite **6** para listar os clientes cadastrados
- Digite **7** para visualizar o relatório geral
- Digite **8** para listar as mídias disponíveis
- Digite **9** para exibir os detalhes das mídias
- Digite **10** para ver a distribuição por tipo de mídia
- Digite **0** para sair do sistema

---

## 5. Solução de problemas comuns

### Problema 1: `javac não é reconhecido`

**Causa:** Java não está instalado ou o PATH não está configurado.

**Solução:**

* Instale o **JDK 21 ou superior**
* Reinicie o terminal após a instalação

---

### Problema 2: `Classe principal não encontrada`

**Verifique se:**

* Você está dentro da pasta `src/`
* O comando foi digitado corretamente:

  ```bash
  java Locadora
  ```
* O projeto foi compilado antes com:

  ```bash
  javac *.java
  ```

---

### Problema 3: Erros de compilação

Todos os **9 arquivos `.java`** devem estar na pasta `src/`:

* `Locadora.java`
* `Pessoa.java`
* `Cliente.java`
* `Funcionario.java`
* `Midia.java`
* `Filme.java`
* `Serie.java`
* `Emprestimo.java`
* `Relatorio.java`

---

### Problema 4: IDs não são sequenciais

**Comportamento esperado.**
O sistema utiliza **contadores estáticos** compartilhados entre `Cliente` e `Funcionario` para demonstrar corretamente o uso do modificador `static`.

Exemplo:

* Cliente 1 → ID 1
* Cliente 2 → ID 2
* Funcionário → ID 3
* Próximo cliente → ID 4

---

## 6. Observações importantes

* Os dados são armazenados **apenas na memória RAM** durante a execução
* Ao encerrar o programa, **todos os dados são perdidos**
* O sistema já inicia com **dados de exemplo**:

  * 2 clientes
  * 4 mídias
* A classe `Funcionario` existe para demonstrar **herança**, conforme exigido no trabalho

---

## 7. Conceitos de POO aplicados

* **Encapsulamento:** atributos protegidos com getters e setters
* **Herança:** `Cliente` e `Funcionario` herdam de `Pessoa`
* **Polimorfismo:** opção 9 demonstra comportamentos diferentes entre `Filme` e `Serie`
* **Associação:** `Emprestimo` associa `Cliente` e `Midia`
* **Abstração:** `Pessoa` e `Midia` são classes abstratas
* **Elementos estáticos:** IDs automáticos utilizando contadores `static`

---

📌 *Projeto desenvolvido para fins acadêmicos na disciplina de Programação Orientada a Objetos.*
