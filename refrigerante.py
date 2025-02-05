class TransdutorMoore:
    def __init__(self):
        self.estado = 0  # Estado inicial, representando 0 centavos

    def transicao(self, entrada):
        """Processa a entrada e retorna a saída."""
        self.estado += entrada  # Soma o valor da moeda ao estado atual
        saida = 0
        if self.estado >= 100:
            self.estado %= 100  # Mantém apenas o valor excedente abaixo de 1 real
            saida = 1  # Libera uma lata de refrigerante
        return saida

    def processar_sequencia(self, entradas):
        """Processa uma sequência de moedas e retorna a saída correspondente."""
        return [self.transicao(moeda) for moeda in entradas]

# Testes conforme a imagem fornecida
transdutor = TransdutorMoore()
entrada = [100, 2, 2, 2, 2, 10, 5, 5, 10, 5, 10, 2, 5, 2, 5, 2, 2, 2, 10]
saida = transdutor.processar_sequencia(entrada)

print("Entrada: ", entrada)
print("Saída:   ", saida)