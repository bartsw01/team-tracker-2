import models.Job;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;

import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Job> jobs = Job.getAll();
            model.put("jobs", jobs);
            return new ModelAndView(model, "/index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/jobs", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Job> jobs = Job.getAll();
            model.put("jobs", jobs);

            return new ModelAndView(model, "show-all.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new post form
        get("/jobs/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "newjob-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: process new post form
        post("/jobs/new", (request, response) -> { //URL to make new post on POST route
            Map<String, Object> model = new HashMap<>();

            String jobTitle = request.queryParams("jobTitle");
            String company = request.queryParams("company");
            String jobDescription = request.queryParams("jobDescription");
            String companyLocation = request.queryParams("companyLocation");
            String startDate = request.queryParams("startDate");
            String endDate = request.queryParams("endDate");
            Job newJob = new Job(jobTitle,company,jobDescription,companyLocation,startDate,endDate);
            model.put("job", newJob);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());


        //get: show an individual post
        get("/jobs/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Job foundJob = Job.findById(idOfJobToFind); //use it to find post
            model.put("job", foundJob); //add it to model for template to display
            return new ModelAndView(model, "job-detail.hbs");
        }, new HandlebarsTemplateEngine());




    }
}