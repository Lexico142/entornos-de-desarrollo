# Ejercicios de Control de Errores con Try/Catch

Aquí hay dos programas sencillos para practicar cómo evitar que el programa "explote" cuando el usuario se equivoca.

## 1. Calculadora
Pide dos números y te deja sumar, restar, multiplicar o dividir.
* **Controla que:**
    * Si escribes letras en vez de números, te avisa y no falla.
    * Si intentas dividir por cero (ej: 5/0), te avisa de que eso no se puede hacer.

## 2. Banco (Cajero)
Es un bucle que simula un cajero con saldo inicial de 1000€.
* **Controla que:**
    * Que no escribas letras en el menú o en el dinero.
    * Que no puedas ingresar ni retirar números negativos.
    * Que no puedas sacar más dinero del que tienes en la cuenta.