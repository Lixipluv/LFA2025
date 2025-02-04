def encontrar_ocorrencias(texto, palavra):
    """Encontra todas as ocorrências exatas de uma palavra no texto."""
    posicoes = []
    tamanho = len(palavra)
    
    for i in range(len(texto) - tamanho + 1):
        if texto[i:i + tamanho] == palavra:
            posicoes.append(i)
    
    return posicoes

def destacar_ocorrencias(texto, palavra, posicoes):
    """Retorna o texto com a palavra destacada visualmente."""
    texto_destacado = ""
    i = 0
    while i < len(texto):
        if i in posicoes:
            texto_destacado += f"[{palavra}]"
            i += len(palavra)
        else:
            texto_destacado += texto[i]
            i += 1
    return texto_destacado

def reconhecer_palavra(texto, palavra):
    """Executa o reconhecimento da palavra no texto e exibe os resultados."""
    posicoes = encontrar_ocorrencias(texto, palavra)
    if posicoes:
        print(f"A palavra '{palavra}' foi encontrada nas posições: {posicoes}\n")
        print("Texto com ocorrências destacadas:")
        print(destacar_ocorrencias(texto, palavra, posicoes))
    else:
        print(f"A palavra '{palavra}' não foi encontrada no texto.")

# Testando reconhecimento da palavra "computador"
texto = (
    "O computador é uma máquina capaz de variados tipos de tratamento automático de informações ou processamento de dados. "
    "Entende-se por computador um sistema físico que realiza algum tipo de computação. "
    "Assumiu-se que os computadores pessoais e laptops são ícones da era da informação. "
    "O primeiro computador eletromecânico foi construído por Konrad Zuse (1910–1995). "
    "Atualmente, um microcomputador é também chamado computador pessoal ou ainda computador doméstico."
)

palavra = "computador"
reconhecer_palavra(texto, palavra)