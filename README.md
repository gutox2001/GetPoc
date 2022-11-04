# Universidade Federal De Viçosa - Campus Florestal
# Ciência da Computação
# Trabalho prático 1 (GetPoc) - Disciplina CCF 313 - PROGRAMAÇÃO ORIENTADA A OBJETOS

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
    
Motivação pela escolha da ArrayList como estrutura de dados principal:

  - A ArrayList em Java é uma estrutura de dados dinâmica que possui boas características em operações de inserção e busca, uma vez que a ordem de complexidade para ambas é O(1). No caso das operações de busca, por exemplo, bastaria associar uma chave ID, inteira, a cada POC e buscar na ArrayList o POC na exata posição em questão.
  - Além das vantagens descritar acima, uma ArrayList possui um código muito mais intuitivo e de fácil compreensão até mesmo para programadores iniciantes em Java, bem como resulta em um programa mais limpo.
  - Por fim, devido ao fato do programa não possuir a necessidade de ser Thread-Safe, isto é, a versão atual do GetPoc apenas possui uma única thread em execução (main), o uso de uma ArrayList para as operações anteriormente descritas é justificável. No entanto, observa-se que no caso do projeto passar a usufruir dos benefícios da programação concorrente, será interessante substituir a ArrayList por estruturas como Vector, que são Thread-Safe. 
    
