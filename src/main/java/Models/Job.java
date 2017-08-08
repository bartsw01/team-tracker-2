package Models;

/**
 * Created by Guest on 8/8/17.
 */
public class Job {
    private String jobTitle;
    private String company;
    private String jobDescription;
    private String companyLocation;
    private String startDate;
    private String endDate;

    public Job (String jobTitle){
        this.jobTitle = jobTitle;
    }

    public String getContent(){
        return this.jobTitle;
    }

}
