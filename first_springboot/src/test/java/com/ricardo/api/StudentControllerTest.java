package com.ricardo.api;

import com.ricardo.models.Student;
import com.ricardo.persistence.InMemoryRepoStudents;
import com.ricardo.services.StudentsServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @Autowired
    private StudentsServices studentsServices;

    @Autowired
    private InMemoryRepoStudents repoStudents;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllStudentsClases() {
        //Comprobabos que el controller devuelve un tamaño > 0
        List<Student> losEstudiantes = studentController.getAllStudents();
        System.out.println(losEstudiantes);
        assertTrue(losEstudiantes.size() > 0);
        assertThat(losEstudiantes).isNotNull();
        assertThat(losEstudiantes).isNotEmpty();

        //Comprobabos que el controller devuelve una lista igual a la que devolvería el servicio
        List<Student> losEstudiantesServicio = studentsServices.getAllStudents();
        System.out.println(losEstudiantesServicio);
        assertTrue(losEstudiantes.equals(losEstudiantesServicio));
        assertThat(losEstudiantes).isSameAs(losEstudiantesServicio);

        //Comprobabos que el controller devuelve una lista igual a la que devolveríala persistencia (+)
        List<Student> losEstudiantesRepo = repoStudents.getAll();
        System.out.println(losEstudiantesRepo);
        assertTrue(losEstudiantes.equals(losEstudiantesRepo));
    }

    @Test
    void getAllStudentsWeb() throws Exception {
        mockMvc.perform(get("/students"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void postNewStudentWebPositive() throws Exception {
        Student newStudent = new Student(0L, "pedro", 3);

        mockMvc.perform(
                post("/students")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(asJsonString(newStudent))
                )
                .andDo(print())
                .andExpect(status().is(201));
    }

    @Test
    void postNewStudentWebNegative() throws Exception {
        Student newStudent = new Student(0L, "pedro", 0);

        mockMvc.perform(
                post("/students")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(asJsonString(newStudent))
                )
                .andDo(print())
                .andExpect(status().is(400));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getOneStudent() {
    }

    @Test
    void updateStudentWeb() throws Exception{
        long idStudent=2L;
         Student theStudent = new Student();
         theStudent.setId(idStudent);
         theStudent.setName("Pedro");

        mockMvc.perform(
                put("/students/"+idStudent)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(asJsonString(theStudent))
                )
                .andDo(print())
                .andExpect(status().is(202));
    }

    @Test
    void deleteStudent() {
    }
}