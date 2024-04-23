package via.doc1.ex8.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import via.doc1.ex8.model.Task;
import via.doc1.ex8.services.TeamService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = TeamController.class)
public class TeamControllerTest {

    // A very useful test approach is to not start the server at all but to
    // test only the layer below that, where Spring handles the incoming HTTP
    // request and hands it off to your controller. That way, almost of the
    // full stack is used, and your code will be called in exactly the same way
    // as if it were processing a real HTTP request but without the cost of
    // starting the server. To do that, we use Spring’s MockMvc:
    @Autowired
    private MockMvc mockMvc;

    // The @MockBean allows us to create and manipulate a fake TeamService object
    // for use in our test - a TeamController depends on being given a TeamService
    // instance when it starts.
    @MockBean
    private TeamService teamService;

    // This is a "real" task, which will be returned by our fake teamService object.
    Task mockTask = new Task("Task1", "IoT Pipeline",
            "Create CD pipeline for IoT component");

    @Test
    public void getTaskDetailsTest() throws Exception {
        // Use Mockito to "program" the fake teamService object to
        // always return our mockTask, no matter whcih arguments are
        // supplied
        Mockito.when(teamService.getTask(Mockito.anyString(),
                Mockito.anyString())).thenReturn(mockTask);

        // Create an object that will "call" or invoke the end point we want
        // test
        RequestBuilder requestBuilder =
                MockMvcRequestBuilders.get("/members/Member1/tasks/Task1")
                        .accept(MediaType.APPLICATION_JSON);

        // Execute the request
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        // Print the response from the end point
        System.out.println(result.getResponse());

        // We expect the response to be exactly like this:
        String expected = "{\"id\":\"Task1\",\"name\":\"IoT Pipeline\",\"description\":\"Create CD pipeline for IoT component\"}";

        // Check that the json returned from the end point exactly matches what we expected
        JSONAssert.assertEquals(expected,
                result.getResponse().getContentAsString(), true);
    }
}
