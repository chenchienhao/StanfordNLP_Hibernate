## Prueba simple de Stanford NLP
Se Realiza la prueba de Stanford NLP en Java con la siguiente frase:
> Pedro entregó a Juan las rosas y luego barrió el piso

<br>

### Crear un Proyecto Maven
```
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.nlp.test -DartifactId=nlp-test
```

<br>

### Agregar Dependencias en POM.xml:
```
<properties>  
    <corenlp.version>3.8.0</corenlp.version>  
</properties>

<dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
    <dependency>  
        <groupId>edu.stanford.nlp</groupId>  
        <artifactId>stanford-corenlp</artifactId>  
        <version>${corenlp.version}</version>  
    </dependency>  
    <dependency>
        <groupId>edu.stanford.nlp</groupId>
        <artifactId>stanford-parser</artifactId>
        <version>${corenlp.version}</version>  
    </dependency>
    <dependency>  
        <groupId>edu.stanford.nlp</groupId>  
        <artifactId>stanford-corenlp</artifactId>  
        <version>${corenlp.version}</version>  
        <classifier>models</classifier>  
    </dependency>  
    <dependency>  
        <groupId>edu.stanford.nlp</groupId>  
        <artifactId>stanford-corenlp</artifactId>  
        <version>${corenlp.version}</version>  
        <classifier>models-english</classifier>  
    </dependency>  
    <dependency>  
        <groupId>edu.stanford.nlp</groupId>  
        <artifactId>stanford-corenlp</artifactId>  
        <version>${corenlp.version}</version>  
        <classifier>models-chinese</classifier>  
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>1.7.25</version>
    </dependency>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-jdk14</artifactId>
        <version>1.7.25</version>
    </dependency>
</dependencies>
```

<br>

### El Código en /src/main/java/com/nlp/test/App.java
```
package com.nlp.test;

import edu.stanford.nlp.simple.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
public class App 
{
    public static void main( String[] args )
    {
        String serializedClassifier = "edu/stanford/nlp/models/ner/spanish.ancora.distsim.s512.crf.ser.gz";
        AbstractSequenceClassifier classifier = CRFClassifier.getClassifierNoExceptions(serializedClassifier);

        String s1 = "Pedro entregó a Juan las rosas y luego barrió el piso a las nueve de la mañana";
        System.out.println(classifier.classifyToString(s1));
    }
}
```

<br>

### Crear nueva carpeta "resources" en nuestro proyecto Maven

> /src/main/resources

<br>

### Descargar Módulo Jar de versión Español
[Descargar.](http://nlp.stanford.edu/software/stanford-spanish-corenlp-2017-06-09-models.jar)

más información en: https://stanfordnlp.github.io/CoreNLP/index.html#download

<br>

### Unzip JAR
```
jar xf stanford-spanish-corenlp-2017-06-09-models.jar
```

<br>

### Trasladar a la carpeta "edu" al dentro de "resources"

> /src/main/resources/edu/.... 


<br>

### Ejecutar
```
mvn compile
mvn package
mvn install
mvn exec:java -Dexec.mainClass="com.nlp.test.App"
java -cp target/nlp-test-1.0-SNAPSHOT.jar com.nlp.test.App
```

<br>

### Resultado Esperado
```
Pedro/PERS entregó/O a/O Juan/PERS las/O rosas/O y/O luego/O barrió/O el/O piso/O a/O las/O nueve/O de/O la/O mañana/O
```

OK! ;)
