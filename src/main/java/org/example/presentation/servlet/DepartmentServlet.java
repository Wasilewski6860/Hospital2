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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/api/department/*")
public class DepartmentServlet extends HttpServlet {

    private AddDepartmentUseCase addDepartmentUseCase;
    private EditDepartmentUseCase editDepartmentUseCase;
    private GetDepartmentUseCase getDepartmentUseCase;
    private GetAllDepartmentsUseCase getAllDepartmentsUseCase;
    private DeleteDepartmentUseCase deleteDepartmentUseCase;
    private DeleteAllDepartmentsUseCase deleteAllDepartmentsUseCase;
    private GetAllPatientsInDepartmentUseCase getAllPatientsInDepartmentUseCase;

    public DepartmentServlet() {
        addDepartmentUseCase = AddDepartmentUseCase.getInstance();
        editDepartmentUseCase = EditDepartmentUseCase.getInstance();
        getDepartmentUseCase = GetDepartmentUseCase.getInstance();
        getAllDepartmentsUseCase = GetAllDepartmentsUseCase.getInstance();
        deleteDepartmentUseCase = DeleteDepartmentUseCase.getInstance();
        deleteAllDepartmentsUseCase = DeleteAllDepartmentsUseCase.getInstance();
        getAllPatientsInDepartmentUseCase = GetAllPatientsInDepartmentUseCase.getInstance();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String responseMessage;

        String pathInfo = req.getPathInfo();

        if (pathInfo == null) {
            List<Department> departments = getAllDepartmentsUseCase.execute();
            responseMessage = new Gson().toJson(departments);
        } else {
            try {
                if (req.getPathInfo().substring(1).startsWith("all")){
                    String idString = req.getPathInfo().substring(5);
                    Integer id = Integer.parseInt(idString);
                    List<Patient> patients = getAllPatientsInDepartmentUseCase.execute(id);

                    if (patients == null) {
                        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        responseMessage = "{\"error\": \"Department with such id is not found\"}";
                    } else {
                        responseMessage = new Gson().toJson(patients);
                    }
                }
                else {
                    String idString = req.getPathInfo().substring(1);
                    Integer id = Integer.parseInt(idString);
                    Department department = getDepartmentUseCase.execute(id);

                    if (department == null) {
                        res.setStatus(HttpServletResponse.SC_NOT_FOUND);
                        responseMessage = "{\"error\": \"Department with such id is not found\"}";
                    } else {
                        responseMessage = new Gson().toJson(department);
                    }
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
            Department department = new Gson().fromJson(json, Department.class);

            editDepartmentUseCase.execute(department.getDepartmentNumber(),department.getName());

            resp.setContentType("application/json");
            resp.getWriter().print("{\"result\": \"Department has been edited\"}");
        }
        else if (pathInfo!=null &&req.getPathInfo().substring(1).startsWith("delete/")){
            Integer id = Integer.parseInt(req.getPathInfo().substring(8));
            deleteDepartmentUseCase.execute(id);
        }
        else if (pathInfo!=null &&req.getPathInfo().substring(1).startsWith("deleteAll")){
            deleteAllDepartmentsUseCase.execute();
        }
        else {
            String json = ServletUtils.parseRequestBody(req);
            Department department = new Gson().fromJson(json, Department.class);

            addDepartmentUseCase.execute(department.getName(),department.getDepartmentNumber());

            resp.setContentType("application/json");
            resp.getWriter().print("{\"result\": \"Department has been created\"}");
        }

    }
}


