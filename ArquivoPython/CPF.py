# Classe responsável por controlar os CPFs
class CPF:
    def __init__(self):
        # Inicializa a lista de CPFs como atributo privado
        self.__fila = []

    # Método para inserir CPF na fila
    def inserirCPF(self, cpf):
        if cpf in self.__fila:
            print("CPF já cadastrado!")
        else:
            self.__fila.append(cpf)
            print("CPF inserido com sucesso!")

    # Método para listar CPFs (com senha)
    def listarCPF(self, senha):
        if senha == "redes2025":
            if len(self.__fila) == 0:
                print("Fila vazia!")
            else:
                print("CPFs na fila:")
                for cpf in self.__fila:
                    print(cpf)
        else:
            print("Senha incorreta!")

    # Método para remover CPF da fila
    def removerCPF(self, cpf):
        if cpf in self.__fila:
            self.__fila.remove(cpf)
            print("CPF removido com sucesso!")
        else:
            print("CPF não encontrado na fila!")

    # Getter para acessar a lista
    def getFila(self):
        return self.__fila


# Função principal com menu interativo usando match-case
def main():
    cpfManager = CPF()

    while True:
        print("\n--- MENU ---")
        print("1 - Inserir um CPF na fila")
        print("2 - Listar os CPFs da fila")
        print("3 - Remover um CPF da fila")
        print("4 - Sair")

        try:
            opcao = int(input("Escolha uma opção: "))
        except ValueError:
            print("Opção inválida! Digite um número.")
            continue

        match opcao:
            case 1:
                cpfInserir = input("Digite o CPF (apenas números): ")
                # Valida se contém apenas números
                if cpfInserir.isdigit():
                    cpfManager.inserirCPF(cpfInserir)
                else:
                    print("CPF inválido! Digite apenas números.")

            case 2:
                senha = input("Digite a senha: ")
                cpfManager.listarCPF(senha)

            case 3:
                cpfRemover = input("Digite o CPF para remover: ")
                cpfManager.removerCPF(cpfRemover)

            case 4:
                print("Programa encerrado.")
                break

            case _:
                print("Opção inválida!")


# Executa o programa
if __name__ == "__main__":
    main()
