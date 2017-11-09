package com.nlp.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "countpostag")
public class CountPOSTag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;
    @Column(name = "ticket_id")
	private long Ticket_Id;
    @Column(name = "comment_id")
	private long Comment_Id;
    @Column(name = "adjectives")
	private long[] Adjectives = new long[2];
    @Column(name = "conjunctions")
	private long[] Conjunctions = new long[2];
    @Column(name = "determiners")
	private long[] Determiners = new long[8];
    @Column(name = "punctuation")
	private long[] Punctuation = new long[21];
    @Column(name = "interjections")
	private long Interjections;
    @Column(name = "nouns")
	private long[] Nouns = new long[5];
    @Column(name = "pronouns")
	private long[] Pronouns = new long[9];
    @Column(name = "adverbs")
	private long[] Adverbs = new long[2];
    @Column(name = "prepositions")
	private long Prepositions;
    @Column(name = "verbs")
	private long[] Verbs = new long[35];
    @Column(name = "dates")
	private long Dates;
    @Column(name = "numerals")
	private long[] Numerals = new long[3];
    @Column(name = "other")
	private long Other;

	
	public CountPOSTag() {
	}
	
	public CountPOSTag(long ticket_id, long comment_id) {
		this.Ticket_Id=ticket_id;
		this.Comment_Id=comment_id;
	}
	
	public CountPOSTag(long id, long ticket_id, long comment_id) {
		this.Id=id;
		this.Ticket_Id=ticket_id;
		this.Comment_Id=comment_id;
	}
	
	public void setId(long id) {
        this.Id = id;
    }
    
    public long getId() {
        return this.Id;
    }

    public void setTicket_Id(long ticket_id) {
        this.Ticket_Id = ticket_id;
    }
    
    public long getTicket_Id() {
        return this.Ticket_Id;
    }

    public void setComment_Id(long comment_id) {
        this.Comment_Id = comment_id;
    }
    
    public long getComment_Id() {
        return this.Comment_Id;
    }

    public void setAdjectives(long[] adjectives) {
        this.Adjectives = adjectives;
    }
    
    public long[] getAdjectives() {
        return this.Adjectives;
    }

    public void setConjunctions(long[] conjunctions) {
        this.Conjunctions = conjunctions;
    }
    
    public long[] getConjunctions() {
        return this.Conjunctions;
    }

    public void setDeterminers(long[] determiners) {
        this.Determiners = determiners;
    }
    
    public long[] getDeterminers() {
        return this.Determiners;
    }

    public void setPunctuation(long[] punctuation) {
        this.Punctuation = punctuation;
    }
    
    public long[] getPunctuation() {
        return this.Punctuation;
    }

    public void setInterjections(long interjections) {
        this.Interjections = interjections;
    }
    
    public long getInterjections() {
        return this.Interjections;
    }

    public void setNouns(long[] nouns) {
        this.Nouns = nouns;
    }
    
    public long[] getNouns() {
        return this.Nouns;
    }

    public void setPronouns(long[] pronouns) {
        this.Pronouns = pronouns;
    }
    
    public long[] getPronouns() {
        return this.Pronouns;
    }

    public void setAdverbs(long[] adverbs) {
        this.Adverbs = adverbs;
    }
    
    public long[] getAdverbs() {
        return this.Adverbs;
    }

    public void setPrepositions(long prepositions) {
        this.Prepositions = prepositions;
    }
    
    public long getPrepositions() {
        return this.Prepositions;
    }

    public void setVerbs(long[] verbs) {
        this.Verbs = verbs;
    }
    
    public long[] getVerbs() {
        return this.Verbs;
    }

    public void setDates(long dates) {
        this.Dates = dates;
    }
    
    public long getDates() {
        return this.Dates;
    }

    public void setNumerals(long[] numerals) {
        this.Numerals = numerals;
    }
    
    public long[] getNumerals() {
        return this.Numerals;
    }

    public void setOther(long other) {
        this.Other = other;
    }
    
    public long getOther() {
        return this.Other;
    }
}