package online_examination_system;

public class DescriptiveEvaluation implements EvaluationStrategy {

    @Override
    public int evaluate(Exam exam) {
        // Manual evaluation simulated
        return exam.getQuestions().size() * 2;
    }
}
