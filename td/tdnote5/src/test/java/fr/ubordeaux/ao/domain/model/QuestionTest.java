package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.ubordeaux.ao.domain.exception.QuestionExamException;
import fr.ubordeaux.ao.domain.model.Question;

public class QuestionTest {

    @Test
    public void encapsulationShouldBePreserved() {
        String question = "Qui a écrit Domain-Driven Design ?";
        String description = "Question de culture générale";
        String reponseA = "Eric Gamma";
        String reponseB = "Eric Evans";
        String reponseC = "Eric EtRamzy";
        Set<String> candidate = new HashSet<String>();
        candidate.add(reponseA);
        candidate.add(reponseB);
        candidate.add(reponseC);
        Set<String> trueAnswser = new HashSet<String>();
        trueAnswser.add(reponseB);
        
        Question q = new Question(question, description, candidate, trueAnswser);
        q.getCandidateAnswerSet().clear();
        
        assertEquals(1,q.getCandidateAnswerSet().size());
        assertTrue(q.getCandidateAnswerSet().contains(reponseB));
    }

    @Test
    public void trueAnswerShouldBelongToCandidateAnswerSet() {
        String question = "Qui a écrit Domain-Driven Design ?";
        String description = "Question de culture générale";
        String reponseA = "Eric Gamma";
        String reponseB = "Eric Evans";
        String reponseC = "Eric EtRamzy";
        Set<String> candidate = new HashSet<String>();
        candidate.add(reponseA);
        candidate.add(reponseC);
        Set<String> trueAnswser = new HashSet<String>();
        trueAnswser.add(reponseB);

        try {
            Question q = new Question(question, description, candidate, trueAnswser);
            fail("CandidateAnswer does not contain true answer although it should");
        } catch (QuestionExamException ex) {
        }
    }

}