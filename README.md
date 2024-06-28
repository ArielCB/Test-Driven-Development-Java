# Bowling - Práctica de TDD

Nombre de los alumnos: Ariel Carnés Blasco

### Setup de los tests

Creamos el objeto bowling para no tener que hacerlo en cada test.

```java
Bowling bowling;
	
@BeforeEach
void setup() {
	bowling = new Bowling();
}
```

### EJEMPLO 1

No se pueden derribar menos de 0 bolos en una tirada.

**EJ1. Código de test**
```java
@Test
void testPins0() {
	IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, ()->bowling.throwing(-1));
	assertEquals("Number must be greater than zero", ex.getMessage());
}
```

**EJ1. Mensaje del test añadido que NO PASA**

```log
org.opentest4j.AssertionFailedError: Expected java.lang.IllegalArgumentException to be thrown, but nothing was thrown.
```

**EJ1. Código mínimo para que el test pase**

Describe brevemente el código mínimo implementado

```java
public void throwing(int pins) {
	throw new IllegalArgumentException("Number must be greater than zero");
}
```

**EJ1. Captura de que TODOS los test PASAN**

![Pasa](capturas/Ejemplo_1_PASA.png "Pasa")

**EJ1. Refactorización**
> [BORRAR]  Solo si se considera necesario

Justificar vuestra refactorización aquí.

```java
public String convert(int number){
    return "I"; // Imaginemos que hemos refactorizado aquí
}
```
**EJ1. Captura de que TODOS los tests PASAN tras la refactorización**
> [BORRAR]  Solo si se ha realizado una refactorización

![Pasa](capturas/Ejemplo_1_PASA.png "Pasa")
