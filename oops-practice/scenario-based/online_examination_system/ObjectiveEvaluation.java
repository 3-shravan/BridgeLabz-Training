package online_examination_system;

public class ObjectiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Exam exam) {
        // For simplicity: 1 mark per question
        return exam.getQuestions().size();
    }
}
