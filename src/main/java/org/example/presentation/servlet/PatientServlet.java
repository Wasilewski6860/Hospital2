package org.example.presentation.servlet;

import com.google.gson.Gson;
import org.example.domain.models.Department;
import org.example.domain.models.Patient;
import org.example.domain.use_cases.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/api/patient/*")
public class PatientServlet extends HttpServlet {

    private AddPatientUseCase addPatientUseCase;
    private EditPatientUseCase editPatientUseCase;
    private GetPatientUseCase getPatientUseCase;
    private GetAllPatientsUseCase getAllPatientsUseCase;
    private RemovePatientUseCase deletePatientUseCase;

    public PatientServlet() {
        addPatientUseCase = AddPatientUseCase.getInstance();
        editPatientUseCase = EditPatientUseCase.getInstance();
        getPatientUseCase = GetPatientUseCase.getInstance();
        getAllPatientsUseCase = GetAllPatientsUseCase.getInstance();
        deletePatientUseCase = RemovePatientUseCase.getInstance();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String responseMessage;

        String pathInfo = req.getPathInfo();

        if (pathInfo == null) {
            res.setStatus(HttpServletResponse.SC_NOT_FOUND);
            responseMessage = "{\"error\": \"Patient or department with such id is not found\"}";
        } else {
            try {
                String idString = req.getPathInfo().substring(1);
                Integer id = Integer.parseInt(idString);
                Patient patient = getPatientUseCase.execute(id);

                if (patient == null) {
                    res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                    responseMessage = "{\"error\": \"Patient with such id is not found\"}";
                } else {
                    responseMessage = new Gson().toJson(patient);
                }
            } catch (NumberFormatException ex) {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                responseMessage = "{\"error\": \"Id is not valid\"}";
            }
        }

        res.setContentType("application/json");
        res.getWriter().print(responseMessage);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String responseMessage = "OK";

        String pathInfo = req.getPathInfo();
//        http://localhost:8080/api/department/delete/
        if (pathInfo!=null && req.getPathInfo().substring(1).startsWith("edit")){
            String json = ServletUtils.parseRequestBody(req);
            Patient patient = new Gson().fromJson(json, Patient.class);

            editPatientUseCase.execute(patient.getDepartmentId(), patient.getID(), patient.getName(),patient.getGender());

            resp.setContentType("application/json");
            resp.getWriter().print("{\"result\": \"Patient has been edited\"}");
        }
        else if (pathInfo!=null &&req.getPathInfo().substring(1).startsWith("delete/")){
            Integer id = Integer.parseInt(req.getPathInfo().substring(8));
            deletePatientUseCase.execute(id);
        }
        else {
            String json = ServletUtils.parseRequestBody(req);
            Patient patient = new Gson().fromJson(json, Patient.class);

            addPatientUseCase.execute(patient.getDepartmentId(),patient.getName(),patient.getGender());

            resp.setContentType("application/json");
            resp.getWriter().print("{\"result\": \"Patient has been created\"}");
        }

    }
}
