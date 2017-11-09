package com.nlp.test;

import java.util.*;
import com.nlp.test.stanfordnlp.VerifyText;
import com.nlp.test.entity.CountPOSTag;
import com.nlp.test.dao.CountPOSTagDAO;

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
        
        //Object
        System.out.println("Object initial");
        CountPOSTag cpt= VerifyText.CountPOSTagProcess(text, 0, 0);
        System.out.println("Object created");

        //Insert to DB
        System.out.println("DB initial");
        CountPOSTagDAO.addCountPOSTag(cpt);
        System.out.println("DB fin");
    }
}
