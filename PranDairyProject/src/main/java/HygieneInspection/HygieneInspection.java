package HygieneInspection;

public class HygieneInspection {

    private final String area;
    private final String complianceScore;
    private final String result;

    public HygieneInspection(String area, String complianceScore, String result) {
        this.area = area;
        this.complianceScore = complianceScore;
        this.result = result;
    }

    public String getArea() {
        return area;
    }

    public String getComplianceScore() {
        return complianceScore;
    }

    public String getResult() {
        return result;
    }
}
