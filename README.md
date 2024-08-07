## Autores
* Augusto G. Serrano
* Caio S. Lopes

## Projeto Aeroporto

Este repositório contém um projeto em Java que simula o controle de um aeroporto. A implementação atual permite a inclusão de voos e também a atualização dos voos que estão no aeroporto. 

Utiliza-se os padrões de projeto:

- State;
- Observer;
- Singleton.

## Totens

Neste projeto foi adicionado uma _feature_ visando a utilização de ***Totens*** em Aeroportos.
Desta forma, a classe é filha de um observer, para que assim todas as alterações de voo que chamem o método Update irão atualizar os dados
que estão sendo exibidos. <br>
A implementação do Totem foi feita visando sua expansão, sendo assim para criar um totem você pode adicionar N estados para serem exibidos que funcionará de forma coesa.
