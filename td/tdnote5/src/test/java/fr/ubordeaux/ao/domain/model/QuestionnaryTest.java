package fr.ubordeaux.ao.domain.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import fr.ubordeaux.ao.domain.exception.QuestionExamException;
import fr.ubordeaux.ao.domain.model.Question;
import fr.ubordeaux.ao.domain.model.Questionnary;

public class QuestionnaryTest {

    @Test
    public void shouldComputeScore() {
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
        Question question1 = new Question(question, description, candidate, trueAnswser);

        Set<Question> questionSet = new HashSet<Question>();
        questionSet.add(question1);

        Questionnary questionnary1 = new Questionnary("#1",questionSet);
        questionnary1.answer(question1, reponseA);
        assertEquals(0,questionnary1.getScore());

        Questionnary questionnary2 = new Questionnary("#2",questionSet);
        questionnary2.answer(question1, reponseB);
        assertEquals(1,questionnary2.getScore());
        
    }

}