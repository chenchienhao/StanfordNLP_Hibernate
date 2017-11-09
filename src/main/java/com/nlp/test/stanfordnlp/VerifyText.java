package com.nlp.test.stanfordnlp;

import java.util.*;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import com.nlp.test.entity.CountPOSTag;

public class VerifyText
{
    public VerifyText () {

    }
    public static List<String> runSpanishAnnotators(String input)
     {
        String text = input;
        Annotation document = new Annotation(text);
        Properties props = new Properties();
        props.put("annotators", "tokenize, ssplit, pos, lemma, ner");
        props.setProperty("tokenize.language", "es");
        props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/spanish/spanish-distsim.tagger");
        props.setProperty("ner.model", "edu/stanford/nlp/models/ner/spanish.ancora.distsim.s512.crf.ser.gz");
        props.setProperty("ner.useSUTime", "0");
        StanfordCoreNLP corenlp = new StanfordCoreNLP(props,true);

        corenlp.annotate(document);
        //text=parserOutput(document);
        return parserOutput(document);
    }
    public static List<String> parserOutput(Annotation document){
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        List<String> ListPOSTag = new ArrayList<String>();
        String text="";
        for(CoreMap sentence: sentences) {
            for (CoreLabel token: sentence.get(CoreAnnotations.TokensAnnotation.class)) {
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                String pos = token.get(CoreAnnotations.PartOfSpeechAnnotation.class);
                String ne = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                ListPOSTag.add(pos);
                //System.out.print(word+"/"+ne+" ");
                text+=(word+"/"+ne+"("+pos+")"+" ");
            }
        }
        return ListPOSTag;
    }

