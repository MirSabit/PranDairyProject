package LabRecord;

public class LabRecord {

    private final String testId;
    private final String batchId;
    private final String testType;
    private final String result;

    public LabRecord(String testId, String batchId, String testType, String result) {
        this.testId = testId;
        this.batchId = batchId;
        this.testType = testType;
        this.result = result;
    }

    public String getTestId() {
        return testId;
    }

    public String getBatchId() {
        return batchId;
    }

    public String getTestType() {
        return testType;
    }

    public String getResult() {
        return result;
    }
}
