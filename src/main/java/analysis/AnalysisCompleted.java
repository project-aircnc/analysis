package analysis;

public class AnalysisCompleted extends AbstractEvent {

    private Long id;
    private String analysisInfo;
    private Long requestId;
    private String requester;
    private String analStatus;

    public AnalysisCompleted(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAnalysisInfo() {
        return analysisInfo;
    }

    public void setAnalysisInfo(String analysisInfo) {
        this.analysisInfo = analysisInfo;
    }
    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }
    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }
    public String getAnalStatus() {
        return analStatus;
    }

    public void setAnalStatus(String analStatus) {
        this.analStatus = analStatus;
    }
}
