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
