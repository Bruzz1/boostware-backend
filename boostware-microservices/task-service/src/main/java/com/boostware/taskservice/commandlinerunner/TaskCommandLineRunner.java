package com.boostware.taskservice.commandlinerunner;

import com.boostware.taskservice.model.Role;
import com.boostware.taskservice.model.Task;
import com.boostware.taskservice.model.User;
import com.boostware.taskservice.repository.TaskRepository;
import com.boostware.taskservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class TaskCommandLineRunner implements CommandLineRunner {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception {
        List<Task> tasks = new ArrayList<>();
        int i = 1;
        while(i <= 2 ) {
            Task task = new Task();
            task.setDescription("Create Spring boot application part " + i);
            task.setStatus(false);
            task.setTargetDate(LocalDate.now().plusDays(10));
            task.setUsername("boostware");
            tasks.add(task);
            i++;
        }
        taskRepository.saveAll(tasks);
        User user = User.builder()
                .firstname("rj")
                .lastname("bruce")
                .email("rj@gmail.com")
                .password(passwordEncoder.encode("1234"))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        User user1 = User.builder()
                .firstname("rj")
                .lastname("bruce")
                .email("boostware")
                .password(passwordEncoder.encode("1234"))
                .role(Role.USER)
                .build();
        userRepository.save(user1);
    }
}
