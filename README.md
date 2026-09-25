# Gauss-Seidel Iterativo - Solucionador de Sistemas Lineares

Um implementação simples em Java do método iterativo **Gauss-Seidel** para resolver sistemas de equações lineares não-lineares.

## Sobre o Método

O método de Gauss-Seidel é um algoritmo iterativo que resolve sistemas de equações da forma:

```
Ax = B
```

Onde:
- `A` é a matriz dos coeficientes (n x n)
- `B` é o vetor dos termos independentes (n x 1)
- `x` é o vetor solução desejado

### Como funciona?

1. Um chute inicial para `x` é fornecido (geralmente vetor nulo)
2. Para cada iteração, cada componente de `x` é recalculado usando:
   ```
   x_i = (b_i - Σ(a_ij * x_j)) / a_ii
   ```
   Onde os `x_j` usados são os **mais recentes** (diferença fundamental do método de Jacobi)
3. O processo repete até que a diferença entre iterações consecutivas seja menor que uma tolerância definida


## Como Testar

Ao executar, você verá uma saída similares a:

```
O Sistema Converge
-------------------
Iteração 1
X1 = 0.7
X2 = -1.6
X3 = 0.6
-------------------
Iteração 2
X1 = 0.34
X2 = -2.36
X3 = 0.22
-------------------
...
O sistema convergiu na iteração: N
```

### Alterando o sistema a ser resolvido

No arquivo `src/Main.java`, modifique as variáveis:

```java
// Matriz dos coeficientes A (n x n)
int[][] A = {
    {10, 2, 1},
    {1, 5, 1},
    {2, 3, 10}
};

// Vetor dos termos independentes B
int[] B = {7, -8, 6};

// Chute inicial (vetor com zeros é padrão)
double[] X = {0, 0, 0};

// Tolerância de convergência (padrão: 0.05)
double tolerancia = 0.05;

// Número máximo de iterações (padrão: 100)
int maxIteracao = 100;
```

**Dica:** Para sistemas de maior ordem, aumente `maxIteracao` se necessário, ou diminua a `tolerancia` para resultados mais precisos.

### Verificando a solução

Para validar a resposta, substitua os valores de `X` em:
```
A × X ≈ B
```

## Condições de Convergência

O método converge se a matriz A for **diagonalmente dominante**, ou seja, para cada linha `i`:

```
|a_ii| > Σ|a_ij|  para todo j ≠ i
```

O código verifica essa condição automaticamente na inicialização.
