package SampleEvaluation;

public class SampleEvaluation {

    private final String sampleId;
    private final String productName;
    private final String tasteScore;
    private final String textureScore;
    private final String result;

    public SampleEvaluation(String sampleId, String productName, String tasteScore, String textureScore, String result) {
        this.sampleId = sampleId;
        this.productName = productName;
        this.tasteScore = tasteScore;
        this.textureScore = textureScore;
        this.result = result;
    }

    public String getSampleId() {
        return sampleId;
    }

    public String getProductName() {
        return productName;
    }

    public String getTasteScore() {
        return tasteScore;
    }

    public String getTextureScore() {
        return textureScore;
    }

    public String getResult() {
        return result;
    }
}
