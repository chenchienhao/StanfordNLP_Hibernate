## Prueba simple de Stanford NLP
Se Realiza la prueba de Stanford NLP en Java con la siguiente frase:
> Pedro entregó a Juan las rosas y luego barrió el piso a las nueve de la mañana.

<br>

### Crear un Proyecto Maven
```
mvn -B archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DgroupId=com.nlp.test -DartifactId=nlp-test
```

<br>

### Agregar Dependencias en POM.xml:
```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.nlp.test</groupId>
  <artifactId>nlp-test</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>nlp-test</name>
  <url>http://maven.apache.org</url>
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
        <artifactId>stanford-corenlp</artifactId>  
        <version>${corenlp.version}</version>  
        <classifier>models</classifier>
    </dependency>
    <dependency>  
        <groupId>edu.stanford.nlp</groupId>  
        <artifactId>stanford-corenlp</artifactId>  
        <version>${corenlp.version}</version>  
        <classifier>models-spanish</classifier>
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
  <build>
    <plugins>
      <!-- any other plugins -->
      <plugin>
        <artifactId>maven-assembly-plugin</artifactId>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>single</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
          </descriptorRefs>
          <appendAssemblyId>false</appendAssemblyId>
        </configuration>
      </plugin>
    </plugins>
  </build>
</project>

```

<br>

### El Código en /src/main/java/com/nlp/test/App.java
```
package com.nlp.test;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;

import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        App example = new App();

        example.runSpanishAnnotators();
    }
     public void runSpanishAnnotators()
     {
        String text = "Pedro entregó a Juan las rosas y luego barrió el piso a las nueve de la mañana.";
        Annotation document = new Annotation(text);
        StanfordCoreNLP corenlp = new StanfordCoreNLP("StanfordCoreNLP-spanish.properties");
        corenlp.annotate(document);
        parserOutput(document);
    }

    public void parserOutput(Annotation document){
        // these are all the sentences in this document
        // a CoreMap is essentially a Map that uses class objects as keys and has values with custom types
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);

        for(CoreMap sentence: sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                // this is the text of the token
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                // this is the NER label of the token
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);

                System.out.print(word+"/"+ne+" ");
            }
        }
    }
}

```

<br>

### Ejecutar
```
mvn clean compile assembly:single
mvn exec:java -Dexec.mainClass="com.nlp.test.App"
java -cp target/nlp-test-1.0-SNAPSHOT.jar com.nlp.test.App
```

<br>

### Resultado Esperado
```
Pedro/PERS entregó/O a/O Juan/PERS las/O rosas/O y/O luego/O barrió/O el/O piso/O a/O las/O nueve/O de/O la/O mañana/O ./O
```

OK! ;)
