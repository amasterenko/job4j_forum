package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;
import ru.job4j.forum.store.PostRepository;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PostService postService;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenCreate() throws Exception {
        this.mockMvc.perform(get("/create"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenRead() throws Exception {
        Mockito.doReturn(new Post()).when(postService).findById(1);
        this.mockMvc.perform(get("/read?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/post"));
    }

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessageWhenUpdate() throws Exception {
        Mockito.doReturn(new Post()).when(postService).findById(1);
        this.mockMvc.perform(get("/update?id=1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("post/update"));
    }
}