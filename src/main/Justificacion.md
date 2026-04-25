# 📝 Justificación del ejercicio — Cafetería instituto

## 🔹 Recurso compartido

El recurso compartido en el programa es el **depósito de cafés**, ya que es accedido tanto por la cafetera (productor) como por los profesores (consumidores).

Este recurso puede provocar problemas de concurrencia, ya que varios hilos pueden intentar acceder a él simultáneamente, lo que podría generar inconsistencias en el número de cafés almacenados.

---

## 🔹 Clase que actúa como monitor

La clase `Deposito` actúa como monitor.

Esto se debe a que:

- Sus métodos (`depositar` y `retirar`) están declarados como `synchronized`
- Controla el acceso exclusivo al recurso compartido
- Gestiona las condiciones de espera de los hilos

Gracias al uso de `synchronized`, solo un hilo puede ejecutar estos métodos al mismo tiempo, evitando condiciones de carrera.

---

## 🔹 Uso de `wait()` y `notifyAll()`

Se utilizan para coordinar la ejecución de los hilos:

### ✔ `wait()`

Se utiliza en dos situaciones:

- Cuando la cafetera intenta depositar café y el depósito está lleno
- Cuando un profesor intenta retirar café y el depósito está vacío

En ambos casos, el hilo se bloquea y libera el monitor hasta que la condición cambie.

---

### ✔ `notifyAll()`

Se utiliza después de modificar el estado del depósito:

- Cuando la cafetera añade un café
- Cuando un profesor retira un café

Su función es despertar a todos los hilos que están esperando para que vuelvan a comprobar si pueden continuar.

---

## 🔹 Uso de `while` en lugar de `if`

Se utiliza `while` para comprobar las condiciones de espera en lugar de `if` porque:

- Un hilo puede despertarse sin que la condición haya cambiado (despertar espurio)
- Puede haber varios hilos compitiendo por el recurso

Por ello, es necesario volver a comprobar la condición antes de continuar la ejecución, garantizando así un comportamiento correcto.

---

## 🔹 Necesidad de la sincronización

La sincronización es necesaria para:

- Evitar condiciones de carrera
- Garantizar la consistencia del número de cafés en el depósito
- Coordinar correctamente la ejecución de productores y consumidores
- Evitar accesos simultáneos incorrectos al recurso compartido

Sin estos mecanismos, podrían producirse errores como:

- Consumir cafés inexistentes
- Superar la capacidad máxima del depósito
- Obtener resultados inconsistentes

---
