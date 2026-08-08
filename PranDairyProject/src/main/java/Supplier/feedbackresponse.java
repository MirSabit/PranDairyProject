package Supplier;

public class FeedbackResponse {

    private final String feedbackId;
    private final String batchId;
    private final String explanation;
    private final String correctiveMeasures;

    public FeedbackResponse(String feedbackId, String batchId, String explanation, String correctiveMeasures) {
        this.feedbackId = feedbackId;
        this.batchId = batchId;
        this.explanation = explanation;
        this.correctiveMeasures = correctiveMeasures;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getCorrectiveMeasures() {
        return correctiveMeasures;
    }
}
