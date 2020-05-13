package analysis;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Analysis_table")
public class Analysis {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String analysisInfo;
    private Long requestId;
    private String requester;
    private String analStatus;

    @PostPersist
    public void onPostPersist(){
        AnalysisCompleted analysisCompleted = new AnalysisCompleted();
        BeanUtils.copyProperties(this, analysisCompleted);
        analysisCompleted.publishAfterCommit();


        ReceptionCompleted receptionCompleted = new ReceptionCompleted();
        BeanUtils.copyProperties(this, receptionCompleted);
        receptionCompleted.publishAfterCommit();


        AnalysisStarted analysisStarted = new AnalysisStarted();
        BeanUtils.copyProperties(this, analysisStarted);
        analysisStarted.publishAfterCommit();


        EquipmentUseRequest equipmentUseRequest = new EquipmentUseRequest();
        BeanUtils.copyProperties(this, equipmentUseRequest);
        equipmentUseRequest.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        analysis.external.Analysis analysis = new analysis.external.Analysis();
        // mappings goes here
        Application.applicationContext.getBean(analysis.external.AnalysisService.class)
            .requestEquipStart(analysis);


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
