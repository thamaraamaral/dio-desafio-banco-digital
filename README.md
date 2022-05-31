## Desafio Bootcamp GFT Start Woman Java

### Descrição do desafio
Reforce seu conhecimento em Programação Orientada a Objetos (POO) em Java com um desafio de projeto totalmente prático. Para isso, os pilares da orientação a objetos são devidamente explorados no contexto bancário, onde o expert implementa um projeto de referência (disponibilizado no GitHub) de forma prática e interativa. Sendo assim, você poderá desenvolver sua capacidade de abstração reproduzindo essa solução. Além disso, caso queira ir além, implemente suas próprias evoluções e melhorias ;-)

#### Meu objetivo
Criar uma aplicação Java que integre com o banco de dados MySQL utilizando o conector JDBC. A partir da aplicação Java teremos as operações de CRUD que serão alimentadas com os dados do cliente do banco.

##### Comentários sobre as etapas de desenvolvimento do projeto

Primeiro, criei os pacotes que utilizarei no projeto.
Depois, no MySql Workbench, iniciei o database do nosso "banco digital fictício" e a tabela referente aos Clientes que possui as colunas idcliente, nome, email e celular.

**Agora o desafio é fazer uma aplicação Java que consiga acessar esse banco de dados e cadastrar, consultar, editar e excluir clientes.**

Começarei criando e configurando a classe Javabean Cliente.

Em seguida, criando uma interface para definir as operações de banco de dados que serão feitas com a entidade Cliente:
create(cliente) - update(cliente) - delete - findAll(List<Clientes>) - findById(id)

Agora é necessário criar uma classe para implementar a interface e, assim, foi adicionada ao projeto a classe ClienteRepository que está localizada no pacote repositories.

Para fazer a conexão com o banco de dados MySQL, faremos a instalação das bibliotecas JDBC para MySQL. Para isso, acessamos o site MVN REPOSITORY.

Acrescentei o conector JDBC de forma manual, indo em Build Path e Configure Build Path. Nessa janela, devemos indicar o diretório que está o conector.

Nessa parte, criei a classe que ficará responsável por estabelecer qualquer conexão com o banco de dados, ConnectionFactory, que terá um método público getConnection(). É essa a classe que utiliza o conector que referenciamos o diretório em Build Path.

**Comentário**: Como essa classe está de acordo com o padrão SOLID, pois é uma classe SÓ PARA estabelecer uma conexão, facilitando qualquer tipo de conexão. Se um dia quisermos alterar a conexão do banco, passar de MySQL para ORACLE, por exemplo, iremos modificar apenas essa classe.

Na classe ClienteFactory, indicamos alguns parâmetros importantes referentes ao HOST, USER, PASSWORD informações necessárias para conectar com o banco de dados. E também, teremos o método DriveManager.getConnection estabelecer a conexão utilizando esses parâmetros.
Usamos criamos os métodos, e utilizamos o PreparedStatement para indicar os parâmetros que serão armazenados no banco de dados sql.

**DESAFIO: a parte de configurar a classe ClienteFactory se mostrou mais dificultosa porque precisamos programar cada método integrando com a linguagem SQL, tendo como referência a tabela já criada previamente.
Ao contrário do hibernate que se mostra mais fácil de configurar.
Inclusive tive um problema na digitação do SQL, erro na sintaxe do código, que gerava um erro em tempo de execução que não permitia conectar com o banco de dados.**

Após a configuração da classe ClienteFactory, criaremos a classe ClienteHelper para nos auxiliar na leitura dos dados de cliente.
Faremos a leitura dos dados do cliente utilizando o componente JOptionPane que exibe uma janela. 

Acrescentamos, em seguida,  a classe ClienteController que está dentro do pacote controller. Essa classe ficará encarregada de controlar as operações de fluxo de entrada e saída de dados do usuário com a entidade Cliente. Nessa classe também configuramos os tratamentos de exceções.

No final, configuramos a classe Program que executará a aplicação.
Nela, apresentaremos algumas opções de serviços para o usuário escolher, esses são os métodos que criamos (cadastrar, atualizar, consultar, deletar). 

Após a seleção do serviço desejado, a operação é realizada ou não e uma mensagem é exibida na tela de acordo com o resultado.

#### Próximas etapas
Criar um relacionamento entre cliente do banco e tipo de conta de forma a conseguir realizar operações como depósito, transferência e saque. 
