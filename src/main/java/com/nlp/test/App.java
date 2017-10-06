package com.nlp.test;

import edu.stanford.nlp.simple.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
/**
 * Hello world!
 *
 */
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
