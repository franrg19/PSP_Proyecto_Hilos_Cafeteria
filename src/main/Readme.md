# ☕ Cafetería Automática Multihilo (Java)

## 📌 Descripción

Este proyecto simula el funcionamiento de una cafetería automática en un instituto, donde múltiples profesores consumen cafés generados por una cafetera.

El sistema implementa el clásico problema de **productor-consumidor** utilizando **monitores en Java**, garantizando una correcta sincronización entre hilos.

---

## 🎯 Objetivos

- Practicar programación multihilo en Java
- Gestionar el acceso concurrente a un recurso compartido
- Implementar monitores con `synchronized`
- Utilizar `wait()` y `notifyAll()`
- Controlar condiciones de espera (depósito lleno/vacío)

---

## 🧠 Funcionamiento del sistema

El sistema está compuesto por:

- ☕ **Cafetera (Productor)**  
  Genera cafés y los deposita en el depósito.

- 👨‍🏫 **Profesores (Consumidores)**  
  Retiran cafés del depósito para consumirlos.

- 📦 **Depósito (Monitor)**  
  Recurso compartido que almacena los cafés y controla el acceso concurrente.

---

## ⚙️ Reglas del sistema

- El depósito tiene una **capacidad máxima limitada**
- La cafetera **no puede depositar cafés si está lleno**
- Los profesores **no pueden retirar cafés si está vacío**
- Los hilos se coordinan mediante:
    - `synchronized`
    - `wait()`
    - `notifyAll()`

---

---

## 🔐 Sincronización

La clase `Deposito` actúa como monitor:

- Métodos sincronizados (`synchronized`)
- Uso de `wait()`:
    - Cuando el depósito está lleno (cafetera espera)
    - Cuando está vacío (profesores esperan)
- Uso de `notifyAll()`:
    - Para despertar hilos cuando cambia el estado

Se utiliza `while` en lugar de `if` para evitar problemas de concurrencia y asegurar que las condiciones se vuelven a comprobar tras despertar.

---
## 💁 Autor
Fran Rebollo
2º DAM - Programación de Servicios y Procesos
