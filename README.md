# Proyecto-Scrabble
Tarea 1 - Proyecto semestral de Metodologías de Diseño y Programación

Para probar el funcionamiento del proyecto, se puede correr src/test/ScrabbleTest.java que contiene todas las transformaciones y operadores que puedan hacerse dentro de los tipos definidos de Scrabble (src/types/*) 

De forma general, el proyecto almacena en clases de distinto nombre (ScrabbleString, ScrabbleBool, ScrabbleFloat, ScrabbleInt, ScrabbleBinary) distintos tipos de valores primitivos de Java, los cuales, respectivamente, corresponden a String, boolean, double, int, String.
Estas clases pueden transformarse entre ellas con algunas limitaciones, y operar entre ellas de la misma manera.

// test : En caso de querer probar con distintos nombres y valores que puedan afectar el funcionamiento "normal" de todas las operaciones, se puede acceder al mismo archivo 'ScrabbleTest.java' en el cual se encuentran todos los test hechos.

// test : Estos se separan en constructorTest(), y de forma general, todas las operaciones de la forma Type.to_Type(), Type.add(), Type.subtract(), Type.multiply(), Type.divide(), Type.and(), Type.or(), Type.neg() . 

// construcción de binarios : Su construcción y entendimiento como números enteros positivos o negativos dependen exclusivamente del bit más significativo
// construcción de binarios : si el bit más significativo es 0, entonces el número se lee como un positivo, y sino, es un negativo
// ejemplo : "0101" es int 5, mientras que "101", si bien se entiende normalmente como int 5, para nuestros métodos será int -3 
// entonces, si se tiene un 0 de bit más significativo, se leerá normalmente, mientras que si hay un 1, se leerá como complemento a dos de un número
