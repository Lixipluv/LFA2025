def dfa_a(cadeia):
    """Verifica se a cadeia é aceita pelo DFA."""
    estado = 0
    transicoes = {
        (0, '0'): 0, (0, '1'): 1,
        (1, '0'): 2, (2, '0'): 0
    }

    for simbolo in cadeia:
        estado = transicoes.get((estado, simbolo))
        if estado is None:
            return False

    return estado == 0

def desenhar_afd():
    """Exibe o AFD de forma textual."""
    print("Estados: q0 (inicial, final), q1, q2")
    print("Transições:")
    print(" q0 --1--> q1\n q0 --0--> q0\n q1 --0--> q2\n q2 --0--> q0")
    print("Estado final: q0 (aceitação)")

def testar_cadeias(cadeias, esperado):
    """Testa cadeias e exibe os resultados."""
    for cadeia in cadeias:
        resultado = "Aceita" if dfa_a(cadeia) else "Rejeitada"
        correto = "✔" if resultado == ("Aceita" if esperado else "Rejeitada") else "✘"
        print(f"Cadeia '{cadeia}': {resultado} {correto}")

# Executando
desenhar_afd()
print("\nTestando cadeias aceitas:")
testar_cadeias(["0", "0100", "100"], True)
print("\nTestando cadeias rejeitadas:")
testar_cadeias(["1", "1001", "010", "0001"], False)
