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

            String teamName = request.queryParams("teamName");
            String teamDescription = request.queryParams("teamDescription");
            String teamMember1 = request.queryParams("teamMember1");
            String teamMember2 = request.queryParams("teamMember2");
            String teamMember3 = request.queryParams("teamMember3");
            String teamMember4 = request.queryParams("teamMember4");
            Job newJob = new Job(teamName,teamDescription,teamMember1,teamMember2,teamMember3,teamMember4);
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

        get("/jobs/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfJobToEdit = Integer.parseInt(request.params("id"));
            Job editJob = Job.findById(idOfJobToEdit);
            model.put("editJob", editJob);
            return new ModelAndView(model, "newjob-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/jobs/:id/update", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String newTeamName = request.queryParams("teamName");
            int idOfJobToEdit = Integer.parseInt(request.params("id"));
            Job editJob = Job.findById(idOfJobToEdit);
            editJob.update(newTeamName);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());






    }
}