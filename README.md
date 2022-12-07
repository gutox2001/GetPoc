**Professor responsável:** 

  - Fabrício Aguiar Silva
    
**Alunos responsáveis:**

  - Thiago Cândido Rocha - 4225 
  - Aroldo Augusto Barbosa Simões - 4250
  - Gabriel Ryan dos Santos Oliveira - 4688
  - João Vitor Chagas Lobo - 4693

**Arquivo:**

  - Descrição do arquivo: Arquivo contendo as instrunções para execução do programa;
  - Ultima atualização: 01/11/2022 - 15:30 - Por: João Lobo.

**Descrição do sistema:**

  - O GetPoc será um sistema gerenciador de Projetos Orientado em Computação (POCs)
  - Algumas das funcionalidades a serem implementadas são:
      - Cadastro de usuário;
      - Cadastro de POC;
      - Pesquisa de POC.

**Execução do sistema:**

  - Para simplificar o primeiro acesso de um usuário, foi criado o usuário "Administrador Padrao", com Matricula: "0001" e senha "12345", após o acesso utilizando este usúário e configuração de pelo menos outro administrador, ele deverá ser deletado.
  - A execução experimental da aplicação se dá atravéz do arqiuvo GetPoc.jar contido na pasta GetPoc-Equipe 2, que contém também os arquivos .csv com os dados que devem ser previamente carregados e que podem ser editados. Para isto, execute a seguinte linha de comando em um terminal dentro da pasta "GetPoc-Equipe2": 
    
    - java -jar GetPoc.jar 

**Documentação:**

  - Os arquivos em html da JavaDoc do projeto estão armazenados na pasta "doc" e devem ser acessados para exibir a documentação da aplicação;

**Escolhas do grupo:**

  - A princípio não definimos uma IDE específica para utilizarmos no projeto, dentre os membros utilizamos algumas como o Visual Studio CODE e o IntelliJ;
  - Os membros não possuem conhecimento prévio na linguagem especificada(JAVA), portanto a disciplina de POO ajudará imensamente na construção de conhecimento sobre a linguagem e sobre programação prientada a objetos;
  - Iniciaremos a construção do código em conjunto, partindo de encontros em reuniões presenciais e online via Google Meet.
    
**Motivação pela escolha da ArrayList como estrutura de dados principal:**

  - A ArrayList em Java é uma estrutura de dados dinâmica que possui ótimas características para operações de inserção e busca, uma vez que a ordem de complexidade para ambas é O(1). No caso das operações de busca, por exemplo, bastaria associar uma chave ID, inteira e incremental, a cada POC e buscar na ArrayList o POC na exata posição do seu ID.
  - Além das vantagens descritar acima, uma ArrayList possui um código muito mais intuitivo e de fácil compreensão até mesmo para programadores iniciantes em Java, bem como resulta em um programa mais limpo.
  - Por fim, devido ao fato do programa não possuir a necessidade de ser Thread-Safe, isto é, a versão atual do GetPoc apenas possui uma única thread em execução (main), o uso de uma ArrayList para as operações anteriormente descritas é justificável. No entanto, observa-se que no caso do projeto passar a usufruir dos benefícios da programação concorrente, será interessante substituir a ArrayList por estruturas como Vector, que são Thread-Safe. 
    
**O emprego do modelo MVC no projeto:**

  - A utilização do MVC no código foi de suma importância para uma melhor organização das funcionalidades de cada pacote bem como das suas respectivas classes. Além disso, facilitou o controle de versões do GitHub uma vez que conflitos podem ser tratados localmente nos pacotes, salvo em ocasiões especiais.
  - O modelo utilizado permitiu unir as funcionalidades da Visão com o Controle e providenciará uma fácil manutenção do código caso o Controle seja subdividido em dois com funcionalidades para objetos específicos.
  - O MVC também tornou possível integrar o Controle com o Modelo juntamente com o Armazenamento, pacote no qual as listas de objetos estão localizadas.
  - Com a abordagem adotada, será possível integrar o projeto com um banco de dados relacional uma vez que a estruturação do código permite adicionar funcionalidades de persistência de dados sem afetar diretamente as demais classes.
=======

Professor responsável: 

  - Fabrício Aguiar Silva
    
Alunos responsáveis:

  - Thiago Cândido Rocha - 4225 
  - Aroldo Augusto Barbosa Simões - 4250
  - Gabriel Ryan dos Santos Oliveira - 4688
  - João Vitor Chagas Lobo - 4693

Arquivo:

    - Descrição do arquivo: Arquivo contendo as instrunções para execução do programa;
    - Ultima atualização: 01/11/2022 - 15:30 - Por: João Lobo.

Descrição do sistema:

    - O GetPoc será um sistema gerenciador de Projetos Orientado em Computação (POCs)
    - Algumas das funcionalidades a serem implementadas são:
        - Cadastro de usuário;
        - Cadastro de POC;
        - Pesquisa de POC.

Escolhas do grupo:

    - A princípio não definimos uma IDE específica para utilizarmos no projeto, dentre os membros utilizamos algumas como o Visual Studio CODE e o IntelliJ;
    - Os membros não possuem conhecimento prévio na linguagem especificada(JAVA), portanto a disciplina de POO ajudará imensamente na construção de conhecimento sobre a linguagem e sobre programação prientada a objetos;
    - Iniciaremos a construção do código em conjunto, partindo de encontros em reuniões presenciais e online via Google Meet.
