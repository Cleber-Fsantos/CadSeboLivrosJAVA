import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Livro metodosLivro = new Livro();
        ArrayList<Livro> listaLivro = new ArrayList<>();

        System.out.println("Bem vindo ao sistema de Cadastro e Listagem de Livros em Sebo\n");

        Scanner scanner = new Scanner(System.in);
        Scanner scannerNum = new Scanner(System.in);

        int opcao;

        do{
            System.out.println("Digite uma opção: \n1 - Cadastrar Livro \n2 - Listagem de livro(s)  \n0 Sair\n");
            opcao = scannerNum.nextInt();

            switch (opcao){
                case 1:
                    Livro novoLivro = new Livro();
                    Autor novoAutor = new Autor();

                    System.out.println("Digite o Título do Livro: ");
                    novoLivro.titulo = scanner.nextLine();

                    System.out.println("Digite o Nome do Autor: ");
                    novoAutor.nome = scanner.nextLine();

                    System.out.println("Digite o Local de Nascimento: ");
                    novoAutor.localNasc = scanner.nextLine();

                    System.out.println("Digite o Preço do Livro: ");
                    novoLivro.preco = scannerNum.nextDouble();

                    System.out.println("Digite o ano de lançamento no formato => (dd/MM/yyyy): ");
                    LocalDate date = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    if(metodosLivro.verificarTempoLanc(date) >= 5){
                        System.out.println("O livro tem mais de 5 anos de lançamento\n\nParabéns Livro cadastrado com Sucesso!!!\n"
);
                    }else {
                        System.out.println("Lamentamos, mas o livro não tem mais de 5 anos de \n");
                        break;
                    }

                    novoLivro.dataLancamento = date;
                    novoLivro.autor = novoAutor;
                    listaLivro.add(novoLivro);

                    break;
                case 2:
                    char pause;
                    if (listaLivro.size() > 0) {

                        System.out.println("\n|######################################################|");
                        System.out.println("\n|                Lista de Livros                       |");
                        System.out.println("\n|######################################################|\n");
                        int contadorLivro =1;
                        for (Livro cadaLivro : listaLivro) {

                            System.out.printf("\nLivro %2d \n", contadorLivro);
                            System.out.println("Titulo: " + cadaLivro.titulo);
                            System.out.println("Autor: " + cadaLivro.autor.nome);
                            System.out.println("Local Nasc: " + cadaLivro.autor.localNasc);
                            System.out.printf("Preço: R$ %.2f\n", cadaLivro.preco);
                            System.out.println("Data de Lançamento: " + cadaLivro.dataLancamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                            contadorLivro++;
                        }
                        System.out.println("\n\nTecle ENTER  para Continuar... ");
                        pause = (char)System.in.read();
                    } else {
                        System.out.println("\n\nLista está vazia, Tecle ENTER para Continuar... ");
                        pause = (char)System.in.read();
                    }

                    break;
                case 0:
                    System.out.println("Obrigado por utilizar nosso sistema ;)");
                    break;
                default:
                    System.out.println("A opção: " + opcao + " é Invalida - Selecione uma opção correta");
                    break;
            }
        }while (opcao != 0);
    }
}