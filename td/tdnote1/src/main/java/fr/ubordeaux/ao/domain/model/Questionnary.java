package fr.ubordeaux.ao.domain.model;

import fr.ubordeaux.ao.domain.exception.QuestionExamException;

import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class Questionnary {
    private String id;
    private Set<Question> questionSet;
    private Map<Question,String> answerMap;

    public Questionnary(String id, Set<Question> questionSet) {
        this.setId(id);
        this.setQuestionSet(questionSet);
        answerMap = new HashMap<Question,String>();
    }

    public String getId() {
        return id;
    }

    public Set<Question> getQuestionSet() {
        return this.questionSet;
    }

    public int getScore() {
        return 0;
    }

    public void answer(Question question, String answer) {
        this.answerMap.put(question, answer);
    }


    private void setId(String id) {
        if (id == null) throw new QuestionExamException("cannot create questionnary with null id");
        this.id = id;
    }

    private void setQuestionSet(Set<Question> questionSet) {
        if (questionSet == null) throw new QuestionExamException("cannot create questionnay with null question");
        this.questionSet = questionSet;
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Questionnary) {
            Questionnary otherQuestionnay = (Questionnary) other;
            boolean sameId = this.getId().compareTo(otherQuestionnay.getId())==0;
            
            boolean equals = sameId;
			return equals;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return getId();
    }
}