    public static CountPOSTag CountPOSTagProcess(String input, long ticket_id, long comment_id){
        List<String> ListPOSTag = runSpanishAnnotators(input);
        System.out.print("Empezamos");
        System.out.print(input);
        System.out.print("fin");
        //String POSTag;
        long[] Adjectives = new long[2];
        long[] Conjunctions = new long[2];
        long[] Determiners = new long[8];
        long[] Punctuation = new long[21];
        long Interjections = 0;
        long[] Nouns = new long[5];
        long[] Pronouns = new long[9];
        long[] Adverbs = new long[2];
        long Prepositions = 0;
        long[] Verbs = new long[35];
        long Dates = 0;
        long[] Numerals = new long[3];
        long Other = 0;

        CountPOSTag countPOSTag = new CountPOSTag();

        //while (input.length()>0) {
        for(String POSTag:ListPOSTag){
            //POSTag=input.substring(input.indexOf("(")+1,input.indexOf(")"));
            if(POSTag.equals("ao0000"))
                Adjectives[0]++;
                    
            if(POSTag.equals("aq0000"))
                Adjectives[1]++;
                    
            if(POSTag.equals("cc"))
                Conjunctions[0]++;
                    
            if(POSTag.equals("cs"))
                Conjunctions[1]++;
                
            if(POSTag.equals("da0000"))
                Determiners[0]++;
                    
            if(POSTag.equals("dd0000"))
                Determiners[1]++;
                    
            if(POSTag.equals("de0000"))
                Determiners[2]++;
                    
            if(POSTag.equals("di0000"))
                Determiners[3]++;
                    
            if(POSTag.equals("dn0000"))
                Determiners[4]++;
                    
            if(POSTag.equals("do0000"))
                Determiners[5]++;
                    
            if(POSTag.equals("dp0000"))
                Determiners[6]++;
                    
            if(POSTag.equals("dt0000"))
                Determiners[7]++;
                    
            if(POSTag.equals("f0"))
                Punctuation[0]++;
                    
            if(POSTag.equals("faa"))
                Punctuation[1]++;
                    
            if(POSTag.equals("fat"))
                Punctuation[2]++;
                    
            if(POSTag.equals("fc"))
                Punctuation[3]++;
                    
            if(POSTag.equals("fca"))
                Punctuation[4]++;
                    
            if(POSTag.equals("fct"))
                Punctuation[5]++;
                    
            if(POSTag.equals("fd"))
                Punctuation[6]++;
                    
            if(POSTag.equals("fe"))
                Punctuation[7]++;
                    
            if(POSTag.equals("fg"))
                Punctuation[8]++;
                    
            if(POSTag.equals("fh"))
                Punctuation[9]++;
                    
            if(POSTag.equals("fia"))
                Punctuation[10]++;
                    
            if(POSTag.equals("fit"))
                Punctuation[11]++;
                    
            if(POSTag.equals("fp"))
                Punctuation[12]++;
                    
            if(POSTag.equals("fpa"))
                Punctuation[13]++;
                    
            if(POSTag.equals("fpt"))
                Punctuation[14]++;
                    
            if(POSTag.equals("fra"))
                Punctuation[15]++;
                    
            if(POSTag.equals("frc"))
                Punctuation[16]++;
                    
            if(POSTag.equals("fs"))
                Punctuation[17]++;
                    
            if(POSTag.equals("ft"))
                Punctuation[18]++;
                    
            if(POSTag.equals("fx"))
                Punctuation[19]++;
                    
            if(POSTag.equals("fz"))
                Punctuation[20]++;
                    
            if(POSTag.equals("i"))
                Interjections++;
                    
            if(POSTag.equals("nc00000"))
                Nouns[0]++;
                    
            if(POSTag.equals("nc0n000"))
                Nouns[1]++;
                    
            if(POSTag.equals("nc0p000"))
                Nouns[2]++;
                    
            if(POSTag.equals("nc0s000"))
                Nouns[3]++;
                    
            if(POSTag.equals("np00000"))
                Nouns[4]++;
                    
            if(POSTag.equals("p0000000"))
                Pronouns[0]++;
                    
            if(POSTag.equals("pd000000"))
                Pronouns[1]++;
                    
            if(POSTag.equals("pe000000"))
                Pronouns[2]++;
                    
            if(POSTag.equals("pi000000"))
                Pronouns[3]++;
                    
            if(POSTag.equals("pn000000"))
                Pronouns[4]++;
                    
            if(POSTag.equals("pp000000"))
                Pronouns[5]++;
                    
            if(POSTag.equals("pr000000"))
                Pronouns[6]++;
                    
            if(POSTag.equals("pt000000"))
                Pronouns[7]++;
                    
            if(POSTag.equals("px000000"))
                Pronouns[8]++;
                    
            if(POSTag.equals("rg"))
                Adverbs[0]++;
                    
            if(POSTag.equals("rn"))
                Adverbs[1]++;
                    
            if(POSTag.equals("sp000"))
                Prepositions++;
                    
            if(POSTag.equals("va00000"))
                Verbs[0]++;
                    
            if(POSTag.equals("vag0000"))
                Verbs[1]++;
                    
            if(POSTag.equals("vaic000"))
                Verbs[2]++;
                    
            if(POSTag.equals("vaif000"))
                Verbs[3]++;
                    
            if(POSTag.equals("vaii000"))
                Verbs[4]++;
                    
            if(POSTag.equals("vaip000"))
                Verbs[5]++;
                    
            if(POSTag.equals("vais000"))
                Verbs[6]++;
                    
            if(POSTag.equals("vam0000"))
                Verbs[7]++;
                    
            if(POSTag.equals("van0000"))
                Verbs[8]++;
                    
            if(POSTag.equals("vap0000"))
                Verbs[9]++;
                    
            if(POSTag.equals("vasi000"))
                Verbs[10]++;
                    
            if(POSTag.equals("vasp000"))
                Verbs[11]++;
                    
            if(POSTag.equals("vmg0000"))
                Verbs[12]++;
                    
            if(POSTag.equals("vmic000"))
                Verbs[13]++;
                    
            if(POSTag.equals("vmif000"))
                Verbs[14]++;
                    
            if(POSTag.equals("vmii000"))
                Verbs[15]++;
                    
            if(POSTag.equals("vmip000"))
                Verbs[16]++;
                    
            if(POSTag.equals("vmis000"))
                Verbs[17]++;
                    
            if(POSTag.equals("vmm0000"))
                Verbs[18]++;
                    
            if(POSTag.equals("vmn0000"))
                Verbs[19]++;
                    
            if(POSTag.equals("vmp0000"))
                Verbs[20]++;
                    
            if(POSTag.equals("vmsi000"))
                Verbs[21]++;
                    
            if(POSTag.equals("vmsp000"))
                Verbs[22]++;
                    
            if(POSTag.equals("vsg0000"))
                Verbs[23]++;
                    
            if(POSTag.equals("vsic000"))
                Verbs[24]++;
                    
            if(POSTag.equals("vsif000"))
                Verbs[25]++;
                    
            if(POSTag.equals("vsii000"))
                Verbs[26]++;
                
            if(POSTag.equals("vsip000"))
                Verbs[27]++;
                    
            if(POSTag.equals("vsis000"))
                Verbs[28]++;
                    
            if(POSTag.equals("vsm0000"))
                Verbs[29]++;
                    
            if(POSTag.equals("vsn0000"))
                Verbs[30]++;
                    
            if(POSTag.equals("vsp0000"))
                Verbs[31]++;
                    
            if(POSTag.equals("vssf000"))
                Verbs[32]++;
                
            if(POSTag.equals("vssi000"))
                Verbs[33]++;
                    
            if(POSTag.equals("vssp000"))
                Verbs[34]++;
                
            if(POSTag.equals("w"))
                Dates++;
                    
            if(POSTag.equals("z0"))
                Numerals[0]++;
                    
            if(POSTag.equals("zm"))
                Numerals[1]++;
                    
            if(POSTag.equals("zu"))
                Numerals[2]++;
                    
            if(POSTag.equals("word"))
                Other++;
            /*
            switch (POSTag){
                case "ao0000":
                    Adjectives[0]++;
                    break;
                case "aq0000":
                    Adjectives[1]++;
                    break;
                case "cc":
                    Conjunctions[0]++;
                    break;
                case "cs":
                    Conjunctions[1]++;
                    break;
                case "da0000":
                    Determiners[0]++;
                    break;
                case "dd0000":
                    Determiners[1]++;
                    break;
                case "de0000":
                    Determiners[2]++;
                    break;
                case "di0000":
                    Determiners[3]++;
                    break;
                case "dn0000":
                    Determiners[4]++;
                    break;
                case "do0000":
                    Determiners[5]++;
                    break;
                case "dp0000":
                    Determiners[6]++;
                    break;
                case "dt0000":
                    Determiners[7]++;
                    break;
                case "f0":
                    Punctuation[0]++;
                    break;
                case "faa":
                    Punctuation[1]++;
                    break;
                case "fat":
                    Punctuation[2]++;
                    break;
                case "fc":
                    Punctuation[3]++;
                    break;
                case "fca":
                    Punctuation[4]++;
                    break;
                case "fct":
                    Punctuation[5]++;
                    break;
                case "fd":
                    Punctuation[6]++;
                    break;
                case "fe":
                    Punctuation[7]++;
                    break;
                case "fg":
                    Punctuation[8]++;
                    break;
                case "fh":
                    Punctuation[9]++;
                    break;
                case "fia":
                    Punctuation[10]++;
                    break;
                case "fit":
                    Punctuation[11]++;
                    break;
                case "fp":
                    Punctuation[12]++;
                    break;
                case "fpa":
                    Punctuation[13]++;
                    break;
                case "fpt":
                    Punctuation[14]++;
                    break;
                case "fra":
                    Punctuation[15]++;
                    break;
                case "frc":
                    Punctuation[16]++;
                    break;
                case "fs":
                    Punctuation[17]++;
                    break;
                case "ft":
                    Punctuation[18]++;
                    break;
                case "fx":
                    Punctuation[19]++;
                    break;
                case "fz":
                    Punctuation[20]++;
                    break;
                case "i":
                    Interjections++;
                    break;
                case "nc00000":
                    Nouns[0]++;
                    break;
                case "nc0n000":
                    Nouns[1]++;
                    break;
                case "nc0p000":
                    Nouns[2]++;
                    break;
                case "nc0s000":
                    Nouns[3]++;
                    break;
                case "np00000":
                    Nouns[4]++;
                    break;
                case "p0000000":
                    Pronouns[0]++;
                    break;
                case "pd000000":
                    Pronouns[1]++;
                    break;
                case "pe000000":
                    Pronouns[2]++;
                    break;
                case "pi000000":
                    Pronouns[3]++;
                    break;
                case "pn000000":
                    Pronouns[4]++;
                    break;
                case "pp000000":
                    Pronouns[5]++;
                    break;
                case "pr000000":
                    Pronouns[6]++;
                    break;
                case "pt000000":
                    Pronouns[7]++;
                    break;
                case "px000000":
                    Pronouns[8]++;
                    break;
                case "rg":
                    Adverbs[0]++;
                    break;
                case "rn":
                    Adverbs[1]++;
                    break;
                case "sp000":
                    Prepositions++;
                    break;
                case "va00000":
                    Verbs[0]++;
                    break;
                case "vag0000":
                    Verbs[1]++;
                    break;
                case "vaic000":
                    Verbs[2]++;
                    break;
                case "vaif000":
                    Verbs[3]++;
                    break;
                case "vaii000":
                    Verbs[4]++;
                    break;
                case "vaip000":
                    Verbs[5]++;
                    break;
                case "vais000":
                    Verbs[6]++;
                    break;
                case "vam0000":
                    Verbs[7]++;
                    break;
                case "van0000":
                    Verbs[8]++;
                    break;
                case "vap0000":
                    Verbs[9]++;
                    break;
                case "vasi000":
                    Verbs[10]++;
                    break;
                case "vasp000":
                    Verbs[11]++;
                    break;
                case "vmg0000":
                    Verbs[12]++;
                    break;
                case "vmic000":
                    Verbs[13]++;
                    break;
                case "vmif000":
                    Verbs[14]++;
                    break;
                case "vmii000":
                    Verbs[15]++;
                    break;
                case "vmip000":
                    Verbs[16]++;
                    break;
                case "vmis000":
                    Verbs[17]++;
                    break;
                case "vmm0000":
                    Verbs[18]++;
                    break;
                case "vmn0000":
                    Verbs[19]++;
                    break;
                case "vmp0000":
                    Verbs[20]++;
                    break;
                case "vmsi000":
                    Verbs[21]++;
                    break;
                case "vmsp000":
                    Verbs[22]++;
                    break;
                case "vsg0000":
                    Verbs[23]++;
                    break;
                case "vsic000":
                    Verbs[24]++;
                    break;
                case "vsif000":
                    Verbs[25]++;
                    break;
                case "vsii000":
                    Verbs[26]++;
                    break;
                case "vsip000":
                    Verbs[27]++;
                    break;
                case "vsis000":
                    Verbs[28]++;
                    break;
                case "vsm0000":
                    Verbs[29]++;
                    break;
                case "vsn0000":
                    Verbs[30]++;
                    break;
                case "vsp0000":
                    Verbs[31]++;
                    break;
                case "vssf000":
                    Verbs[32]++;
                    break;
                case "vssi000":
                    Verbs[33]++;
                    break;
                case "vssp000":
                    Verbs[34]++;
                    break;
                case "w":
                    Dates++;
                    break;
                case "z0":
                    Numerals[0]++;
                    break;
                case "zm":
                    Numerals[1]++;
                    break;
                case "zu":
                    Numerals[2]++;
                    break;
                case "word":
                    Other++;
                    break;
                default:
                    break;
            }
            */
            //input = input.substring(input.indexOf(")")+1);
        }
        countPOSTag.setTicket_Id(ticket_id);
        countPOSTag.setComment_Id(comment_id);
        countPOSTag.setAdjectives(Adjectives);
        countPOSTag.setConjunctions(Conjunctions);
        countPOSTag.setDeterminers(Determiners);
        countPOSTag.setPunctuation(Punctuation);
        countPOSTag.setInterjections(Interjections);
        countPOSTag.setNouns(Nouns);
        countPOSTag.setPronouns(Pronouns);
        countPOSTag.setAdverbs(Adverbs);
        countPOSTag.setPrepositions(Prepositions);
        countPOSTag.setVerbs(Verbs);
        countPOSTag.setDates(Dates);
        countPOSTag.setNumerals(Numerals);
        countPOSTag.setOther(Other);

        return countPOSTag;
    }
}