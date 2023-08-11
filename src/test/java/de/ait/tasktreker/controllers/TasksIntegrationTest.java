package de.ait.tasktreker.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("TasksController is working:")
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
@ActiveProfiles("test")
public class TasksIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;

  @Nested
  @DisplayName("GET /api/tasks is working: ")
  class GetAllTasksTest {

    @Test
    @Sql(scripts = "/sql/data_for_tasks.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void get_all_tasks() throws Exception {

      mockMvc.perform(get("/api/tasks")
              .param("page", "0")
              .param("items", "3"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.count", is(8)));
    }

    @Test
    @Sql(scripts = "/sql/data_for_tasks.sql")
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    void get_all_task_with_pagination_sorting_and_filtering() throws Exception {

      mockMvc.perform(get("/api/tasks")
              .param("page", "0")
              .param("items", "5")
              .param("orderBy", "title")
              .param("desk", "true")
              .param("filterBy", "finishDate")
              .param("filterValue", "2023-09-15"))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$.count", is(2)))
          .andExpect(jsonPath("$.pages", is(1)))
          .andExpect(jsonPath("$.tasks.size()", is(2)));

    }

  }
}

