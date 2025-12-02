import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe responsável por controlar os CPFs
public class CPF {
    // Atributo privado que guarda a lista de CPFs
    private List<String> fila;

    // Construtor que inicializa a lista
    public CPF() {
        this.fila = new ArrayList<>();
    }

    // Método para inserir CPF na fila
    public void inserirCPF(String cpf) {
        // Verifica se o CPF já existe
        if (fila.contains(cpf)) {
            System.out.println("CPF já cadastrado!");
        } else {
            fila.add(cpf); // Adiciona CPF à lista
            System.out.println("CPF inserido com sucesso!");
        }
    }

    // Método para listar CPFs (com senha)
    public void listarCPF(String senha) {
        if (senha.equals("redes2025")) {
            if (fila.isEmpty()) {
                System.out.println("Fila vazia!");
            } else {
                System.out.println("CPFs na fila:");
                for (String cpf : fila) {
                    System.out.println(cpf);
                }
            }
        } else {
            System.out.println("Senha incorreta!");
        }
    }

    // Método para remover CPF da fila
    public void removerCPF(String cpf) {
        if (fila.contains(cpf)) {
            fila.remove(cpf);
            System.out.println("CPF removido com sucesso!");
        } else {
            System.out.println("CPF não encontrado na fila!");
        }
    }

    // Getter para acessar a lista
    public List<String> getFila() {
        return fila;
    }

    // Setter
    public void setFila(List<String> fila) {
        this.fila = fila;
    }

    // Método principal com menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CPF cpfManager = new CPF();
        int opcao;

        // Menu interativo usando switch
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Inserir um CPF na fila");
            System.out.println("2 - Listar os CPFs da fila");
            System.out.println("3 - Remover um CPF da fila");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o CPF (apenas números): ");
                    String cpfInserir = sc.nextLine();
                    // Valida se contém apenas números
                    if (cpfInserir.matches("\\d+")) {
                        cpfManager.inserirCPF(cpfInserir);
                    } else {
                        System.out.println("CPF inválido! Digite apenas números.");
                    }
                    break;

                case 2:
                    System.out.print("Digite a senha: ");
                    String senha = sc.nextLine();
                    cpfManager.listarCPF(senha);
                    break;

                case 3:
                    System.out.print("Digite o CPF para remover: ");
                    String cpfRemover = sc.nextLine();
                    cpfManager.removerCPF(cpfRemover);
                    break;

                case 4:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        sc.close();
    }
}
