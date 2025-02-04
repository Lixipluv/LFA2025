def dfa_b(cadeia):
    """Verifica se a cadeia pertence à linguagem {a,b}* onde o último símbolo é 'b' e o número de 'a' é par."""
    estado = 0
    transicoes = {
        (0, 'a'): 1, (0, 'b'): 0,
        (1, 'a'): 0, (1, 'b'): 1
    }
    
    for simbolo in cadeia:
        estado = transicoes.get((estado, simbolo))
        if estado is None:
            return False
    
    return estado == 0

def desenhar_afd_b():
    """Exibe o AFD de forma textual."""
    print("Estados: q0 (inicial, final), q1")
    print("Transições:")
    print(" q0 --a--> q1\n q0 --b--> q0\n q1 --a--> q0\n q1 --b--> q1")
    print("Estado final: q0 (aceitação)")

def testar_cadeias_b(cadeias, esperado):
    """Testa cadeias e exibe os resultados."""
    for cadeia in cadeias:
        resultado = "Aceita" if dfa_b(cadeia) else "Rejeitada"
        correto = "✔" if resultado == ("Aceita" if esperado else "Rejeitada") else "✘"
        print(f"Cadeia '{cadeia}': {resultado} {correto}")

# Executando
desenhar_afd_b()
print("\nTestando cadeias aceitas:")
testar_cadeias_b(["b", "aab", "abab", "bbb"], True)
print("\nTestando cadeias rejeitadas:")
testar_cadeias_b(["a", "aa", "ba", "abb", "baa"], False)

